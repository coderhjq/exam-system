package com.hjq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hjq.entity.Notice;

/**
 * @Date 2020/10/20 9:04
 * @created by hjq
 */
public interface NoticeService extends IService<Notice> {
    // 将所有公告设置为历史公告
    boolean setAllNoticeIsHistoryNotice();
}
