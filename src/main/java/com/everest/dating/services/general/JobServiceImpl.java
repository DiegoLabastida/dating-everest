package com.everest.dating.services.general;

import com.everest.dating.models.entity.Job;
import com.everest.dating.models.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class JobServiceImpl implements ServiceGeneral<Job> {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Iterable<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Job save(Job job) {
        try {
            if (!jobRepository.findById(job.getId()).isEmpty())
                throw new SQLIntegrityConstraintViolationException("Job Already Exists");
            return jobRepository.save(job);
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        jobRepository.deleteById(id);
    }
}
