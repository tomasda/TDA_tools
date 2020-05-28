package com.opencanarias.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
 
public class ADAuthenticator 
{
  private String domain;
  //private String searchBase;
  protected static String ACESS_USER;
  protected static String ACESS_PASS;
  protected static String NUM_IDENTIFICATION_FIELD;
  protected static String LDAP_URL;
  protected static String BASE;	
  protected static String UO;

  
   
  public ADAuthenticator() {  //DC=APTF,DC=LOCAL CN=admin-ae3,cn=users,DC=APTF,DC=LOCAL 389
    domain = "APTF"; //"YOUR DOMAIN"; 
	//  searchBase = "cn=users,DC=APTF,DC=LOCAL"; 
	ACESS_USER = ConfigUtils.getParametro("security.authentication.username");
	ACESS_PASS = ConfigUtils.getParametro("security.authentication.password");
	NUM_IDENTIFICATION_FIELD = ConfigUtils.getParametro("security.authentication.numIdentificationField");
	LDAP_URL = ConfigUtils.getParametro("security.authentication.ldapURL"); //"ldap://YOUR SERVER";
	BASE = ConfigUtils.getParametro("security.authentication.base");//"OU=Users,OU=XXXXXX,DC=XXXX,DC=XXXXXX,DC=XXXX"; // YOUR SEARCH BASE IN LDAP
	UO = ConfigUtils.getParametro("security.authentication.ou");
  }
 

  
  	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Map<String, Object>> authenticate(String consulta) {      //Map<String, Object> authenticate(String user, String pass, String consulta) {
        consulta = "("+NUM_IDENTIFICATION_FIELD+"="+consulta+")";
  		String returnedAtts[] ={ "cn", "sn", "givenName", "name", "userPrincipalName", "displayName", "memberOf", "carLicense", "businessCategory","ou"};//"cn", "sn", "givenName", "name", "userPrincipalName", "displayName", "memberOf" };
        //String searchFilter = "(&(objectClass=user)(sAMAccountName=" + user + "))"; // + user + "))";
        String searchFilter = "(&(objectClass=person)("+consulta+"))";// EL LDAP DESARROLLO NO TIENE EL OBJECTCLASS USER, POR ESO LO CAMBIE A PERSON"(&(objectClass=user)("+consulta+"))"; // + user + "))";
        
        // Create the search controls
        SearchControls searchCtls = new SearchControls();
        searchCtls.setReturningAttributes(returnedAtts);
         
        // Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        
        // Defino las variables de acceso y consulta según el entorno.
        StringBuilder dn = new StringBuilder();
        if (ConfigUtils.getEntorno().endsWith("des")){
        	dn.append("cn="+ACESS_USER+","+BASE);
		}else{
        	dn.append(ACESS_USER + "@" + domain);
        }
        String DN = dn.toString();
        
        StringBuilder baseSearch = new StringBuilder();
        if (UO!=null && !UO.equals("")){
        	baseSearch.append(UO+",");
        }
    	baseSearch.append(BASE);
        String BASE_SEARCH = baseSearch.toString();
        
     // Set up environment for creating initial context
    	Hashtable env = new Hashtable(11);
    	env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    	env.put(Context.PROVIDER_URL, LDAP_URL);

    	// Authenticate as S. User and password "mysecret"
    	env.put(Context.SECURITY_AUTHENTICATION, "simple");
    	env.put(Context.SECURITY_PRINCIPAL, DN);
    	env.put(Context.SECURITY_CREDENTIALS, ACESS_PASS);

    	LdapContext ctxGC = null;
     
        try {
             
            // This is the actual Authentication piece. Will throw javax.naming.AuthenticationException
            // if the users password is not correct. Other exceptions may include IO (server not found) etc.
            ctxGC = new InitialLdapContext(env, null);
             
            // Now try a simple search and get some attributes as defined in returnedAtts
            NamingEnumeration<SearchResult> answer = ctxGC.search(BASE_SEARCH,searchFilter, searchCtls);
            
            // crea una lista de resultados
            List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
            //mapList.add(new TreeMap<String, Object>());
            while (answer.hasMoreElements()) {
                SearchResult sr = (SearchResult) answer.next();
                Attributes attrs = sr.getAttributes();
                Map<String, Object> amap = null;
                if (attrs != null) {
                    amap = new HashMap<String,Object>();
                    NamingEnumeration<?> ne = attrs.getAll();
                    while (ne.hasMore()) {
                        Attribute attr = (Attribute) ne.next();
                        if (attr.size() == 1) {
                            amap.put(attr.getID(), attr.get());
                        } else {
                            HashSet<String> s = new HashSet<String>();
                            NamingEnumeration n =  attr.getAll();
                            while (n.hasMoreElements()) {
                                s.add((String)n.nextElement());
                            }
                            amap.put(attr.getID(), s);
                        }
                    }
                    ne.close();
                }
                ctxGC.close();  // Close and clean up
                //return amap;
                mapList.add(amap);
            }
            return mapList;
        } catch (NamingException nex) {
            nex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
         
        return null;
    }

     
}
