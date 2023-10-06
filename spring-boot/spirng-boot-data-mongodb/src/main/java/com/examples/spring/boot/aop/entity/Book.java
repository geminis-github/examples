package com.examples.spring.boot.aop.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * 书
 *
 * @author: Thinking9527
 * @date: 2023-04-01 23:29
 */
@Data
public class Book {

    @MongoId
    private Long id;

    private String name;

    private String type;

    private String description;

    public Book() {

    }

    public Book(Long id) {
        this.id = id;
    }
}
