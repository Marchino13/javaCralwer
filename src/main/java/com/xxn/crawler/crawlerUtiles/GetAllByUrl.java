package com.xxn.crawler.crawlerUtiles;

import com.xxn.crawler.controller.MyProcessor;
import org.springframework.stereotype.Component;
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

@Component
public class GetAllByUrl implements PageProcessor {
    private String url;
    private String path;
    private Spider spider;

    public GetAllByUrl() {
    }

    public GetAllByUrl(String url, String path) {
        this.url = url;
        this.path = path;
    }

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

    /***
     * @description 爬取数据并以String格式返回, 同时将数据保存到本地
     * @param:
     * @return java.lang.String
     * @author Marchino
     * @date 21:59 2024/7/3
     */
    public String start(){
        spider = Spider.create(new MyProcessor())
                .addUrl(url)
                .addPipeline(new FilePipeline(path))
                .thread(5);
        spider.start();
        return null;
    }

    public void stop(){
        spider.stop();
    }
}
