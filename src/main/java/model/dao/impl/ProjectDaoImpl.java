package model.dao.impl;

import model.Project;
import model.dao.ProjectDao;

import java.util.List;

public class ProjectDaoImpl implements ProjectDao {

    private static ProjectDao instance = new ProjectDaoImpl();

    private ProjectDaoImpl() {
    }

    public static ProjectDao getInstance(){
        return ProjectDaoImpl.instance;
    }

    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Project getProjectById(long id) {
        return null;
    }

    @Override
    public Project getProjectByTitle(String title) {
        return null;
    }
}
