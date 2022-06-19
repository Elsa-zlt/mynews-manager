package com.web.news.controller;
import com.web.news.service.NewsEditService;
import com.web.news.pojo.News;
import com.web.news.pojo.RespBean;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsEditController {
    @Autowired
    private NewsEditService newsEditService;

    @PostMapping ("/updateNews")
    public RespBean updateNews(@RequestBody News news){
        System.out.println(news);

        try{
            System.out.println("news id:" + news.getId());
            System.out.println("news title:" + news.getTitle());
            newsEditService.updateNews(news);
            return RespBean.ok("修改成功",news);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.err("修改失败");
        }
    }

    @PostMapping("/addNews")
    public RespBean addNews(@RequestBody News news){
        System.out.println(news);
        try {
            System.out.println("news id:" + news.getId());
            System.out.println("news title:" + news.getTitle());
            newsEditService.addNews(news);
            return RespBean.ok("添加成功",news);
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.err("添加失败");
        }
    }

    @GetMapping("/removeNews")
    public RespBean removeNews(int[] ids){
        try {
            System.out.println("news id:" + ids[0]);
            newsEditService.removeNews(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.err("删除失败");
        }
    }
}