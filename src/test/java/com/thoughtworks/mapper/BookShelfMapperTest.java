package com.thoughtworks.mapper;

import com.thoughtworks.model.Book;
import com.thoughtworks.model.BookShelf;
import com.thoughtworks.model.PhysicalBook;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class BookShelfMapperTest {

    private JdbcTemplate jdbcTemplate;
    private BookShelfMapper bookShelfMapper;

    @Before
    public  void setUp(){
        jdbcTemplate= Mockito.mock(JdbcTemplate.class);
        bookShelfMapper= new BookShelfMapper();
        bookShelfMapper.setJdbcTemplate(jdbcTemplate);
    }

    @Test
    public void should_get_physical_books() throws Exception {
        String sql = BookShelfMapper.QUERYBOOK_SQL + "ISBN1";

        PhysicalBook physicalBook1 = new PhysicalBook("ISBN1", "Book1", 20.0, "author1");
        PhysicalBook physicalBook2 = new PhysicalBook("ISBN2", "Book2", 20.0, "author2");
        BookShelf bookShelf = new BookShelf();
        bookShelf.addPhysicalBook(physicalBook1);
        List<Book> bookList = new ArrayList<Book>();
        List<PhysicalBook> bookList1 = new ArrayList<PhysicalBook>();
        bookList.add(physicalBook1);
        bookList.add(physicalBook2);
        bookList1 = bookShelf.getPhysicalBookList();

        when(jdbcTemplate.queryForObject(Mockito.eq(sql), Mockito.any(LoadRowMapper.class))).thenReturn(physicalBook1);
        assertThat(bookShelf.getBookShelfSize(), is(bookList1.size()));
    }

    @Test
    public void should_add_physical_book() throws Exception {
        String sql = BookShelfMapper.INSERTBOOK_SQL;

        PhysicalBook physicalBook1 = new PhysicalBook("ISBN1", "Book1", 20.0, "author1");
        BookShelf bookShelf = new BookShelf();
        bookShelf.addPhysicalBook(physicalBook1);

        when(jdbcTemplate.update(Mockito.eq(sql), Mockito.any(LoadRowMapper.class))).thenReturn(any(Integer.class));
        assertThat(bookShelf.getBookShelfSize(), is(1));

    }
}