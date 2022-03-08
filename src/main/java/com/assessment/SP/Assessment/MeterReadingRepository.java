package com.assessment.SP.Assessment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
	
	@Query("select m from MeterReading m where m.meterReadingType= ?1 and m.customerId= ?2")
	List<MeterReading> getMeterReadingsByCustomerIdAndFuel(MeterReadingType meterreadingType, Long customerId);


}
