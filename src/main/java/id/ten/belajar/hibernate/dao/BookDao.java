/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package id.ten.belajar.hibernate.dao;

import id.ten.belajar.hibernate.models.Book;
import java.util.List;

/**
 *
 * @author teten.nugraha
 */
public interface BookDao {
    void saveBook(Book book);
    Book getById(long id);
    List<Book> getAllBooks();
    List<Book> getAllBooksByTitle(String title);
    void updateBook(Book book);
    void deleteBookById(long id);
}
