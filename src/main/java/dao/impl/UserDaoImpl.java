package dao.impl;

import dao.UserDao;
import model.User;
import model.enums.Role;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(EntityManager em, User user) {
        em.persist(user);
    }

    @Override
    public List<User> findAllUsers(EntityManager em) {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public List<User> findUsersByRole(EntityManager em, Role role) {
        return em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class)
                .setParameter("role", role)
                .getResultList();
    }

    @Override
    public User findUserById(EntityManager em, Long id) {
        return em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public User findUserByLogin(EntityManager em, String login) {
        return em.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public User findUserByEmail(EntityManager em, String email) {
        return em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public User findUserByNameAndSurname(EntityManager em, String name, String surname) {
        return em.createQuery("SELECT u FROM User u WHERE u.name = :name AND u.surname = :surname", User.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getSingleResult();
    }

    @Override
    public void updateUserNameById(EntityManager em, String name, Long id) {
        em.createQuery("UPDATE User u SET u.name = :name WHERE u.id = :id")
                .setParameter("name", name)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateUserSurnameById(EntityManager em, String surname, Long id) {
        em.createQuery("UPDATE User u SET u.surname = :surname WHERE u.id = :id")
                .setParameter("surname", surname)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateUserUserLoginById(EntityManager em, String login, Long id) {
        em.createQuery("UPDATE User u SET u.login = :login WHERE u.id = :id")
                .setParameter("login", login)
                .setParameter("id", id)
                .executeUpdate();

    }

    @Override
    public void updateUserPasswordById(EntityManager em, String password, Long id) {
        em.createQuery("UPDATE User u SET u.password = :password WHERE u.id = :id")
                .setParameter("password", password)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateUserEmailById(EntityManager em, String email, Long id) {
        em.createQuery("UPDATE User u SET u.email = :email WHERE u.id = :id")
                .setParameter("email", email)
                .setParameter("id", id)
                .executeUpdate();
    }
}
