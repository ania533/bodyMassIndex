package pl.kodu.akademia.bodyMassIndex.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class HibernateSessionFactoryService {
    //Tworzenie połąćzenia do bazy danych
    private SessionFactory sessionFactory;
    //Wczytuję xml jako plik, wczytuję nam sesję, połączenie z bazą danych
    public HibernateSessionFactoryService() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public Session getSession() {
        return this.sessionFactory.openSession();// openSeassion otwiera sesję
    }
}