/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        JerseyClient client = new JerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Vishal
 */
public class JerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RentManagement/webresources";

    public JerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public <T> T getAllStates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllStates");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getAllCity(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCity");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getAllAmenities(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAmenities");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getAllPropertytype(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPropertytype");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getAllSeller(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllSeller");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getAllUsertbs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllUsertbs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    public <T> T getAllFeatures(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllFeatures");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    
    public String addstate(String statename) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addstate/{0}", new Object[]{statename})).request().post(null, String.class);
    }
     public String updatestate(String stateid,String statename) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatestate/{0}/{1}", new Object[]{stateid, statename})).request().post(null, String.class);
    }
     public String deletestate(String stateid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletestate/{0}", new Object[]{stateid})).request().post(null, String.class);
    }
     
    public String addcity(String stateid,String cityname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addcity/{0}/{1}", new Object[]{stateid,cityname})).request().post(null, String.class);
    }
     public String updatecity(String stateid,String cityid,String cityname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatecity/{0}/{1}/{2}", new Object[]{stateid,cityid,cityname})).request().post(null, String.class);
    }
     public String deletecity(String cityid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletecity/{0}", new Object[]{cityid})).request().post(null, String.class);
    } 
     
    public String addAmenities(String amenitiesname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addAmenities/{0}", new Object[]{amenitiesname})).request().post(null, String.class);
    }
     public String updateAmenities(String amenitiesid,String amenitiesname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateAmenities/{0}/{1}", new Object[]{amenitiesid, amenitiesname})).request().post(null, String.class);
    }
     public String deleteAmenities(String amenitiesid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteAmenities/{0}", new Object[]{amenitiesid})).request().post(null, String.class);
    } 
    
    public String addPropertytype(String propertyname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addPropertytype/{0}", new Object[]{propertyname})).request().post(null, String.class);
    }
     public String updatePropertytype(String propertytypeid,String propertyname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatePropertytype/{0}/{1}", new Object[]{propertytypeid, propertyname})).request().post(null, String.class);
    }
     public String deletePropertytype(String propertytypeid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletePropertytype/{0}", new Object[]{propertytypeid})).request().post(null, String.class);
    } 
     
    public String addUser(String username,String email,String password,String mobileno,Integer issseller) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}/{4}", new Object[]{username,email,password,mobileno,issseller})).request().post(null, String.class);
    }
    public String updateUser(String userid,String username,String email,String mobileno) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}", new Object[]{userid,username,email,mobileno})).request().post(null, String.class);
    }
    public String deleteuser(String userid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deleteuser/{0}", new Object[]{userid})).request().post(null, String.class);
    } 
    
    
    public String addfeatures(String propertytypeid,String featurename) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addfeatures/{0}/{1}", new Object[]{propertytypeid,featurename})).request().post(null, String.class);
    }
     public String updatefeatures(String propertytypeid,String featureid,String featurename) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatefeatures/{0}/{1}/{2}", new Object[]{propertytypeid,featureid,featurename})).request().post(null, String.class);
    }
     public String deletefeatures(String featureid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletefeatures/{0}", new Object[]{featureid})).request().post(null, String.class);
    } 
    
    
     public void close() {
        client.close();
    }
    
}
