package com.yinrj.drawingboardserver.modules.user.infrastructure.db.dao;

import com.yinrj.drawingboardserver.modules.user.infrastructure.db.model.UserDO;
import org.apache.ibatis.annotations.*;

/**
 * Name: UserDAO
 * Author: yinrongjie
 * Date: 2025/1/22
 */
@Mapper
public interface UserDAO {

        @Insert("INSERT INTO users(name, student_id, phone, created_at, updated_at) " +
                        "VALUES (#{username}, #{studentId}, #{phone}, #{createTime}, #{updateTime})")
        void insertUser(UserDO userDO);

        @Select("SELECT * FROM users WHERE name = #{name} AND student_id = #{studentId} AND phone = #{phone}")
        @Results(value = {
                        @Result(column = "id", property = "id"),
                        @Result(column = "name", property = "username"),
                        @Result(column = "student_id", property = "studentId"),
                        @Result(column = "phone", property = "phone"),
                        @Result(column = "created_at", property = "createTime"),
                        @Result(column = "updated_at", property = "updateTime")
        }, id = "resultMap")
        UserDO selectUser(@Param("name") String username, @Param("studentId") String studentId,
                        @Param("phone") String phone);

        @Select("SELECT * FROM users WHERE name = #{name} AND student_id = #{studentId}")
        @ResultMap("resultMap")
        UserDO selectUserWithoutPhone(@Param("name") String username, @Param("studentId") String studentId);

        @Update("UPDATE users SET phone = #{phone}, updated_at = #{updateTime} WHERE id = #{id}")
        void updateUserPhone(UserDO userDO);
}
