package com.doromv.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.doromv.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author DoromvQAQ
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-04-10 10:16:21
* @Entity com.doromv.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteByUidAndName(@Param("uid") Long uid, @Param("name") String name);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}




