/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import metodos.metodosHistorial;
import metodos.metodosMedicos;
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
                        int resultadoMedico;
                        int idMedico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el identificador del Medico"));
                        resultadoMedico=metodosMedicos.getInstancia().busquedaSecuencialIdentificacion(medico,idMedico);
                        if (resultadoMedico != -1) {
                            JOptionPane.showMessageDialog(null, "Ya existe este registro");
                            
                        }else{
                            String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre ");
                        String apellidoMedico = JOptionPane.showInputDialog("Ingrese el apellido del medico");
                        String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad del medico");
                        metodosMedicos.getInstancia().registrarMedico(medico,new Medico(idMedico,nombreMedico,apellidoMedico,especialidad));
                        JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                        JOptionPane.showMessageDialog(null,metodosMedicos.getInstancia().imprimirLista(medico));
                        }
                        
                        break;
                    case 2:
                        
                        int opcionBusqueda = Integer.parseInt(JOptionPane.showInputDialog("1.- Buscar por id\n2.-Buscar por Nombre"));
                        switch(opcionBusqueda){
                            case 1:
                           int  idBusquedaMed = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de identificacion del medico"));
                            resultadoMedico=metodosMedicos.getInstancia().busquedaSecuencialIdentificacion(medico,idBusquedaMed);
                            if (resultadoMedico != -1) {
                               JOptionPane.showMessageDialog(null,metodosMedicos.getInstancia().imprimirListaID(medico,idBusquedaMed));
                                
                            }else  {
                                JOptionPane.showMessageDialog(null, "No existe un registro con este numero de identificacion");
                            }
                                
                            break;
                       
                    
                            case 2:
                          String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del medico");
                          resultadoMedico=metodosMedicos.getInstancia().busquedaSecuencialNombre(medico, nombreBusqueda);
                            if (resultadoMedico != -1) {
                                     JOptionPane.showMessageDialog(null,metodosMedicos.getInstancia().imprimirListaNombre(medico, nombreBusqueda));
                              
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "No existe un registro con este nombre");
                            }
                                break;
                            
                        }
                        break;
                    case 3:
                         int resultadoMod= 0;
                        int opcionModiciacion = Integer.parseInt(JOptionPane.showInputDialog("1.-Modificar id\n2.- Modificar nombre"));
                        switch(opcionModiciacion){
                            case 1:
                                int idMod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar"));
                               resultadoMod= metodosMedicos.getInstancia().busquedaSecuencialIdentificacion(medico, idMod);
                                if (resultadoMod != -1) {
                                     int idModNuevo = Integer.parseInt("Ingrese el id nuevo");
                                     metodosMedicos.getInstancia().modificarID(medico, resultadoMod,idModNuevo);
                                     JOptionPane.showMessageDialog(null,metodosMedicos.getInstancia().imprimirListaID(medico, idModNuevo));
                                }else{
                                    
                                }
                                JOptionPane.showMessageDialog(null, "No existe un registro con este numero de identificacion");
                            break;
                            case 2: 
                                String nombreModMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico a buscar");
                                resultadoMod = metodosMedicos.getInstancia().busquedaSecuencialNombre(medico, nombreModMedico);
                                if (resultadoMod != -1) {
                                    String nuevoMedMedico = JOptionPane.showInputDialog("Ingrese el nuevo nombre ");
                                    metodosMedicos.getInstancia().modificarNombre(medico, resultadoMod, nombreModMedico);
                                    JOptionPane.showMessageDialog(null,metodosMedicos.getInstancia().imprimirListaNombre(medico, nombreModMedico));
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null,"No existe un registro con este nombre");
                                }
                                
                        }
                           
                        break;
                    case 4:
                               int resultadoEliminarBusqueda = 0;
                                int idEliminarMed = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a buscar"));
                                resultadoEliminarBusqueda = metodosMedicos.getInstancia().busquedaSecuencialIdentificacion(medico, idEliminarMed);
                                if (resultadoEliminarBusqueda != -1) {
                                   metodosMedicos.getInstancia().eliminarRegistro(medico, resultadoEliminarBusqueda);
                                   JOptionPane.showMessageDialog(null,"Se elimino el registro");
                                   JOptionPane.showMessageDialog(null,metodosMedicos.getInstancia().imprimirLista(medico));
                                   
                                }else{
                                   JOptionPane.showMessageDialog(null,"No existe un registro con este numero de identificacion"); 
                                }
                            
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
                        int idPacienteHistorial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del usuario"));
                         int idMedicoHistorial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico"));
                        if ((metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, idPacienteHistorial) != -1)&& (metodosHistorial.getInstancia().busquedaSecuencialidMedico(historial, idMedicoHistorial) != -1)) {
                           JOptionPane.showMessageDialog(null,"Ya existe el historial de este paciente con este medico");
                           
                            
                        }else{
                            String codigo = JOptionPane.showInputDialog("Ingrese el codigo del historial");
                            if ((metodosHistorial.getInstancia().busquedaSecuencialcodigo(historial, codigo)) != -1) {
                                JOptionPane.showMessageDialog(null,"Ya existe un registro con este codigo");
                                
                            }else{
                                String fecha = JOptionPane.showInputDialog("Ingrese la fecha");
                                String observaciones = JOptionPane.showInputDialog("Ingrese una observacion");
                                metodosHistorial.getInstancia().registrarHistorial(historial, new HistorialClinico(codigo,fecha,idPacienteHistorial,idMedicoHistorial,observaciones));
                                JOptionPane.showMessageDialog(null, "Se inserto el registro");
                                JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirLista(historial));
                            }
                        }
                        
                        break;
                    case 2:
                         int resultadoBusquedaHistorial= 0;
                       int opcionBusquedaHistorial = Integer.parseInt(JOptionPane.showInputDialog("1.- Buscar por id Paciente\n2.-Buscar por codigo de Historial"));
                       switch (opcionBusquedaHistorial){
                           case 1:
                               int idPacienteHistorialBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del paciente a buscar"));
                              resultadoBusquedaHistorial = metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, idPacienteHistorialBuscar);
                               if (resultadoBusquedaHistorial != -1) {
                                  JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirListaIDPaciente(historial,idPacienteHistorialBuscar));
                                   
                               }else{
                                   JOptionPane.showMessageDialog(null, "No existe un registro con este numero de identificacion");
                               }
                               break;
                           case 2:
                               String codigoHistorial = JOptionPane.showInputDialog("Ingrese el codigo del historial");
                               resultadoBusquedaHistorial = metodosHistorial.getInstancia().busquedaSecuencialcodigo(historial, codigoHistorial);
                               if (resultadoBusquedaHistorial  != -1) {
                                   JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirListaCodigo(historial, codigoHistorial));
                                   
                               }else{
                                   JOptionPane.showMessageDialog(null,"No existe un registro con este codigo");
                               }
                               break;
                       }
                        break;
                    case 3:
                        int opcionModHistorial = Integer.parseInt(JOptionPane.showInputDialog("1.- Modificar id paciente\n2.-Modificar id Medico\n3.-Modificar codigo"));
                        switch (opcionModHistorial){
                            case 1:
                                int resultadoBusqHist ;
                                int nuevoIdpacienteHistorial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del paciente a buscar"));
                                resultadoBusqHist = metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, nuevoIdpacienteHistorial);
                                if (resultadoBusqHist != -1) {
                                    int idMedico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico"));
                                    int nuevoInsertarPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id"));
                                    if ((metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, nuevoInsertarPaciente) != -1)&& (metodosHistorial.getInstancia().busquedaSecuencialidMedico(historial, idMedico) != -1)) {
                                        JOptionPane.showMessageDialog(null,"No se pueden guardar los cambios");
                                    }else{
                                        metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, nuevoInsertarPaciente);
                                        JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirListaIDPaciente(historial, nuevoInsertarPaciente));
                                        
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "No exiiste este registro");
                                }
                                break;
                            case 2:
                                
                                int resultadoBusqHistMed ;
                                int medicoHistorial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del medico a buscar"));
                                resultadoBusqHistMed = metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, medicoHistorial);
                                if (resultadoBusqHistMed != -1) {
                                    int idPaciente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del paciente"));
                                    int nuevoInsertarMedico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo id"));
                                    if ((metodosHistorial.getInstancia().busquedaSecuencialidMedico(historial, nuevoInsertarMedico) != -1)&& (metodosHistorial.getInstancia().busquedaSecuencialidMedico(historial, idPaciente) != -1)) {
                                        JOptionPane.showMessageDialog(null,"No se pueden guardar los cambios");
                                    }else{
                                        metodosHistorial.getInstancia().busquedaSecuencialidPaciente(historial, nuevoInsertarMedico);
                                        JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirListaIDPaciente(historial, nuevoInsertarMedico));
                                        
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "No exiiste este registro");
                                }
                                
                                break;
                                
                            case 3:
                                String codigoBuscar = JOptionPane.showInputDialog("Ingrese el codigo a buscar");
                                resultadoBusqHistMed = metodosHistorial.getInstancia().busquedaSecuencialcodigo(historial, codigoBuscar);
                                if (resultadoBusqHistMed != -1) {
                                    String nuevoCodigoHistorial = JOptionPane.showInputDialog("Ingrese el nuevo codigo");
                                    metodosHistorial.getInstancia().modificarCodigo(historial,resultadoBusqHistMed ,nuevoCodigoHistorial);
                                    JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirListaCodigo(historial, nuevoCodigoHistorial));
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null,"No existe este registro");
                                }
                                
                                break;
                                    
                       
                        }
                       
                        break;
                    case 4:
                        String codigoHistorialEliminar = JOptionPane.showInputDialog("Ingrese el codigo del historial que desea eliminar");
                         int resultadoEliminar = metodosHistorial.getInstancia().busquedaSecuencialcodigo(historial,codigoHistorialEliminar);
                         if (resultadoEliminar != -1) {
                            metodosHistorial.getInstancia().eliminarRegistro(historial,resultadoEliminar);
                            JOptionPane.showMessageDialog(null,metodosHistorial.getInstancia().imprimirLista(historial));
                             
                        }else{
                             JOptionPane.showMessageDialog(null, "No existe este registro");
                         }
                        
                        break;
                    case 5:
                        break;
                }
                break;
        
        }
        
    }while(opcion != 4);
    
}
}
