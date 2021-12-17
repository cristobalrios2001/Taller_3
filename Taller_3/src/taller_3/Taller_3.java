/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

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
        Random r = new Random();
        
        lecturaLocalizacion( sistema);
        lecturaCliente( sistema);
        lecturaEntregas( sistema);
        
        Scanner sc = new Scanner(System.in);
        /*
        System.out.print("Ingrese tipo: ");
        String tipo = sc.next();//Encomienda
        System.out.print("Ingrese peso: ");
        Double peso = sc.nextDouble(); 
        System.out.print("Ingrese grosor: ");
        Double grosor = sc.nextDouble();
        */
        //                           verificarParametro(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material);
        //System.out.println(sistema.verificarParametro("Encomienda", 10.0, 0.0, 10.0, 10.0, 10.0, null));
        // obtenerPrecio(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material)
        
        String tipoEntrega = "Encomienda";
        Double peso = 40000.0;
        Double largo =120.0 ;
        Double ancho = 80.0;
        Double profundidad = 80.0;        
        String rutRemitente = "22222222";
        String rutDestinatario = "11111111";
        
        System.out.println(sistema.verificarParametro(tipoEntrega, peso, 0.0, largo, ancho, profundidad, null));
        sistema.entregaConfirmada( tipoEntrega,  rutRemitente,  rutDestinatario,  peso,  0.0,  largo,  ancho,  profundidad,  null);
        
        System.out.println(sistema.obtenerEntregasCliente());
        
        System.out.println(sistema.obtenerEntregasPorLocalizacion());
        
        System.out.println("\n"+sistema.obtenerBalanceOficina());
        
        
        
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
    
    
    private static void menuAdmin(SystemImpl system) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la contraseña");
        String contraseña= sc.nextLine();
        if(contraseña.equals("choripan123")){
            boolean salir=false;
                int opcion;
                do{
                    System.out.println("Bienvenido al menu del cliente: ");
                    System.out.println("Dispone de las siguientes opciones");
                    System.out.println("1) Entregas por tipo");
                    System.out.println("2) Entregas por localizacion");
                    System.out.println("3) Entregas por cliente");
                    System.out.println("4) Registro de ganancias");
                    System.out.println("5) Salir");
                    try{
                        System.out.println("Ingrese el numero de unas de las opciones");
                        opcion=Integer.parseInt(sc.nextLine());
                        switch(opcion){
                            case 1:
                                System.out.println("Ha seleccionado la opcion 1: ´Entregas por tipo´ ");                                
                                System.out.println(system.obtenerEntregasPorTipo());
                                break;
                            case 2:
                                System.out.println("Ha seleccionado la opcion 2: ´Entregas por localizacion´ ");                                
                                System.out.println(system.obtenerEntregasPorLocalizacion());
                                break;
                            case 3:
                                System.out.println("Ha seleccionado la opcion 3: ´Entregas por cliente´ ");                                
                                System.out.println(system.obtenerEntregasCliente());
                                break;
                            case 4:
                                System.out.println("Ha seleccionado la opcion 4: ´Registro de ganancias´");
                                System.out.println(system.obtenerBalanceOficina());
                                System.out.println(system.obtenerBalanceTotal());
                            case 5:
                                System.out.println("Cerrando sistema...");
                                salir=true;
                                break;
                            default:
                                System.out.println("Solo numeros entre 1 y 4");
                        }
                    }catch(Exception e){
                        System.out.println("Debe Insertar un número ");
                        sc.next();
                    }
                }while(!salir);
        }else{
            System.out.println("Contraseña incorrecta");
        }
    }
    
    private static void menu(SystemImpl system) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Bienvenido al sistema");
        System.out.println("Ingrese su rut: ");
        String rut = sc.nextLine();
        if(rut.equals("Admin")){
            menuAdmin(system);
        }else{
            boolean op = system.verificarRut(rut);
            if(op){
                boolean salir=false;
                int opcion;
                do{
                    System.out.println("Bienvenido al menu del cliente: ");
                    System.out.println("Dispone de las siguientes opciones");
                    System.out.println("1) Realizar una entrega");
                    System.out.println("2) Recargar saldo");
                    System.out.println("3) Ver tus entregas");
                    System.out.println("4) Salir");
                    try{
                        System.out.println("Ingrese el numero de unas de las opciones");
                        opcion=Integer.parseInt(sc.nextLine());
                        switch(opcion){
                            case 1:
                                System.out.println("Ha seleccionado la opcion 1: ´Realizar una entrega´ ");
                                realizarEntrega(rut);
                                break;
                            case 2:
                                System.out.println("Ha seleccionado la opcion 2: ´Recargar Saldo´ ");
                                recargarSaldo(rut, system);
                                break;
                            case 3:
                                System.out.println("Ha seleccionado la opcion 3: ´Ver tus entregas´ ");
                                System.out.println(system.obtenerEntregas(rut));                                
                                break;
                            case 4:
                                System.out.println("Cerrando sistema...");
                                salir=true;
                                break;
                            default:
                                System.out.println("Solo numeros entre 1 y 3");
                        }
                    }catch(Exception e){
                        System.out.println("Debe Insertar un número ");
                        sc.next();
                    }
                }while(!salir);
                
            
            }else{
                System.out.println("Rut no encontrado");
                System.out.println("¿Desea registrarse como cliente?: (1)Si - (2) no ");
                String opcion=sc.nextLine();
                while(!opcion.equals("1") && !opcion.equals("2")){
                    System.out.println("Ingrese un numero valido (1)Si - (2) no");
                    opcion=sc.nextLine();
                }if (opcion.equals("1")) {
                    sys.ingresarRut(rut);
                }else{
                    System.out.println("Cerrando sistema...");
                    System.exit(0);
                }
                
            }
        }
    }
    
    private static void recargarSaldo(String rut,SystemImpl system ) {
        Scanner sc = new Scanner(System.in);
        int monto=0;
        System.out.print("Ingrese el monto que desea añadir a su cuenta: ");
        monto=Integer.parseInt(sc.nextLine());
        while (monto<=0){
            System.out.println("El monto que ha ingresado es menor o igual a cero");
            System.out.print("Reingrese el monto: ");
            monto=Integer.parseInt(sc.nextLine());
        }
        system.recargarSaldo(rut, monto);    
    }
    
    private static void realizarEntrega(String rut, SystemImpl system) {
        Scanner sc= new Scanner(System.in);
        boolean salir=false;
        int opcion;
        do{
            System.out.println("Que tipo de entrega desea realizar: ");
            System.out.println("1) Entrega de documento: ");
            System.out.println("2) Entrega  de encomienda: ");
            System.out.println("3) Entrega de valijas");
            System.out.println("4) Salir");
            try{
                System.out.println("Ingrese una de las opciones");
                opcion=Integer.parseInt(sc.nextLine());
            switch(opcion){
                case 1:
                    System.out.println("Ha escogido la entrega de documentos");
                    String tipoD = "Documento";
                    documentos();
                    break;
                case 2:
                    System.out.println("Ha escogido la entrega de encomienda");
                    String tipoE = "Encomienda";
                    encomienda();
                    break;
                case 3:
                    System.out.println("Ha escogido la entrega de valijas");
                    String tipoV = "Valija";
                    valijas();
                    break;
                case 4:
                    System.out.println("Cerrando sistema");
                    salir=true;
                    break;               
                default:
                    System.out.println("Solo numeros entre 1 y 4");
            }
                      
            }
            catch(Exception e){
                System.out.println("Ingrese una opcion valida: ");
                sc.next();
            }
                    
        }while(!salir);
        
    }
    
    
    
    
    private static void documentos(SystemImpl system) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el PESO del Documento (en gramos): ");
        double peso = sc.nextInt();
        while (peso <0){
            System.out.println("Ingrese un valor de PESO valido !");
            System.out.print("Ingrese el PESO del Documento (en gramos): ");
            peso = sc.nextInt();
        }
        System.out.print("Ingrese el GROSOR del Documento (en milimetros): ");
        double grosor = sc.nextInt();
        while (grosor <0){
            System.out.println("Ingrese un valor de GROSOR valido !");
            System.out.print("Ingrese el GROSOR del Documento (en milimetros): ");
            grosor = sc.nextInt();
        }
        boolean parametroValido = system.verificarParametro("Documento", peso, grosor, 0.0, 0.0, 0.0, null);
        if(parametroValido){
            
        }else{
            System.out.println("Los parametros no son validos !");
        }
        
        
    }
}
