package cn.lunatic.springboot.security.persistence.ext.mapper;

import cn.lunatic.springboot.security.persistence.auto.model.RoleInfo;

import java.util.List;

public interface UserRoleMapper {

    List<RoleInfo> selectByUserId(Long userId);
}
