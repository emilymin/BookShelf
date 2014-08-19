package com.thoughtworks.service;

import com.thoughtworks.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookShelfService {
    /**
     * 根据ISBN号借阅一本书，借阅之后书的状态需要更新，电子书支持无限次借阅
     *
     * @param bookIsbn
     * @return
     */
    public Book borrowBook(String bookIsbn);

    /**
     * 根据书的名称查询书籍，支持模糊查询，结果按照isbn号排序，优先返回电子书
     *
     * @param bookName
     * @return
     */
    public List<Book> queryBookByName(String bookName);

    /**
     * 往书架上增加一本书
     * @param book
     * @return
     */
    public boolean addBook(Book book);

    /**
     * 返回所有电子书的名称和书的Map
     * @return
     */
    public Map<String,Book> queryAllEBookNames();

    public int bookAmount();

}

