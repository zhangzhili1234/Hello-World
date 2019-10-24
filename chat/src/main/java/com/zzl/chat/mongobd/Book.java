package com.zzl.chat.mongobd;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @author john（coder_john@163.com）
 * @desc 书籍对象
 * @date 2019-09-23
 */
@Getter
@Setter
@ToString
@Document(collection = "books")
public class Book implements Serializable {

    private static final long serialVersionUID = -207437731484463063L;

    @Id
    private String id;

    @Transient
    @Field
    @Indexed
    private String title;

    private Date publishDate;

    public Book() {
    }

    public Book(String title, Date publishDate) {
        this.title = title;
        this.publishDate = publishDate;
    }

    public Book(String id, String title, Date publishDate) {
        this.id = id;
        this.title = title;
        this.publishDate = publishDate;
    }
}
