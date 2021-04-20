package com.hjq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjq.entity.Question;
import com.hjq.mapper.QuestionMapper;
import com.hjq.service.QuestionService;
import org.springframework.stereotype.Service;

/**
 * @Date 2020/10/20 9:05
 * @created by hjq
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
}
