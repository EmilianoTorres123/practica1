/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package org.uv.programa_01da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emili
 */
public class Programa_01DA {

    public static void main(String[] args) {
         Connection con=null;
        Statement str=null;
        try {
            String url="jdbc:postgresql://localhost:5432/practica_3";
            String usr="postgres";
            String pwd="Totita123.";
            String sql="INSERT INTO empleado(id,nombre,direccion,telefono) "
                    + "VALUES ('5','emi','Avenida 2','2223334441');";
            
            con=DriverManager.getConnection(url,usr,pwd);
            Logger.getLogger(Programa_01DA.class.getName()).log(Level.INFO,"Se conecto...");
            
            str=con.createStatement();
            boolean res= str.execute(sql);
            
            if (!res){
                Logger.getLogger(Programa_01DA.class.getName()).log(Level.INFO,"Se guardo...");
            }
            else{
                Logger.getLogger(Programa_01DA.class.getName()).log(Level.INFO,"No se guardo...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Programa_01DA.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (str!=null) 
                    try {
                        str.close();
            } catch (SQLException ex) {
                Logger.getLogger(Programa_01DA.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con!=null) 
                    con.close();               
            } catch (SQLException ex) {
                Logger.getLogger(Programa_01DA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   }

