package dao.impl;

import dao.UserDao;
import model.User;
import model.enums.Role;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAllUsers(EntityManager em) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        criteriaQuery.select(user);

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findUsersByRole(EntityManager em, Role role) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Path<Object> userRole = user.get("role");

        criteriaQuery.select(user).where(builder.equal(userRole, role));

        return em.createQuery(criteriaQuery).getResultList();

    }

    @Override
    public List<User> findUsersByProject(EntityManager em, String projectTitle) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Path<Object> project = user.get("project");

        criteriaQuery.select(user).where(builder.equal(project, projectTitle));

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public User findUserById(EntityManager em, long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Path<Object> userId = user.get("id");

        criteriaQuery.select(user).where(builder.equal(userId, id));

        return em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User findUserByLogin(EntityManager em, String login) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Path<Object> userLogin = user.get("login");

        criteriaQuery.select(user).where(builder.equal(userLogin, login));

        return em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User findUserByEmail(EntityManager em, String email) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Path<Object> userEmail = user.get("email");

        criteriaQuery.select(user).where(builder.equal(userEmail, email));

        return em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public User findUserByNameAndSurname(EntityManager em, String name, String surname) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
        Root<User> user = criteriaQuery.from(User.class);

        Path<Object> userName = user.get("name");
        Path<Object> userSurname = user.get("surname");

        criteriaQuery.select(user).where(builder.and(builder.equal(userName, name), builder.equal(userSurname, surname)));

        return em.createQuery(criteriaQuery).getSingleResult();
    }
}
