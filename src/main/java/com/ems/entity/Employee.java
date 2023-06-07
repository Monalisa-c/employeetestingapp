package com.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {	
private long empId;
private String empName;
private double empSal; //month take home

//entity reference
Address address;  //"HAS- A relationship/association"
}
