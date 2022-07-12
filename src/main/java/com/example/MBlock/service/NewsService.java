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

    /**
     * Write News
     */
    public void write(WriteNewsReq request) throws IOException {
        String imgUrl=null;
        if (request.getImgFile() != null) {
          imgUrl = s3Uploader.upload(request.getImgFile().get(), "news" );
        }

        User user = userRepository.findByUserLoginId(request.getWriter_login_id()).get();

        News news = News.builder()
                .user(user)
                .title(request.getTitle())
                .context(request.getContext())
                .imgUrl(imgUrl).build();

        newsRepository.save(news);
    }

    /**
     * Read All News
     */
    public Slice<GetNewsRes> getAllNews(Pageable pageable) {
        Slice<News> newsList = newsRepository.findAllBy(pageable);
        return newsList.map(news ->
                new GetNewsRes(news.getId(), news.getUser().getProfile_img() ,news.getUser().getName(), news.getUser().getPosition() ,news.getTitle(), news.getContext(), news.getImgUrl(), news.getViewCount(), news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")), news.isMain())
        );
    }

    /**
     * Read One News
     */
    public GetNewsRes getNews(Long id) {
        News news = newsRepository.findById(id).get();

        return newsToGetNewsRes(news);
    }

    /**
     * Read Recent Updated 3 News
     */
    public List<GetNewsRes> getTop3News() {
        List<GetNewsRes> result = new ArrayList<>();

        List<News> newsList = newsRepository.findTop3ByOrderByUpdatedAtDesc();

        newsList.forEach(
                news -> {
                    result.add(
                        newsToGetNewsRes(news)
                    );
                }
        );

        return result;
    }

    /**
     * Read Main News
     */
    public GetNewsRes getMainNews() {
        Optional<News> mainNews = newsRepository.findNewsByIsMainTrue();

        if (mainNews.isPresent()) {
            News news = mainNews.get();
            return newsToGetNewsRes(news);
        } else {
            return new GetNewsRes();
        }
    }

    /**
     * Update News
     */
    @Transactional
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

    /**
     * Delete News
     */
    @Modifying
    public void deleteNews(Long newsId) {
        News news = newsRepository.findById(newsId).get();

        newsRepository.delete(news);
    }

    /**
     * Set Main News
     */
    @Transactional
    public void setMainNews(Long newsId) {
        Optional<News> oldMain = newsRepository.findNewsByIsMainTrue();

        oldMain.ifPresent(
                n -> {
                    n.setMain(false);
                    newsRepository.save(n);
                }
        );

        News newMain = newsRepository.findById(newsId).get();

        newMain.setMain(true);

        newsRepository.save(newMain);
    }

    public GetNewsRes newsToGetNewsRes(News news) {
        return GetNewsRes.builder()
                .id(news.getId())
                .writer_name(news.getUser().getName())
                .profile_img(news.getUser().getProfile_img())
                .writer_position(news.getUser().getPosition())
                .title(news.getTitle())
                .context(news.getContext())
                .imgUrl(news.getImgUrl())
                .viewCount(news.getViewCount())
                .dateTime(news.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd")))
                .build();
    }
}
