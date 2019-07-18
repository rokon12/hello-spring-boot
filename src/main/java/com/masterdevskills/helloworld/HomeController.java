package com.masterdevskills.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * @author A N M Bazlur Rahman
 * @since 2019-07-18
 */
@Controller
public class HomeController {

    private final BlogPostService blogPostService;

    public HomeController(BlogPostService blogPostService) {
        this.blogPostService = blogPostService;
    }

    @GetMapping("/")
    public String index(Model uiModel) {
        final Optional<String> fromDZone = blogPostService.findMyAwesomeBlogPostFromDZone();
        fromDZone.ifPresent(post -> uiModel.addAttribute("post", post));

        return "index";
    }
}
