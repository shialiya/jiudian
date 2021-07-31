package cn.scau;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import cn.scau.dao.StaffMapper;
import cn.scau.pojo.Staff;

public class TestStaffDAO extends BaseTest{
	private static Logger logger=Logger.getLogger(TestStaffDAO.class);
	@Autowired
	private StaffMapper staffMapper;
	
//	@Test
//	public void testCheckStaff() throws Exception{
//
//		Staff staff=staffMapper.checkStaff(68942, "123456");
//		staff.setNotes("Hlosdhf");
//		staffMapper.updateByPrimaryKeySelective(staff);
//		logger.info("testCheckUser() result is "+staff);
//	}
}
