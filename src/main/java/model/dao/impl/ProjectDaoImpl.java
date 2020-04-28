package model.dao.impl;

import model.Project;
import model.dao.ProjectDao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    private static ProjectDao instance = new ProjectDaoImpl();

    private ProjectDaoImpl() {
    }

    public static ProjectDao getInstance() {
        return ProjectDaoImpl.instance;
    }

    @Override
    public void createProject(EntityManager em, Project project) {
        em.persist(project);
    }

    @Override
    public List<Project> findAllProjects(EntityManager em) {
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p", Project.class);

        return query.getResultList();
    }

    @Override
    public Project findProjectById(EntityManager em, Long id) {
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p WHERE p.id = ?1", Project.class);
        query.setParameter(1, id);

        return query.getSingleResult();
    }

    @Override
    public Project findProjectByTitle(EntityManager em, String title) {
        return em
                .createQuery("SELECT p FROM Project p where p.title = :title", Project.class)
                .setParameter("title", title)
                .getSingleResult();
    }

    @Override
    public void updateProjectTitleById(EntityManager em, String title, Long id) {
        em.createQuery("UPDATE Project p SET p.title = :title WHERE p.id = :id")
                .setParameter("title", title)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateProjectDescriptionById(EntityManager em, String description, Long id) {
        em.createQuery("UPDATE Project p SET p.description = :description WHERE p.id = :id")
                .setParameter("description", description)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void removeProjectById(EntityManager em, Long id) {
        em.createQuery("DELETE FROM Computer c WHERE c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
