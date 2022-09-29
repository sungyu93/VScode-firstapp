package site.metacoding.firstapp.web;

import org.springframework.web.bind.annotation.GetMapping;

public class ProductController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
