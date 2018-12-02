package com.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.Serializable;

public class ORMHelper {

    private static EntityManagerFactory sf;
    private static final ThreadLocal tltx = new ThreadLocal();
    private static final ThreadLocal tls = new ThreadLocal();

    protected static synchronized EntityManagerFactory getSessionFactory(String name) {
        if (sf == null) {
            sf = Persistence.createEntityManagerFactory(name,System.getProperties());
        }
        return sf;
    }

    public static void openSession() {
        EntityManager s = (EntityManager) tls.get();
        if (s == null) {
            s = getSessionFactory("Velodrome").createEntityManager();
            tls.set(s);
        }
    }

    public static EntityManager getCurrentSession() {
        return (EntityManager) tls.get();
    }

    public static void closeSession() {
        EntityManager s = (EntityManager) tls.get();
        tls.set(null);
        if (s != null && s.isOpen()) s.close();
    }

    public static void beginTransaction() {
        EntityTransaction tx = (EntityTransaction) tltx.get();
        if (tx == null) {
            tx = getCurrentSession().getTransaction();
            tx.begin();
            tltx.set(tx);
        }
    }

    public static void commitTransaction() {
        EntityTransaction tx = (EntityTransaction)tltx.get();
        if (tx != null && tx.isActive()) tx.commit();
        tltx.set(null);
    }

    public static void rollbackTransaction() {
        EntityTransaction tx = (EntityTransaction)tltx.get();
        tltx.set(null);
        if (tx != null && tx.isActive()) tx.rollback();
    }

    public static void create( Serializable obj ) {
        getCurrentSession().persist((Object) obj);
    }

    public static Object retrieve(Class clz, Serializable key) {
        return getCurrentSession().find( clz, (Object) key );
    }

    public static Object update( Serializable obj ) {
        return getCurrentSession().merge((Object) obj);
    }

    public static void delete( Serializable obj ) {
        getCurrentSession().remove( (Object) obj);
    }
}
