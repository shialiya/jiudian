package cn.scau.service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.scau.dao.RateTypeMapper;
import cn.scau.dao.ReservationMapper;
import cn.scau.dao.RoomTypeMapper;
import cn.scau.page.Page;
import cn.scau.pojo.RateType;
import cn.scau.pojo.ReservationExample;
import cn.scau.pojo.ReservationExample.Criteria;
import cn.scau.pojo.ReservationWithBLOBs;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationMapper r;
	@Autowired
	RoomTypeMapper room;
	@Autowired 
	RateTypeMapper rate;
	
	@Override
	public int total(ReservationWithBLOBs reservation) {
		// TODO Auto-generated method stub
		return r.total(reservation);
	}

	@Override
	public List<ReservationWithBLOBs> list(Page page, ReservationWithBLOBs reservation) {
		// TODO Auto-generated method stub
		return r.list(page, reservation);
	}

	@Override
	public int add(ReservationWithBLOBs reservation) {
		// TODO Auto-generated method stub
		return r.insertSelective(reservation);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return r.deleteByPrimaryKey(id);
	}

	@Override
	public ReservationWithBLOBs get(Integer id) {
		// TODO Auto-generated method stub
		return r.selectByPrimaryKey(id);
	}

	@Override
	public int update(ReservationWithBLOBs reservation) {
		// TODO Auto-generated method stub
		return r.updateByPrimaryKey(reservation);
	}

	@Override
	public List<ReservationWithBLOBs> search(ReservationWithBLOBs reservation) {
			ReservationExample example=new ReservationExample();
			Criteria criteria=example.createCriteria();
			
			if(reservation.getConfirmID()!=null) {
				System.out.println(1);
				criteria.andConfirmIDEqualTo(reservation.getConfirmID());}
			if(! reservation.getCiDate().toString().equals("2000-01-30")) {
				System.out.println(2);
				criteria.andCiDateEqualTo(reservation.getCiDate());}
			if(!reservation.getCoDate().toString().equals("2000-01-30")) {
				System.out.println(3);
				criteria.andCoDateEqualTo(reservation.getCoDate());}
			if(reservation.getName1().length()!=0) {
				System.out.println(4);
				criteria.andName1EqualTo(reservation.getName1());}
			if(reservation.getSurname1().length()!=0) {
				System.out.println(5);
				criteria.andSurname1EqualTo(reservation.getSurname1());}
			if(reservation.getStatus().length()!=0) {
				System.out.println(reservation.getStatus()+" "+reservation.getStatus().length());
				criteria.andStatusEqualTo(reservation.getStatus());}
			if(reservation.getRmType().length()!=0) {
				System.out.println(7);
				criteria.andRmTypeEqualTo(reservation.getRmType());}
			if(reservation.getRateType().length()!=0) {
				System.out.println(8);
				criteria.andRateTypeEqualTo(reservation.getRateType());}
			if(reservation.getPhone().length()!=0) {
				System.out.println(9);
				criteria.andPhoneEqualTo(reservation.getPhone());}
			if(reservation.getCountry().length()!=0) {
				System.out.println(10);
				criteria.andCountryEqualTo(reservation.getCountry());}
			if(reservation.getRsvFrom().length()!=0) {
				System.out.println(11);
				criteria.andRsvFromEqualTo(reservation.getRsvFrom());}
			if(!reservation.getMadeDate().toString().equals("2000-01-30")) {
				System.out.println(12);
				criteria.andMadeDateEqualTo(reservation.getMadeDate());}
			Criteria criteria2=example.createCriteria();
			if(reservation.getConfirmID()!=null) {
				System.out.println(1);
				criteria2.andConfirmIDEqualTo(reservation.getConfirmID());}
			if(! reservation.getCiDate().toString().equals("2000-01-30")) {
				System.out.println(2);
				criteria2.andCiDateEqualTo(reservation.getCiDate());}
			if(!reservation.getCoDate().toString().equals("2000-01-30")) {
				System.out.println(3);
				criteria2.andCoDateEqualTo(reservation.getCoDate());}
			if(reservation.getName1().length()!=0) {
				System.out.println(4);
				criteria2.andName2EqualTo(reservation.getName1());}
			if(reservation.getSurname1().length()!=0) {
				System.out.println(5);
				criteria2.andSurname2EqualTo(reservation.getSurname1());}
			if(reservation.getStatus().length()!=0) {
				System.out.println(reservation.getStatus()+" "+reservation.getStatus().length());
				criteria2.andStatusEqualTo(reservation.getStatus());}
			if(reservation.getRmType().length()!=0) {
				System.out.println(7);
				criteria2.andRmTypeEqualTo(reservation.getRmType());}
			if(reservation.getRateType().length()!=0) {
				System.out.println(8);
				criteria2.andRateTypeEqualTo(reservation.getRateType());}
			if(reservation.getPhone().length()!=0) {
				System.out.println(9);
				criteria2.andPhoneEqualTo(reservation.getPhone());}
			if(reservation.getCountry().length()!=0) {
				System.out.println(10);
				criteria2.andCountryEqualTo(reservation.getCountry());}
			if(reservation.getRsvFrom().length()!=0) {
				System.out.println(11);
				criteria2.andRsvFromEqualTo(reservation.getRsvFrom());}
			if(!reservation.getMadeDate().toString().equals("2000-01-30")) {
				System.out.println(12);
				criteria2.andMadeDateEqualTo(reservation.getMadeDate());}
			example.or(criteria2);
			List<ReservationWithBLOBs> list=r.selectByExampleWithBLOBs(example);
			System.out.println(list.size());
		return list;
	}

	@Override
	public int sendMail(Integer id) {
		ReservationWithBLOBs r=get(id);
		Properties prop = new Properties();
	    prop.setProperty("mail.debug", "true");
	    prop.setProperty("mail.host", "smtp.sina.cn");
	    prop.setProperty("mail.transport.protocol", "smtp");
	    prop.setProperty("mail.smtp.auth", "true");
	    int i=1;
	    Session session = Session.getInstance(prop);
	    try {
	    	
	    	  Transport ts = session.getTransport();
	  	    ts.connect("", "", "");
	  	    MimeMessage message = new MimeMessage(session);
	  	    message.setFrom(new InternetAddress("")); 
	  	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(r.getCountry())); // 邮件的收件人
//	  	    message.setRecipient(Message.RecipientType.CC, new InternetAddress(MAIL_CC)); // 邮件的抄送人
	  	    message.setRecipient(Message.RecipientType.BCC, new InternetAddress("")); // 邮件的密送人
	  	    //标题
	  	    String title="Your reservation has been confirmed #"+id;
	  	    message.setSubject(title); 
	  	  DecimalFormat df = new DecimalFormat("#.00");

	  	    String content="Dear "+r.getTitle1()+" "+r.getSurname1()+",\n \n"+"Your reservation has been confirmed. The confirmation number is #"+id
	  	    		+". Your stay's details are followings:\n \n Guest name: "+r.getName1()+" "+r.getSurname1()+" "+r.getTitle1()
	  	    		+"\n Check-in date: "+r.getCiDate().toString()+"\n Check-out Date: "+r.getCoDate()
	  	    		+"\n Rooms: "+r.getQuantity()+"\n Guests: "+r.getAdults()+" Adult(s) "+r.getChild()+" Child(ren)\n Total rate: "
	  	    		+df.format(r.getAmount())+" CNY\n Room type: "+room.selectByPrimaryKey(r.getRmType()).getName()+"\n Room details: \n"
	  	    		+room.selectByPrimaryKey(r.getRmType()).getDescription()+"\n Rate type: "+rate.selectByPrimaryKey(r.getRateType()).getName()
	  	    		+"\n Rate details: "+rate.selectByPrimaryKey(r.getRateType()).getDescription()+"\n You can cancel your reservation without penalty before "
	  	    		+r.getFreeCancelDate().toString()+". \n \n Thank you for choosing us. If you need furthur assistance, please do not hesitate to contact us! \n \n Reservation Associate.";
	  	    message.setText(content);
	  	 
	  	    ts.sendMessage(message, message.getAllRecipients());
	  	    ts.close();
		} catch (Exception e) {
			i=0;
		}
	  
		return i;
	}

}
