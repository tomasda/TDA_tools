package com.tda.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.tda.controllers.ProjectConstants;
import com.tda.entities.Employee;
import com.tda.entities.EntityManagerUtils;

/**
 *
 * @author javaknowledge
 */
public class EmployeeDao {
	private EntityManager em;

    public void addCustomer(Employee cust) {
    	em = EntityManagerUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
    }

    public void deleteCustomer(Employee custid) {
    	em = EntityManagerUtils.getEntityManager();
		em.getTransaction().begin();
		em.remove(custid);
		em.getTransaction().commit();
 
    }

    public void updateCustomer(Employee cust) {
    	
    	em = EntityManagerUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	public List<Employee> getAllCustomers() {
    	List<Employee> users = new ArrayList<>();
    	em = EntityManagerUtils.getEntityManager();
		em.getTransaction().begin();
		users = em.createNamedQuery(ProjectConstants.EMPLOYEE).getResultList();
		em.getTransaction().commit();

        return users;
    }

    @SuppressWarnings("unchecked")
	public List<Employee> getCustomerById(String custid) {
    	List<Employee> users = new ArrayList<>();
    	em = EntityManagerUtils.getEntityManager();
		em.getTransaction().begin();
		users = em.createNamedQuery(ProjectConstants.EMPLOYEELIKENAME).getResultList();
		em.getTransaction().commit();
        System.out.println(custid);
        return users;
    }
}
