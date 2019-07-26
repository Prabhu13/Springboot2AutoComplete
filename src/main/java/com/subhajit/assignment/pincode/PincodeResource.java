package com.subhajit.assignment.pincode;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Subhajit
 * @since Jul-2019
 * @see com.subhajit.assignment.pincode#suggestCities
 *
 */

@RestController
@Validated
@RequestMapping(path = "/suggest_cities")
public class PincodeResource {

	private final static Logger LOGGER = LoggerFactory.getLogger(PincodeResource.class);

	@Autowired
	private PincodeService pincodeService;

	@RequestMapping(method = RequestMethod.GET, produces = "text/plain")
	public String suggestCities(final @RequestParam @NotBlank String start,
			final @RequestParam @Min(1) @Max(5) int atmost) {
		LOGGER.info("Request for suggestion for start: {} and atmost: {}", start, atmost);
		return String.join("\r\n", pincodeService.getSuggestion(start, atmost));
	}
}
