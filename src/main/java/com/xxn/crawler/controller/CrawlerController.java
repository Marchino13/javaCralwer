package com.xxn.crawler.controller;

import com.xxn.crawler.result.Result;
import com.xxn.crawler.utiles.CrawlerUtils;
import org.springframework.web.bind.annotation.*;
import us.codecraft.webmagic.Spider;

/**
 *
 * @author Marchino
 * @date 2024/7/2 21:30
 * @description
 */

@RestController
@RequestMapping("/crawler")
public class CrawlerController {

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@RequestBody String userStr){ // 把前台发过来的 json字符串 转成java对象
//        System.out.println(userStr);
//        return "SUCCESS";
//    }

    @RequestMapping(value = "/url",method = RequestMethod.POST)
    public String getUrl(@RequestBody String url){ // 把前台发过来的 json字符串 转成java对象
        System.out.println(url);
        if(url.equals("404")) return "False";



        return "Success";
    }


    @RequestMapping("/start")
    public void start(String url) {
        System.out.println(url);
        MyProcessor myProcessor = new MyProcessor();
        myProcessor.start();
    }

    /***
     * @description 传入一个url，使用默认配置， 获取该url的页面信息,不对信息进行任何处理
     * @param: url
     * @return void
     * @author Marchino
     * @date 11:04 2024/7/3
     */
    @GetMapping("/getByUrl")
    public Result<String> getByUrl(String url){
        System.out.println(url);
        CrawlerUtils crawlerUtils = new CrawlerUtils();
        crawlerUtils.getByUrl(url);
        Spider.create(crawlerUtils).addUrl(url).thread(5).run();
        return Result.success("爬取成功");
    }




}
