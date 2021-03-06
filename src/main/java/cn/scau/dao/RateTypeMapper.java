package cn.scau.dao;

import cn.scau.page.Page;
import cn.scau.pojo.RateType;
import cn.scau.pojo.RateTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RateTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    int insert(RateType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    int insertSelective(RateType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    List<RateType> selectByExampleWithBLOBs(RateTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    List<RateType> selectByExample(RateTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    RateType selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    int updateByPrimaryKeySelective(RateType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(RateType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RateType
     *
     * @mbg.generated Sat Aug 04 20:04:16 CST 2018
     */
    int updateByPrimaryKey(RateType record);
    List<RateType> list(@Param("page") Page page, @Param("record") RateType record);
    
    int total(@Param("record") RateType record);
    
}