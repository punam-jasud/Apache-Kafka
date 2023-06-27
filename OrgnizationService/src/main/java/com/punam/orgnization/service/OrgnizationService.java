package com.punam.orgnization.service;

import com.punam.orgnization.model.OrgnizationDto;

public interface OrgnizationService {

	OrgnizationDto saveOrgnization(OrgnizationDto orgnizationDto);

	OrgnizationDto getOrgnization(String code);

}
