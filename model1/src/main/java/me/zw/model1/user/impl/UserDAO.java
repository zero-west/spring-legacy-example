package me.zw.model1.user.impl;

import me.zw.model1.common.JDBCUtil;
import me.zw.model1.user.UserVO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private final String USER_GET = "select * from users where id=? and password=?";

    public UserVO getUser(UserVO userVO) {
        UserVO user = null;
        try {
            System.out.println("===> JDBC 로 getUser() 기능 처리");
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(USER_GET);
            preparedStatement.setString(1, userVO.getId());
            preparedStatement.setString(2, userVO.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new UserVO();
                user.setId(resultSet.getString("ID"));
                user.setPassword(resultSet.getString("PASSWORD"));
                user.setName(resultSet.getString("NAME"));
                user.setRole(resultSet.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(resultSet, preparedStatement, connection);
        }
        return user;
    }
}
