package base.service.impl;

import base.dao.UserInfoDao;
import base.model.UserInfo;
import base.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author: luoyi
 * @Description:
 * @Date: 11:47 2017/8/2
 * @Version: 1.0.0
 * @Modified By: xxx
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    @Cacheable("getUserInfo")
    public UserInfo getUserInfo(int id) {
        return userInfoDao.getUserInfo(id);
    }
}
