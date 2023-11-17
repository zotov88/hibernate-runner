package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Company;
import org.example.entity.PersonalInfo;
import org.example.entity.Profile;
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

//        Company company = Company.builder()
//                .name("Sber")
//                .build();
//
//        User user1 = User.builder()
//                .username("ivan@gmail.com")
//                .personalInfo(PersonalInfo.builder()
//                        .firstname("Ivan")
//                        .lastname("Petrov")
//                        .build())
//                .build();
//
//        company.addUser(user1);

//        User user2 = User.builder()
//                .username("petr@gmail.com")
//                .personalInfo(PersonalInfo.builder()
//                        .firstname("Ivan")
//                        .lastname("Petrov")
//                        .build())
//                .company(company)
//                .build();

//        Profile profile = Profile.builder()
//                .street("Izm prosp")
//                .language("RU")
//                .build();
//
//        profile.setUser(user1);


        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory()) {
            Session session1 = sessionFactory.openSession();
            try (session1) {
                Transaction transaction = session1.beginTransaction();

                Company company = session1.get(Company.class, 1L);
                session1.delete(company);

                session1.getTransaction().commit();
            }
        }
    }
}
