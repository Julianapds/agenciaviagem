package com.rotasdosol.dao;

import com.rotasdosol.config.HibernateConfig;
import com.rotasdosol.model.ClienteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClienteDAO {

    public void salvar(ClienteModel cliente) {
        Transaction transaction = null;
        try {
            Session session = HibernateConfig.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(cliente);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public ClienteModel buscarPorEmailESenha(String email, String senhaHash) {
        Transaction transaction = null;
        ClienteModel cliente = null;
        try  {

            Session session = HibernateConfig.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            String hql = "FROM Cliente WHERE email = :email AND senhaHash = :senha";
            Query<ClienteModel> query = session.createQuery(hql, ClienteModel.class);
            query.setParameter("email", email);
            query.setParameter("senha", senhaHash);

            cliente = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return cliente;
    }

    public boolean existePorCpf(String cpf) {
        Transaction transaction = null;
        boolean existe = false;
        try  {

            Session session = HibernateConfig.getSessionFactory().openSession();

            transaction = session.beginTransaction();

            String hql = "SELECT count(*) FROM Cliente WHERE cpf = :cpf";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("cpf", cpf);

            existe = query.uniqueResult() > 0;

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return existe;
    }

}
