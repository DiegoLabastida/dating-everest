package com.everest.dating.services.general;

import com.everest.dating.models.entity.Match;
import com.everest.dating.models.entity.User;
import com.everest.dating.models.enums.Hobbies;
import com.everest.dating.models.repository.MatchRepository;
import com.everest.dating.models.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService{

    private final UserRepository userRepository;
    private final MatchRepository matchRepository;

    public MatchServiceImpl(UserRepository userRepository, MatchRepository matchRepository) {
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Iterable<User> getPossibleMatch(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return null;

        User userDB = user.get();
        Iterable<User> users = null;
        switch (userDB.getSexualOrientation()) {
            case HETEROSEXUAL:
                users = userRepository.findUsersMatchPossibility(userDB.getGender(),
                        userDB.getSexualOrientation(), userDB.getHobbies());
                break;
            case BISEXUAL:
                users = userRepository.findUsersMatchPossibility(userDB.getId(), userDB.getHobbies());
                break;
            case HOMOSEXUAL:
                users = userRepository.findUsersMatchPossibility(userDB.getId(), userDB.getGender(),
                        userDB.getSexualOrientation(), userDB.getHobbies());
                break;
            case OTHER:
                users = userRepository.findUsersMatchPossibility(userDB.getId(),
                        userDB.getSexualOrientation(), userDB.getHobbies());
                break;
            default:
                break;
        }
        return users;
    }

    @Override
    public Match makeMatch(Long idUser, Long idMatch) {
        Optional<User> user = userRepository.findById(idUser);
        Optional<User> userMatch = userRepository.findById(idMatch);
        if (user.isEmpty() || userMatch.isEmpty()) return null;
        Match match = new Match();
        match.setUser(user.get());
        match.setMatch(userMatch.get());
        return matchRepository.save(match);
    }

    @Override
    public Iterable<Match> getMatches(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return null;
        return matchRepository.findByUserId(id);
    }

    @Override
    public Object getPercentageMatch(Long idUser, Long idMatch) {
        Optional<User> user = userRepository.findById(idUser);
        Optional<User> userMatch = userRepository.findById(idMatch);
        if (user.isEmpty() || userMatch.isEmpty()) return null;
        User userDB = user.get();
        User userMDB = userMatch.get();

        int sizeUDB = userDB.getHobbies().size();
        int coincidence = 0;
        for(Hobbies hobby : userMDB.getHobbies()){
            coincidence += userDB.getHobbies().contains(hobby) ? 1 : 0;
        }

        Map<String,Object> message = new HashMap<>();
        message.put("message", "Match percentage");
        message.put("percentage", (coincidence*100/sizeUDB)+" %");
        return message;
    }

}
