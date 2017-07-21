package by.safronenko.repositories;

import by.safronenko.entities.LinkFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkFolderRepository extends JpaRepository<LinkFolder, Integer> {

    @Query("select f from LinkFolder f where f.username = :username")
    List<LinkFolder> findLinkFolderByUsername(@Param("username") String username);


}
