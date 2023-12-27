package com.ideaco.diabatch4.controller;

import com.ideaco.diabatch4.model.JobModel;
import com.ideaco.diabatch4.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    @Autowired
    private JobService jobService;

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
}
