package com.opencanarias.objects;

public class O_LDAP {

		//private int carLisence2;
		private String carLicense;
		private String businessCategory;
		private String cn;
		private String ou;
		//private String dni_nie;
		//private String cargo;
		//private String mail;
		//private int es_firmante;
		//private int es_validador;
		
		
		
		//public int getIdFirmante() {return carLisence2;	}
		public String getCarLicense() {return carLicense;	}
		public String getBusinessCategory() {return businessCategory;	}
		public String getCN() {return cn;	}
		public String getOU() {return ou;	}
		/*public String getDNI_NIE() {return dni_nie; }
		public String getCargo() {return cargo; }
		public String getMail(){return mail; }
		public int getEsFirmante(){return es_firmante;}
		public String getEsFirmanteCheckBox(){
			String data;
				if (es_firmante==0){
					data ="";
				}else{
					data="checked";
				}
			return data;
			}
		public int getEsValidador(){return es_validador;}
		public String getEsValidadorCheckBox(){
			String data;
			if (es_validador==0){
				data="";
			}else{
				data="checked";
			}
			return data;
		}
		*/
		//public void setIdFirmante(int dato) {this.carLisence2 = dato;}
		public void setCarLicense(String dato) {this.carLicense = dato; }
		public void setBusinessCategory(String dato) {this.businessCategory = dato;}
		public void setCN(String dato) {this.cn = dato;}
		public void setOU(String dato) {this.ou = dato;}
		//public void setDNI_NIE(String dato) {this.dni_nie = dato; }
		//public void setCargo(String dato) { this.cargo = dato; }
		//public void setMail(String dato){this.mail = dato; }
		//public void setEsFirmante(int dato){this.es_firmante = dato;}
		//public void setEsValidador(int dato){this.es_validador = dato;}

		public void setParametros (String datocarLicense, String datobusinessCategory, String datocn){
			//this.carLisence2=datoID;
			this.carLicense=datocarLicense;
			this.businessCategory=datobusinessCategory;
			this.cn=datocn;
			//this.dni_nie=datoDNI_NIE;
			//this.cargo=datoCargo;
			//this.mail=datoMail;
			//this.es_firmante=datoESFirmante;
			//this.es_validador=datoESValidador;
		}
}
