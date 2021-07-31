package cn.scau.service;

import java.util.List;

import cn.scau.page.Page;
import cn.scau.pojo.ReservationWithBLOBs;

public interface ReservationService {

	int total(ReservationWithBLOBs reservation);
	List<ReservationWithBLOBs> list(Page page,ReservationWithBLOBs reservation);
	int add(ReservationWithBLOBs reservation);
	int delete(Integer id);
	ReservationWithBLOBs get(Integer id);
	int update(ReservationWithBLOBs reservation);
	List<ReservationWithBLOBs> search(ReservationWithBLOBs reservation);
	int sendMail(Integer id);
}
