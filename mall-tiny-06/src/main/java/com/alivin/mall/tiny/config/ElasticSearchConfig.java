package com.alivin.mall.tiny.config;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URLConnection;

/**
 * 配置Elasticsearch的集群信息
 *
 * @author Fer
 * @date 2021/8/12
 */
@Configuration
public class ElasticSearchConfig {

    @Bean
    public RestHighLevelClient esRestClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        // 配置 elasticsearch
                        new HttpHost("127.0.0.1", 9200, "http"))
                /*.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
                    @Override
                    public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder builder) {
                        return builder.setConnectTimeout(5000 * 1000) // 连接超时（默认为1秒）
                                .setSocketTimeout(6000 * 1000);// 套接字超时（默认为30秒）//更改客户端的超时限制默认30秒现在改为100*1000分钟
                    }
                })*/
        );
    }

}
