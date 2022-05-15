package com.web.news.controller;

import com.web.news.pojo.News;
import com.web.news.pojo.RespBean;
import com.web.news.service.NewsEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsEditController {

    @Autowired
    private NewsEditService newsEditService;

    @PutMapping("updateNews")
    public RespBean updateNews(@RequestBody News news) {
        try {
            // id会回填到news对象中
            newsEditService.updateNews(news);
            return RespBean.ok("修改成功",news);
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.err("修改失败");
        }
    }

}
