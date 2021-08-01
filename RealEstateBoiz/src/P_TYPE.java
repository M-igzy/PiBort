
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class P_TYPE {
    
    private int id;
    private String name;
    private String description;
    
    //create getters and setters
    public Integer getId()
    {
        return id;
    }        
     
    public String getName()
    {
        return name;
    }     
    
    public void setName(String NAME)
    {
        this.name = NAME;
       
    }
     public String getDescription()
     {
         return this.description;
     }
    
     public void setDescription(String DESCRIPTION)
    {
        this.name = DESCRIPTION;
    }
    

     
     // create the class constructor
     
     public P_TYPE(){}
     
     public P_TYPE(Integer ID, String NAME, String DESCRIPTION)
     {
         
         this.id = ID;
         this.name = NAME;
         this.description = DESCRIPTION;
         
     }
     
     //create a function to edit create insert
     
     public boolean execTypeQuery(String queryType, P_TYPE type)
     {
        
         PreparedStatement ps;
         
         
         //add new type
         
         if(queryType.equals("add"))
         {
             try {
                 // query -- INSERT INTO `property_type`(`name`, `description`) VALUES (?,?)
                 ps = THE_CONNECTION.getTheConnection().prepareStatement("INSERT INTO `property_type`(`name`, `description`) VALUES (?,?)");
                 ps.setString(1, type.getName());
                 ps.setString(2, type.getDescription());
                 
                 return (ps.executeUpdate() > 0);
                 
             } catch (SQLException ex) {
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
             }
             
         }
         
         //add new type
        else if(queryType.equals("edit"))
         {
             try {
                 
                 
                 // query -- UPDATE `property_type` SET `name`=?,`description`=? WHERE `id` = ?
                 ps = THE_CONNECTION.getTheConnection().prepareStatement("UPDATE `property_type` SET `name`=?,`description`=? WHERE `id` = ?");
                 ps.setString(1, type.getName());
                 ps.setString(2, type.getDescription());
                 ps.setInt(3, type.getId());
                         
                         
                 return (ps.executeUpdate() > 0);
                 
             } catch (SQLException ex) {
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
             }
             
         }
         
         //add new type
        else if(queryType.equals("remove"))
         {
             try {
                 
                 
                 // query -- DELETE FROM `property_type` WHERE `id` = ?
                 ps = THE_CONNECTION.getTheConnection().prepareStatement("DELETE FROM `property_type` WHERE `id` = ?");
                 ps.setInt(1, type.getId());
                         
                         
                 return (ps.executeUpdate() > 0);
                 
             } catch (SQLException ex) {
                 Logger.getLogger(P_TYPE.class.getName()).log(Level.SEVERE, null, ex);
                 return false;
             }
             
         }
         
        else{
            JOptionPane.showMessageDialog(null, "Enter The Correct Query ( add,edit,remove )", "InValid Operation", 2);
            return false;
        }
         
     }
     
     
     
}
