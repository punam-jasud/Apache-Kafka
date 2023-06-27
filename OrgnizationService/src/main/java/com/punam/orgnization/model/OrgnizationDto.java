package com.punam.orgnization.model;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
		description = "Orgnization Service Model"
)

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrgnizationDto {
	
	
	@Schema(
			description = "Orgnization ID"
	)
	private Long id;
	
	@Schema(
			description = "Orgnization Name"
	)
	private String name;
	
	@Schema(
			description = "Orgnization Description"
	)
	private String description;
	
	@Schema(
			description = "Orgnization Code"
	)
	private String code;
	
	@Schema(
			description = "Orgnization Created Date"
	)
	private LocalDateTime createdDate;

}
