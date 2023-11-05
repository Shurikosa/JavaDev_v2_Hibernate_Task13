package repositories;

import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class ClientRepository {
    private SessionFactory sessionFactory = HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        }
    }
    public Client findById(Long id){
        try(Session session = sessionFactory.openSession()){
            return session.get(Client.class, id);
        }
    }
    public void update(Client client){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.update(client);
            tx.commit();
        }
    }
    public void delete(Client client){
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.delete(client);
            tx.commit();
        }
    }
}
