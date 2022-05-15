package com.web.news.service.impl;

import com.web.news.mapper.NewsMapper;
import com.web.news.pojo.News;
import com.web.news.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsQueryServiceImpl implements NewsQueryService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> queryNews() {
        return newsMapper.selectByExample(null);
    }

}
