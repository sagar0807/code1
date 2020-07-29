package gov.naco.soch.ti.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gov.naco.soch.entity.Facility;
import gov.naco.soch.entity.LinkedFacilityBeneficiary;
import gov.naco.soch.entity.MasterBeneficiaryDeleteReason;
import gov.naco.soch.entity.TiOstBeneficiary;
import gov.naco.soch.repository.LinkedFacilityBeneficiaryRepository;
import gov.naco.soch.repository.TiOstBeneficiaryRepository;
import gov.naco.soch.ti.dto.LinkedBeneficiaryDTO;
import gov.naco.soch.ti.mapper.LinkBeneficiaryMapper;

@Service
@Transactional
public class TiSatelliteOstServiceImpl {

	private final Logger log = LoggerFactory.getLogger(TiSatelliteOstServiceImpl.class);

	private final LinkedFacilityBeneficiaryRepository linkedFacilityBeneficiaryRepository;

	private final TiOstBeneficiaryRepository tiOstBeneficiaryRepository;

	private final LinkBeneficiaryMapper linkBeneficiaryMapper;

	public TiSatelliteOstServiceImpl(LinkedFacilityBeneficiaryRepository linkedFacilityBeneficiaryRepository,
			TiOstBeneficiaryRepository tiOstBeneficiaryRepository, LinkBeneficiaryMapper linkBeneficiaryMapper) {
		this.linkedFacilityBeneficiaryRepository = linkedFacilityBeneficiaryRepository;
		this.linkBeneficiaryMapper = linkBeneficiaryMapper;
		this.tiOstBeneficiaryRepository = tiOstBeneficiaryRepository;
	}

	public LinkedBeneficiaryDTO save(LinkedBeneficiaryDTO linkedBeneficiaryDTO) {
		log.info("Request to link TIOstBeneficiary : {}", linkedBeneficiaryDTO);
		LinkedFacilityBeneficiary linkedFacilityBeneficiary = linkBeneficiaryMapper.toEntity(linkedBeneficiaryDTO);
		linkedFacilityBeneficiary = linkedFacilityBeneficiaryRepository.save(linkedFacilityBeneficiary);
		setLinkedFacilityToOstBeneficiary(linkedBeneficiaryDTO);
		LinkedBeneficiaryDTO response = linkBeneficiaryMapper.toDto(linkedFacilityBeneficiary);
		return response;
	}

	private void setLinkedFacilityToOstBeneficiary(LinkedBeneficiaryDTO linkedBeneficiaryDTO) {
		Optional<TiOstBeneficiary> ostBeneficiary = tiOstBeneficiaryRepository
				.findById(linkedBeneficiaryDTO.getOstBeneficiaryId());
		if (ostBeneficiary.isPresent()) {
			TiOstBeneficiary tiOstBeneficiary = ostBeneficiary.get();
			Facility linkedFacility = new Facility();
			if (linkedBeneficiaryDTO.getIsLinked() == true) {
				linkedFacility.setId(linkedBeneficiaryDTO.getLinkedFacilityId());
				tiOstBeneficiary.setLinkedFacility(linkedFacility);
			} else {
				tiOstBeneficiary.setLinkedFacility(null);
			}

			tiOstBeneficiaryRepository.save(tiOstBeneficiary);
		}
	}

	public void delete(Long id, Long unlinkReasonId) {
		log.debug("Request to unlink TIOstBeneficiary : {}", id);
		Optional<TiOstBeneficiary> tiBen = tiOstBeneficiaryRepository.findById(id);
		if (tiBen.isPresent()) {
			TiOstBeneficiary tIOstBeneficiary = tiBen.get();
			MasterBeneficiaryDeleteReason masterBeneficiaryDeleteReason = new MasterBeneficiaryDeleteReason();
			masterBeneficiaryDeleteReason.setId(unlinkReasonId);
			tIOstBeneficiary.setSatelliteUnlinkReason(masterBeneficiaryDeleteReason);
			tIOstBeneficiary.setLinkedFacility(null);
			tiOstBeneficiaryRepository.save(tIOstBeneficiary);

		}

	}

}
