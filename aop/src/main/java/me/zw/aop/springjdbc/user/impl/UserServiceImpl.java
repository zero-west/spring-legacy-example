package me.zw.aop.springjdbc.user.impl;

import me.zw.aop.springjdbc.user.UserService;
import me.zw.aop.springjdbc.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserVO getUser(UserVO userVO) {
        return userDAO.getUser(userVO);
    }
}
