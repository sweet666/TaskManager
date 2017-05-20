package by.safronenko.repositories;

import by.safronenko.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    @Query("select n from Note n where n.username = :username")
    List<Note> findNotesByUser(@Param("username") String username);
}
