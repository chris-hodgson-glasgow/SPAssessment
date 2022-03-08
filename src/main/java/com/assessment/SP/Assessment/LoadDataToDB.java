package com.assessment.SP.Assessment;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDataToDB {
	
	public static final Logger logger = LoggerFactory.getLogger(LoadDataToDB.class);
	
	@Bean
	CommandLineRunner initialiseDBData(MeterReadingRepository repository) {
		return args -> {
			logger.info("Loading DB record for " + repository.save(new MeterReading(
					111111L,
					MeterReadingType.ELECTRIC,
					123456L,
					000123L,
					new Date()
					)));
			
			logger.info("Loading DB record for " + repository.save(new MeterReading(
					111111L,
					MeterReadingType.GAS,
					654321L,
					000456L,
					new Date()
					)));
			
			logger.info("Loading DB record for " + repository.save(new MeterReading(
					222222L,
					MeterReadingType.ELECTRIC,
					111111L,
					222123L,
					new Date()
					)));
			
			logger.info("Loading DB record for " + repository.save(new MeterReading(
					222222L,
					MeterReadingType.GAS,
					987654L,
					111111L,
					new Date()
					)));
		};
	}

}
