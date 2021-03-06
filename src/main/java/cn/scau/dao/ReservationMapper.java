package cn.scau.dao;

import cn.scau.page.Page;
import cn.scau.pojo.Reservation;
import cn.scau.pojo.ReservationExample;
import cn.scau.pojo.ReservationWithBLOBs;
import cn.scau.pojo.Reservation;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ReservationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    int deleteByPrimaryKey(Integer confirmID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    int insert(ReservationWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    int insertSelective(ReservationWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    List<ReservationWithBLOBs> selectByExampleWithBLOBs(ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    List<Reservation> selectByExample(ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    ReservationWithBLOBs selectByPrimaryKey(Integer confirmID);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    int updateByPrimaryKeySelective(ReservationWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(ReservationWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Reservation
     *
     * @mbg.generated Mon Aug 06 09:49:26 CST 2018
     */
    int updateByPrimaryKey(Reservation record);
    
List<ReservationWithBLOBs> list(@Param("page") Page page, @Param("record") ReservationWithBLOBs record);
    
    int total(@Param("record") ReservationWithBLOBs record);
}