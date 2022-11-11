package com.everest.dating.models.repository;

import com.everest.dating.models.entity.Match;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {

    @Query("SELECT m.match FROM Match m WHERE m.user.id = :id")
    Iterable<Match> findByUserId(Long id);

}
