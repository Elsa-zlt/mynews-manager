package com.web.news.service.impl;

import com.web.news.mapper.CategoryMapper;
import com.web.news.mapper.NewsMapper;
import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.pojo.NewsExample;
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

    @Override
    public List<News> findAllNews() {
        return newsMapper.selectByExample(null);
    }

    @Override
    public List<News> findNewsByCondition(News news) {
        NewsExample example = new NewsExample();
        NewsExample.Criteria criteria = example.createCriteria();
        if (news!=null){
            if (news.getCategoryid()!=0) {
                criteria.andCategoryidEqualTo(news.getCategoryid());
            }
            if (news.getTitle()!=null && !"".equals(news.getTitle())) {
                criteria.andTitleLike("%" + news.getTitle() + "%");
            }
        }
        List<News> list = newsMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public News findNewsById(Integer id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
