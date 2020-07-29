package gov.naco.soch.projection;

import java.util.Date;

public interface MasterLineProjection {

	/*
	 * private String MllCenName; private String MllAddr; private String MllCity;
	 * private String MllDist; private String MllState; private String MllPin;
	 * private Date MllCurrDate; private String MllUid; private String MllRegNum;
	 * private String MllPatientName; private String MllPatGender; private String
	 * MllPatAge; private String MllPatMobile; private String MllCurrStatus; private
	 * String MllCurrDosage;
	 */


	/*
	 * select f.name AS MllCenName,a.address AS MllAddr,a.city as MllCity,s.name AS
	 * MllState ,d.name AS MllDist,a.pincode as MllPin,b.uid as
	 * MllUid,b.ost_code,concat(b.first_name,' ',b.last_name) as
	 * MllPatientName,b.created_time,b.gender,b.age,b.mobile_number,
	 * b.beneficiary_activity_status,bp.current_dose from soch.facility f inner join
	 * soch.address a on f.address_id = a.id inner join soch.beneficiary b on f.code
	 * = b.ost_code inner join soch.address ad on f.address_id = ad.id inner join
	 * soch.district d on a.district_id = d.id inner join soch.state s on a.state_id
	 * = s.id left outer join soch.ti_ost_details bp on bp.beneficiary_id = b.id
	 * where f.id = 1001;
	 */
	
	
	public String getMllCenName();

	public void setMllCenName(String mllCenName) ;

	public String getMllAddr();

	public void setMllAddr(String mllAddr);

	public String getMllCity() ;

	public void setMllCity(String mllCity) ;

	public String getMllDist() ;

	public void setMllDist(String mllDist);

	public String getMllState();

	public void setMllState(String mllState);

	public String getMllPin() ;

	public void setMllPin(String mllPin);

	public Date getMllRegDate();

	public void setMllRegDate(Date mllCurrDate);

	public String getMllUid();

	public void setMllUid(String mllUid);

	public String getMllRegNum();

	public void setMllRegNum(String mllRegNum);

	public String getMllPatientName();

	public void setMllPatientName(String mllPatientName) ;

	public String getMllPatGender();

	public void setMllPatGender(String mllPatGender);

	public String getMllPatAge();

	public void setMllPatAge(String mllPatAge) ;

	public String getMllPatMobile();

	public void setMllPatMobile(String mllPatMobile) ;

	public String getMllCurrStatus();

	public void setMllCurrStatus(String mllCurrStatus) ;

	public String getMllCurrDosage();

	public void setMllCurrDosage(String mllCurrDosage) ;


}
