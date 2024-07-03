package com.xxn.crawler.controller;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author Marchino
 * @date 2024/7/2 20:42
 * @description
 */

public class MyProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);


    @Override
    public void process(Page page) {
        String title = page.getHtml().xpath("//title/text()").toString();
        page.putField("title", title);
    }

    @Override
    public Site getSite() {
        return site;
    }


    public void start() {
        Spider.create(new MyProcessor())
                .addUrl("https://www.jd.com/")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(3)
                .run();
    }

    public static void main(String[] args) {
        Spider.create(new MyProcessor())
                .addUrl("https://www.jd.com/")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
                .thread(3)
                .run();
    }

}
