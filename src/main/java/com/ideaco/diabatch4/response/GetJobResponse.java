package com.ideaco.diabatch4.response;

import com.ideaco.diabatch4.dto.JobDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetJobResponse extends BaseResponse{
    private JobDTO data;
}
