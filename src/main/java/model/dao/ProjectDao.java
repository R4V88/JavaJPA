package model.dao;

import model.Project;

import java.util.List;

public interface ProjectDao {

    public List<Project> getAllProjects();

    public Project getProjectById(long id);

    public Project getProjectByTitle(String title);
}
