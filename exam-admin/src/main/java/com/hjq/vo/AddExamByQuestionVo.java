package com.hjq.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Date 2020/11/2 15:48
 * @created by hjq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddExamByQuestionVo {
    private String examName;
    private String examDesc;
    private Integer type;
    private String password;
    private Integer examDuration;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String endTime;
    private Integer totalScore;
    private Integer passScore;
    private Integer status;


    private String questionIds;
    private Integer examId;
    private String scores;
    private String fileurl;
    private Integer teacherId;

}
