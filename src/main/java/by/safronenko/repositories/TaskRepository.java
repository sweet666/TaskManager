package by.safronenko.repositories;

import by.safronenko.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("select t from Task t where t.is_end = :is_end and t.username = :username")
    List<Task> findTasksByEnd(@Param("is_end") int is_end, @Param("username") String username);

}
