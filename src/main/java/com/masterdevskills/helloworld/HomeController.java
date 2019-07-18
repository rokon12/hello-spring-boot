package com.masterdevskills.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author A N M Bazlur Rahman
 * @since 2019-07-18
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {


        return "index";
    }
}
