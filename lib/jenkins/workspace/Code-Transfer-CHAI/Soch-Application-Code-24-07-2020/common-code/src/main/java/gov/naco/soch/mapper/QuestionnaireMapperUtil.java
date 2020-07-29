package gov.naco.soch.mapper;

import gov.naco.soch.dto.FacilityTypeDto;
import gov.naco.soch.dto.QuestionDto;
import gov.naco.soch.dto.QuestionnaireDto;
import gov.naco.soch.entity.FacilityType;
import gov.naco.soch.entity.Question;
import gov.naco.soch.entity.Questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

public class QuestionnaireMapperUtil {
	// method to map questionnaireList with questionnaireDtoList
	public static List<QuestionnaireDto> mapToQuestionnaireDtoList(List<Questionnaire> questionnaireList) {
		List<QuestionnaireDto> questionnaireDtoList = new ArrayList<QuestionnaireDto>();
		if (!CollectionUtils.isEmpty(questionnaireList)) {
			questionnaireList.forEach(questionnaire -> {
				QuestionnaireDto questionnaireDto = new QuestionnaireDto();
				questionnaireDto.setId(questionnaire.getId());
				questionnaireDto.setSurveyName(questionnaire.getSurveyName());
				questionnaireDto.setDescription(questionnaire.getDescription());
				questionnaireDtoList.add(questionnaireDto);
			});
		}
		return questionnaireDtoList;
	}

//	private Questionnaire mapQuestionnaireFromDto(QuestionnaireDto questionnaireDto, Questionnaire questionnaire) {
//
//		questionnaire.setSurveyName(questionnaireDto.getSurveyName());
//		questionnaire.setDescription(questionnaireDto.getDescription());
//		return questionnaire;
//	}
	
	
	// method to map facilityTypeDto with facilityType
	public static Questionnaire maptoQuestionnaire(QuestionnaireDto questionnaireDto, Questionnaire questionnaire) {

		if (questionnaire == null) {
			questionnaire = new Questionnaire();
		} else {
			if (questionnaireDto != null) {
				questionnaire.setId(questionnaireDto.getId());
				questionnaire.setSurveyName(questionnaireDto.getSurveyName().toString());
				questionnaire.setDescription(questionnaireDto.getDescription());
//				questionnaire.setIsActive(questionnaireDto.getIsActive());
//				questionnaire.setIsDelete(false);
			}
		}
		return questionnaire;
	}
	
	public static QuestionnaireDto mapQuestionnaireToDto(Questionnaire questionnaire, boolean isLoadQuestions ) {
		
		QuestionnaireDto questionnaireDto = new QuestionnaireDto();
		questionnaireDto.setId( questionnaire.getId() );
		questionnaireDto.setSurveyName(questionnaire.getSurveyName());
		questionnaireDto.setDescription(questionnaire.getDescription());
		
//		if ( isLoadQuestions) {
//			questionnaireDto.setQstns(mapQuestionListToDto(questionnaire.getQuestions()));
//		} else {
//			questionnaireDto.setQstns( new ArrayList<QuestionDto>());
//		}
				
		return questionnaireDto;
	}
}
