package com.everest.dating.models.repository;

import com.everest.dating.models.entity.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
