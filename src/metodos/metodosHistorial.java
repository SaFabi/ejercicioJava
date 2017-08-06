/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import hospital.HistorialClinico;
import hospital.Medico;
import hospital.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Fabi
 */
public class metodosHistorial {
     private static metodosHistorial instancia;
    public static metodosHistorial getInstancia(){
        if (instancia == null) {
            instancia = new metodosHistorial();
        }
        return instancia;
    }
    
     public  void registrarHistorial(ArrayList<HistorialClinico> lista,HistorialClinico historial ){
         lista.add(historial);
         
    }
     
    //REALIZAR LAS BUSQUEDAS
    
   public  int busquedaSecuencialidPaciente(ArrayList<HistorialClinico> arreglo, int idPaciente){
        
        for (int i = 0; i < arreglo.size(); i++) {
            if (idPaciente == arreglo.get(i).getIdPaciente()) {
                return i;
                
            }
        }
        return -1;
    }
    
    public int busquedaSecuencialidMedico(ArrayList<HistorialClinico> arreglo,int  idMedico){
        
        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getIdMedico() == idMedico) {
                return i;
                
            }
        }
        return -1;
    }
   
     public int busquedaSecuencialcodigo(ArrayList<HistorialClinico> arreglo,String  codigo){
        
        for (int i = 0; i < arreglo.size(); i++) {
            if (arreglo.get(i).getCodigo().equals(codigo)) {
                return i;
                
            }
        }
        return -1;
    }
     

    //IMPRIMIR LAS LISTAS CON LOS RESULTADOS
    
    public String imprimirListaIDPaciente(ArrayList<HistorialClinico>lista, int id){
        String result ="";
        for (int i = 0; i < lista.size(); i++) {
             if (lista.get(i).getIdPaciente() == id) {
                 result += lista.get(i).toString();
            
            }
           
            
        }
        return result;
    }
     public String imprimirListaCodigo(ArrayList<HistorialClinico>lista, String nombre){
        String result ="";
        for (int i = 0; i < lista.size(); i++) {
             if (lista.get(i).getCodigo().equals(nombre)) {
                 result += lista.get(i).toString();
            
            }
           
            
        }
        return result;
    }
     public String imprimirLista(ArrayList<HistorialClinico>lista){
        String result ="";
        for (int i = 0; i < lista.size(); i++) {
            result += lista.get(i).toString();
            
            
        }
        return result;
    }
    

   
    
   
    
    public void eliminarRegistro(ArrayList<HistorialClinico>lista, int id){
        lista.remove(id);
    }
    
    //MODIFICANDO
    public void modificarIDMedico(ArrayList<HistorialClinico>lista,int id1,int id2){
        lista.get(id1).setIdMedico(id2);
        
    }
    
    public void modificarIDPaciente(ArrayList<HistorialClinico>lista,int id1,int id2){
        lista.get(id1).setIdPaciente(id2);
        
    }
    public void modificarCodigo(ArrayList<HistorialClinico>lista,int id1,String codigo){
        lista.get(id1).setCodigo(codigo);
        
    }
    public void modificarfecha(ArrayList<HistorialClinico>lista,int id1,String fecha){
        lista.get(id1).setFecha(fecha);
        
    }
    public void modificarObservaciones(ArrayList<HistorialClinico>lista,int id1,String mod){
        lista.get(id1).setObservaciones(mod);
        
    }
    
            
}
     
     
     
    
    
    

