package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    User findUsersInfo();
    @Select("select * from user where name=#{name}")
    User  findUserInfo(@Param("name") String name);

}
