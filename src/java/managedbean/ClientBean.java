/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.JerseyClient;
import ejb.DataModelLocal;
import entity.Amenitiestb;
import entity.Featurestb;
import entity.Propertyfeaturestb;
import entity.Propertyimagetb;
import entity.Propertytb;
import entity.Propertytypetb;
import entity.Sellertb;
import entity.Sellertb;
import entity.Usertb;
import entity.Wishlisttb;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vishal
 */
@Named(value = "clientBean")
@ApplicationScoped
public class ClientBean implements Serializable {

    @EJB
    DataModelLocal ejb;
    Part file;
    Response rs;
    JerseyClient jc;

    Integer userid, featureid, propertytypeid, isseller, isactive, amenitiesid,stateid,cityid;
    Boolean check, auth;

    String errormsg = null;
    String username, adminname, amenities;
    String email, password, repassword, mobileno, feature, title;

    //Property
    Integer propertyid;
            String price;
    String propertyname, decription, type, address, plotarea, areaunit, ptype, pimage,companyname,companyurl;
    //search type
    String searchtype;
    Integer searchcity,searchptype;
    //
    Collection<Usertb> getusertb;
    GenericType<Collection<Usertb>> gcusertb;

    Collection<Usertb> getusertbs;
    GenericType<Collection<Usertb>> gcusertbs;

    Collection<Amenitiestb> getAmenities;
    GenericType<Collection<Amenitiestb>> gcAmenities;

    Collection<Featurestb> getfeaturestb;
    GenericType<Collection<Featurestb>> gcfeaturestb;
    Collection<Propertytypetb> getPropertytype;
    GenericType<Collection<Propertytypetb>> gcPropertytype;

    Collection<Wishlisttb> getwishlisttb;
    Collection<Propertyimagetb> getPropertyimagetbs;
    Collection<Propertyfeaturestb> getPropertyfeaturetbs;
    Collection<Propertytb> getPropertytbs;
    Collection<Sellertb> getSellertbs;
    Usertb usertb = new Usertb();
    Featurestb featurestb = new Featurestb();
    Wishlisttb wishlisttb = new Wishlisttb();
    Propertytypetb propertytypetb = new Propertytypetb();
    Sellertb sellertb = new Sellertb();
    Propertytb propertytb = new Propertytb();
    Propertyimagetb propertyimagetb = new Propertyimagetb();
    List<Integer> selectedItems;
    List<SelectItem> selectItems;

    /**
     * Creates a new instance of ClientBean
     */
    @PostConstruct
    public void init() {
        jc = new JerseyClient();
        userid = 0;
        isseller = 0;
        username = null;
        title = "";
        errormsg = null;
        auth = false;
        this.getSellertbs = ejb.getAllSellertbs();
        this.clearAll();
    }

    public ClientBean() {
            
//        selectItems = new ArrayList<SelectItem>();
//        for (Usertb usertb1 : getusertb) {
//            
//        }
//        selectItems.add(new SelectItem("value1", "label1"));
//        selectItems.add(new SelectItem("value2", "label2"));
//        selectItems.add(new SelectItem("value3", "label3"));
    }

    public Integer getSearchptype() {
        return searchptype;
    }

    public void setSearchptype(Integer searchptype) {
        this.searchptype = searchptype;
    }

    public Integer getSearchcity() {
        return searchcity;
    }

    public void setSearchcity(Integer searchcity) {
        this.searchcity = searchcity;
    }

    public String getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(String searchtype) {
        this.searchtype = searchtype;
    }
    
    public Part getFile() {
        return file;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getCompanyurl() {
        return companyurl;
    }

    public void setCompanyurl(String companyurl) {
        this.companyurl = companyurl;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public List<Integer> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<Integer> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public List<SelectItem> getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(List<SelectItem> selectItems) {
        this.selectItems = selectItems;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public Collection<Propertyfeaturestb> getGetPropertyfeaturetbs() {
        return getPropertyfeaturetbs;
    }

    public void setGetPropertyfeaturetbs(Collection<Propertyfeaturestb> getPropertyfeaturetbs) {
        this.getPropertyfeaturetbs = getPropertyfeaturetbs;
    }

    public Collection<Sellertb> getGetSellertbs() {
        return getSellertbs;
    }

    public void setGetSellertbs(Collection<Sellertb> getSellertbs) {
        this.getSellertbs = getSellertbs;
    }

    public Collection<Propertytb> getGetPropertytbs() {
        return getPropertytbs;
    }

    public void setGetPropertytbs(Collection<Propertytb> getPropertytbs) {
        this.getPropertytbs = getPropertytbs;
    }

    public String getDecription() {
        return decription;
    }

    public Collection<Propertyimagetb> getGetPropertyimagetbs() {
        return getPropertyimagetbs;
    }

    public void setGetPropertyimagetbs(Collection<Propertyimagetb> getPropertyimagetbs) {
        this.getPropertyimagetbs = getPropertyimagetbs;
    }

    public Collection<Amenitiestb> getGetAmenities() {
        return getAmenities;
    }

    public void setGetAmenities(Collection<Amenitiestb> getAmenities) {
        this.getAmenities = getAmenities;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAmenitiesid() {
        return amenitiesid;
    }

    public Integer getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPropertyname() {
        return propertyname;
    }

    public void setPropertyname(String propertyname) {
        this.propertyname = propertyname;
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

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPlotarea() {
        return plotarea;
    }

    public void setPlotarea(String plotarea) {
        this.plotarea = plotarea;
    }

    public String getAreaunit() {
        return areaunit;
    }

    public void setAreaunit(String areaunit) {
        this.areaunit = areaunit;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Propertytypetb> getGetPropertytype() {
        return getPropertytype;
    }

    public void setGetPropertytype(Collection<Propertytypetb> getPropertytype) {
        this.getPropertytype = getPropertytype;
    }

    public Integer getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Integer featureid) {
        this.featureid = featureid;
    }

    public Integer getPropertytypeid() {
        return propertytypeid;
    }

    public void setPropertytypeid(Integer propertytypeid) {
        this.propertytypeid = propertytypeid;
    }

    public Integer getIsactive() {
        return isactive;
    }

    public void setIsactive(Integer isactive) {
        this.isactive = isactive;
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

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getIsseller() {
        return isseller;
    }

    public void setIsseller(Integer isseller) {
        this.isseller = isseller;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public Collection<Usertb> getGetusertb() {
        return getusertb;
    }

    public void setGetusertb(Collection<Usertb> getusertb) {
        this.getusertb = getusertb;
    }
//    public void getUserId()
//    {
//        HttpSession session = SessionUtils.getSession();
//        Integer UserId = (Integer) session.getAttribute("UserId");
//        
//    }
    public String adduser() {
        try {

            System.out.println("Adduser:=" + username + "/" + email + "/" + password + "/" + repassword + "/" + mobileno + "/" + check);
            if (check == true) {
                isseller = 1;
            } else {
                isseller = 0;
            }
            Usertb usertb = new Usertb();
            usertb.setUserName(username);
            usertb.setEmail(email);
            usertb.setPassword(password);
            usertb.setMobileNo(mobileno);
            usertb.setIsSeller(isseller);
            jc.addUser(username, email, password, mobileno, isseller);
            clearAll();
            return "login.xhtml?faces-redirect=true";

        } catch (Exception e) {
            return e.getMessage();

        }
    }

    public String deleteuser(Integer id) {
        try {
            System.out.println("Delete user:=" + jc.deleteuser(String.valueOf(id)));
            clearAll();
            return "user.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateuser() {

        try {

            System.out.println("Updateuser:=" + jc.updateUser(String.valueOf(userid), username, email, mobileno));
            clearAll();
            return "myprofile.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    public String searchuser(Integer uid) {
        try {
            usertb = ejb.searchUser(uid);
            userid = usertb.getUserId();
            username = usertb.getUserName();
            email = usertb.getEmail();
            mobileno = usertb.getMobileNo();

            if (usertb.getIsSeller() != 0) {
                title = "Seller";
            }
            title = "Customer";
            return "myprofile.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String auth() {
        Integer UserId = LoginDAO.validate(username, password);
        errormsg = null;

        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("admin", username);
            adminname = (String) session.getAttribute("admin");
            return "/admin/index.xhtml?faces-redirect=true";
        } else if (UserId != 0) {
            usertb = ejb.searchUser(UserId);
            System.out.println("isSeller:=" + usertb.getIsSeller());
            if (usertb.getIsSeller() != 0) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", username);
                session.setAttribute("isSeller", usertb.getIsSeller());
                session.setAttribute("UserId", usertb.getUserId());
                this.auth = true;
                this.isseller = usertb.getIsSeller();
                userid = usertb.getUserId();
                email = usertb.getEmail();
                mobileno = usertb.getMobileNo();
                title = "Seller";
                return "index.xhtml?faces-redirect=true";
            } else if (usertb.getIsSeller() == 0) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("username", username);
                session.setAttribute("isSeller", usertb.getIsSeller());
                session.setAttribute("UserId", usertb.getUserId());
                this.auth = true;
                this.isseller = usertb.getIsSeller();
                userid = usertb.getUserId();
                email = usertb.getEmail();
                mobileno = usertb.getMobileNo();
                title = "User";
                return "index.xhtml?faces-redirect=true";
            } else {
                errormsg = "Please enter correct username and Password";
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Incorrect Username and Passowrd",
                                "Please enter correct username and Password"));
                System.out.println("Incorrect password 1");
                clearAll();

                return "login.xhtml?faces-redirect=true";
            }
        } else {
            errormsg = "Please enter correct username and Password";
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            System.out.println("Incorrect password 2");
            clearAll();

            return "login.xhtml?faces-redirect=true";
        }

    }

    public String authenticate() {

        try {
            if (username.equals("admin") && password.equals("admin")) {
                HttpSession session = SessionUtils.getSession();
                session.setAttribute("admin", username);
                adminname = (String) session.getAttribute("admin");
                return "/admin/index.xhtml?faces-redirect=true";
            } else {
                Integer UserId = LoginDAO.validate(username, password);
                usertb = ejb.searchUser(UserId);
                System.out.println("isSeller:=" + usertb.getIsSeller());
                if (usertb.getIsSeller() != 0) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("isSeller", usertb.getIsSeller());
                    session.setAttribute("UserId", usertb.getUserId());
                    this.auth = true;
                    this.isseller = usertb.getIsSeller();
                    userid = usertb.getUserId();
                    email = usertb.getEmail();
                    mobileno = usertb.getMobileNo();
                    title = "Seller";
                    return "index.xhtml?faces-redirect=true";
                } else if (usertb.getIsSeller() == 0) {
                    HttpSession session = SessionUtils.getSession();
                    session.setAttribute("username", username);
                    session.setAttribute("isSeller", usertb.getIsSeller());
                    session.setAttribute("UserId", usertb.getUserId());
                    this.auth = true;
                    this.isseller = usertb.getIsSeller();
                    userid = usertb.getUserId();
                    email = usertb.getEmail();
                    mobileno = usertb.getMobileNo();
                    title = "User";
                    return "index.xhtml?faces-redirect=true";
                } else {

                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Incorrect Username and Passowrd",
                                    "Please enter correct username and Password"));
                    System.out.println("Incorrect password");
                    return "login.xhtml?faces-redirect=true";
                }
            }

        } catch (Exception e) {
            errormsg = "Please enter correct username and Password";
            System.out.println("authenticate:=" + e.getMessage());
            return "login.xhtml?faces-redirect=true";
        }
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        clearAll();
        return "/client/login.xhtml?faces-redirect=true";
    }

    public String getuser() {
        HttpSession session = SessionUtils.getSession();
        String user = (String) session.getAttribute("username");

        return user;
    }

    public Collection<Usertb> showSeller() {
        gcusertb = new GenericType<Collection<Usertb>>() {
        };
        rs = jc.getAllSeller(Response.class);
        getusertb = rs.readEntity(gcusertb);

        return getusertb;
    }

    public Collection<Usertb> showUsertbs() {
        gcusertbs = new GenericType<Collection<Usertb>>() {
        };
        rs = jc.getAllUsertbs(Response.class);
        getusertbs = rs.readEntity(gcusertbs);

        return getusertbs;
    }

    public Collection<Propertytypetb> showPropertytype() {
        
        gcPropertytype = new GenericType<Collection<Propertytypetb>>() {
        };
        rs = jc.getAllPropertytype(Response.class);
        getPropertytype = rs.readEntity(gcPropertytype);
        
        return getPropertytype;
    }

    public String addfeature() {

        try {

            System.out.println("Addfeature:=" + feature + "/" + propertytypeid);

            System.out.println("Addfeature:=" + jc.addfeatures(String.valueOf(propertytypeid), feature));
            clearAll();
            return "features.xhtml?faces-redirect=true";

        } catch (Exception e) {
            return e.getMessage();

        }
    }

    public String searchfeatures(Integer fid) {
        try {
            featurestb = ejb.searchFeatures(fid);
            featureid = featurestb.getFeatureId();
            feature = featurestb.getFeature();
            propertytypeid = featurestb.getPropertyTypeId().getPropertytypeId();
            return "addfeatures.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updatefeatures() {

        try {
            System.out.println("UpdateFeature:=" + jc.updatefeatures(String.valueOf(propertytypeid), String.valueOf(featureid), feature));
            clearAll();

            return "features.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    public String deletefeatures(Integer id) {
        try {
            jc.deletefeatures(String.valueOf(id));
            return "features.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public Collection<Featurestb> showfeatures() {
//        gcfeaturestb = new GenericType<Collection<Featurestb>>() {
//        };
//        rs = jc.getAllFeatures(Response.class);
//        getfeaturestb = rs.readEntity(gcfeaturestb);
        getfeaturestb=ejb.getAllFeatures();
        return getfeaturestb;
    }

    public Collection<Wishlisttb> showwishdata() {

        getwishlisttb = ejb.searchWishList(ejb.searchUser(userid));

        return getwishlisttb;

    }

    public Collection<Amenitiestb> showAmenities() {
        gcAmenities = new GenericType<Collection<Amenitiestb>>() {
        };
        rs = jc.getAllAmenities(Response.class);
        getAmenities = rs.readEntity(gcAmenities);

        return getAmenities;
    }

    public String addproperty() {
        try {
            HttpSession session = SessionUtils.getSession();
            Integer UserId = (Integer) session.getAttribute("UserId");
            
            System.out.println("addproperty:="+propertyname+"-"+ptype+"-"+propertytypeid+"-"+price+"-"+areaunit+"-"+plotarea+"-"+pimage+"-"+address+"-"+"-"+stateid+"-"+cityid+"-"+decription+"-"+selectedItems);
            InputStream input = file.getInputStream();
            
            if (file.getSubmittedFileName().contains(".jpg") || file.getSubmittedFileName().contains(".jpeg") || file.getSubmittedFileName().contains(".png")) {
                String fullPath = "\\D:\\Rent Management System\\RentManagement\\web\\client\\images\\";

                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                pimage = "IMG_" + temp +".jpg";
                Files.copy(input, new File(fullPath, pimage).toPath());
                
                System.out.println("addproperty:="+ejb.addProperty(UserId,propertyname,ptype,propertytypeid,price,areaunit,plotarea,pimage,address,stateid,cityid,decription,selectedItems));
                clearAll();
                return "index.xhtml?faces-redirect=true";
            }
            else
            {
                System.out.println("Error:= image upload");
                return "SubmitProperty.xhtml?faces-redirect=true";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }
    

    public String showimage(int i) {
        String img = null;

        getPropertyimagetbs = ejb.searchImage(i);
        for (Propertyimagetb propertyimagetb : getPropertyimagetbs) {

            img = propertyimagetb.getImage();
            break;
        }

        return img;
    }

    public Collection<Sellertb> showpropertydatabyid() {
        HttpSession session = SessionUtils.getSession();
        Integer UserId = (Integer) session.getAttribute("UserId");
        getSellertbs = ejb.getAllPropertytbid(UserId);

        return getSellertbs;

    }

    public String deleteproperty(Integer pid) {

        ejb.removeProperty(pid);

        return "myproperties.xhtml?faces-redirect=true";
    }

    public String showpropertybyid(int i) {
        try {
            //System.out.println("showpropertybyid:=" + i);
            propertytb = ejb.searchProperty(i);
            sellertb = ejb.searchSeller(propertytb.getPropertyId());
            getPropertyimagetbs = ejb.searchImage(propertytb.getPropertyId());
            getPropertyfeaturetbs = ejb.searchPropertyFeature(propertytb.getPropertyId());
            propertyid = sellertb.getPropertyId().getPropertyId();
            propertyname = propertytb.getPropertyName();
            type = sellertb.getType();
            address = sellertb.getAddress();
            String p=String.valueOf(propertytb.getPrice());
            price = p;
            areaunit = propertytb.getAreaUnit();
            plotarea = propertytb.getPlotArea();
            decription = propertytb.getDescription();
            this.username = sellertb.getUserId().getUserName();
            this.mobileno = sellertb.getUserId().getMobileNo();
            this.email = sellertb.getUserId().getEmail();
//            System.out.println("Seller details:=" + username + "-" + mobileno + "-" + email);
//            System.out.println("Property details:=" + propertyname + "-" + type + "-" + address + "-" + price + "-" + areaunit);
//            for (Propertyimagetb image : getPropertyimagetbs) {
//                System.out.println("images:=" + image.getImage());
//            }
            return "SinglePropertySeller.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public String myprofile() {

        HttpSession session = SessionUtils.getSession();
        Integer UserId = (Integer) session.getAttribute("UserId");
        System.out.println("managedbean.ClientBean.myprofile():=" + UserId);

        return "myprofile.xhtml";
    }

    public Collection<Propertytb> showPropertytbs() {
        getPropertytbs = ejb.getAllPropertytb();

        return null;
    }
    public void searchbytype()
    {
        System.out.println("managedbean.ClientBean.searchbytype()"+searchtype+"/"+searchcity+"/"+searchptype);
        this.getSellertbs=ejb.getAllPropertytbtype(searchtype,searchcity,searchptype);
        
    }
    public Collection<Sellertb> showSellertbs() {
        
        getSellertbs = ejb.getAllSellertbs();
        
        return getSellertbs;
    }

    public Collection<Propertyimagetb> showPropertyimagetbs(int id) {
        //System.out.println("show:=" + id);
        getPropertyimagetbs = ejb.searchImage(id);

        return getPropertyimagetbs;
    }

    public String deletewishlist(Integer wishlistid) {

        ejb.removeWishList(wishlistid);

        return "mybookmarks.xhtml?faces-redirect=true";
    }

    public String addwishlist(Integer pid) {
        HttpSession session = SessionUtils.getSession();
        Integer UserId = (Integer) session.getAttribute("UserId");
        System.out.println("addwishlist:=" + UserId + "-" + pid);
        //return null;
        ejb.addWishList(UserId, pid);
        return "mybookmarks.xhtml?faces-redirect=true";
    }

    public void clearAll() {
        System.out.println("managedbean.ClientBean.clearAll()");
        userid = 0;
        isseller = 0;
        propertytypeid = 0;
        featureid = 0;
        amenitiesid = 0;
        amenities = "";
        propertyid = 0;
        price = "";
        address = "";
        decription = "";
        propertyname = "";
        type = "";
        ptype = "";
        username =null;
        email = "";
        password = "";
        mobileno = "";
        feature = "";
        title = "";
        auth = false;
        selectedItems=null;
        pimage="";
        companyname="";
        companyurl="";
        errormsg=null;
    }
}
