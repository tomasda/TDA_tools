package com.tda.controllers;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;

import com.tda.entities.Employee;
import com.tda.entities.EntityManagerUtils;
import java.io.Serializable;

@Named
@SessionScoped
public class Core implements Serializable {
	private static final long serialVersionUID = 1L;
	private double version;
	private List<Employee> empleados;
	private EntityManager em;
	
	
	@SuppressWarnings("unchecked")
	public Core() {
		setVersion(1.001);
		em = EntityManagerUtils.getEntityManager();
		em.getTransaction().begin();
		empleados=em.createNamedQuery(ProjectConstants.EMPLOYEE).getResultList();
		em.getTransaction().commit();
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
