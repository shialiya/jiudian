package cn.scau.dao;

import cn.scau.page.Page;
import cn.scau.pojo.DailyRate;
import cn.scau.pojo.DailyRateExample;
import cn.scau.pojo.DailyRateKey;
import cn.scau.pojo.DailyRateM;
import cn.scau.pojo.RoomType;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DailyRateMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int deleteByPrimaryKey(DailyRateKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int insert(DailyRate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int insertSelective(DailyRate record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	List<DailyRate> selectByExample(DailyRateExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	DailyRate selectByPrimaryKey(DailyRateKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int updateByPrimaryKeySelective(DailyRate record);
	
	

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table DailyRate
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int updateByPrimaryKey(DailyRate record);
	
	List<DailyRateM> list(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate, @Param("room") String roomType, @Param("rat") String rateType);
	
	
}