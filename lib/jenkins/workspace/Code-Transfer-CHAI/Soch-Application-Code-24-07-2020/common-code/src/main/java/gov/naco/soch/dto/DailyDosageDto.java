package gov.naco.soch.dto;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DailyDosageDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value="sno")
	private long serialNum;
	
	private String facility;
	
	private Date reportingDate;
	
	private String userName;
	
	private String ostDistrict;
	
	private int totalRegd;
	
	private int startOstMonth;
	
	@JsonProperty(value="client_name")
	private String patientName;
	
	@JsonProperty(value="ost_no")
	private String ostRegnNum;
	
	private String currentDose;
	
	@JsonProperty(value="total_days")
	private int totalDoseDays;
	
	@JsonProperty(value="total_dispense")
	private double totalDose;

	@JsonProperty(value="1")
	private String day1;
	
	@JsonProperty(value="2")
	private String day2;
	
	@JsonProperty(value="3")
	private String day3;
	
	@JsonProperty(value="4")
	private String day4;
	
	@JsonProperty(value="5")
	private String day5;
	
	@JsonProperty(value="6")
	private String day6;
	
	@JsonProperty(value="7")
	private String day7;
	
	@JsonProperty(value="8")
	private String day8;
	
	@JsonProperty(value="9")
	private String day9;
	
	@JsonProperty(value="10")
	private String day10;
	
	@JsonProperty(value="11")
	private String day11;
	
	@JsonProperty(value="12")
	private String day12;
	
	@JsonProperty(value="13")
	private String day13;
	
	@JsonProperty(value="14")
	private String day14;
	
	@JsonProperty(value="15")
	private String day15;
	
	@JsonProperty(value="16")
	private String day16;
	
	@JsonProperty(value="17")
	private String day17;
	
	@JsonProperty(value="18")
	private String day18;
	
	@JsonProperty(value="19")
	private String day19;
	
	@JsonProperty(value="20")
	private String day20;
	
	@JsonProperty(value="21")
	private String day21;
	
	@JsonProperty(value="22")
	private String day22;
	
	@JsonProperty(value="23")
	private String day23;
	
	@JsonProperty(value="24")
	private String day24;
	
	@JsonProperty(value="25")
	private String day25;
	
	@JsonProperty(value="26")
	private String day26;
	
	@JsonProperty(value="27")
	private String day27;
	
	@JsonProperty(value="28")
	private String day28;
	
	@JsonProperty(value="29")
	private String day29;
	
	@JsonProperty(value="30")
	private String day30;
	
	@JsonProperty(value="31")
	private String day31;	
	
	
	/**
	 * @return the serialNum
	 */
	public long getSerialNum() {
		return serialNum;
	}

	/**
	 * @param serialNum the serialNum to set
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * @return the facility
	 */
	public String getFacility() {
		return facility;
	}

	/**
	 * @param facility the facility to set
	 */
	public void setFacility(String facility) {
		this.facility = facility;
	}

	/**
	 * @return the reportingDate
	 */
	public Date getReportingDate() {
		return reportingDate;
	}

	/**
	 * @param reportingDate the reportingDate to set
	 */
	public void setReportingDate(Date reportingDate) {
		this.reportingDate = reportingDate;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the ostDistrict
	 */
	public String getOstDistrict() {
		return ostDistrict;
	}

	/**
	 * @param ostDistrict the ostDistrict to set
	 */
	public void setOstDistrict(String ostDistrict) {
		this.ostDistrict = ostDistrict;
	}

	/**
	 * @return the totalRegd
	 */
	public int getTotalRegd() {
		return totalRegd;
	}

	/**
	 * @param totalRegd the totalRegd to set
	 */
	public void setTotalRegd(int totalRegd) {
		this.totalRegd = totalRegd;
	}

	/**
	 * @return the startOstMonth
	 */
	public int getStartOstMonth() {
		return startOstMonth;
	}

	/**
	 * @param startOstMonth the startOstMonth to set
	 */
	public void setStartOstMonth(int startOstMonth) {
		this.startOstMonth = startOstMonth;
	}

	/**
	 * @return the patientName
	 */
	public String getPatientName() {
		return patientName;
	}

	/**
	 * @param patientName the patientName to set
	 */
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	/**
	 * @return the ostRegnNum
	 */
	public String getOstRegnNum() {
		return ostRegnNum;
	}

	/**
	 * @param ostRegnNum the ostRegnNum to set
	 */
	public void setOstRegnNum(String ostRegnNum) {
		this.ostRegnNum = ostRegnNum;
	}

	/**
	 * @return the currentDose
	 */
	public String getCurrentDose() {
		return currentDose;
	}

	/**
	 * @param currentDose the currentDose to set
	 */
	public void setCurrentDose(String currentDose) {
		this.currentDose = currentDose;
	}

	/**
	 * @return the totalDoseDays
	 */
	public int getTotalDoseDays() {
		return totalDoseDays;
	}

	/**
	 * @param totalDoseDays the totalDoseDays to set
	 */
	public void setTotalDoseDays(int totalDoseDays) {
		this.totalDoseDays = totalDoseDays;
	}

	/**
	 * @return the totalDose
	 */
	public double getTotalDose() {
		return totalDose;
	}

	/**
	 * @param totalDose the totalDose to set
	 */
	public void setTotalDose(double totalDose) {
		this.totalDose = totalDose;
	}

	/**
	 * @return the day1
	 */
	public String getDay1() {
		return day1;
	}

	/**
	 * @param day1 the day1 to set
	 */
	public void setDay1(String day1) {
		this.day1 = day1;
	}

	/**
	 * @return the day2
	 */
	public String getDay2() {
		return day2;
	}

	/**
	 * @param day2 the day2 to set
	 */
	public void setDay2(String day2) {
		this.day2 = day2;
	}

	/**
	 * @return the day3
	 */
	public String getDay3() {
		return day3;
	}

	/**
	 * @param day3 the day3 to set
	 */
	public void setDay3(String day3) {
		this.day3 = day3;
	}

	/**
	 * @return the day4
	 */
	public String getDay4() {
		return day4;
	}

	/**
	 * @param day4 the day4 to set
	 */
	public void setDay4(String day4) {
		this.day4 = day4;
	}

	/**
	 * @return the day5
	 */
	public String getDay5() {
		return day5;
	}

	/**
	 * @param day5 the day5 to set
	 */
	public void setDay5(String day5) {
		this.day5 = day5;
	}

	/**
	 * @return the day6
	 */
	public String getDay6() {
		return day6;
	}

	/**
	 * @param day6 the day6 to set
	 */
	public void setDay6(String day6) {
		this.day6 = day6;
	}

	/**
	 * @return the day7
	 */
	public String getDay7() {
		return day7;
	}

	/**
	 * @param day7 the day7 to set
	 */
	public void setDay7(String day7) {
		this.day7 = day7;
	}

	/**
	 * @return the day8
	 */
	public String getDay8() {
		return day8;
	}

	/**
	 * @param day8 the day8 to set
	 */
	public void setDay8(String day8) {
		this.day8 = day8;
	}

	/**
	 * @return the day9
	 */
	public String getDay9() {
		return day9;
	}

	/**
	 * @param day9 the day9 to set
	 */
	public void setDay9(String day9) {
		this.day9 = day9;
	}

	/**
	 * @return the day10
	 */
	public String getDay10() {
		return day10;
	}

	/**
	 * @param day10 the day10 to set
	 */
	public void setDay10(String day10) {
		this.day10 = day10;
	}

	/**
	 * @return the day11
	 */
	public String getDay11() {
		return day11;
	}

	/**
	 * @param day11 the day11 to set
	 */
	public void setDay11(String day11) {
		this.day11 = day11;
	}

	/**
	 * @return the day12
	 */
	public String getDay12() {
		return day12;
	}

	/**
	 * @param day12 the day12 to set
	 */
	public void setDay12(String day12) {
		this.day12 = day12;
	}

	/**
	 * @return the day13
	 */
	public String getDay13() {
		return day13;
	}

	/**
	 * @param day13 the day13 to set
	 */
	public void setDay13(String day13) {
		this.day13 = day13;
	}

	/**
	 * @return the day14
	 */
	public String getDay14() {
		return day14;
	}

	/**
	 * @param day14 the day14 to set
	 */
	public void setDay14(String day14) {
		this.day14 = day14;
	}

	/**
	 * @return the day15
	 */
	public String getDay15() {
		return day15;
	}

	/**
	 * @param day15 the day15 to set
	 */
	public void setDay15(String day15) {
		this.day15 = day15;
	}

	/**
	 * @return the day16
	 */
	public String getDay16() {
		return day16;
	}

	/**
	 * @param day16 the day16 to set
	 */
	public void setDay16(String day16) {
		this.day16 = day16;
	}

	/**
	 * @return the day17
	 */
	public String getDay17() {
		return day17;
	}

	/**
	 * @param day17 the day17 to set
	 */
	public void setDay17(String day17) {
		this.day17 = day17;
	}

	/**
	 * @return the day18
	 */
	public String getDay18() {
		return day18;
	}

	/**
	 * @param day18 the day18 to set
	 */
	public void setDay18(String day18) {
		this.day18 = day18;
	}

	/**
	 * @return the day19
	 */
	public String getDay19() {
		return day19;
	}

	/**
	 * @param day19 the day19 to set
	 */
	public void setDay19(String day19) {
		this.day19 = day19;
	}

	/**
	 * @return the day20
	 */
	public String getDay20() {
		return day20;
	}

	/**
	 * @param day20 the day20 to set
	 */
	public void setDay20(String day20) {
		this.day20 = day20;
	}

	/**
	 * @return the day21
	 */
	public String getDay21() {
		return day21;
	}

	/**
	 * @param day21 the day21 to set
	 */
	public void setDay21(String day21) {
		this.day21 = day21;
	}

	/**
	 * @return the day22
	 */
	public String getDay22() {
		return day22;
	}

	/**
	 * @param day22 the day22 to set
	 */
	public void setDay22(String day22) {
		this.day22 = day22;
	}

	/**
	 * @return the day23
	 */
	public String getDay23() {
		return day23;
	}

	/**
	 * @param day23 the day23 to set
	 */
	public void setDay23(String day23) {
		this.day23 = day23;
	}

	/**
	 * @return the day24
	 */
	public String getDay24() {
		return day24;
	}

	/**
	 * @param day24 the day24 to set
	 */
	public void setDay24(String day24) {
		this.day24 = day24;
	}

	/**
	 * @return the day25
	 */
	public String getDay25() {
		return day25;
	}

	/**
	 * @param day25 the day25 to set
	 */
	public void setDay25(String day25) {
		this.day25 = day25;
	}

	/**
	 * @return the day26
	 */
	public String getDay26() {
		return day26;
	}

	/**
	 * @param day26 the day26 to set
	 */
	public void setDay26(String day26) {
		this.day26 = day26;
	}

	/**
	 * @return the day27
	 */
	public String getDay27() {
		return day27;
	}

	/**
	 * @param day27 the day27 to set
	 */
	public void setDay27(String day27) {
		this.day27 = day27;
	}

	/**
	 * @return the day28
	 */
	public String getDay28() {
		return day28;
	}

	/**
	 * @param day28 the day28 to set
	 */
	public void setDay28(String day28) {
		this.day28 = day28;
	}

	/**
	 * @return the day29
	 */
	public String getDay29() {
		return day29;
	}

	/**
	 * @param day29 the day29 to set
	 */
	public void setDay29(String day29) {
		this.day29 = day29;
	}

	/**
	 * @return the day30
	 */
	public String getDay30() {
		return day30;
	}

	/**
	 * @param day30 the day30 to set
	 */
	public void setDay30(String day30) {
		this.day30 = day30;
	}

	/**
	 * @return the day31
	 */
	public String getDay31() {
		return day31;
	}

	/**
	 * @param day31 the day31 to set
	 */
	public void setDay31(String day31) {
		this.day31 = day31;
	}
	
	
	
	
}
