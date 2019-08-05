package cn.zshuai.dao;

import cn.zshuai.entity.CovJson;
import cn.zshuai.entity.CovJsonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CovJsonMapper {
    int countByExample(CovJsonExample example);

    int deleteByExample(CovJsonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CovJson record);

    int insertSelective(CovJson record);

    List<CovJson> selectByExample(CovJsonExample example);

    CovJson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CovJson record, @Param("example") CovJsonExample example);

    int updateByExample(@Param("record") CovJson record, @Param("example") CovJsonExample example);

    int updateByPrimaryKeySelective(CovJson record);

    int updateByPrimaryKey(CovJson record);
}