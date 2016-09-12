/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class PersonaControlador extends Conexion{
   
    private ResultSet rs;

    public PersonaControlador() {
         this.getConexion();
    }
    
    public boolean insertar(Persona per){
     
        try{
            //getStatement();
            String query = "insert into persona values ('"+per.getId()+"','"+per.getNombre()+"', '"+per.getEdad()+"')";
            System.out.println("QUERY "+query);
            st.executeUpdate(query); //como es un insert se utiliza executeUpdate, si era un select executeQuery
            //this.cerrarSesion();
            return true;
        }catch(SQLException ex){
            System.out.println("Error al insertar "+ex.getMessage());
            return false;  //no inserta
        }
      
    }
    
    public ArrayList<Persona> consultar(){
       
        ArrayList<Persona> persona = new ArrayList<Persona>();
        
       try{
            String query = "Select * from persona";
            rs = st.executeQuery(query);
            while(rs.next()){
               persona.add(new Persona(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
             return persona;
        }catch(SQLException ex){
            System.out.println("Error al consultar "+ex.getMessage());
            
        }
       return persona;
    }
    
    
    
}
