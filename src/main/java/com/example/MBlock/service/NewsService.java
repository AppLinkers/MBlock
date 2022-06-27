package com.example.MBlock.service;

import com.example.MBlock.domain.News;
import com.example.MBlock.domain.User;
import com.example.MBlock.dto.News.GetNewsRes;
import com.example.MBlock.dto.News.SetMainNewsReq;
import com.example.MBlock.dto.News.WriteNewsReq;
import com.example.MBlock.repository.NewsRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;

    private final UserRepository userRepository;

    private final S3Uploader s3Uploader;

    public void write(WriteNewsReq request) throws IOException {
        String imgUrl=null;
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
        Slice<News> newsList = newsRepository.findAllByMainIsFalse(pageable);

        return newsList.map(news ->
                new GetNewsRes(news.getId(), news.getUser().getName(), news.getTitle(), news.getContext(), news.getImgUrl(), news.getViewCount(), news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd"))));
    }

    public GetNewsRes getMainNews() {
        News main = newsRepository.findNewsByMainIsTrue();

        return GetNewsRes.builder()
                .id(main.getId())
                .writer_name(main.getUser().getName())
                .title(main.getTitle())
                .context(main.getContext())
                .imgUrl(main.getImgUrl())
                .viewCount(main.getViewCount())
                .dateTime(main.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
                .build();
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

    @Modifying
    public void updateNews(WriteNewsReq request, Long newsId) throws IOException {
        News news = newsRepository.findById(newsId).get();

        news.setTitle(request.getTitle());
        news.setContext(request.getContext());

        if (request.getImgFile() != null) {
            String imgUrl = s3Uploader.upload(request.getImgFile().get(), "news");
            news.setImgUrl(imgUrl);
        }


        newsRepository.save(news);
    }

    @Modifying
    public void setMainNews(SetMainNewsReq request) {
        System.out.println(request);
        News oldMain = newsRepository.findById(request.getOldNewsId()).get();
        News newMain = newsRepository.findById(request.getNewNewsId()).get();

        oldMain.setMain(false);
        newMain.setMain(true);

        newsRepository.saveAll(List.of(oldMain, newMain));
    }
}
