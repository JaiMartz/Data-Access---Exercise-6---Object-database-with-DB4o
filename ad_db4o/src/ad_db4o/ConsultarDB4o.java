/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_db4o;

import com.db4o.*;
/**
 *
 * @author Jairo
 */
public class ConsultarDB4o {
    public static void main(String[] args) {
        
        //PATH Base de datos
        String pathBD = "C:\\Users\\Yleve\\Desktop\\BDOO\\gestionLaboral1819.yap";

        //Establecemos conexion con la BD
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), pathBD);

        //Creamos el ejemplo de consulta
        Empleado emp = new Empleado (0,null,null,null,0);

        //Almacenamos el resultado de la consulta en una lista
        ObjectSet<Empleado> consulta = db.queryByExample(emp);

        if(consulta.size() == 0){
                System.out.println("No existen empleados con los datos especificados");
        }else{
            //Recorremos la lista para mostrar los empleados
            while(consulta.hasNext()){
                Empleado emp_actual = consulta.next();
                System.out.println("\nCódigo Empleado: "+emp_actual.getCodEmpleado()+"\t\tNombre: "+emp_actual.getNombre()+
                        "\t\tApellido: "+emp_actual.getApellido() +"\t\tPuesto: "+emp_actual.getPuesto()+"\t\tSalario: "+emp_actual.getSalario());
            }
        }
        
        //Cerramos el flujo con la BD
        db.close();
    }
}
