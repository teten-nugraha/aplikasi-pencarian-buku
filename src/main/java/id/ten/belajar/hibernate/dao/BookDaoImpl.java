package id.ten.belajar.hibernate.dao;

import id.ten.belajar.hibernate.conf.HibernateConfiguration;
import id.ten.belajar.hibernate.models.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author teten.nugraha
 */
public class BookDaoImpl implements BookDao{
    
    private SessionFactory factory = HibernateConfiguration.getFactory();
    
    @Override
    public void saveBook(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
                transaction = session.beginTransaction();
                session.save(book);
                transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                    transaction.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public Book getById(long id) {
        Transaction transaction = null;
        Book book = null;
        Session session = null;
        try {
            session = factory.openSession();
                transaction = session.beginTransaction();
                book = session.get(Book.class, id);
                transaction.commit();
        } catch (Exception e) {
                if(transaction != null)
                        transaction.rollback();
        }finally{
            session.close();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        Transaction transaction = null;
        List<Book> books = null;
        Session session = null;
        try {
            session = factory.openSession();
                transaction = session.beginTransaction();
                books = session.createQuery("from Book").list();
                transaction.commit();
        } catch (Exception e) {
                if(transaction != null)
                        transaction.rollback();
        }finally{
            session.close();
        }
        return books;
    }

    @Override
    public void updateBook(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
                transaction = session.beginTransaction();
                session.saveOrUpdate(book);
                transaction.commit();
        } catch (Exception e) {
                if(transaction != null)
                        transaction.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public void deleteBookById(long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
                transaction = session.beginTransaction();
                Book book = session.get(Book.class, id);
                session.delete(book);
                transaction.commit();
        } catch (Exception e) {
                if(transaction != null)
                        transaction.rollback();
        }finally{
            session.close();
        }
    }

    @Override
    public List<Book> getAllBooksByTitle(String title) {
        Transaction transaction = null;
        List<Book> books = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("select p from Book p where p.title  like :title");
            query.setParameter("title", "%" + title + "%");
            books = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null)
                    transaction.rollback();
        }finally{
            session.close();
        }
        return books;
    }
    
}
