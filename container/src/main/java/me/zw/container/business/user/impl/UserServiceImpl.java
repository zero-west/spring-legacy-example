package me.zw.container.business.user.impl;

import me.zw.container.business.user.UserService;
import me.zw.container.business.user.UserVO;
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
