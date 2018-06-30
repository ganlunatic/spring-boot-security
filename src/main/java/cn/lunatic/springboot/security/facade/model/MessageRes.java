package cn.lunatic.springboot.security.facade.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 测试响应报文信息
 */
@Data
@AllArgsConstructor
public class MessageRes {
    private String title;

    private String content;

    private String etraInfo;

}
