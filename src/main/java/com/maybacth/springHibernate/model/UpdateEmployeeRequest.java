package com.maybacth.springHibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {
	  private Long id;
	    private String name;
	    private String email;
	    private String designation;
}
