/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ten.belajar.hibernate.conf;

import id.ten.belajar.hibernate.models.Book;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author teten.nugraha
 */
public class HibernateConfiguration {
    
    private static SessionFactory factory;
    
    private HibernateConfiguration() {}
    
    public static SessionFactory getFactory() {
        if(factory == null) {
            Configuration configuration = new Configuration();
			
            Properties settings = new Properties();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/book-db");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "password");

            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            settings.put(Environment.SHOW_SQL, "false");
            settings.put(Environment.HBM2DDL_AUTO, "update");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(Book.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build();

            factory = configuration.buildSessionFactory(serviceRegistry);
        }
        return factory;
    }
    
}
