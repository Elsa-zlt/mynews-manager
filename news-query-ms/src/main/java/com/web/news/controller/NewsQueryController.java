package com.web.news.controller;

import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsQueryController {
    @Autowired
    private NewsQueryService newsQueryService;

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
