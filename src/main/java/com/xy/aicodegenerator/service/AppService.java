package com.xy.aicodegenerator.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xy.aicodegenerator.model.dto.app.AppQueryRequest;
import com.xy.aicodegenerator.model.entity.App;
import com.xy.aicodegenerator.model.entity.User;
import com.xy.aicodegenerator.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author <a href="https://github.com/Xy-hub">xy</a>
 */
public interface AppService extends IService<App> {

    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    AppVO getAppVO(App app);

    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    List<AppVO> getAppVOList(List<App> appList);
}
