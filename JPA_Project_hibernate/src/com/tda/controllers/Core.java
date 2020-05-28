package com.tda.controllers;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.tda.dao.EmployeeDao;
import com.tda.entities.Employee;
import java.io.Serializable;

@Named
@SessionScoped
public class Core implements Serializable {
	private static final long serialVersionUID = 1L;
	private double version;
	private List<Employee> empleados;
	private EmployeeDao eDao = new EmployeeDao();
//	private EntityManager em;
	
	
	public Core() {
		setVersion(1.001);
//		em = EntityManagerUtils.getEntityManager();
//		em.getTransaction().begin();
//		empleados=em.createNamedQuery(ProjectConstants.EMPLOYEE).getResultList();
//		em.getTransaction().commit();
		empleados =  eDao.getAllCustomers();
	}
	
	
	

	public List<Employee> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Employee> empleados) {
		this.empleados = empleados;
	}

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

}
