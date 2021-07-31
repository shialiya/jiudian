package cn.scau.pojo;

import java.sql.Date;

public class DailyRateM {
	  private Date ciDate;
	  private Date coDate;
	  private int rest;
	  private String rateType;
	  private String rmType;
	 
	public Date getCiDate() {
		return ciDate;
	}
	public void setCiDate(Date ciDate) {
		this.ciDate = ciDate;
	}
	public Date getCoDate() {
		return coDate;
	}
	public void setCoDate(Date coDate) {
		this.coDate = coDate;
	}
	public int getRest() {
		return rest;
	}
	public void setRest(int i) {
		this.rest = i;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getRmType() {
		return rmType;
	}
	public void setRmType(String rmType) {
		this.rmType = rmType;
	}

	  
	  
}
