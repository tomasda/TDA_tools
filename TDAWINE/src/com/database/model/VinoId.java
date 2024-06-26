package com.database.model;
// Generated 20-dic-2017 9:37:08 by Hibernate Tools 5.2.5.Final

/**
 * VinoId generated by hbm2java
 */
public class VinoId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int idVino;
	private int tiposVinoIdTiposVino;

	public VinoId() {
	}

	public VinoId(int idVino, int tiposVinoIdTiposVino) {
		this.idVino = idVino;
		this.tiposVinoIdTiposVino = tiposVinoIdTiposVino;
	}

	public int getIdVino() {
		return this.idVino;
	}

	public void setIdVino(int idVino) {
		this.idVino = idVino;
	}

	public int getTiposVinoIdTiposVino() {
		return this.tiposVinoIdTiposVino;
	}

	public void setTiposVinoIdTiposVino(int tiposVinoIdTiposVino) {
		this.tiposVinoIdTiposVino = tiposVinoIdTiposVino;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VinoId))
			return false;
		VinoId castOther = (VinoId) other;

		return (this.getIdVino() == castOther.getIdVino())
				&& (this.getTiposVinoIdTiposVino() == castOther.getTiposVinoIdTiposVino());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdVino();
		result = 37 * result + this.getTiposVinoIdTiposVino();
		return result;
	}

}
