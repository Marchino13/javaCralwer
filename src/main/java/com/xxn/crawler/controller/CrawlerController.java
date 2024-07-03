package com.xxn.crawler.controller;

import com.xxn.crawler.result.Result;
import com.xxn.crawler.crawlerUtiles.GetAllByUrl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marchino
 * @date 2024/7/2 21:30
 * @description
 */

@RestController
@RequestMapping("/crawler")
public class CrawlerController {

    @RequestMapping("/start")
    public void start(String url) {
        GetAllByUrl.start("https://www.jd.com/");
    }

    /***
     * @description 传入一个url，使用默认配置， 获取该url的页面信息,不对信息进行任何处理
     * @param: url
     * @return void
     * @author Marchino
     * @date 11:04 2024/7/3
     */
    @GetMapping("/getByUrl")
    public Result<String> getByUrl(String url) {
        return
                null;
    }


}
