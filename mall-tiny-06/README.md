### Elasticsearch

> Elasticsearch 是一个分布式、可扩展、实时的搜索与数据分析引擎。 它能从项目一开始就赋予你的数据以搜索、分析和探索的能力，可用于实现全文搜索和实时数据统计。

windows 下安装与使用

官网下载

https://www.elastic.co/cn/downloads/elasticsearch

安装中文分词插件，在 elasticsearch-7.6.2\bin目录下执行以下命令：

```bash
elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v6.2.2/elasticsearch-analysis-ik-6.2.2.zip
```

运行bin目录下的 elasticsearch.bat 启动Elasticsearch

下载对应版本 kibana，作为访问  elasticsearch 的客户端

运行bin目录下的 kibana.bat，启动 Kibana 的用户界面

访问 [http://localhost:5601](http://localhost:5601/)  即可打开Kibana的用户界面

## Spring Data Elasticsearch

> Spring Data Elasticsearch是Spring提供的一种以Spring Data风格来操作数据存储的方式，它可以避免编写大量的样板代码。

SpringBoot 连接 ElasticSearch 有以下种方式，

- TransportClient，9300端口，在 7.x 中已经被弃用，据说在8.x 中将完全删除
- restClient，9200端口，
- high level client，新推出的连接方式，基于restClient。使用的版本需要保持和ES服务端的版本一致。

根据官方的建议，使用 high-level-client 进行链接。

导入依赖（两个版本保持一致）

```xml
<dependency>
    <groupId>org.elasticsearch</groupId>
    <artifactId>elasticsearch</artifactId>
    <version>7.6.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.elasticsearch.client/elasticsearch-rest-high-level-client -->
<dependency>
    <groupId>org.elasticsearch.client</groupId>
    <artifactId>elasticsearch-rest-high-level-client</artifactId>
    <version>7.6.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-elasticsearch -->
<dependency>
    <groupId>org.springframework.data</groupId>
    <artifactId>spring-data-elasticsearch</artifactId>
    <version>4.0.1.RELEASE</version>
</dependency>
```



