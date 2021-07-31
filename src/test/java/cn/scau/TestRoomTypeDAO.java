package cn.scau;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.dao.RoomTypeMapper;
import cn.scau.dao.StaffMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RoomType;
import cn.scau.pojo.Staff;

public class TestRoomTypeDAO extends BaseTest{
	private static Logger logger=Logger.getLogger(TestStaffDAO.class);
	@Autowired
	private RoomTypeMapper roomTypeMapper;
	
	@Test
	public void testRoomTypeList() throws Exception{
		RoomType record = new RoomType();
		Page page=new Page();
		record.setDescription("Amenities");
//		List<RoomType> r=roomTypeMapper.list(page, record);
		int i=roomTypeMapper.total(record);
		logger.info("the result is"+i);
	}
}
