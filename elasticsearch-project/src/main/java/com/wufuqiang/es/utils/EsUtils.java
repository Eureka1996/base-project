package com.wufuqiang.es.utils;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexRequest;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.wufuqiang.es.entities.Goods;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wufuqiang
 * @date 2022/2/5 5:23 PM
 **/

public class EsUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(EsUtils.class);

    private ElasticsearchClient client ;

    public ElasticsearchClient getClient(){
        if(this.client != null) return client;
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        ElasticsearchClient client = new ElasticsearchClient(transport);
        this.client = client;
        return this.client;
    }

    public void createIndex(String indexName) throws IOException {
        ElasticsearchClient client = getClient();
        //CreateIndexRequest userIndexRequest = new CreateIndexRequest.Builder().index(indexName).build();
        //CreateIndexResponse createIndexResponse = client.indices().create(userIndexRequest);
        CreateIndexResponse createIndexResponse = client.indices().create(c -> c.index(indexName));
        LOGGER.info("创建index：{}，是否成功:{}",indexName,createIndexResponse.acknowledged());
    }

    public void deleteIndex(String indexName) throws IOException {
        ElasticsearchClient client = getClient();
        //DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(indexName).build();
        //DeleteIndexResponse deleteIndexResponse = client.indices().delete(deleteIndexRequest);
        DeleteIndexResponse deleteIndexResponse = client.indices().delete(c -> c.index(indexName));
        LOGGER.info("删除index:{},是否成功：{}",indexName,deleteIndexResponse.acknowledged());
    }

    public void insertDocument() throws IOException {
        ElasticsearchClient client = getClient();
        Goods goods = new Goods("title","category","images",3.14);
        IndexRequest<Goods> indexRequest = new IndexRequest.Builder<Goods>()
                .index("user")
                .document(goods)
                .build();


        IndexResponse indexResponse = client.index(indexRequest);
        LOGGER.info("插入数据：{}，id：{}",goods,indexResponse.id());
        LOGGER.info("result:{}",indexResponse.result());
    }



    public void search() throws IOException {
        ElasticsearchClient client = getClient();
        SearchResponse<Goods> shopping = client.search(s -> s.index("shopping"), Goods.class);

        shopping.hits().hits().forEach(goodsHit -> {
            LOGGER.info("产品信息：{}",goodsHit.source());
        });
    }

    public void insertBatch(String indexName) throws IOException {
        ElasticsearchClient client = getClient();

        List<BulkOperation> bulkOperationList = new ArrayList<>();


        Goods goods = new Goods("title2","category2","images2",3.1415);
        bulkOperationList.add(new BulkOperation.Builder().create(e -> e.document(goods)).build());

        //BulkOperation build = new BulkOperation.Builder().delete(e -> e.id("1001")).build();


        //BulkRequest bulkRequest = new BulkRequest.Builder().index(indexName).operations(bulkOperationList).build();
        //client.bulk(bulkRequest);

        BulkResponse bulkResponse = client.bulk(bulkRequest -> bulkRequest.index(indexName).operations(bulkOperationList));
        LOGGER.info("批量插入数据，index:{}：error:{}",indexName,bulkResponse.errors());
    }

}
