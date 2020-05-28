/**
 * 
 */
package com.database.model;

import java.io.Serializable;

import org.hibernate.Session;

/**
 * @author Admin-AE
 *
 */
public class TiposVinoDAO extends GenericDAOImplementation<TiposVino, Serializable> {

	public TiposVinoDAO(Session session) {
		super(session);
	}

}
