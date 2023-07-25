/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.DataModelLocal;
import entity.Amenitiestb;
import entity.Citytb;
import entity.Featurestb;
import entity.Propertytb;
import entity.Propertytypetb;
import entity.Statetb;
import entity.Usertb;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vishal
 */
@Path("generic")
public class GenericResource {
    @EJB DataModelLocal ejb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @Path("getAllStates")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Statetb> getAllStates()
    {
        return ejb.getAllStates();
    }
    @Path("getAllCity")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Citytb> getAllCity()
    {
        return ejb.getAllCity();
    }
    @Path("getAllAmenities")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Amenitiestb> getAllAmenities()
    {
        return ejb.getAllAmenities();
    }
    @Path("getAllPropertytype")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Propertytypetb> getAllPropertytype()
    {
        return ejb.getAllPropertytype();
    }
    @Path("getAllSeller")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usertb> getAllSeller()
    {
        return ejb.getAllSeller();
    }
    @Path("getAllUsertbs")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Usertb> getAllUsertbs()
    {
        return ejb.getAllUsertbs();
    }
    @Path("getAllFeatures")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Featurestb> getAllFeatures()
    {
        return ejb.getAllFeatures();
    }
    ////////Amenitites
    @Path("addAmenities/{amenitiesname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addAmenities(@PathParam("amenitiesname") String amenitiesname)
    {
        return ejb.addAmenities(amenitiesname);
    }
    @Path("updateAmenities/{amenitiesid}/{amenitiesname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updateAmenities(@PathParam("amenitiesid") Integer amenitiesid,@PathParam("amenitiesname") String amenitiesname)
    {
        return ejb.updateAmenities(amenitiesid, amenitiesname);
    }
    @Path("deleteAmenities/{amenitiesid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteAmenities(@PathParam("amenitiesid") Integer amenitiesid)
    {
        return ejb.removeAmenities(amenitiesid);
    }
    ////City
    @Path("addcity/{stateid}/{cityname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addcity(@PathParam("stateid") Integer stateid,@PathParam("cityname") String cityname)
    {
        return ejb.addCity(stateid,cityname);
    }
    @Path("updatecity/{stateid}/{cityid}/{cityname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updatecity(@PathParam("stateid") Integer stateid,@PathParam("cityid") Integer cityid,@PathParam("cityname") String cityname)
    {
        return ejb.updateCity(stateid,cityid,cityname);
    }
    @Path("deletecity/{cityid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deletecity(@PathParam("cityid") Integer cityid)
    {
        return ejb.removeCity(cityid);
    }
    ////Property
    @Path("addPropertytype/{propertyname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addPropertytype(@PathParam("propertyname") String propertyname)
    {
        return ejb.addPropertytype(propertyname);
    }
    @Path("updatePropertytype/{propertytypeid}/{propertyname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updatePropertytype(@PathParam("propertytypeid") Integer propertytypeid,@PathParam("propertyname") String propertyname)
    {
        return ejb.updatePropertytype(propertytypeid, propertyname);
    }
    @Path("deletePropertytype/{propertytypeid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePropertytype(@PathParam("propertytypeid") Integer propertytypeid)
    {
        return ejb.removePropertytype(propertytypeid);
    }
    ////User
    @Path("addUser/{username}/{email}/{password}/{mobileno}/{isseller}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addUser(@PathParam("username") String username,@PathParam("email") String email,@PathParam("password") String password,@PathParam("mobileno") String mobileno,@PathParam("isseller") Integer isseller)
    {
        return ejb.addUser(username,email,password,mobileno,isseller);
    }
    @Path("updateUser/{userid}/{username}/{email}/{mobileno}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(@PathParam("userid") Integer userid,@PathParam("username") String username,@PathParam("email") String email,@PathParam("mobileno") String mobileno)
    {
        return ejb.updateUser(userid, username, email, mobileno);
    }
    @Path("deleteuser/{userid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteuser(@PathParam("userid") Integer userid)
    {
        return ejb.removeUser(userid);
    }
    ////Features
    @Path("addfeatures/{propertytypeid}/{featurename}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addfeatures(@PathParam("propertytypeid") Integer propertytypeid,@PathParam("featurename") String featurename)
    {
        return ejb.addFeatures(propertytypeid, featurename);
    }
    @Path("updatefeatures/{propertytypeid}/{featureid}/{featurename}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updatefeatures(@PathParam("propertytypeid") Integer propertytypeid,@PathParam("featureid") Integer featureid,@PathParam("featurename") String featurename)
    {
        return ejb.updateFeatures(propertytypeid, featureid, featurename);
    }
    @Path("deletefeatures/{featureid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deletefeatures(@PathParam("featureid") Integer featureid)
    {
        return ejb.removeFeatures(featureid);
    }
}
