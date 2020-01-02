package com.tanishq.jdbc;

import com.tanishq.jdbc.model.Book;
import com.tanishq.jdbc.service.BookService;
import com.tanishq.jdbc.service.BookServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcOperation {

    public static void main(String[] args) throws SQLException {
        BookService bookService = new BookServiceImpl(getConnection());
        int id = 500;
        //1
        System.out.println("Store book");
        Book tanishqBook = new Book(id, "Taishq Book", "Tanishq", 600.0);
        bookService.save(tanishqBook);

        //2
        System.out.println("ReaD BOOk");
        Book book =  bookService.get(id);
        System.out.println(book);

        //3
        System.out.println("Update book");
        bookService.update(50000.0, id);
        System.out.println("ReaD updated BOOk");
        Book book2 =  bookService.get(id);
        System.out.println(book2);

        //4
        System.out.println("Delete book");
        bookService.delete(id);

        //5
        Book book1 = bookService.get(id);
        System.out.println(book1 ==null);


    }

    private static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.h2.Driver");

            System.out.println("About to create database connection");
            con = DriverManager.
                    getConnection("jdbc:h2:tcp://localhost/./esha;IFEXISTS=TRUE", "sa", "sa");
            System.out.println("database connection created successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
}
