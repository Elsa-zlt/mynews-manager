package com.web.news.controller;

import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class NewsQueryController {
    @Autowired
    private NewsQueryService newsQueryService;

    @Autowired
    private RestTemplate restTemplate;

    public String baseURL = "http://localhost:8877/";

    @GetMapping("queryNews1")
    public ModelAndView queryNews1() {
        // 泛型： LinkedHashMap
        List list = restTemplate.getForObject(baseURL + "queryNews", List.class);
        System.out.println(list);

        ModelAndView mv = new ModelAndView();
        mv.addObject("newsList",list);
        mv.setViewName("index");
        return mv;
    }

    /**
     * 查询所有新闻列表
     * @return
     */
    @GetMapping("queryNews")
    public List<News> queryNews() {
        return newsQueryService.queryNews();
    }

    /**
     * 根据新闻分类和标题查询新闻列表
     * @param news
     * @return
     */
    @GetMapping("queryNewsByCategoryAndTitle")
    public List<News> queryNewsByCategoryAndTitle(News news) {
        return newsQueryService.queryNews(news);
    }

    /**
     * 查询所有新闻类别
     * @return
     */
    @GetMapping("findAllCategory")
    public List<Category> findAllCategory() {
        return newsQueryService.findAllCategory();
    }

    /**
     * 根据唯一标识查询单条新闻
     * @return
     */
    @GetMapping("findNewsById/{id}")
    public News findNewsById(@PathVariable int id) {
        return newsQueryService.findNewsById(id);
    }

}
