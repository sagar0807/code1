/**
 * 
 */
package gov.naco.soch.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import gov.naco.soch.admin.ArtMiniMasterDto;
import gov.naco.soch.admin.service.ArtMiniMasterService;

/**
 * @author Pranav MS (144958)
 * @email pranav.sasi@ust-global.com
 * @date 2020-Jul-20 11:58:18 am 
 * 
 */
@RestController
@RequestMapping("/artminimaster")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtMiniMasterController {
	private static final Logger logger = LoggerFactory.getLogger(ArtMiniMasterController.class);

	@Autowired
	ArtMiniMasterService artMiniMasterService;
	
	public ArtMiniMasterController() {
	}

	@GetMapping("/addbenficiary")
	public @ResponseBody ArtMiniMasterDto getMiniMasterForAddBenficiary() {
		logger.debug("Entering into method getAllLabTypes");
		return artMiniMasterService.getMiniMasterForAddBenficiary();
	}
}
