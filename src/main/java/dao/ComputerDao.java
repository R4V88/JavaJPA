package dao;

import model.Computer;
import model.enums.Drive;

import javax.persistence.EntityManager;
import java.util.List;

public interface ComputerDao {

     List<Computer> getAllComputers(EntityManager em);

     Computer getComputerById (EntityManager em, Long id);

     Computer getComputerByManufacturer(EntityManager em, String manufacturer);

     Computer getComputerByDrive(EntityManager em, Drive drive);




}
