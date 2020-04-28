package model.dao;

import model.Project;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProjectDao {

    public List<Project> getAllProjects(EntityManager em);

    public Project getProjectById(EntityManager em, Long id);

    public Project getProjectByTitle(EntityManager em, String title);
}
