package dao;

import model.Note;

import javax.persistence.EntityManager;
import java.util.List;

public interface NoteDao {

    void createNote (EntityManager em);

    List<Note> findAllNotes(EntityManager em);

    Note findNoteById(EntityManager em, Long id);

    void updateNoteTitleById(EntityManager em, Long id);

    void updateNoteTextFieldById(EntityManager em, Long id);

    void removeNoteById(EntityManager em, Long id);
}
