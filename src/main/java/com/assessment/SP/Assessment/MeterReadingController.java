package com.assessment.SP.Assessment;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(path="/api/smart/")
@RestController
@Component
public class MeterReadingController {
	
	private final MeterReadingRepository repository;
	
	MeterReadingController(MeterReadingRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/reads/{accountNumber}")
	String getCustomerMeterReadingsById(@PathVariable Long accountNumber){
		
		List<MeterReading> gasMeterReadings =  repository.getMeterReadingsByCustomerIdAndFuel(MeterReadingType.GAS, accountNumber);
		List<MeterReading> electricMeterReadings =  repository.getMeterReadingsByCustomerIdAndFuel(MeterReadingType.ELECTRIC, accountNumber);
		
		JSONArray gasMeterReadingArray = new JSONArray(gasMeterReadings.toArray());
		JSONArray electricMeterReadingArray = new JSONArray(electricMeterReadings.toArray());
		
		JSONObject meterReadingsJson = new JSONObject();
		
		meterReadingsJson.put("accountId", accountNumber);
		meterReadingsJson.put("gasReadings", gasMeterReadingArray);
		meterReadingsJson.put("elecReadings", electricMeterReadingArray);

		return meterReadingsJson.toString();
	}

}
