/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import metodos.metodosPacientes;

/**
 *
 * @author Fabi
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        ArrayList<Paciente> paciente = new ArrayList<>();
        ArrayList<Medico> medico = new ArrayList<>();
        ArrayList<HistorialClinico> historial = new ArrayList<>();
        
        do{
        opcion = Integer.parseInt(JOptionPane.showInputDialog("1.-Gestionar Pacientes.\n 2.-Gestionar Medicos\n3.-Gestionar Historial Clinico\n4.-Salir"));
        switch (opcion){
            case 1:

               int opcionPaciente= Integer.parseInt(JOptionPane.showInputDialog("1.-Registrar Paciente\n 2.-Consultar Paciente\n3.-Modificar Paciente\n4.-Eliminar Paciente\n5.-Atras"));
                switch(opcionPaciente){
                    case 1://Registrar
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del paciente"));
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Paciente");
                        String apellidos = JOptionPane.showInputDialog("Ingrese los apellidos del paciente");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del paciente"));
                        String genero = JOptionPane.showInputDialog("Ingrese el genero del usuario");
                        metodosPacientes.getInstancia().registrarPaciente(paciente,new Paciente(id,nombre,apellidos,edad,genero));
                        JOptionPane.showMessageDialog(null,"Se inserto correctamente");
                        break;
                    case 2://Buscar
                        int opcionBusqueda = Integer.parseInt(JOptionPane.showInputDialog("1.- Busqueda por ID\n 2 Busqueda por Nombre"));
                        if (opcionBusqueda == 1) {
                         int idBusqueda=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar"));
                           int resultadoBusquedaId= metodosPacientes.getInstancia().busquedaSecuencialIdentificacion(paciente, idBusqueda);
                            if (resultadoBusquedaId != -1) {
                                
                                 JOptionPane.showInputDialog(null,metodosPacientes.getInstancia().imprimirListaID(paciente,idBusqueda));
                            }else  {
                                JOptionPane.showMessageDialog(null,"No existe un registro con este numero de identificacion");
                            }
                         
                         
                        }
                        if (opcionBusqueda == 2) {
                            String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre a buscar ");
                            int resultadoBusquedanombre= metodosPacientes.getInstancia().busquedaSecuencialNombre(paciente, nombreBusqueda);
                            if (resultadoBusquedanombre != -1) {
                                
                                 JOptionPane.showMessageDialog(null,metodosPacientes.getInstancia().imprimirListaNombre(paciente,nombreBusqueda));
                            }else  {
                                JOptionPane.showMessageDialog(null,"No existe un registro con este nombre");
                            }
                            

                        }
                        break;
                    case 3://Modificar
                        JOptionPane.showMessageDialog(null,metodosPacientes.getInstancia().imprimirLista(paciente));
                        int OpcionModificar=Integer.parseInt(JOptionPane.showInputDialog("Elija el dato que desea modificar\n1.-Id\n2.-Nombre\n3.-Apellidos\n4.-Atras"));
                       
                        switch(OpcionModificar){
                            case 1:
                                int idCambiar=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a modificar"));
                                int posicionId = metodosPacientes.getInstancia().busquedaSecuencialIdentificacion(paciente, idCambiar);
                                if (posicionId != -1) {
                                    int idNuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el nuevo id"));
                                    metodosPacientes.getInstancia().modificarID(paciente, posicionId, idNuevo);
                                   JOptionPane.showMessageDialog(null,"Se guardaron los cambios");
                                   JOptionPane.showMessageDialog(null,metodosPacientes.getInstancia().imprimirListaID(paciente,idNuevo));
                                    
                                    
                                }else  {
                                    JOptionPane.showMessageDialog(null,"No existe un registro con este numero de identificacion");
                                }
                                
                                
                                
                                
                                break;
                            case 2:
                                String nombreCambiar=JOptionPane.showInputDialog("Ingrese el nombre a modificar");
                                posicionId = metodosPacientes.getInstancia().busquedaSecuencialNombre(paciente,nombreCambiar);
                                if (posicionId != -1) {
                                    String nombreNuevo = JOptionPane.showInputDialog("Ingresa el nuevo nombre");
                                    metodosPacientes.getInstancia().modificarNombre(paciente, posicionId,nombreNuevo);
                                   JOptionPane.showMessageDialog(null,"Se guardaron los cambios");
                                   JOptionPane.showMessageDialog(null,metodosPacientes.getInstancia().imprimirListaNombre(paciente,nombreNuevo));
                                    
                                    
                                }else  {
                                    JOptionPane.showMessageDialog(null,"No existe un registro con este numero de identificacion");
                                }
                                
                                break;    
                            
                            case 3:
                                break;
                            
                        }
                        
                        
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,metodosPacientes.getInstancia().imprimirLista(paciente));
                        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Inserta el id que se requiere eliminar"));
                        int posicionEliminar = metodosPacientes.getInstancia().busquedaSecuencialIdentificacion(paciente, idEliminar);
                                if (posicionEliminar != -1) {
                                   metodosPacientes.getInstancia().eliminarRegistro(paciente, posicionEliminar);
                                   JOptionPane.showMessageDialog(null,"Se Elimino el registro");
                                    JOptionPane.showMessageDialog(null,metodosPacientes.getInstancia().imprimirLista(paciente));
                                   
                                    
                                    
                                }else  {
                                    JOptionPane.showMessageDialog(null,"No existe un registro con este numero de identificacion");
                                }
                                
                        
                        
                        
                        break;
                    case 5:
                        break;
                }
                break;
            case 2:
                 int opcionMedico;
                 opcionMedico= Integer.parseInt(JOptionPane.showInputDialog("1.-Registrar Medico\n 2.-Consultar Medico\n3.-Modificar Medico\n4.-Eliminar Medico\n5.-Atras"));
                 switch(opcionMedico){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                break;
            case 3: 
                int opcionHistorial;
                opcionHistorial= Integer.parseInt(JOptionPane.showInputDialog("1.-Registrar Historial\n 2.-Consultar Historial\n3.-Modificar Historial\n4.-Eliminar Historial\n5.-Atras"));
                switch(opcionHistorial){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
                break;
        
        }
        
    }while(opcion != 4);
    
}
}
