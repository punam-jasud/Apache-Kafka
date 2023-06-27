package com.punam.orgnization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.punam.orgnization.entity.Orgnization;
import com.punam.orgnization.mapper.OrgnizationMapper;
import com.punam.orgnization.model.OrgnizationDto;
import com.punam.orgnization.repository.OrgnizationRepository;

@Service
public class OrgnizationServiceImpl implements OrgnizationService {
	
	@Autowired
	private OrgnizationRepository repository;

	@Override
	public OrgnizationDto saveOrgnization(OrgnizationDto orgnizationDto) {
		
		Orgnization orgnization = OrgnizationMapper.mapToOrgnization(orgnizationDto);
		Orgnization savedOrgnization = repository.save(orgnization);
		OrgnizationDto orgDto = OrgnizationMapper.mapToOrgnizationDto(savedOrgnization);
		
		return orgDto;
	}

	@Override
	public OrgnizationDto getOrgnization(String code) {
		Orgnization orgnization = repository.findByCode(code);
		OrgnizationDto dto = OrgnizationMapper.mapToOrgnizationDto(orgnization);
		return dto;
	}

}
