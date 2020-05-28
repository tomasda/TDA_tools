package com.tda.beans;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
 
@Named("order")
@SessionScoped
public class OrderBean implements Serializable{

	private static final long serialVersionUID = 1L;
	int scroll = 0;

	private static final Order[] orderList = new Order[] {
		
		new Order("A0001", "Intel CPU", 
				new BigDecimal("700.00"), 1,false),
		new Order("A0002", "Harddisk 10TB", 
				new BigDecimal("500.00"), 2,false),
		new Order("A0003", "Dell Laptop", 
				new BigDecimal("11600.00"), 8,false),
		new Order("A0004", "Samsung LCD", 
				new BigDecimal("5200.00"), 3,false),
		new Order("A0005", "A4Tech Mouse", 
				new BigDecimal("100.00"), 10,false)
	};
	 
	public Order[] getOrderList() {
 
		return orderList;
 
	}
	
	public static class Order{
		
		String orderNo;
		String productName;
		BigDecimal price;
		int qty;
		boolean seleccionado;
		

		public Order(String orderNo, String productName, BigDecimal price, int qty, boolean selec) {
			this.orderNo = orderNo;
			this.productName = productName;
			this.price = price;
			this.qty = qty;
			this.seleccionado = selec;
		}
		
		public String getOrderNo() {
			return orderNo;
		}
		public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public BigDecimal getPrice() {
			return price;
		}
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}

		public boolean isSeleccionado() {
			return seleccionado;
		}

		public void setSeleccionado(boolean seleccionado) {
			this.seleccionado = seleccionado;
		}


	}
	public void load() {
		System.out.println("Submit");
	}
	
	public void method(ValueChangeEvent actionEvent) {
		// Get parameter
		String ancla = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("anchor");
		System.out.println(scroll);
	
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml#" + ancla);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getScroll() {
		return scroll;
	}

	public void setScroll(int scroll) {
		this.scroll = scroll;
	}
}