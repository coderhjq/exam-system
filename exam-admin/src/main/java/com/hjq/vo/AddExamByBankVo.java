package com.hjq.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Date 2020/11/2 19:51
 * @created by hjq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddExamByBankVo {
    private Integer teacherId;
    private String bankNames;
    private Integer examDuration;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;
    private String examDesc;
    private String examName;
    private Integer judgeScore;
    private Integer multipleScore;
    private Integer passScore;
    private Integer shortScore;
    private Integer singleScore;
    private Integer status;
    private Integer type;
    private String password;

}
