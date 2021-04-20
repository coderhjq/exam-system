package com.hjq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjq.entity.Exam;
import com.hjq.mapper.ExamMapper;
import com.hjq.service.ExamService;
import org.springframework.stereotype.Service;

/**
 * @Date 2020/10/20 9:05
 * @created by hjq
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
}
