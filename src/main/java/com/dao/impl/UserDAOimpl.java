package com.dao.impl;

import com.dao.UserDAO;
import com.entity.User;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOimpl implements UserDAO {

    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {
        ORMHelper.openSession();
        try {
            ORMHelper.beginTransaction();
            List<User> users = new ArrayList<User>();

            Query query = ORMHelper.getCurrentSession().createQuery("SELECT u FROM User u where u.username LIKE: param")
                .setParameter("param",username);
            users = query.getResultList();
            ORMHelper.retrieve(User.class,username);
            ORMHelper.commitTransaction();

            if (users.size() > 0) {
                return users.get(0);
            } else {
                return null;
            }
        } catch (RuntimeException ex) {
            ORMHelper.rollbackTransaction();
            throw ex;
        } finally {
            //ORMHelper.closeSession(); //Если закрыть сессию почему-то нельзя в дальнейшем получить роль пользователя
        }
    }

}
