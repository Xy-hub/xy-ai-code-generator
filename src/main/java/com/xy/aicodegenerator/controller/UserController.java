package com.xy.aicodegenerator.controller;

import com.mybatisflex.core.paginate.Page;
import com.xy.aicodegenerator.common.BaseResponse;
import com.xy.aicodegenerator.common.ResultUtils;
import com.xy.aicodegenerator.exception.ErrorCode;
import com.xy.aicodegenerator.exception.ThrowUtils;
import com.xy.aicodegenerator.model.dto.user.UserRegisterRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.xy.aicodegenerator.model.entity.User;
import com.xy.aicodegenerator.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 用户 控制层。
 *
 * @author <a href="https://github.com/Xy-hub">xy</a>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 保存用户。
     *
     * @param user 用户
     * @return {@code true} 保存成功，{@code false} 保存失败
     */
    @PostMapping("save")
    public BaseResponse<Boolean> save(@RequestBody User user) {
        return ResultUtils.success(userService.save(user));
    }

    /**
     * 根据主键删除用户。
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("remove/{id}")
    public BaseResponse<Boolean> remove(@PathVariable Long id) {
        return ResultUtils.success(userService.removeById(id));
    }

    /**
     * 根据主键更新用户。
     *
     * @param user 用户
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("update")
    public BaseResponse<Boolean> update(@RequestBody User user) {
        return ResultUtils.success(userService.updateById(user));
    }

    /**
     * 查询所有用户。
     *
     * @return 所有数据
     */
    @GetMapping("list")
    public BaseResponse<List<User>> list() {
        return ResultUtils.success(userService.list());
    }

    /**
     * 根据主键获取用户。
     *
     * @param id 用户主键
     * @return 用户详情
     */
    @GetMapping("getInfo/{id}")
    public BaseResponse<User> getInfo(@PathVariable Long id) {
        return ResultUtils.success(userService.getById(id));
    }

    /**
     * 分页查询用户。
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("page")
    public BaseResponse<Page<User>> page(Page<User> page) {
        return ResultUtils.success(userService.page(page));
    }

    @PostMapping("/register")
    public BaseResponse<Long> userRegister(@RequestBody UserRegisterRequest registerRequest) {
        ThrowUtils.throwIf(registerRequest == null, ErrorCode.PARAMS_ERROR);
        String userAccount = registerRequest.getUserAccount();
        String userPassword = registerRequest.getUserPassword();
        String checkPassword = registerRequest.getCheckPassword();
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }

}
