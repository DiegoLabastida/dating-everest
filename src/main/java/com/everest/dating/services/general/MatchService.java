package com.everest.dating.services.general;

import com.everest.dating.models.entity.Match;
import com.everest.dating.models.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface MatchService {

    Iterable<User> getPossibleMatch(Long id);

    Match makeMatch(Long idUser, Long idMatch);

    Iterable<Match> getMatches(Long id);

    Object getPercentageMatch(Long idUser, Long idMatch);

}
