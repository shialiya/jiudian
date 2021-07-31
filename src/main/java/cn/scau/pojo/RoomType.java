package cn.scau.pojo;

import java.util.List;

public class RoomType {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RoomType.code
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	private String code;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RoomType.name
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	private String name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RoomType.num
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	private Integer num;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RoomType.bed
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	private Integer bed;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RoomType.tier
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	private Integer tier;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column RoomType.description
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	private String description;



	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RoomType.code
	 * @return  the value of RoomType.code
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public String getCode() {
		return code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RoomType.code
	 * @param code  the value for RoomType.code
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RoomType.name
	 * @return  the value of RoomType.name
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RoomType.name
	 * @param name  the value for RoomType.name
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RoomType.num
	 * @return  the value of RoomType.num
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RoomType.num
	 * @param num  the value for RoomType.num
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RoomType.bed
	 * @return  the value of RoomType.bed
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public Integer getBed() {
		return bed;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RoomType.bed
	 * @param bed  the value for RoomType.bed
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public void setBed(Integer bed) {
		this.bed = bed;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RoomType.tier
	 * @return  the value of RoomType.tier
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public Integer getTier() {
		return tier;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RoomType.tier
	 * @param tier  the value for RoomType.tier
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public void setTier(Integer tier) {
		this.tier = tier;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column RoomType.description
	 * @return  the value of RoomType.description
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column RoomType.description
	 * @param description  the value for RoomType.description
	 * @mbg.generated  Sat Aug 04 20:04:16 CST 2018
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<RoomType> roomTypes;
    
    private List<List<RoomType>> roomTypesByRow;
    
    

    public List<RoomType> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<List<RoomType>> getRoomTypesByRow() {
		return roomTypesByRow;
	}

	public void setRoomTypesByRow(List<List<RoomType>> roomTypesByRow) {
		this.roomTypesByRow = roomTypesByRow;
	}
}