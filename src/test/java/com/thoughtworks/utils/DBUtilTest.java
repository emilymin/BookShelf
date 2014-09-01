package com.thoughtworks.utils;

import com.thoughtworks.domain.PhysicalBook;
import com.thoughtworks.mapper.LoadPhyRowMapper;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DBUtilTest {

    @Test
    public void should_return_complete_sql(){
        String result = DBUtil.generateSQL("INSERT INTO BOOKS (ISBN, NAME, AUTHOR, LOCATION, TYPE) VALUES(?, ?, ?, ?, ?)", Arrays.asList("1", "2", "3", "4", "5"));
        String expectedResult = "INSERT INTO BOOKS (ISBN, NAME, AUTHOR, LOCATION, TYPE) VALUES(1, 2, 3, 4, 5)";

        assertThat(result, is(expectedResult));
    }

    @Test
    public void should_insert_correct_parameters() throws Exception {
        DBUtil.update("INSERT INTO BOOKS (ISBN, NAME, AUTHOR, LOCATION, TYPE) VALUES(?, ?, ?, ?, ?)", Arrays.asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void should_return_query_result() throws Exception {
        List<PhysicalBook> bookList = DBUtil.query("SELECT * FROM BOOKS WHERE TYPE = \"ELECTRONIC\"", Arrays.asList(""), new LoadPhyRowMapper());
        PhysicalBook book = bookList.get(0);
    }
}