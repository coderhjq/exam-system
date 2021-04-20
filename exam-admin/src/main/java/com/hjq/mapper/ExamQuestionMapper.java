package com.hjq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjq.entity.ExamQuestion;
import org.springframework.stereotype.Repository;

/**
 * @Date 2020/10/20 8:59
 * @created by hjq
 */
//在对应的mapper上面实现基本的接口
@Repository//代表持久层
public interface ExamQuestionMapper extends BaseMapper<ExamQuestion> {
}
