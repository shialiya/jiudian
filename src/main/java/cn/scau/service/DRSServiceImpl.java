package cn.scau.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.DRSMapper;
import cn.scau.pojo.DRS;
import cn.scau.pojo.DRSExample;
import cn.scau.pojo.DRSExample.Criteria;
import cn.scau.pojo.DailyRateM;

@Service
public class DRSServiceImpl implements DRSService {

	@Autowired
	DRSMapper d;
	
	public Date beforeDate(Date coDate) {
		 long currTime=coDate.getTime() ; 
		 long oneDay =1000*60*60*24; 
		 long beforDayTime =currTime-oneDay ; 
		 coDate=new Date(beforDayTime );
		 return coDate;
	}
	
	@Override
	public List<DRS> show(DailyRateM dailyRateM) {
		DRSExample example=new DRSExample();
		Date ddate=beforeDate(dailyRateM.getCoDate());
		Criteria criteria=example.createCriteria();
		criteria.andDdateBetween(dailyRateM.getCiDate(), ddate);
		criteria.andRestGreaterThanOrEqualTo(dailyRateM.getRest());
		criteria.andRateTypeEqualTo(dailyRateM.getRateType());
		criteria.andRmTypeEqualTo(dailyRateM.getRmType());
		List<DRS> list=d.selectByExample(example);
		int count=(int)((ddate.getTime()-dailyRateM.getCiDate().getTime())/(3600*24*1000));
//		System.out.println(count+"  "+list.size());
//		if(list.size()==count+1) {
//			System.out.println(list.get(list.size()-1).getDdate().toString());
//			DRS drs=new DRS();
//			drs.setBed(list.get(0).getBed());
//			drs.setFreeCancelDate(list.get(0).getFreeCancelDate());
//			drs.setIsToAll(list.get(0).getIsToAll());
//			
//			double sum=0;
//			for(int i=0;i<list.size();i++)
//				sum+=list.get(i).getRate();
//			drs.setRate(sum);
//			if(drs.getFreeCancelDate()==999) {
//				long time=System.currentTimeMillis();
//				Date date=new Date(time);
//				drs.setDdate(date);
//			}else {
//				long currTime=dailyRateM.getCiDate().getTime() ; 
//				long oneDay =1000*60*60*24*drs.getFreeCancelDate(); 
//				long beforDayTime =currTime-oneDay ; 
//				Date date=new Date(beforDayTime);
//				drs.setDdate(date);
//			}
//			System.out.println(list.get(list.size()-1).getDdate().toString());
//			drs.setRest(999);
//			list.add(drs);
//		}
//		else if(list.size()==0){
//			return null;
//		}else {
//			list.get(0).setRest(500);
//		}
		return list;
//		List<DRS> list2=new ArrayList<DRS>();
//		boolean start=true;
//		double sum=0;
//		int total=list.size();
//		for(int j=0;j<list.size();j++) {
//			
//			DRS drs;
//			DRS last=list.get(j);
//			if(j<total-1)
//			  drs=list.get(j+1);
//			else
//				drs=null;
//			if(j<total-1)
//			if (( !last.getRmType().equals(drs.getRmType()) || !last.getRateType().equals(drs.getRateType()) ||j==total-1)&&  (last.getDdate().toString()).equals(dailyRateM.getCoDate().toString()) && !start) {
//				list2.add(last);
//				System.out.println("I'm in 1");
//				DRS newi=last;
//				sum+=last.getRate();
//				newi.setRest(999);
//				newi.setRate(sum);
//				if(newi.getFreeCancelDate()==999) {
//					System.out.println("I'm in 1-1");
//
//					long time=System.currentTimeMillis();
//					Date date=new Date(time);
//					newi.setDdate(date);
//				}else {
//					System.out.println("I'm in 1-2");
//
//					long currTime=dailyRateM.getCiDate().getTime() ; 
//					long oneDay =1000*60*60*24*newi.getFreeCancelDate(); 
//					long beforDayTime =currTime-oneDay ; 
//					Date date=new Date(beforDayTime);
//					newi.setDdate(date);
//				}
//				if(dailyRateM.getFromRate()>sum || dailyRateM.getToRate()<sum) {
//					System.out.println("I'm in 1-3");
//
//					while(list2.size()>0 || list2.get(list2.size()-1).getRest()!=999) {
//						list2.remove(list2.size()-1);
//					}
//				}else
//				{
//					System.out.println("I'm in 1-4");
//
//				list2.add(newi);}
//				sum=0;
//				start=true;
//			}
//			else if((!last.getRmType().equals(drs.getRmType()) || !last.getRateType().equals(drs.getRateType()) ||j==total-1)&& !( last.getDdate().toString()).equals(dailyRateM.getCoDate().toString()) && !start) {
//				while(list2.size()>0 || list2.get(list2.size()-1).getRest()!=999) {
//					list2.remove(list2.size()-1);
//				}
//				sum=0;
//
//			}
//			else if (start && ( last.getDdate().toString()).equals(dailyRateM.getCiDate().toString()) ) {
//				sum+=last.getRate();
//				start=false;
//				list2.add(last);
//				System.out.println("I'm 3");
//
//			}
//			else if (start && !(last.getDdate().toString()).equals(dailyRateM.getCiDate().toString()) ) {
//				System.out.println("I'm 4");
//				System.out.println(last.getDdate().toString()+"    "+dailyRateM.getCiDate().toString());
//			}
//			else if (!start&& last.getDdate().toString().equals(beforeDate(drs.getDdate()).toString())) {
//				sum+=last.getRate();
//				list2.add(last);
//				System.out.println("I'm 5");
//
//			}
//			else if (!start&& !last.getDdate().toString().equals(beforeDate(drs.getDdate()).toString())) {
//				start=true;
//				while(list2.size()>0 && list2.get(list2.size()-1).getRest()!=999) {
//					System.out.println(list2.get(list2.size()-1).getRest());
//					list2.remove(list2.size()-1);
//				}
//				sum=0;
//				System.out.println("I'm 6");
//
//			}
//		}
//		
		
	}

}

