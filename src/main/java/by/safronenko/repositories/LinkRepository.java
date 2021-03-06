package by.safronenko.repositories;

import by.safronenko.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {

    @Query("select l from Link l where l.username = :username")
    List<Link> findLinkByUsername(@Param("username") String username);

    @Query("select l from Link l where l.username = :username and l.linkFolder > 0")
    List<Link> findLinkWithFolder(@Param("username") String username);

}
