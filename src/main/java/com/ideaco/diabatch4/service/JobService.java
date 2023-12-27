package com.ideaco.diabatch4.service;

import com.ideaco.diabatch4.model.JobModel;
import com.ideaco.diabatch4.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobModel> getData(int jobId) {
        List<JobModel> data = jobRepository.findByDataJob();
        return data;
    }

    public Optional<JobModel> getDataOptional(int jobId) {
        Optional<JobModel> data = jobRepository.findByJPQLJob(jobId);
        return data;
    }
}
