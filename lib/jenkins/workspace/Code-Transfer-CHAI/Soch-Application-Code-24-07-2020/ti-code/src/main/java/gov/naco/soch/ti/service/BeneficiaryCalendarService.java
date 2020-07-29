package gov.naco.soch.ti.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.naco.soch.constructordto.CalendarServiceDto;
import gov.naco.soch.dto.BeneficiaryCalendarDateDto;
import gov.naco.soch.dto.BeneficiaryCalendarEventDto;
import gov.naco.soch.dto.BeneficiaryServiceCalendarDto;
import gov.naco.soch.repository.BeneficiaryCalendarRepository;

@Service
public class BeneficiaryCalendarService {

	@Autowired
	BeneficiaryCalendarRepository beneficiaryCalendarRepository;

	public BeneficiaryServiceCalendarDto getBeneficiaryCalendarData(Long beneficairyId, int serviceTypeId,
			Long facilityId) {
		BeneficiaryServiceCalendarDto beneficiaryServiceCalendarDto = new BeneficiaryServiceCalendarDto();
		List<CalendarServiceDto> calendarServiceDtos = beneficiaryCalendarRepository
				.getBeneficiaryServiceData(serviceTypeId, beneficairyId, facilityId);
		if (calendarServiceDtos != null && calendarServiceDtos.size() > 0) {
			beneficiaryServiceCalendarDto = transformServiceData(calendarServiceDtos);
		}
		return beneficiaryServiceCalendarDto;

	}

	public BeneficiaryServiceCalendarDto transformServiceData(List<CalendarServiceDto> calendarServiceDtos) {
		BeneficiaryServiceCalendarDto beneficiaryServiceCalendarDto = new BeneficiaryServiceCalendarDto();
		beneficiaryServiceCalendarDto.setServiceId(calendarServiceDtos.get(0).getServiceTypeId());
		List<BeneficiaryCalendarDateDto> beneficiaryCalendarDateDtos = new ArrayList<BeneficiaryCalendarDateDto>();
		for (CalendarServiceDto calendarServiceDto : calendarServiceDtos) {

			if (calendarServiceDto.getDateOne() != null) {
				List<BeneficiaryCalendarEventDto> beneficiaryCalendarEventDtoList = new ArrayList<BeneficiaryCalendarEventDto>();
				BeneficiaryCalendarDateDto beneficiaryCalendarDateDto = new BeneficiaryCalendarDateDto();
				beneficiaryCalendarDateDto.setDate(calendarServiceDto.getDateOne());
				beneficiaryCalendarDateDto.setoId(1);
				// if (!checkifEventForDateExists(beneficiaryCalendarDateDtos,
				// calendarServiceDto.getDateOne())) {
				if (calendarServiceDto.getEventdataone() != null) {
					BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
					eventDto.setEventId(1);
					eventDto.setEventDesc(calendarServiceDto.getEventdataone());
					beneficiaryCalendarEventDtoList.add(eventDto);

				}
				if (calendarServiceDto.getEventdatatwo() != null) {
					BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
					eventDto.setEventId(2);
					eventDto.setEventDesc(calendarServiceDto.getEventdatatwo());
					beneficiaryCalendarEventDtoList.add(eventDto);

				}
				if (calendarServiceDto.getEventdatathree() != null) {
					BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
					eventDto.setEventId(3);
					eventDto.setEventDesc(calendarServiceDto.getEventdatathree());
					beneficiaryCalendarEventDtoList.add(eventDto);
				}
				if (calendarServiceDto.getEventdatafour() != null) {
					BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
					eventDto.setEventId(4);
					eventDto.setEventDesc(calendarServiceDto.getEventdatafour());
					beneficiaryCalendarEventDtoList.add(eventDto);
				}
				if (calendarServiceDto.getEventdatafive() != null) {
					BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
					eventDto.setEventId(5);
					eventDto.setEventDesc(calendarServiceDto.getEventdatafive());
					beneficiaryCalendarEventDtoList.add(eventDto);
				}
				beneficiaryCalendarDateDto.setBeneficiaryCalendarEventDtos(beneficiaryCalendarEventDtoList);
				// }

				beneficiaryCalendarDateDtos.add(beneficiaryCalendarDateDto);
			}
			if (calendarServiceDto.getDateTwo() != null && calendarServiceDto.isDateTwoValid()) {
				List<BeneficiaryCalendarEventDto> beneficiaryCalendarEventDtoList = new ArrayList<BeneficiaryCalendarEventDto>();
				BeneficiaryCalendarDateDto beneficiaryCalendarDateDto = new BeneficiaryCalendarDateDto();
				beneficiaryCalendarDateDto.setDate(calendarServiceDto.getDateTwo());
				beneficiaryCalendarDateDto.setoId(2);
				if (calendarServiceDto.isDatetwoevent()) {
					if (calendarServiceDto.getEventdataone() != null) {
						BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
						eventDto.setEventId(1);
						eventDto.setEventDesc(calendarServiceDto.getEventdataone());
						beneficiaryCalendarEventDtoList.add(eventDto);

					}
					if (calendarServiceDto.getEventdatatwo() != null) {
						BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
						eventDto.setEventId(2);
						eventDto.setEventDesc(calendarServiceDto.getEventdatatwo());
						beneficiaryCalendarEventDtoList.add(eventDto);

					}
					if (calendarServiceDto.getEventdatathree() != null) {
						BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
						eventDto.setEventId(3);
						eventDto.setEventDesc(calendarServiceDto.getEventdatathree());
						beneficiaryCalendarEventDtoList.add(eventDto);
					}
					if (calendarServiceDto.getEventdatafour() != null) {
						BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
						eventDto.setEventId(4);
						eventDto.setEventDesc(calendarServiceDto.getEventdatafour());
						beneficiaryCalendarEventDtoList.add(eventDto);
					}
					if (calendarServiceDto.getEventdatafive() != null) {
						BeneficiaryCalendarEventDto eventDto = new BeneficiaryCalendarEventDto();
						eventDto.setEventId(5);
						eventDto.setEventDesc(calendarServiceDto.getEventdatafive());
						beneficiaryCalendarEventDtoList.add(eventDto);
					}
					beneficiaryCalendarDateDto.setBeneficiaryCalendarEventDtos(beneficiaryCalendarEventDtoList);
				}

				beneficiaryCalendarDateDtos.add(beneficiaryCalendarDateDto);
			}

		}
		beneficiaryServiceCalendarDto.setDateList(beneficiaryCalendarDateDtos);
		return beneficiaryServiceCalendarDto;
	}

	public boolean checkifEventForDateExists(List<BeneficiaryCalendarDateDto> beneficiaryCalendarDateDtos,
			Date dateToValidate) {
		boolean isExists = false;
		BeneficiaryCalendarDateDto dateDto;
		try {
			dateDto = beneficiaryCalendarDateDtos.stream().filter(o -> o.getDate().equals(dateToValidate)).findFirst()
					.get();

			if (dateDto != null && dateDto.getBeneficiaryCalendarEventDtos() != null) {
				isExists = true;
			}
		} catch (Exception e) {
			return false;
		}
		return isExists;
	}

}
