import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("toDoListPu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();





        entityManager.close();
        entityManagerFactory.close();

    }
}
