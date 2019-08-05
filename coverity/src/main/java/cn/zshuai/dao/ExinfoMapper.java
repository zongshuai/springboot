package cn.zshuai.dao;

import cn.zshuai.entity.Exinfo;
import cn.zshuai.entity.ExinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExinfoMapper {
    int countByExample(ExinfoExample example);

    int deleteByExample(ExinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Exinfo record);

    int insertSelective(Exinfo record);

    List<Exinfo> selectByExample(ExinfoExample example);

    Exinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Exinfo record, @Param("example") ExinfoExample example);

    int updateByExample(@Param("record") Exinfo record, @Param("example") ExinfoExample example);

    int updateByPrimaryKeySelective(Exinfo record);

    int updateByPrimaryKey(Exinfo record);
}