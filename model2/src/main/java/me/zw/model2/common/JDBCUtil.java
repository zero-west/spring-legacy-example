package me.zw.model2.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {
    public static Connection getConnection() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(PreparedStatement preparedStatement, Connection connection) {
        if (preparedStatement != null) {
            try {
                if (!preparedStatement.isClosed()) preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                preparedStatement = null;
            }
        }

        if (connection != null) {
            try {
                if (!connection.isClosed()) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        if (resultSet != null) {
            try {
                if (!resultSet.isClosed()) resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                resultSet = null;
            }
        }

        close(preparedStatement, connection);
    }
}
