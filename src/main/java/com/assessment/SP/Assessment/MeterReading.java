package com.assessment.SP.Assessment;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MeterReading {
	
	private @Id @GeneratedValue Long id;
	private Long customerId;
	private MeterReadingType meterReadingType;
	private Long meterId;
	private Long reading;
	private Date readingDate;
	
	public MeterReading() {}
	
	public MeterReading( Long customerId, MeterReadingType meterReadingType, Long meterId, Long reading, Date readingDate) {
		super();
		this.customerId = customerId;
		this.meterReadingType = meterReadingType;
		this.meterId = meterId;
		this.reading = reading;
		this.readingDate = readingDate;
	}
	
	public MeterReadingType getMeterReadingType() {
		return meterReadingType;
	}

	public void setMeterReadingType(MeterReadingType meterReadingType) {
		this.meterReadingType = meterReadingType;
	}

	public Long getMeterId() {
		return meterId;
	}

	public void setMeterId(Long meterId) {
		this.meterId = meterId;
	}

	public Long getReading() {
		return reading;
	}

	public void setReading(Long reading) {
		this.reading = reading;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public Long getId() {
		return id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, id, meterId, meterReadingType, reading, readingDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeterReading other = (MeterReading) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(id, other.id)
				&& Objects.equals(meterId, other.meterId) && meterReadingType == other.meterReadingType
				&& Objects.equals(reading, other.reading) && Objects.equals(readingDate, other.readingDate);
	}
	
	@Override
	public String toString() {
		return "MeterReading [id=" + id + ", customerId=" + customerId + ", meterReadingType=" + meterReadingType
				+ ", meterId=" + meterId + ", reading=" + reading + ", readingDate=" + readingDate + "]";
	}


}
