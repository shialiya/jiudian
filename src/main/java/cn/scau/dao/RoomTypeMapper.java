package cn.scau.dao;

import cn.scau.page.Page;
import cn.scau.pojo.RoomType;
import cn.scau.pojo.RoomTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoomTypeMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int deleteByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int insert(RoomType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int insertSelective(RoomType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	List<RoomType> selectByExampleWithBLOBs(RoomTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	List<RoomType> selectByExample(RoomTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	RoomType selectByPrimaryKey(String code);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int updateByPrimaryKeySelective(RoomType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(RoomType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RoomType
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	int updateByPrimaryKey(RoomType record);

	List<RoomType> list(@Param("page") Page page, @Param("record") RoomType record);
    
    int total(@Param("record") RoomType record);
    
}