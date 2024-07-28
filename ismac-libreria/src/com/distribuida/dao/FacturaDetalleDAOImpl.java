package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.distribuida.entities.FacturaDetalle;

@Repository
public class FacturaDetalleDAOImpl implements FacturaDetalleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<FacturaDetalle> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from FacturaDetalle", FacturaDetalle.class).getResultList();
    }

    @Override
    @Transactional
    public FacturaDetalle findOne(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(FacturaDetalle.class, id);
    }

    @Override
    @Transactional
    public void add(FacturaDetalle detalle) {
        Session session = sessionFactory.getCurrentSession();
        session.save(detalle);
    }

    @Override
    @Transactional
    public void up(FacturaDetalle detalle) {
        Session session = sessionFactory.getCurrentSession();
        session.update(detalle);
    }

    @Override
    @Transactional
    public void del(int id) {
        Session session = sessionFactory.getCurrentSession();
        FacturaDetalle detalle = session.get(FacturaDetalle.class, id);
        if (detalle != null) {
            session.delete(detalle);
        }
    }
}