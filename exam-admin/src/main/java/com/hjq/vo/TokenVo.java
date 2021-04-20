package com.hjq.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2020/10/20 11:58
 * @created by hjq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenVo {
    private String roleId;
    private String username;
    private String password;
}
