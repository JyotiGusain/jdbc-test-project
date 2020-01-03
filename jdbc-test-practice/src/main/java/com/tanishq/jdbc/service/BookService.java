package com.tanishq.jdbc.service;

import com.tanishq.jdbc.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {

    /*
    Method to save book object in database
     */
    void save(Book book);

    /*

     */
    void update(double price, int id);

    /*

     */
    Book get(int id) throws SQLException;

    /*

     */
    List<Book> getAll();

    /*

     */
    void delete(int id) throws SQLException;

    /*

     */
    void deleteAll();
}
