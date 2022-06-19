package com.web.news.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.web.news.pojo.Category;
import com.web.news.pojo.News;
import com.web.news.pojo.PageResult;
import com.web.news.service.NewsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class NewsQueryController {
    @Autowired
    private NewsQueryService newsQueryService;

    @GetMapping("/queryNews")
    public List<News> queryNews(){
        return newsQueryService.findAllNews();
    }

    @PostMapping("/queryNewsByCondition")
    public List<News> queryNewsByCondition(@RequestBody News news) {
        System.out.println(news.getCategoryid());
        System.out.println(news.getTitle());
        return newsQueryService.findNewsByCondition(news);
    }

    @GetMapping("/findAllCategory")
    public List<Category> findAllCategory(){
        return newsQueryService.findAllCategory();
    }

    @GetMapping("/findNewsById/{id}")
    public News findNewsById(@PathVariable int id){
        return newsQueryService.findNewsById(id);
    }

    @GetMapping("/findByPage")
    public PageResult findByPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);//分页的拦截，重构分页的sql
        Page<News> page = (Page<News>) newsQueryService.findAllNews();
        PageResult pageResult = new PageResult();
        pageResult.setRows(page.getResult());
        pageResult.setTotal(page.getTotal());
        return pageResult;
    }

}
