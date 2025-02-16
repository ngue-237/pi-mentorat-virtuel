package com.logonedigital.pi_mentorat_virtuel.repositories;

import com.logonedigital.pi_mentorat_virtuel.entities.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack,Integer> {
    @Query("select f from FeedBack f where f.commentaire = :" +
            "commentaire")
    Optional<FeedBack> findFeedBackByCommentaire(@Param("commentaire") String commentaire);
}
