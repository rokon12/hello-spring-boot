package com.masterdevskills.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author A N M Bazlur Rahman
 * @since 2019-07-18
 */
@Service
@Slf4j
public class BlogPostServiceImpl implements BlogPostService {


    public List<String> findAllPosts() {
        final var connection = Jsoup.connect("https://dzone.com/articles/how-to-handle-checked-exception-in-lambda-expressi");
        try {
            var document = connection.get();
            var content = document.getElementsByClass("content");
            final String html = content.html();
            log.info("content: {}", html);

            return List.of(html);
        } catch (IOException e) {
            log.error("Couldn't fetch blog post", e);
        }


        return null;
    }

    @Cacheable("post")
    @Override
    public Optional<String> findMyAwesomeBlogPostFromDZone() {
        var connection = Jsoup.connect("https://dzone.com/articles/how-to-handle-checked-exception-in-lambda-expressi");
        try {
            var document = connection.get();
            var content = document.getElementsByClass("content");
            var html = content.html();

            return Optional.of(html);

        } catch (IOException e) {
            log.error("Couldn't fetch blog post", e);

            return Optional.empty();
        }
    }
}
