package gov.naco.soch.controller;

import javax.cache.CacheManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.dto.SystemDto;
import gov.naco.soch.util.CommonConstants;

/*Controller class for API to get application details.*/

@RestController
@RequestMapping("/system")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@PropertySource("classpath:application.yml")
public class SystemController {

	@Autowired
	private Environment env;

	@Autowired
	CacheManager cacheManager;

	public SystemController() {
	}

	/* API to get application details. */
	@GetMapping("/details")
	public @ResponseBody SystemDto getApplicationDetails(String accessKey) {
		if (StringUtils.isBlank(accessKey) || !env.getProperty(CommonConstants.PROPERTY_ACCESS_KEY).equals(accessKey)) {
			throw new AccessDeniedException("accessKey is not valid");
		}
		SystemDto systemDto = new SystemDto();
		systemDto.setVersion("1.0.19");
		systemDto.setProfile(env.getProperty(CommonConstants.PROPERTY_PROFILE));
		systemDto.setUpdatedOn("23-Jul-2020 22:30 IST");
		return systemDto;

	}

	/* API to clear cache entries. */
	@GetMapping("/clearCache")
	public void evictAllCacheValues(String cacheName, String cacheKey, String accessKey) {
		if (StringUtils.isBlank(accessKey) || !env.getProperty(CommonConstants.PROPERTY_ACCESS_KEY).equals(accessKey)) {
			throw new AccessDeniedException("accessKey is not valid");
		}
		if (!StringUtils.isBlank(cacheName) && cacheManager.getCache(cacheName) != null) {
			if (!StringUtils.isBlank(cacheKey)) {
				cacheManager.getCache(cacheName).remove(cacheKey);
			} else {
				cacheManager.getCache(cacheName).clear();
			}
		} else {
			cacheManager.getCacheNames().forEach(cacheNameStored -> cacheManager.getCache(cacheNameStored).clear());
		}
	}
}
