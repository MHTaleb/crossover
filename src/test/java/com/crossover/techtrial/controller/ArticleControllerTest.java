/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.techtrial.controller;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crossover.techtrial.model.Article;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ArticleControllerTest {

    @Autowired
	private TestRestTemplate template;

	@Before
	public void setup() throws Exception {

	}

	@Test
	public void testArticleShouldBeCreated() throws Exception {
		HttpEntity<Object> article = getHttpEntity("{\"email\": \"user1@gmail.com\", \"title\": \"hello\", \"content\": \"content\" }");
		ResponseEntity<Article> resultAsset = template.postForEntity("/articles", article, Article.class);
		Assert.assertNotNull(resultAsset.getBody().getId());
		Assert.assertNotNull(resultAsset.getBody().getContent());
		Assert.assertNotNull(resultAsset.getBody().getTitle());
		Assert.assertNotNull(resultAsset.getBody().getEmail() );
	}
	

	private HttpEntity<Object> getHttpEntity(Object body) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Object>(body, headers);
	}
    
    
    
    

}
