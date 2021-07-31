package cn.scau;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.scau.pojo.RoomType;
import cn.scau.pojo.Staff;
import cn.scau.service.RoomTypeService;
import cn.scau.service.StaffService;

public class TestRoomTypeService extends BaseTest {

	@Autowired
	private RoomTypeService r;
	
	@Test
	public void testList() {
		RoomType record = new RoomType();
		record.setBed(1);
		record.setCode("XXX");
		record.setName("Test");
		record.setNum(10);
		record.setTier(10);
		int i=r.add(record);
		System.out.println("the result is"+i);
	}
}
