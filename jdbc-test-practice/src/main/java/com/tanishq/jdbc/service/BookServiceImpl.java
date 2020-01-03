package com.tanishq.jdbc.service;

import com.tanishq.jdbc.model.Book;

import java.sql.*;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final Statement statement;

    public BookServiceImpl(Statement statement){
        this.statement = statement;
    }
    public void save(Book book) {

    }

    public void update(double price, int id) {

    }

    public Book get(int id) throws SQLException {
        String sqlQuery = "Select * from BOOK where id="+id;
        System.out.println("Sql query to get data: "+sqlQuery);
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        resultSet.next();
        return new Book(resultSet.getInt(1) ,  resultSet.getString(2) , resultSet.getString(3) , resultSet.getInt(4));
    }

    public List<Book> getAll() {
        return null;
    }

    public void delete(int id) throws SQLException {
        String query = "delete from book where id="+id;
        System.out.println("Sql query to delete data: "+query);
        statement.execute(query);
        System.out.println("Successfully deleted record for id: "+id);
    }

    public void deleteAll() {

    }

}
