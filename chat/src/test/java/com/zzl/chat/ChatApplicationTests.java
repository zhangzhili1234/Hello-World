package com.zzl.chat;

import com.zzl.chat.mongobd.Book;
import com.zzl.chat.mongobd.MyMongodbRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MyMongodbRepository myMongodbRepository;

    @Test
    public void testMongoDBSave() {
        Book book = new Book("java学习", new Date());
        myMongodbRepository.save(book);
    }

    @Test
    public void testMongoDBFind() {
        List<Book> books = myMongodbRepository.findAll();
        books.forEach(System.out::println);
    }
}
