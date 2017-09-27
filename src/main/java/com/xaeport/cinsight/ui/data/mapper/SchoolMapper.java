package com.xaeport.cinsight.ui.data.mapper;


import com.xaeport.cinsight.ui.data.entity.City;
import com.xaeport.cinsight.ui.data.entity.School;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by xcp on 2017/4/5.
 */
@Mapper
public interface SchoolMapper {

    /**
     * 描述:根据主键查询单个city对象
     */
    @Select("SELECT * FROM city WHERE id = #{id}")
    City findCityById(@Param("id") int id);


    /**
     * 描述:更新对象
     */
    @Update(" update city set name=#{city.name},state=#{city.state} where id=#{city.id} ")
    void updateCity(@Param("city") City city);

    /**
     * 描述:插入数据,返回主键
     */
    @Insert(" insert into city(name, state, country) values(#{city.name}, #{city.state}, #{city.country}) ")
    void insertCity(@Param("city") City city);


    /**
     * 描述:根据主键删除数据
     */
    @Delete("delete from city where id = #{id} ")
    void deleteCityById(@Param("id") int id);


    /**
     * 描述:根据主键查询单个city对象，按参数位置
     */
    @Select("SELECT * FROM city WHERE id = #{0}")
    City findCityById1(int id);

    /**
     * 描述:插入数据,返回主键
     */
    @Insert(" insert into city(name, state, country) values(#{city.name}, #{city.state}, #{city.country}) ")
   /* @Options(useGeneratedKeys = true, keyProperty = "city.id")*/
    int insertCity1(@Param("city") City city);


    /**
     * 描述:联查询,一对一,返回自定义对象
     */
    @Select(" select * from school where id=#{id} ")
    @Results(
            id = "schools",
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "cityId", property = "cityId")
            }
    )
    School findOneToOne(@Param("id") int id);

    /**
     * 描述:根据ID跟状态,返回自定义对象
     */
    @Select(" select * from school where id=#{id} and state=#{state} ")
    @ResultMap(value = "school")
    School findResultMap(@Param("id") int id, @Param("state") String state);


    /**
     * 描述:根据ID查询,返回自定义的List<Map> 集合
     */
    @Select(" SELECT c.id AS cityId ,c.name AS cityName ,s.id AS schoolId,s.name AS schoolName FROM city c LEFT JOIN school s ON s.cityId = c.id WHERE c.id = #{id} ")
    @ResultType(List.class)
    List<Map<String, Object>> findByMaps(@Param("id") int id);


    /**
     * 描述:根据ID查询,返回自定义的MAP集合
     */
    @Select(" SELECT c.id AS cityId ,c.name AS cityName  FROM city c WHERE c.id =#{id} ")
    @ResultType(Map.class)
    Map<String, Object> findByMap(@Param("id") int id);

    /**
     * @One 一对一注解, 表示返回的是一个关联对象
     * @Many 一对多注解, 表示返回的是一个关联对象集合
     * */


    /**
     * 描述:级联查询,一对一,返回自定义对象
     */
    @Select(" select * from school where id=#{id} ")
    @Results(
            id = "school",
            value = {
                    @Result(column = "id", property = "id"),
                    @Result(column = "name", property = "name"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "cityId", property = "cityId"),
                    @Result(column = "cityId", property = "city", one = @One(select = "com.xaeport.project.mybatis.mapper.local.SchoolMapper.findCityById"))
            }
    )
    School findOneToOne1(@Param("id") int id);


    /**
     * 描述:用于一对多级联查询使用的SQL
     */
    @Select(" select * from school where cityId=#{cityId} ")
    List<School> findManyToOne(@Param("cityId") int id);


    /**
     * 描述:级联查询,一对多,返回自定义的对象
     */
    @Select(" select * from city where id=#{id} ")
    @Results(
            id = "city",
            value = {
                    @Result(column = "id", property = "id", id = true),
                    @Result(column = "name", property = "name"),
                    @Result(column = "state", property = "state"),
                    @Result(column = "country", property = "country"),
                    @Result(column = "id", property = "schools", many = @Many(select = "com.xaeport.project.mybatis.mapper.local.SchoolMapper.findManyToOne"))
            }
    )
    City findOneToMany(@Param("id") int id);

}
