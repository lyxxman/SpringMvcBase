package base.service;

import base.model.UserInfo;

/**
 * @Author: luoyi
 * @Description:
 * @Date: 11:47 2017/8/2
 * @Version: 1.0.0
 * @Modified By: xxx
 */
public interface UserInfoService {
    /**
     * 获取用户信息
     * @param id
     * @return 用户信息
     */
    UserInfo getUserInfo(int id);
}
