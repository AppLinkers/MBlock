package com.example.MBlock.service;

import com.example.MBlock.domain.News;
import com.example.MBlock.domain.User;
import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.dto.News.WriteNewsReq;
import com.example.MBlock.repository.NewsRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    private final UserRepository userRepository;

    private final S3Uploader s3Uploader;

    public void write(WriteNewsReq request) throws IOException {
        String imgUrl = null;

        if (request.getImgFile() != null) {
            imgUrl = s3Uploader.upload(request.getImgFile().get(), "news" );
        }

        User user = userRepository.findByUser_id(request.getWriter_login_id()).get();

        News news = News.builder()
                .user(user)
                .title(request.getTitle())
                .context(request.getContext())
                .imgUrl(imgUrl).build();

        newsRepository.save(news);
    }

    // Read All - slice
    public Slice<GetNewsRes> getAllNews(Pageable pageable) {
        Slice<News> newsList = newsRepository.findAllBy(pageable);

        return newsList.map(news ->
                new GetNewsRes(news.getId(), news.getUser().getName(), news.getTitle(), news.getContext(), news.getImgUrl(), news.getViewCount(), news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd"))));
    }


    // Read One
    public GetNewsRes getNews(Long id) {
        News news = newsRepository.findById(id).get();

        return GetNewsRes.builder()
                .id(news.getId())
                .writer_name(news.getUser().getName())
                .title(news.getTitle())
                .context(news.getContext())
                .imgUrl(news.getImgUrl())
                .viewCount(news.getViewCount())
                .dateTime(news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
                .build();
    }
}
