package com.toray.ojt.web.service;

import com.toray.ojt.web.entity.User;

public interface UserService {
    User findByAccountId(String accountId);
}
