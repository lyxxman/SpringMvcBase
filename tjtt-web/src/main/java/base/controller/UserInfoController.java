package base.controller;

import base.BaseResult;
import base.dto.ApiResult;
import base.model.UserInfo;
import base.service.UserInfoService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @Author: luoyi
 * @Description:
 * @Date: 16:21 2017/8/2
 * @Version: 1.0.0
 * @Modified By: xxx
 */
@Controller
public class UserInfoController {
    @Resource
    UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping(value = "/user/getUserInfo", method = RequestMethod.GET)
    public BaseResult getUserInfo(int id){
       UserInfo userInfo = userInfoService.getUserInfo(id);
       return new ApiResult().onSuccess(userInfo);
    };


}
