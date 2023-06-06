package com.adt.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class Contact implements Serializable {
	
	private static final long serialVersioUID =1L;
	
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private long contactNo;
	private Date createdDate;
	private Date updatedDate;
	
}
