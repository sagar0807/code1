package gov.naco.soch.service.mapper;


import gov.naco.soch.domain.*;
import gov.naco.soch.service.dto.RiskProfilingQuestionsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RiskProfilingQuestions} and its DTO {@link RiskProfilingQuestionsDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RiskProfilingQuestionsMapper extends EntityMapper<RiskProfilingQuestionsDTO, RiskProfilingQuestions> {



    default RiskProfilingQuestions fromId(Long id) {
        if (id == null) {
            return null;
        }
        RiskProfilingQuestions riskProfilingQuestions = new RiskProfilingQuestions();
        riskProfilingQuestions.setId(id);
        return riskProfilingQuestions;
    }
}
