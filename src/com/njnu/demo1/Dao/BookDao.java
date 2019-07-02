package com.njnu.demo1.Dao;

import com.njnu.demo1.Bean.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao extends BaseDao{
    public List<Book> findAll()
    {
        String sql="select * from book";
        return this.getListBySql(Book.class,sql);
    }
}
