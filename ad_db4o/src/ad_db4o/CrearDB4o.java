/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_db4o;

import com.db4o.*;

/**
 *
 * @author Yleve
 */
public class CrearDB4o {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //PATH Base de datos
        String urlDB = "C:\\Users\\Jairo\\Desktop\\BDOO\\gestionLaboral1819.yap";
        
        //Creamos la conexion con la BD
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), urlDB);
        
        //Creamso los objetos que vamos a introducir en la BD
        Empleado emp1 = new Empleado(1,"Juan","Martín","Administrativo",1200);
        Empleado emp2 = new Empleado(2,"Ana","Amezcua","Programador Senior",1500);
        Empleado emp3 = new Empleado(3,"Raúl","Perez","Programador Junior",1400);
        Empleado emp4 = new Empleado(4,"Jairo","Martínez","Programador Junior",1400);
        Empleado emp5 = new Empleado(5,"Celia","Carrillo","Jefe de equipo",1800);
        
        //Almacenamos los empleados en la BD
        db.store(emp1);
        db.store(emp2);
        db.store(emp3);
        db.store(emp4);
        db.store(emp5);
        
        System.out.println("La base de datos gestionLaboral1819 se ha creado.");
        //Cerramos conexion
        db.close();
    }
    
}
