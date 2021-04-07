package top.musuixin;

import java.sql.ResultSet;

/**
 * @author musuixin
 * @date 2020-06-26 17:56
 */
public interface IRowMapper<T> {
    T mapping(ResultSet resultSet) throws Exception;
}
