package com.xian.mall.search.controller;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Controller;

@Controller
public class MallESConfig {


    public static final RequestOptions COMMON_OPTIONS;
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();


        COMMON_OPTIONS = builder.build();
    }



    /**
     * 基本配置方法
     * @return
     */
    public RestHighLevelClient esRestClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("47.103.199.145", 9200, "http")
                )
        );

        return client;

    }



}
