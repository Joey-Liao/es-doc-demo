package com.lzy.esdocdemo.repository;


import com.lzy.esdocdemo.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends CrudRepository<Book,String> {
    /**
     * @descriptions
     * {
     *     "query": {
     *         "bool" : {
     *             "must" : [
     *                 { "query_string" : { "query" : "?", "fields" : [ "name" ] } },
     *                 { "query_string" : { "query" : "?", "fields" : [ "price" ] } }
     *             ]
     *         }
     *     }
     * }
     * @author Joey Liao
     * @date 2023/6/20 10:15
     * @param name
     * @param price
     * @return java.util.List<java.awt.print.Book>
     */
    List<Book> findByNameAndPrice(String name, double price);


    /**
     * @descriptions 如果使用参数John调用该函数，它将产生以下查询主体：对于第一个、第二个、第三个参数等，占位符的形式为?0、等。?1?2
     * {
     *   "query": {
     *     "match": {
     *       "name": {
     *         "query": "John"
     *       }
     *     }
     *   }
     * }
     * @author Joey Liao
     * @date 2023/6/20 10:20
     * @param name
     * @param pageable
     * @return org.springframework.data.domain.Page<java.awt.print.Book>
     */
    @Query("{\"match\": {\"name\": {\"query\": \"?0\"}}}")
    Page<Book> findByName(String name, Pageable pageable);


    /**
     * @descriptions 功能描述
     * {
     *   "query": {
     *     "ids": {
     *       "values": ["id1", "id2", "id3"]
     *     }
     *   }
     * }
     * @author Joey Liao
     * @date 2023/6/20 10:27
     * @param ids
     * @return java.util.List<java.awt.print.Book>
     */
    @Query("{\"ids\": {\"values\": ?0 }}")
    List<Book> getByIds(Collection<String> ids);


}