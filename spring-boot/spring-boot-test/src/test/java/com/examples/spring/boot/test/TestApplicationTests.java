package com.examples.spring.boot.test;

import com.examples.spring.boot.test.entity.Machine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest(classes = TestApplication.class)
class TestApplicationTests {

    @BeforeAll
    public static void before01() {
      log.info("before start");
    }

    @Test
    public void spyTest() {
        Machine machine = new Machine();
        machine.setName("Jack");
        machine.setAge(25);
        machine.setSex(false);
        Machine spy = spy(machine);
        when(spy.getName()).thenReturn("Mark");
        System.out.println(spy.getName());
    }


}
