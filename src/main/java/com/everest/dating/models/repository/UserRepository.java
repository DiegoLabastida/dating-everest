package com.everest.dating.models.repository;

import com.everest.dating.models.entity.User;
import com.everest.dating.models.enums.Gender;
import com.everest.dating.models.enums.Hobbies;
import com.everest.dating.models.enums.SexualOrientation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {

    Iterable<User> findUsersByIdIsNotLike(Long id);

    @Query("SELECT u FROM User u JOIN u.hobbies h WHERE u.gender <> :gender AND u.sexualOrientation = :sexualOrientation AND h in :hobbies")
    Iterable<User> findUsersMatchPossibility(Gender gender, SexualOrientation sexualOrientation, Collection<Hobbies> hobbies);

    @Query("SELECT u FROM User u JOIN u.hobbies h WHERE u.id <> :id AND h in :hobbies AND u.sexualOrientation <> 'other'")
    Iterable<User> findUsersMatchPossibility(Long id, Collection<Hobbies> hobbies);

    @Query("SELECT u FROM User u JOIN u.hobbies h WHERE u.id <> :id AND u.sexualOrientation = :sexualOrientation AND h in :hobbies")
    Iterable<User> findUsersMatchPossibility(Long id, SexualOrientation sexualOrientation, Collection<Hobbies> hobbies);

    @Query("SELECT u FROM User u JOIN u.hobbies h WHERE u.id <> :id AND u.gender = :gender AND u.sexualOrientation = :sexualOrientation AND h in :hobbies")
    Iterable<User> findUsersMatchPossibility(Long id, Gender gender, SexualOrientation sexualOrientation, Collection<Hobbies> hobbies);

}
