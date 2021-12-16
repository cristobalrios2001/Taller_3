/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class Taller_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SystemImpl sistema =new SystemEnvios();
        
        lecturaLocalizacion( sistema);
        lecturaCliente( sistema);
        lecturaEntregas( sistema);
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese tipo: ");
        String tipo = sc.next();
        System.out.print("Ingrese peso: ");
        Double peso = sc.nextDouble();
        System.out.print("Ingrese grosor: ");
        Double grosor = sc.nextDouble();
       
        System.out.println(sistema.verificarParametro(tipo, peso, grosor, 0.0, 0.0, 0.0, null));
        
        
        
    }
    
    public static void lecturaLocalizacion(SystemImpl system)throws IOException{
        Scanner s = new Scanner(new File("localizacion.txt"));
        while(s.hasNextLine()) {
            String line = s.nextLine();
            system.ingresarCiudad(line);
        }  

    }
    
    public static void lecturaCliente(SystemImpl system)throws IOException{
        Scanner s = new Scanner(new File("clientes.txt"));
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String [] partes = line.split(",");
            String rut = partes[0];
            String nombre = partes[1];
            String apellido = partes[2];
            int saldo = Integer.parseInt(partes[3]);
            String ciudad = partes[4];
            
            
            system.ingresarAsociarCliente(rut, nombre, apellido, saldo, ciudad);
        }  

    }
    
    
    public static void lecturaEntregas(SystemImpl system)throws IOException{
        Scanner s = new Scanner(new File("entregas.txt"));
        while(s.hasNextLine()) {
            String line = s.nextLine();
            String [] partes = line.split(",");
            String codigo = partes[0];
            String tipo = partes[1];
            
           
            switch(tipo){
                case "D": {
                    String rutRemitente = partes[2];
                    String rutDestinatario = partes[3];
                    Double peso= Double.parseDouble(partes[4]);
                    Double grosor= Double.parseDouble(partes[5]); 
                    
                    system.ingresarDocumento(codigo, rutRemitente, rutDestinatario, peso, grosor);
                    break;
                }                   
                case "E": {                    
                    String rutRemitente = partes[2];
                    String rutDestinatario = partes[3];
                    Double peso= Double.parseDouble(partes[4]);
                    Double largo= Double.parseDouble(partes[5]); 
                    Double ancho= Double.parseDouble(partes[6]); 
                    Double profundidad= Double.parseDouble(partes[7]); 
                    
                    system.ingresarEncomienda(codigo, rutRemitente, rutDestinatario, peso, largo, ancho, profundidad);
                    break;
                }                          
                case "V":{
                    String rutRemitente = partes[2];
                    String rutDestinatario = partes[3];
                    String material = partes[4];
                    Double peso= Double.parseDouble(partes[5]);
                    
                    system.ingresarValija(codigo, rutRemitente, rutDestinatario, material, peso);
                    break;
                }
                default:
                    break;   
            }
            
            
            
            
        }  

    }
}
