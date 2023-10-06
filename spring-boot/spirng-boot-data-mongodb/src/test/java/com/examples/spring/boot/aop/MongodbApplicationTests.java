package com.examples.spring.boot.aop;

import com.examples.spring.boot.aop.entity.Book;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
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
        Book book = new Book();
        book.setId(1000L);
        book.setName("HelloWorld");
        book.setType("happy");
        book.setDescription("very good book.");
        mongoTemplate.save(book);
    }

    @Test
    public void findTest() {
        Book book = mongoTemplate.findById(1000L, Book.class);
    }

    @Test
    public void removeTest() {
        DeleteResult result1 = mongoTemplate.remove(new Book(10L));
        DeleteResult result2 = mongoTemplate.remove(new Book(100L));
        DeleteResult result3 = mongoTemplate.remove(new Book(1000L));
        DeleteResult result4 = mongoTemplate.remove(new Book(10086L));
    }

}
