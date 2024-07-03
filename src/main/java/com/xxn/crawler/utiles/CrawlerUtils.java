package com.xxn.crawler.utiles;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author Marchino
 * @date 2024/7/3 10:48
 * @description
 */

public class CrawlerUtils implements PageProcessor {
    
    /***
     * @description 定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     * @param: page
     * @return void
     * @author Marchino
     * @date 10:50 2024/7/3
     */

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return null;
    }

    /***
     * @description 传入一个url，获取该url的页面信息
     * @param: url
     * @return void
     * @author Marchino
     * @date 10:58 2024/7/3
     */
    public void getByUrl(String url){

    }

}
