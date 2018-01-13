package com.walking.techie;

import com.walking.techie.model.Book;
import com.walking.techie.model.Chapter;
import com.walking.techie.model.ChapterPrimaryKey;
import com.walking.techie.model.Publisher;
import com.walking.techie.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class BookStoreClient {
    public static void main(String[] args) {
        // All Book information
        List<Chapter> chapters = new LinkedList<>();
        Publisher publisher = new Publisher("TECH", "Java Publications");

        Book book = new Book("123456789", "Java Persistence with Hibernate", publisher, chapters);
        ChapterPrimaryKey cpk1 = new ChapterPrimaryKey(1, book);
        ChapterPrimaryKey cpk2 = new ChapterPrimaryKey(2, book);
        Chapter chapter1 = new Chapter("Introduction of Hibernate", cpk1);
        Chapter chapter2 = new Chapter("Introduction of JPA and Hibernate", cpk2);

        chapters.add(chapter1);
        chapters.add(chapter2);

        List<Chapter> chapters1 = new LinkedList<>();
        Publisher publisher1 = new Publisher("MANN", "Java Publications");
        Book book1 = new Book("123456799", "Java Persistence with Hibernate", publisher1, chapters1);
        ChapterPrimaryKey cpk3 = new ChapterPrimaryKey(1, book1);
        ChapterPrimaryKey cpk4 = new ChapterPrimaryKey(2, book1);
        Chapter chapter3 = new Chapter("Introduction of Hibernate", cpk3);
        Chapter chapter4 = new Chapter("Introduction of JPA and Hibernate", cpk4);

        chapters1.add(chapter3);
        chapters1.add(chapter4);
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            // save book object graph in DB
            session.persist(book);
            session.persist(book1);

            // retrieve Book object graph from DB based on ISBN
            book = session.get(Book.class, "123456789");
            // print book information on console
            System.out.println(book);
            book = session.get(Book.class, "123456799");
            // print book information on console
            System.out.println(book);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null)
                sessionFactory.close();
        }

    }
}
