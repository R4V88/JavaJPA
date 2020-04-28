package dao;

import model.Computer;
import model.enums.Drive;

import javax.persistence.EntityManager;
import java.util.List;

public interface ComputerDao {

    void createComputer(EntityManager em, Computer computer);

    List<Computer> findAllComputers(EntityManager em);

    List<Computer> findComputerByManufacturer(EntityManager em, String manufacturer);

    List<Computer> findComputerByDrive(EntityManager em, Drive drive);

    Computer findComputerById(EntityManager em, Long id);

    void updateComputerRamById(EntityManager em, Long id, String ram);

    void updateComputerProcessorById(EntityManager em, Long id, String ram);

    void updateComputerDriveById(EntityManager em, Long id, Drive drive);

    void removeComputerById(EntityManager em, Long id);


}
