package model.dao;

import model.Project;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProjectDao {

    void createProject(EntityManager em, Project project);

    public List<Project> findAllProjects(EntityManager em);

    public Project findProjectById(EntityManager em, Long id);

    public Project findProjectByTitle(EntityManager em, String title);

    void updateProjectTitleById(EntityManager em, String title);

    void updateProjectDescriptionById(EntityManager em, String description);

    void removeProjectById(EntityManager em, Long id);
}
