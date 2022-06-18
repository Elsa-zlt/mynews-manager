package com.web.news.service;

import com.web.news.pojo.Category;
import com.web.news.pojo.News;

import java.util.List;

public interface NewsQueryService {
    /**
     * 查询所有新闻列表
     * @return
     */
    public List<News> findAllNews();
    /**
     * 根据新闻分类和标题查询新闻列表
     * @param news
     * @return
     */
    public List<News> findNewsByCondition(News news);
    /**
     * 查询所有新闻类别
     * @return
     */
    public List<Category> findAllCategory();
    /**
     * 根据唯一标识查询单条新闻
     * @return
     */
    public News findNewsById(Integer id);
}