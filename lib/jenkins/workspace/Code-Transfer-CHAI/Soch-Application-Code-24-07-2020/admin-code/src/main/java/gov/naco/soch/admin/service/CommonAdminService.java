package gov.naco.soch.admin.service;

import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import gov.naco.soch.util.CommonConstants;

@Service
public class CommonAdminService {

	private static final Logger logger = LoggerFactory.getLogger(CommonAdminService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${cache.clearEndpointAdmin}")
	private String CACHE_CLEAR_ENDPOINT;

	@Autowired
	private Environment env;

	public void clearCache(String cacheName, String cacheKey) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>("body", headers);
			StringBuilder cacheClearEndpoint = new StringBuilder(CACHE_CLEAR_ENDPOINT);
			if (!StringUtils.isBlank(cacheName)) {
				cacheClearEndpoint.append("?cacheName=");
				cacheClearEndpoint.append(cacheName);
				if (!StringUtils.isBlank(cacheKey)) {
					cacheClearEndpoint.append("&cacheKey=");
					cacheClearEndpoint.append(cacheKey);
				}
				cacheClearEndpoint.append("&accessKey=");
				cacheClearEndpoint.append(env.getProperty(CommonConstants.PROPERTY_ACCESS_KEY));
			}
			restTemplate.exchange(cacheClearEndpoint.toString(), HttpMethod.GET, entity, String.class);
		} catch (Exception e) {
			logger.error("Exception in clearing cache !", e);
		}

	}
}
