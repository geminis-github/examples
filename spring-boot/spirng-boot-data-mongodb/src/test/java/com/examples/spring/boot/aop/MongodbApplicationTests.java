package com.examples.spring.boot.aop;

import com.examples.spring.boot.aop.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * mongodb测试用例
 *
 * @author Thinking9527
 * @date 2023-04-01 22:48
 */
@Slf4j
@SpringBootTest(classes = MongodbApplication.class)
public class MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void saveTest() {
        Book helloWorldBook = new Book();
        helloWorldBook.setId(ObjectId.get());
        helloWorldBook.setName("HelloWorld");
        helloWorldBook.setType("happy");
        helloWorldBook.setDescription("very good redBook.");
        mongoTemplate.save(helloWorldBook);

        Book redBook = new Book();
        redBook.setId(ObjectId.get());
        redBook.setName("Red");
        redBook.setType("Learn");
        redBook.setDescription("The Red");
        mongoTemplate.save(redBook);
    }

    @Test
    public void findTest() {
        Book book = mongoTemplate.findById("656b474af197b02ad4d12cb3", Book.class);
    }


}
