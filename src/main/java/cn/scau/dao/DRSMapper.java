package cn.scau.dao;

import cn.scau.pojo.DRS;
import cn.scau.pojo.DRSExample;
import java.util.List;

public interface DRSMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drs
     *
     * @mbg.generated Tue Aug 07 09:44:00 CST 2018
     */
    long countByExample(DRSExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drs
     *
     * @mbg.generated Tue Aug 07 09:44:00 CST 2018
     */
    int insert(DRS record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drs
     *
     * @mbg.generated Tue Aug 07 09:44:00 CST 2018
     */
    int insertSelective(DRS record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drs
     *
     * @mbg.generated Tue Aug 07 09:44:00 CST 2018
     */
    List<DRS> selectByExample(DRSExample example);
}