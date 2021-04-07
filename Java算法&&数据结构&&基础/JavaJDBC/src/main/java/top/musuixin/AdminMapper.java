package top.musuixin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author musuixin
 * @date 2020-06-26 17:35
 */
public class AdminMapper {
    public static <T> T getList(String sql, IRowMapper<T> rowMapper) {
        Connection connection = JDBCUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            return rowMapper.mapping(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
