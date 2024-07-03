package com.xxn.crawler.crawlerUtiles;

import com.xxn.crawler.controller.MyProcessor;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author Marchino
 * @date 2024/7/3 16:27
 * @description 传入一个url，使用默认配置， 获取该url的页面信息,不对信息进行任何处理
 */

public class GetAllByUrl implements PageProcessor {


    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);
    @Override
    public void process(Page page) {
        String html = page.getHtml().toString();
        page.putField("html", html);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void start(String url){
        Spider.create(new MyProcessor())
                .addUrl(url)
                .addPipeline(new FilePipeline("D:\\webmagic\\"))
                .thread(5)
                .run();
    }
}
