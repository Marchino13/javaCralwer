package com.xxn.crawler;

import com.xxn.crawler.crawlerUtiles.GetAllByUrl;

public class Test {
    public static void main(String[] args) {
        GetAllByUrl getAllByUrl = new GetAllByUrl("https://www.itheima.com/", "D:\\test");
        getAllByUrl.start();
    }
}
