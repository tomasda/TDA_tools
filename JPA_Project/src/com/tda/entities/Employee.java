package com.tda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.tda.controllers.ProjectConstants;



@Entity
@Table(name="EMPLOYEE")
@NamedQueries({
	@NamedQuery(name = ProjectConstants.EMPLOYEE, query = "SELECT a FROM Employee a "),
})
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="ID_")
	private Long id;
	@Column(name="NAME_")
	private String name;

	public Employee() {};
	public Employee(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
