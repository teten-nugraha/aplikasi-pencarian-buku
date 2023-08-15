/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id.ten.belajar.hibernate;

import id.ten.belajar.hibernate.dao.BookDao;
import id.ten.belajar.hibernate.dao.BookDaoImpl;
import id.ten.belajar.hibernate.models.Book;
import id.ten.belajar.hibernate.presenter.BookPresenter;
import java.util.List;

/**
 *
 * @author teten.nugraha
 */
public class BelajarHibernate {

    public static void main(String[] args) {
        
        BookDao bookDao = new BookDaoImpl();
        
        BookPresenter bookPresenter = new BookPresenter(bookDao);
        bookPresenter.setVisible(true);
        
    }
}
