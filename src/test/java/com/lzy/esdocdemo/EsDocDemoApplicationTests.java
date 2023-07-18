package com.lzy.esdocdemo;

import com.lzy.esdocdemo.pojo.Book;
import com.lzy.esdocdemo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
class EsDocDemoApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void TestBookRepositoryInsert(){
        Book book1 = bookRepository.save(new Book("1", "西游记", "降妖除魔", 15));


        System.out.println(book1);
    }
    @Test
    void TestBookRepositoryfindByNameAndPrice(){

        List<Book> books = bookRepository.findByNameAndPrice("挪威的森林", 199);
        for (Book book: books
             ) {
            System.out.println(book);
        }
    }

    @Test
    void TestBookRepositoryfindByName(){
        Page<Book> page = bookRepository.findByName("挪威的森林", PageRequest.of(0, 5));
        for (Book book: page
        ) {
            System.out.println(book);
        }
    }

    @Test
    void TestBookRepositoryfindById(){
        List<Book> books = bookRepository.getByIds(Stream.of("1", "2", "3").collect(Collectors.toList()));
        for (Book book: books
             ) {
            System.out.println(book);
        }
    }
    @Test
    void test() {
        Optional<Book> book = bookRepository.findById("1");
        System.out.println(book.get());

    }



}
