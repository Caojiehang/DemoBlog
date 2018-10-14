package pers.caojiehang.blogs.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pers.caojiehang.blogs.repository.models.UserPo;

import java.util.List;

/**
 * @author linckye 2018-10-14
 */
@Repository
public interface UserRepository {

    @Insert("INSERT INTO users(" +
            "   username, " +
            "   password  " +
            ") VALUES( " +
            "   #{userPo.username}, " +
            "   #{userPo.password}  " +
            ") ")
    int insertUser(
            @Param("userPo") UserPo userPo);

    @Update("UPDATE users " +
            "SET " +
            "   username = #{userPo.username}," +
            "   password = #{userPo.password} " +
            "WHERE id = #{userPo.id} ")
    int updateUser(
            @Param("userPo") UserPo userPo);

    @Delete("DELETE FROM users " +
            "WHERE id = #{id} ")
    int deleteUser(
            @Param("id") Long id);

    @Select("SELECT * " +
            "FROM users " +
            "WHERE id = #{id} ")
    UserPo selectUser(
            @Param("id") Long id);

    @Select("SELECT * " +
            "FROM users ")
    List<UserPo> selectUsers();

}
