package com.ideaco.diabatch4.controller;

import com.ideaco.diabatch4.dto.JobDTO;
import com.ideaco.diabatch4.model.JobModel;
import com.ideaco.diabatch4.request.JobRequest;
import com.ideaco.diabatch4.service.FileService;
import com.ideaco.diabatch4.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private FileService fileService;

    /* ------------------- GET ------------------- */
    @GetMapping("/data")
    public String getData() {
        return "Hello World";
    }

    @GetMapping("/dataWithPathVariable/{jobId}")
    public String getDataWithPathVariable(@PathVariable("jobId") int jobId) {
        return "Value : " + jobId;
    }

    @GetMapping("/dataWithParams")
    public List<JobModel> getDataWithParams(@RequestParam("jobId") int jobId) {
        return jobService.getData(jobId);
    }

    @GetMapping("/dataOptionalWithJPQL")
    public Optional<JobModel> getDataOptionalWithJPQL(@RequestParam("jobId") int jobId) {
        return jobService.getDataOptional(jobId);
    }

    @GetMapping("/dataWithRequestBody")
    public String getDataWithRequestBody(@RequestBody JobRequest jobRequest) {
//        Optional<JobModel> data = jobService.getDataOptional(jobModel.getJobId());

        return "Value : " + jobRequest.getJobName();
    }

    /* ------------------- POST ------------------- */

    @PostMapping("/createJobWithParams")
    public JobModel postCreateJob(@RequestParam("jobName") String jobName,
                                  @RequestParam("jobDesc") String jobDesc,
                                  @RequestParam("jobSalary") int jobSalary) {
        return jobService.postCreateJob(jobName, jobDesc, jobSalary);
    }

    @PostMapping("/createJobWithMultipleBody")
    public List<JobModel> postCreateJobWithMultipleBody(@RequestBody List<JobModel> jobModels) {
        return jobService.postCreateJobMultiple(jobModels);
    }

    /* ------------------- PUT ------------------- */

    @PutMapping("/updateJobWithBody")
    public JobModel putUpdateJobWithBody(@RequestBody JobModel jobModel) {
        return jobService.putUpdateJobWithBody(jobModel);
    }

    /* ------------------- PATCH ------------------- */

    @PatchMapping("/updateJobWithPatch")
    public JobModel patchUpdateJobWithPatch(@RequestParam("jobId") int jobId,
                                            @RequestParam("jobName") String jobName) {
        return jobService.patchUpdateWithParams(jobId, jobName);
    }

    /* ------------------- DELETE ------------------- */

    @DeleteMapping("/deleteJob")
    public String deleteJob(@RequestParam("jobId") int jobId) {
        boolean response =  jobService.deleteJob(jobId);

        if (response) {
            return "Delete success";
        } else {
            return "Delete failed";
        }
    }

    /* ------------------- MULTIPART ------------------- */

    @PostMapping("/uploadFile")
    public boolean uploadFile(@RequestParam("file") MultipartFile file) {
        fileService.saveFile(file);
        return true;
    }

    /* ------------------- DTO ------------------- */

    @GetMapping("/dataWithDTO")
    public JobDTO getDataWithDTO(@RequestParam("jobId") int jobId) {
        return jobService.dataWithDTO(jobId);
    }
}
