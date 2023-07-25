/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.JerseyClient;
import ejb.DataModelLocal;
import entity.Amenitiestb;
import entity.Citytb;
import entity.Featurestb;
import entity.Propertytypetb;
import entity.Sellertb;
import entity.Statetb;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vishal
 */
@Named(value = "adminBean")
@ApplicationScoped
public class AdminBean {
    @EJB DataModelLocal ejb;
    
    
    Response rs;
    JerseyClient jc;
    
    Integer stateid,cityid,amenitiesid,propertytypeid,featureid,isactive;
    String state,city,amenities,propertyname,feature;
    
    
    
    
    String clickdata;
    Collection<Statetb> getstate;
    GenericType<Collection<Statetb>> gstate;
    Collection<Citytb> getcity;
    GenericType<Collection<Citytb>> gcity;
    Collection<Amenitiestb> getAmenities;
    GenericType<Collection<Amenitiestb>> gcAmenities;
    Collection<Propertytypetb> getPropertytype;
    GenericType<Collection<Propertytypetb>> gcPropertytype;
    Collection<Featurestb> getfeaturestb;
    GenericType<Collection<Featurestb>> gcfeaturestb;
    Collection<Sellertb> getSellertbs;
    Statetb statetb=new Statetb();
    Citytb citytb=new Citytb();
    Amenitiestb amenitiestb=new Amenitiestb();
    Propertytypetb propertytypetb=new Propertytypetb();
    Featurestb featurestb=new Featurestb();
    
    /**
     * Creates a new instance of AdminBean
     */
    @PostConstruct
    public void init()
    {
        jc=new JerseyClient();
        stateid=0;
        cityid=0;
        amenitiesid=0;
        propertytypeid=0;
        featureid=0;
    }
    
    public AdminBean() {
    }

    public Collection<Sellertb> getGetSellertbs() {
        return getSellertbs;
    }

    public void setGetSellertbs(Collection<Sellertb> getSellertbs) {
        this.getSellertbs = getSellertbs;
    }
    
    public String printstatus(int i)
    {
        if(i==0)
        {
            return "Active";
        }
        else
        {
            return "InActive";
        }
    }
    public Integer getSellerCount()
    {
        return ejb.getCountSeller();
    }
    public Integer getUserCount()
    {
        return ejb.getCountUser();
    }
    public Integer getPropertyCount()
    {
        return ejb.getPropertyCount();
    }
    public String getClickdata() {
        return clickdata;
    }

    public void setClickdata(String clickdata) {
        this.clickdata = clickdata;
    }

    public Integer getCityid() {
        return cityid;
    }

    public Integer getPropertytypeid() {
        return propertytypeid;
    }

    public void setPropertytypeid(Integer propertytypeid) {
        this.propertytypeid = propertytypeid;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
    }

    public Collection<Propertytypetb> getGetPropertytype() {
        return getPropertytype;
    }

    public void setGetPropertytype(Collection<Propertytypetb> getPropertytype) {
        this.getPropertytype = getPropertytype;
    }

    

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getAmenitiesid() {
        return amenitiesid;
    }

    public void setAmenitiesid(Integer amenitiesid) {
        this.amenitiesid = amenitiesid;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public Collection<Amenitiestb> getGetAmenities() {
        return getAmenities;
    }

    public void setGetAmenities(Collection<Amenitiestb> getAmenities) {
        this.getAmenities = getAmenities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
    }

   

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Collection<Statetb> getGetstate() {
        return getstate;
    }

    public void setGetstate(Collection<Statetb> getstate) {
        this.getstate = getstate;
    }

    public Collection<Citytb> getGetcity() {
        return getcity;
    }

    public void setGetcity(Collection<Citytb> getcity) {
        this.getcity = getcity;
    }

    public Integer getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Integer featureid) {
        this.featureid = featureid;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Collection<Featurestb> getGetfeaturestb() {
        return getfeaturestb;
    }

    public void setGetfeaturestb(Collection<Featurestb> getfeaturestb) {
        this.getfeaturestb = getfeaturestb;
    }
    
   public Collection<Statetb> showstate()
   {
        gstate=new GenericType<Collection<Statetb>>(){};
        rs=jc.getAllStates(Response.class);
        getstate=rs.readEntity(gstate);
       
       return getstate;
   }
   public String addstate()
   {
      
       try {
           clearAll();
           
           System.out.println("Addstate:="+jc.addstate(state));
           state="";
           return "state.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String searchstate(Integer sid)
   {
       try {
           statetb=ejb.searchState(sid);
           stateid=statetb.getStateId();
           state=statetb.getState();
           return "addstate.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updatestate()
   {
      
       try {
           
           System.out.println("Updatestate:="+jc.updatestate(String.valueOf(stateid), state));
           clearAll();
           return "state.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deletestate(Integer id){
        try{
            jc.deletestate(String.valueOf(id));
            return "state.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
   public String addcity()
   {
      
       try {
          
           System.out.println("Addcity:="+city+"/"+stateid);
           
           System.out.println("Addcity:="+jc.addcity(String.valueOf(stateid), city));
           clearAll();
           return "city.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String searchcity(Integer cid)
   {
       try {
           citytb=ejb.searchCity(cid);
           cityid=citytb.getCityId();
           city=citytb.getCity();
           stateid=citytb.getStateId().getStateId();
           return "addcity.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updatecity()
   {
      
       try {
            System.out.println("Updatecity:="+jc.updatecity(String.valueOf(stateid),String.valueOf(cityid), city));
           clearAll();
           
           return "city.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deletecity(Integer id){
        try{
            jc.deletecity(String.valueOf(id));
            return "city.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
   public Collection<Citytb> showcity()
   {
      gcity=new GenericType<Collection<Citytb>>(){};
        rs=jc.getAllCity(Response.class);
        getcity=rs.readEntity(gcity);
       
       return getcity;
   }
   
   public String addAmenities()
   {
      
       try {
           
           System.out.println("AddAmenities:="+jc.addAmenities(amenities));
           clearAll();
           return "amenities.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String searchAmenities(Integer aid)
   {
       try {
           amenitiestb=ejb.searchAmenities(aid);
           amenitiesid=amenitiestb.getAmenitiesId();
           amenities=amenitiestb.getAmenities();
           return "addamenities.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updateAmenities()
   {      
       try {
            System.out.println("UpdateAmenities:="+jc.updateAmenities(String.valueOf(amenitiesid),amenities));
           clearAll();
           
           return "amenities.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deleteAmenities(Integer id){
        try{
            jc.deleteAmenities(String.valueOf(id));
            return "amenities.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
   public Collection<Amenitiestb> showAmenities()
   {
      gcAmenities=new GenericType<Collection<Amenitiestb>>(){};
        rs=jc.getAllAmenities(Response.class);
        getAmenities=rs.readEntity(gcAmenities);
      
       return getAmenities;
   }
   public String addPropertytype()
   {
      
       try {
           
           System.out.println("AddPropertytype:="+jc.addPropertytype(propertyname));
           clearAll();
           return "propertytype.xhtml?faces-redirect=true";
          
          
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String searchPropertytype(Integer pid)
   {
       try {
           propertytypetb=ejb.searchPropertytype(pid);
           propertytypeid=propertytypetb.getPropertytypeId();
           propertyname=propertytypetb.getPropertyName();
           return "addpropertytype.xhtml?faces-redirect=true";
       } catch (Exception e) {
           return e.getMessage();
       }
   }
   public String updatePropertytype()
   {
      
       try {
            System.out.println("UpdatePropertytype:="+jc.updatePropertytype(String.valueOf(propertytypeid),propertyname));
           clearAll();
           
           return "propertytype.xhtml?faces-redirect=true";
       } 
       catch (Exception e) {
           return e.getMessage();
          
       }
   }
   public String deletePropertytype(Integer id){
        try{
            jc.deletePropertytype(String.valueOf(id));
            return "propertytype.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
   public Collection<Propertytypetb> showPropertytype()
   {
        gcPropertytype=new GenericType<Collection<Propertytypetb>>(){};
        rs=jc.getAllPropertytype(Response.class);
        getPropertytype=rs.readEntity(gcPropertytype);
       
       return getPropertytype;
   }
   public String addfeature()
    {

        try {

            System.out.println("Addfeature:="+feature+"/"+propertytypeid);

            System.out.println("Addfeature:="+jc.addfeatures(String.valueOf(propertytypeid), feature));
            clearAll();
            return "features.xhtml?faces-redirect=true";


        } 
        catch (Exception e) {
            return e.getMessage();

        }
    }
    public String searchfeatures(Integer fid)
    {
        try {
            featurestb=ejb.searchFeatures(fid);
            featureid=featurestb.getFeatureId();
            feature=featurestb.getFeature();
            propertytypeid=featurestb.getPropertyTypeId().getPropertytypeId();
            return "addfeatures.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public String updatefeatures()
    {
        try {
             System.out.println("UpdateFeature:="+jc.updatefeatures(String.valueOf(propertytypeid),String.valueOf(featureid),feature));
            clearAll();

            return "features.xhtml?faces-redirect=true";
        } 
        catch (Exception e) {
            return e.getMessage();

        }
    }
     public String deletefeatures(Integer id){
        try{
            jc.deletefeatures(String.valueOf(id));
            return "features.xhtml?faces-redirect=true";
        }catch(Exception e){
            return e.getMessage();
        }
    }
    public Collection<Featurestb> showfeatures()
    {
//        gcfeaturestb=new GenericType<Collection<Featurestb>>(){};
//        rs=jc.getAllFeatures(Response.class);
//        getfeaturestb=rs.readEntity(gcfeaturestb);
        getfeaturestb=ejb.getAllFeatures();
        return getfeaturestb;
    }
   
   public Collection<Sellertb> showSellertbs() {
        
        getSellertbs = ejb.getAllSellertbs();
        
        return getSellertbs;
    }
    public String deleteproperty(Integer pid) {

        ejb.removeProperty(pid);

        return "propertylisting.xhtml?faces-redirect=true";
    }
//   public String shownav()
//   {
//   
//        //return this.clickdata="./admin/components/layout.xhtml";
//        return this.clickdata="city.xhtml";
//   }
//   public String showdasboard()
//   {
//   
//        //return this.clickdata="./admin/components/layout.xhtml";
//        return this.clickdata="./admin/components/layout.xhtml";
//   }
   public void clearAll()
   {
       stateid=0;
       cityid=0;
       amenitiesid=0;
       propertytypeid=0;
       featureid=0;
       city="";
       state="";
       amenities="";
       propertyname="";
       feature="";
   }
   
   
}
