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
    public List<Project> getAllProjects(EntityManager em) {
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p", Project.class);

        return query.getResultList();
    }

    @Override
    public Project getProjectById(EntityManager em, Long id) {
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p WHERE p.id = ?1", Project.class);
        query.setParameter(1, id);

        return query.getSingleResult();
    }

    @Override
    public Project getProjectByTitle(EntityManager em, String title) {
        return em
                .createQuery("SELECT p FROM Project p where p.title = :title", Project.class)
                .setParameter("title", title)
                .getSingleResult();
    }
}
