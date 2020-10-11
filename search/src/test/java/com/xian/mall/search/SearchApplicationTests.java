package com.xian.mall.search;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static com.xian.mall.search.controller.MallESConfig.COMMON_OPTIONS;

@SpringBootTest
class SearchApplicationTests {
	@Autowired
	private RestHighLevelClient restHighLevelClient;

	@Test
	void contextLoads() {
		System.out.println(restHighLevelClient);

	}

	@Data
	class User{
		private String userName;
		private Integer age;
	}


	@Test
	void indexData() throws IOException {

		User user = new User();
		user.setUserName("zhangsan");
		user.setAge(18);

		String s = JSON.toJSONString(user);
		IndexRequest indexRequest = new IndexRequest("user");
		indexRequest.id("2");
		indexRequest.source(s, XContentType.JSON);

		IndexResponse index = restHighLevelClient.index(indexRequest, COMMON_OPTIONS);

		System.out.println(index);
	}

}
