package dao;

import model.Project;
import model.User;
import model.enums.Role;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserDao {

    void addUser(EntityManager em, User user);

    List<User> findAllUsers(EntityManager em);

    List<User> findUsersByRole(EntityManager em, Role role);

    User findUserById(EntityManager em, Long id);

    User findUserByLogin(EntityManager em, String name);

    User findUserByEmail(EntityManager em, String email);

    User findUserByNameAndSurname(EntityManager em, String name, String surname);

    void updateUserNameById(EntityManager em, String name, Long id);

    void updateUserSurnameById(EntityManager em, String surname, Long id);

    void updateUserUserLoginById(EntityManager em, String login, Long id);

    void updateUserPasswordById(EntityManager em, String password, Long id);

    void updateUserEmailById(EntityManager em, String email, Long id);

}
