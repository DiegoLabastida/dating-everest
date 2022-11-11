package com.everest.dating.models.repository;

import com.everest.dating.models.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
