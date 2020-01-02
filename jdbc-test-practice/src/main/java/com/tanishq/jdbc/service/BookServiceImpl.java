package com.tanishq.jdbc.service;

import com.tanishq.jdbc.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookServiceImpl implements BookService {

    private final Connection connection;

    public BookServiceImpl(Connection connection){
        this.connection = connection;
    }
    public void save(Book book) {

    }

    public void update(double price, int id) {

    }

    public Book get(int id) throws SQLException {
        Book book = null;
        String sqlQuery = "Select * from BOOK where id="+id;
        System.out.println("Sql query to get data: "+sqlQuery);
        Statement statement = getStatement(this.connection);
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
             book = new Book(resultSet.getInt(1) ,  resultSet.getString(2) , resultSet.getString(3) , resultSet.getInt(4));
        }
        return book;
    }

    public List<Book> getAll() {
        return null;
    }

    public void delete(int id) {

    }

    private Statement getStatement(Connection connection){
        Statement statement = null;
        try {
            statement =  connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  statement;
    }
}
