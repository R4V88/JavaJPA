package dao;

import model.Project;
import model.User;
import model.enums.Role;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDao {

    List<User> findAllUsers(EntityManager em);

    List<User> findUsersByRole(EntityManager em, Role role);

    List<User> findUsersByProject(EntityManager em, String projectTitle);

    User findUserById(EntityManager em, long id);

    User findUserByLogin(EntityManager em, String name);

    User findUserByEmail(EntityManager em, String email);

    User findUserByNameAndSurname(EntityManager em, String name, String surname);

}
