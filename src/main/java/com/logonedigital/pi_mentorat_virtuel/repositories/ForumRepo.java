package com.logonedigital.pi_mentorat_virtuel.repositories;
import com.logonedigital.pi_mentorat_virtuel.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ForumRepo extends JpaRepository<Forum, Integer> {
    Optional<Forum> findByTitle(String title);

    @Query("select f from Forum f where f.description like %:description%")
    List<Forum> fetchByDescription(@Param("description") String description);
}
