package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@Slf4j
public class HibernateRunner {

    // сделает lombok
//    private final static Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {

        User user = User.builder()
                .username("ivan@gmail.com")
                .firstname("Ivan")
                .lastname("Ivanov")
                .build();
        log.info("User entity is in transient state, Object {}", user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();
                log.trace("Transaction is created {}", transaction);
                session1.saveOrUpdate(user);
                log.trace("User in is persistent state: {}, session: {}", user, session1);
                session1.getTransaction().commit();
            }

            log.warn("User in is detached state: {}, session is closed: {}", user, session1);

        } catch (Exception exception) {
            log.error("Exception occurred ", exception);
        }
    }
}
