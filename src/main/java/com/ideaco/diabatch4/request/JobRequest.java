package com.ideaco.diabatch4.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JobRequest {
    private String jobName;
    private String jobDesc;
    private int jobSalary;
}
