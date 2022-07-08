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
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Slice<News> newsList = newsRepository.findAllBy(pageable);
        return newsList.map(news ->
                new GetNewsRes(news.getId(), news.getUser().getProfile_img() ,news.getUser().getName(), news.getUser().getRole() ,news.getTitle(), news.getContext(), news.getImgUrl(), news.getViewCount(), news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")), news.isMain())
        );
    }


    // Read One
    public GetNewsRes getNews(Long id) {
        News news = newsRepository.findById(id).get();

        return GetNewsRes.builder()
                .id(news.getId())
                .profile_img(news.getUser().getProfile_img())
                .writer_name(news.getUser().getName())
                .writer_role(news.getUser().getRole())
                .title(news.getTitle())
                .context(news.getContext())
                .imgUrl(news.getImgUrl())
                .viewCount(news.getViewCount())
                .dateTime(news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
                .build();
    }

    public List<GetNewsRes> getTop3News() {
        List<GetNewsRes> result = new ArrayList<>();

        List<News> newsList = newsRepository.findTop3ByOrderByUpdatedAtDesc();

        newsList.forEach(
                news -> {
                    result.add(GetNewsRes.builder()
                            .id(news.getId())
                            .writer_name(news.getUser().getName())
                            .writer_role(news.getUser().getRole())
                            .title(news.getTitle())
                            .context(news.getContext())
                            .imgUrl(news.getImgUrl())
                            .viewCount(news.getViewCount())
                            .dateTime(news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
                            .build());
                }
        );

        return result;
    }
    public GetNewsRes getMainNews() {
        Optional<News> mainNews = newsRepository.findNewsByMainIsTrue();

        if (mainNews.isPresent()) {
            News news = mainNews.get();
            return GetNewsRes.builder()
                    .id(news.getId())
                    .writer_name(news.getUser().getName())
                    .writer_role(news.getUser().getRole())
                    .title(news.getTitle())
                    .context(news.getContext())
                    .imgUrl(news.getImgUrl())
                    .viewCount(news.getViewCount())
                    .dateTime(news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
                    .build();
        } else {
            return new GetNewsRes();
        }
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

    @Transactional
    public void setMainNews(SetMainNewsReq request) {
        News oldMain = newsRepository.findById(request.getOldNewsId()).get();
        News newMain = newsRepository.findById(request.getNewNewsId()).get();

        oldMain.setMain(false);
        newMain.setMain(true);

        newsRepository.saveAll(List.of(oldMain, newMain));
    }

    @Modifying
    public void deleteNews(Long newsId) {
        News news = newsRepository.findById(newsId).get();

        newsRepository.delete(news);
    }
}
