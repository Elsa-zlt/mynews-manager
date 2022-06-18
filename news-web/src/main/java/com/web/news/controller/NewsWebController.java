package com.web.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsWebController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String BASE_QUERY_URL = "http://localhost:8899/news-query/";

    @GetMapping("/queryNews")
    public ModelAndView queryNews() {
        // 新闻列表
        List list = restTemplate.getForObject(BASE_QUERY_URL + "queryNews", List.class);
        // 新闻分类列表
        List categoryList = restTemplate.getForObject(BASE_QUERY_URL + "findAllCategory", List.class);

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList",list);
        mv.addObject("categoryList",categoryList);
        mv.setViewName("index");
        return mv;
    }
}
