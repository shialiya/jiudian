package cn.scau.pojo;

import java.sql.Date;

public class DailyRateSearch {

	Date ciDate;
	Date coDate;
	String rmType;
	String rateType;
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
	public String getRmType() {
		return rmType;
	}
	public void setRmType(String rmType) {
		this.rmType = rmType;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	
}
