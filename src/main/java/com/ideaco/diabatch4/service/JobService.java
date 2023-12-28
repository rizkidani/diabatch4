package com.ideaco.diabatch4.service;

import com.ideaco.diabatch4.dto.JobDTO;
import com.ideaco.diabatch4.model.JobModel;
import com.ideaco.diabatch4.repository.JobRepository;
import com.ideaco.diabatch4.request.JobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    /* ------------------- GET ------------------- */

    public List<JobModel> getData(int jobId) {
        List<JobModel> data = jobRepository.findByDataJob();
        return data;
    }

    public Optional<JobModel> getDataOptional(int jobId) {
        Optional<JobModel> data = jobRepository.findByJPQLJob(jobId);
        return data;
    }

    public List<JobModel> getDataList() {
        List<JobModel> data = jobRepository.findByDataJob();
        return data;
    }

    /* ------------------- POST ----------------------- */

    public JobModel postCreateJob(String jobName, String jobDesc, int jobSalary) {
        JobModel jobModel = new JobModel();
        jobModel.setJobName(jobName);
        jobModel.setJobDesc(jobDesc);
        jobModel.setJobSalary(jobSalary);

        return jobRepository.save(jobModel);
    }

    public List<JobModel> postCreateJobMultiple(List<JobModel> jobModels) {
        return jobRepository.saveAll(jobModels);
    }

    /* ------------------- PUT ------------------- */

    public JobModel putUpdateJobWithBody(JobModel jobModel) {
        int jobId = jobModel.getJobId();
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()) {
            return null;
        }

        return jobRepository.save(jobModel);
    }

    /* ------------------- PATCH ------------------- */

    public JobModel patchUpdateWithParams(int jobId, String jobName) {
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        JobModel jobModel = jobModelOptional.get();
        jobModel.setJobName(jobName);

        return jobRepository.save(jobModel);
    }

    /* ------------------- DELETE ------------------- */

    public boolean deleteJob(int jobId) {
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()) {
            return false;
        }

        jobRepository.deleteById(jobId);
        return true;
    }

    /* ------------------- DTO ------------------- */

    public JobDTO dataWithDTO(int jobId) {
        Optional<JobModel> jobModelOptional = jobRepository.findById(jobId);

        if (jobModelOptional.isEmpty()) {
            return null;
        }

        return convertDTO(jobModelOptional.get());
    }

    private JobDTO convertDTO(JobModel item) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobName(item.getJobName());
        jobDTO.setJobSalary(item.getJobSalary());

        return jobDTO;
    }
}
