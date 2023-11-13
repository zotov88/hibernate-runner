package org.example;

import org.example.converter.BirthDayConverter;
import org.example.entity.BirthDate;
import org.example.entity.Role;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class HibernateRunner {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAttributeConverter(new BirthDayConverter(), true);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = User.builder()
                    .username("ivanka@mail.ru")
                    .firstname("Ivan")
                    .lastname("Ivanov")
                    .birthDate(new BirthDate(LocalDate.of(1988, 06, 11)))
                    .role(Role.USER)
                    .build();
            session.save(user);

            session.getTransaction().commit();

        }
    }
}
