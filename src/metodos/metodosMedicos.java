/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import hospital.Medico;
import hospital.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Fabi
 */
public class metodosMedicos {
    private static metodosMedicos instancia;
    public static metodosMedicos getInstancia(){
        if (instancia == null) {
            instancia = new metodosMedicos();
        }
        return instancia;
    }
    
    
    //REGISTRAR UN MEDICO
    public  void registrarMedico(ArrayList<Medico> lista,Medico medico ){
         lista.add(medico);
         
    }
    
    //REALIZAR LAS BUSQUEDAS
    
   public  int busquedaSecuencialIdentificacion(ArrayList<Medico> arreglo, int id){
        
        for (int i = 0; i < arreglo.size(); i++) {
            if (id == arreglo.get(i).getId()) {
                return i;
                
            }
        }
        return -1;
    }
    
    public int busquedaSecuencialNombre(ArrayList<Medico> arreglo,String nombre){
        
        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getNombre().equals(nombre)) {
                return i;
                
            }
        }
        return -1;
    }
    
    //IMPRIMIR LAS LISTAS CON LOS RESULTADOS
    
    public String imprimirListaID(ArrayList<Medico>lista, int id){
        String result ="";
        for (int i = 0; i < lista.size(); i++) {
             if (lista.get(i).getId() == id) {
                 result += lista.get(i).toString();
            
            }
           
            
        }
        return result;
    }
     public String imprimirListaNombre(ArrayList<Medico>lista, String nombre){
        String result ="";
        for (int i = 0; i < lista.size(); i++) {
             if (lista.get(i).getNombre().equals(nombre)) {
                 result += lista.get(i).toString();
            
            }
           
            
        }
        return result;
    }
     public String imprimirLista(ArrayList<Medico>lista){
        String result ="";
        for (int i = 0; i < lista.size(); i++) {
            result += lista.get(i).toString();
            
            
        }
        return result;
    }
     
    //MODIFICAR ALGUNA PARTE
    public void modificarID(ArrayList<Medico>lista,int id1,int id2){
        lista.get(id1).setId(id2);
        
    }
    public void modificarNombre(ArrayList<Medico>lista,int id1,String nombre){
        lista.get(id1).setNombre(nombre);
        
    }
   //ELIMINA UN REGISTRO
    
    public void eliminarRegistro(ArrayList<Medico>lista, int id){
        lista.remove(id);
    }
    

    
    
    
            
    
    
    
    
    
    
    
}
