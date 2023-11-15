package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Company;
import org.example.entity.PersonalInfo;
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

        Company company = Company.builder()
                .name("Sber")
                .build();

        User user = User.builder()
                .username("petr@gmail.com")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Ivan")
                        .lastname("Petrov")
                        .build())
                .company(company)
                .build();

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();

                User user1 = session1.get(User.class, 1L);
//                session1.save(company);
//                session1.save(user);

                session1.getTransaction().commit();
            }
        }
    }
}
