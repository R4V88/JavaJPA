package dao.impl;

import dao.ComputerDao;
import model.Computer;
import model.enums.Drive;

import javax.persistence.EntityManager;
import java.util.List;

public class ComputerDaoImpl implements ComputerDao {

    private static ComputerDao instance = new ComputerDaoImpl();

    private ComputerDaoImpl() {
    }

    public static ComputerDao getInstance() {
        return ComputerDaoImpl.instance;
    }

    @Override
    public void createComputer(EntityManager em, Computer computer) {
        em.persist(computer);
    }

    @Override
    public List<Computer> findAllComputers(EntityManager em) {
        return em
                .createQuery("SELECT c FROM Computer c", Computer.class)
                .getResultList();
    }

    @Override
    public List<Computer> findComputerByManufacturer(EntityManager em, String manufacturer) {
        return em.createQuery("SELECT c FROM Computer c WHERE c.manufacturer = :manufacturer", Computer.class)
                .setParameter("manufacturer", manufacturer).getResultList();
    }

    @Override
    public List<Computer> findComputerByDrive(EntityManager em, Drive drive) {
        return em
                .createQuery("SELECT c FROM Computer c WHERE c.drive = :drive")
                .setParameter("drive", drive)
                .getResultList();
    }

    @Override
    public Computer findComputerById(EntityManager em, Long id) {
        return em
                .createQuery("SELECT c FROM Computer c WHERE c.id = :id", Computer.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void updateComputerRamById(EntityManager em, Long id, String ram) {
        em.createQuery("UPDATE Computer c SET c.ram = :ram WHERE c.id = :id")
                .setParameter("ram", ram)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateComputerProcessorById(EntityManager em, Long id, String processor) {
        em.createQuery("UPDATE Computer c SET c.processor = :processor WHERE c.id = :id")
                .setParameter("processor", processor)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateComputerDriveById(EntityManager em, Long id, Drive drive) {
        em.createQuery("UPDATE Computer c SET c.drive = :drive WHERE c.id = :id")
                .setParameter("drive", drive)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void removeComputerById(EntityManager em, Long id) {
        em.createQuery("DELETE FROM Computer c WHERE c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
