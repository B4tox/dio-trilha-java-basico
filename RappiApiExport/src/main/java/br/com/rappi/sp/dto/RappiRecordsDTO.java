package br.com.rappi.sp.dto;

import java.io.Serializable;
import java.util.List;

public class RappiRecordsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<RappiDTO> records;

	public List<RappiDTO> getRecords() {
		return records;
	}

	public void setRecords(List<RappiDTO> records) {
		this.records = records;
	}
	
}
