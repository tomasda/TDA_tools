/**
 * 
 */
package com.tda.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@Alternative
@Named("control")
@SessionScoped
/**
 * @author user
 *
 */
public class ControlBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int scrollPosition;

	public ControlBean() {
		scrollPosition = 0;
	}

	public int getScrollPosition() {
		return scrollPosition;
	}

	public void setScrollPosition(int scrollPosition) {
		this.scrollPosition = scrollPosition;
	}

	public void position() {
		
	}
	
}
