package com.examples.spring.boot.data.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchAsyncClient;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.ElasticsearchIndicesClient;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(classes = ElasticSearchApplication.class)
class ElasticSearchApplicationTests {

    @Test
    public void test01() throws IOException {
        RestClientBuilder builder = RestClient.builder(new HttpHost("geminis", 9200, "http"));
        RestClient restClient = builder.build();
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        ElasticsearchClient client = new ElasticsearchClient(transport);
        ElasticsearchAsyncClient asyncClient = new ElasticsearchAsyncClient(transport);
        ElasticsearchIndicesClient indexClient = client.indices();
        GetIndexResponse getIndexResponse = client.indices().get(req -> req.index("*"));
    }

}
