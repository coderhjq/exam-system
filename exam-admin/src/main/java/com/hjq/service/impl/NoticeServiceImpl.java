package com.hjq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjq.entity.Notice;
import com.hjq.mapper.NoticeMapper;
import com.hjq.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Date 2020/10/20 9:05
 * @created by hjq
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public boolean setAllNoticeIsHistoryNotice() {
        return noticeMapper.setAllNoticeIsHistoryNotice();
    }
}
