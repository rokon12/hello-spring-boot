package com.masterdevskills.helloworld;

import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author A N M Bazlur Rahman
 * @since 2019-07-18
 */
public interface BlogPostService {
    List<Post> findAllPosts();
}
