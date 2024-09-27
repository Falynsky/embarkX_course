package com.falynsky.embarkx.app.repositories;

import com.falynsky.embarkx.app.enities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
