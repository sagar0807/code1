package gov.naco.soch.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.cdac.medinfo.csnotk.csnolib.agents.SNOMEDAgent;
import in.cdac.medinfo.csnotk.csnolib.commons.ConceptDetails;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumAcceptability;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumLangRefset;
import in.cdac.medinfo.csnotk.csnolib.commons.EnumState;
import in.cdac.medinfo.csnotk.csnolib.model.CompositeDescription;

@Service
@Transactional
public class SnomedCtService {

	private static final Logger logger = LoggerFactory.getLogger(SnomedCtService.class);

	@Value("${snomedct.installFileDirectory}")
	private String installFilePathDefault;
	@Value("${snomedct.dataDirectory}")
	private String dataDir;
	@Value("${snomedct.logDirectory}")
	private String errorLogDir;

	public boolean createSnomedCtDb(String installFilePath, Integer searchReturnlimit, Integer suggestReturnlimit,
			Integer topSuggestReturnlimit, boolean overridedb) throws Exception {

		SNOMEDAgent agent = configSnomedCt(searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit);
		if (StringUtils.isBlank(installFilePath)) {
			installFilePath = installFilePathDefault;
		}
		if (StringUtils.isBlank(installFilePath)) {
			logger.error("SnomedCT installation path is missing");
			throw new Exception("SnomedCT Installation directory path not found");
		}
		logger.debug("Creatomg SnomedCT db with installFilePath->{}:", installFilePath);
		agent.createSNOMEDdb(installFilePath, overridedb);
		return true;
	}

	public boolean createSnomedCtExtensiondb(String installFilePath, Integer searchReturnlimit,
			Integer suggestReturnlimit, Integer topSuggestReturnlimit, boolean overridedb) throws Exception {

		SNOMEDAgent agent = configSnomedCt(searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit);
		if (StringUtils.isBlank(installFilePath)) {
			installFilePath = installFilePathDefault;
		}
		if (StringUtils.isBlank(installFilePath)) {
			logger.error("SnomedCT installation path is missing");
			throw new Exception("SnomedCT Installation directory path not found");
		}
		logger.debug("Creatomg SnomedCT extension db with installFilePath->{}:", installFilePath);
		agent.createExtensiondb(installFilePath, overridedb);
		return true;
	}

	public Set<CompositeDescription> search(String matchTerm, String semanticTags, Integer searchReturnlimit,
			Integer suggestReturnlimit, Integer topSuggestReturnlimit) throws Exception {

		SNOMEDAgent agent = configSnomedCt(searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit);
		logger.debug("Searching snomedCt with matchTerm->{}:", matchTerm);
		EnumState enumState = EnumState.getEnum("active");
		List<String> semanticTagList = new ArrayList<String>();
		if(!StringUtils.isBlank(semanticTags)) {
			semanticTagList.addAll(Arrays.asList(semanticTags.split(",")));	
		}
		EnumAcceptability enumAcceptability = EnumAcceptability.getEnum("preferred");
		Set<CompositeDescription> descriptions = agent.search(matchTerm, enumState, semanticTagList, enumAcceptability,
				searchReturnlimit, false, null, null);
		return descriptions;
	}

	public ConceptDetails getConceptDetails(String conceptId) throws Exception {

		SNOMEDAgent agent = configSnomedCt(null, null, null);
		EnumLangRefset langRefset = EnumLangRefset.getEnum("uk");
		ConceptDetails conceptDetails = agent.getConceptDetails(conceptId, langRefset);
		return conceptDetails;
	}

	public Set<String> getSuggestions(String matchTerm, Integer searchReturnlimit, Integer suggestReturnlimit,
			Integer topSuggestReturnlimit) throws Exception {

		SNOMEDAgent agent = configSnomedCt(searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit);
		logger.debug("Searching snomedCt with matchTerm->{}:", matchTerm);
		EnumState enumState = EnumState.getEnum("active");
		List<String> semanticTagList = new ArrayList<String>();
		semanticTagList.add("finding");
		EnumAcceptability enumAcceptability = EnumAcceptability.getEnum("preferred");
		Set<String> descriptions = agent.getSuggestions(matchTerm, enumState, semanticTagList, enumAcceptability,
				searchReturnlimit, null, null);
		return descriptions;
	}

	private SNOMEDAgent configSnomedCt(Integer searchReturnlimit, Integer suggestReturnlimit,
			Integer topSuggestReturnlimit) throws Exception {

		if (StringUtils.isBlank(dataDir)) {
			logger.error("SnomedCT dataDir is not passed, so going with default dataDir->{}:", dataDir);
			throw new Exception("SnomedCT Data directory path not found");
		}
		if (StringUtils.isBlank(errorLogDir)) {
			logger.error("SnomedCT errorLogDir is not passed, so going with default errorLogDir->{}:", errorLogDir);
			throw new Exception("SnomedCT Log directory path not found");
		}
		if (searchReturnlimit == null) {
			searchReturnlimit = 10000;
			logger.debug("SnomedCT searchReturnlimit is not passed, so going with default searchReturnlimit->{}:",
					searchReturnlimit);
		}
		if (suggestReturnlimit == null) {
			suggestReturnlimit = 500;
			logger.debug("SnomedCT suggestReturnlimit is not passed, so going with default suggestReturnlimit->{}:",
					suggestReturnlimit);
		}
		if (topSuggestReturnlimit == null) {
			topSuggestReturnlimit = 50;
			logger.debug(
					"SnomedCT topSuggestReturnlimit is not passed, so going with default topSuggestReturnlimit->{}:",
					topSuggestReturnlimit);
		}
		SNOMEDAgent agent = new SNOMEDAgent();
		agent.init(dataDir, errorLogDir, searchReturnlimit, suggestReturnlimit, topSuggestReturnlimit);
		return agent;
	}

}
