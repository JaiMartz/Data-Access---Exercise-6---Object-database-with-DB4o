/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_db4o;

import com.db4o.*;
import com.db4o.query.Query;

/**
 *
 * @author Jairo
 */
public class ActualizarDB4o {
    public static void main(String[] args) {
        //PATH base de datos
        String pathBD = "C:\\Users\\Yleve\\Desktop\\BDOO\\gestionLaboral1819.yap";
        
        //Establecemos conexion con la BD
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),pathBD);
    
        //Preparamos la consulta
        Query consulta = db.query();
        //Establecemos la consulta a traves del campo salario, indicamos que deben ganar menos de 1500
        consulta.descend("salario").constrain(1500).smaller();
        //Guardamos el resultado de la consulta en una lista
        ObjectSet resultado = consulta.execute();
        
        if(resultado.size() == 0){
            System.out.println("No existen empleados con los datos especificados.");
        }else{
            //Recorremos y modificamos el empleado que cumple las condiciones
            while(resultado.hasNext()){
                Empleado emp_actual = (Empleado)resultado.next();
                emp_actual.setSalario(emp_actual.getSalario()+100);
                db.store(emp_actual);
            }
        }
        //Cerramos
        db.close();
    }

}
