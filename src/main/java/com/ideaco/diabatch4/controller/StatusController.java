package com.ideaco.diabatch4.controller;

import com.ideaco.diabatch4.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    @Autowired
    private JobService jobService;

    @GetMapping("")
    public boolean getJobStatus(){
        return jobService.getJobStatus();
    }
}
