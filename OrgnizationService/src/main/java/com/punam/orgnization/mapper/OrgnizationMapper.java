package com.punam.orgnization.mapper;

import com.punam.orgnization.entity.Orgnization;
import com.punam.orgnization.model.OrgnizationDto;

public class OrgnizationMapper {
	
	public static OrgnizationDto mapToOrgnizationDto(Orgnization org) {
		OrgnizationDto dto = new OrgnizationDto();
		dto.setId(org.getId());
		dto.setName(org.getName());
		dto.setDescription(org.getDescription());
		dto.setCode(org.getCode());
		dto.setCreatedDate(org.getCreatedDate());
		
		return dto;
	}
	
	public static Orgnization mapToOrgnization(OrgnizationDto dto) {
		Orgnization org = new Orgnization();
		org.setId(dto.getId());
		org.setName(dto.getName());
		org.setDescription(dto.getDescription());
		org.setCode(dto.getCode());
		org.setCreatedDate(dto.getCreatedDate());
		
		return org;
	}

}
