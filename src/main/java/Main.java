import model.User;
import model.enums.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toDoListPu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


//        User user = User.builder().name("asdasd").email("adqeads").login("asdasda").role(Role.USER).password("12341234").surname("12341234").build();


        entityManager.close();
        entityManagerFactory.close();

    }
}
