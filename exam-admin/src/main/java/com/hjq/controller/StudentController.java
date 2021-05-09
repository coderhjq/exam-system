package com.hjq.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itextpdf.text.DocumentException;
import com.hjq.Util.CertificateUtil.ContentStyle;
import com.hjq.Util.CertificateUtil.DateTimeUtil;
import com.hjq.Util.CertificateUtil.PDFUtil;
import com.hjq.Util.RedisUtil;
import com.hjq.entity.ExamRecord;
import com.hjq.entity.Notice;
import com.hjq.entity.User;
import com.hjq.service.impl.*;
import com.hjq.vo.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.*;

/**
 * @Date 2020/11/7 19:44
 * @created by hjq
 */
@RestController
@RequestMapping(value = "/student")
@Slf4j
@Api(tags = "学生权限相关的接口")
public class StudentController {

    @Autowired
    private ExamServiceImpl examService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private ExamQuestionServiceImpl examQuestionService;

    @Autowired
    private ExamRecordServiceImpl examRecordService;

    @Autowired
    private QuestionBankServiceImpl questionBankService;

    @Autowired
    private AnswerServiceImpl answerService;

    @Autowired
    private NoticeServiceImpl noticeService;

    //注入自己的redis工具类
    @Autowired
    private RedisUtil redisUtil;

    /**
     * @param username 系统登录用户名
     * @param pageNo   页面大小
     * @param pageSize 页面大小
     * @param examId   考试id
     * @return
     */
    @GetMapping("/getMyGrade")
    @ApiOperation("获取个人成绩(分页 根据考试名查询)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "系统唯一用户名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pageNo", value = "当前页面数", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "当前页面大小", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "examId", value = "考试唯一id", required = false, dataType = "int", paramType = "query")
    })
    public CommonResult<Object> getMyGrade(String username, Integer pageNo, Integer pageSize,
                                                     @RequestParam(required = false) Integer examId) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        //参数一是当前页，参数二是每页个数
        IPage<ExamRecord> examRecordPage = new Page<>(pageNo, pageSize);
        //查询条件(可选)
        QueryWrapper<ExamRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getId());
        if (examId != null) wrapper.eq("exam_id", examId);

        IPage<ExamRecord> page = examRecordService.page(examRecordPage, wrapper);
        List<ExamRecord> examRecords = page.getRecords();
        // 创建分页结果集
        Map<Object, Object> result = new HashMap<>();
        result.put("examRecords", examRecords);
        result.put("total", examRecordPage.getTotal());
        return new CommonResult<>(200, "查询成绩成功", result);
    }

    @GetMapping("/getCurrentNewNotice")
    @ApiOperation("获取当前系统最新的公告")
    public CommonResult<Object> getCurrentNewNotice() {
        log.info("执行了===>StudentController中的getCurrentNewNotice方法");
        if (redisUtil.get("currentNewNotice") != null) {//redis中有缓存
            return new CommonResult<>(200, "获取最新公告成功", redisUtil.get("currentNewNotice"));
        } else {//redis无缓存
            Notice notice = noticeService.getOne(new QueryWrapper<Notice>().eq("status", "1"));
            //设置默认缓存时间(24小时)
            redisUtil.set("currentNewNotice", notice.getContent(), 60 * 1440);
            return new CommonResult<>(200, "获取最新公告成功", notice.getContent());
        }
    }

}
