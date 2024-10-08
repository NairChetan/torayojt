package com.toray.ojt.web.mapper;

import com.toray.ojt.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByAccountId(String accountId);
}
