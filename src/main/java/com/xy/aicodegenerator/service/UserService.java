package com.xy.aicodegenerator.service;

import com.mybatisflex.core.service.IService;
import com.xy.aicodegenerator.model.entity.User;

/**
 * 用户 服务层。
 *
 * @author <a href="https://github.com/Xy-hub">xy</a>
 */
public interface UserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);


    String getEncryptPassword(String userPassword);
}
