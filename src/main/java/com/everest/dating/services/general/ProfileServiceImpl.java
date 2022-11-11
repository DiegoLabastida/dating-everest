package com.everest.dating.services.general;

import com.everest.dating.exception.RestExceptionHandler;
import com.everest.dating.models.entity.Profile;
import com.everest.dating.models.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ServiceGeneral<Profile> {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }

    @Override
    @Transactional
    public Profile save(Profile profile) {
        try{
            if (!profileRepository.findById(profile.getId()).isEmpty()) throw new SQLIntegrityConstraintViolationException("Profile Already Exists");
            return  profileRepository.save(profile);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}
