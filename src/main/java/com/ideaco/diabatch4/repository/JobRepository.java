package com.ideaco.diabatch4.repository;

import com.ideaco.diabatch4.model.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<JobModel, Integer> {
    @Query(value = "SELECT * FROM tab_job", nativeQuery = true)
    List<JobModel> findByDataJob();

    @Query(value = "SELECT j FROM JobModel j WHERE j.jobId = :jobId")
    Optional<JobModel> findByJPQLJob(int jobId);

    Optional<JobModel> findByJobId(int jobId);
    Optional<JobModel> findByJobIdAndJobName(int jobId, String jobName);
}
