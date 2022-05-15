package com.web.news.service.impl;

import com.web.news.mapper.CategoryMapper;
import com.web.news.mapper.NewsMapper;
import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsQueryServiceImpl implements NewsQueryService {

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询所有新闻列表
     * @return
     */
    @Override
    public List<News> queryNews() {
        return newsMapper.selectByExample(null);
    }

    /**
     * 根据新闻分类和标题查询新闻列表
     * @param news
     * @return
     */
    @Override
    public List<News> queryNews(News news) {
        return newsMapper.selectByExample(null);
    }

    /**
     * 查询所有新闻类别
     * @return
     */
    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.selectByExample(null);
    }

    /**
     * 根据唯一标识查询单条新闻
     * @return
     */
    @Override
    public News findNewsById(int id) {
        return newsMapper.selectByPrimaryKey(id);
    }

}
