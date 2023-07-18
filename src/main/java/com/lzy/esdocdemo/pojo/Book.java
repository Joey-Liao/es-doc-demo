package com.lzy.esdocdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @descriptions: '
 * @author: Joey Liao
 * @date: 2023/6/20 10:11
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(indexName="book")
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String summary;

    @Field(type = FieldType.Double)
    private Integer price;

    // getter/setter ...
}
