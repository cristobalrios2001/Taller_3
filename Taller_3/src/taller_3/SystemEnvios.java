/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author crist
 */
public class SystemEnvios implements SystemImpl{
    ArrayList<Ciudad> ListaCiudades = new ArrayList<>(); 
    LinkedList<Cliente> ListaClientes = new LinkedList<>();
    ListaDobleNexo ListaEntregas = new ListaDobleNexo();
    
    

    @Override
    public boolean ingresarAsociarCliente(String rut, String nombre, String apellido, int saldo, String ciudad) {
        Cliente cliente = new Cliente (rut, nombre, apellido, saldo, ciudad);
        return ListaClientes.add(cliente);
    }

    @Override
    public boolean ingresarCiudad(String nombre) {
        Ciudad ciudad = new Ciudad(nombre);
        return ListaCiudades.add(ciudad);
    }

   
    
    @Override
    public boolean verificarCiudad (String nombreCiudad){
        for (int i = 0; i < ListaCiudades.size(); i++) {
            Ciudad ciudad = ListaCiudades.get(i);
            if(ciudad.getNombre().equals(nombreCiudad)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void ingresarDocumento(String codigo, String rutRemitente, String rutDestinatario, Double peso, Double grosor) {
        Envio documento = new Documento(codigo, peso, grosor);
        documento.setRutDestinatario(rutDestinatario);
        documento.setRutRemitente(rutRemitente);
        ListaEntregas.insertar(documento);
        
        for(int j=0;j<ListaClientes.size();j++) {
            Cliente c =ListaClientes.get(j);
            String rutpersona = c.getRut();
            if(rutpersona.equals(rutRemitente) ) {
                c.getlEnvioRemitente().insertar(documento);
                boolean ciudadExiste = verificarCiudad(c.getCiudad());
                
                if(ciudadExiste){
                    for (int i = 0; i < ListaCiudades.size(); i++) {
                        Ciudad ciudad = ListaCiudades.get(i);
                        if(ciudad.getNombre().equals(c.getCiudad())){
                            ciudad.setCantEnviados(ciudad.getCantEnviados()+1);    
                            ciudad.setGanancia(ciudad.getGanancia()+documento.valor());
                            
                            
                        }
                    }
                }
                
                
            }else if(rutpersona.equals(rutDestinatario)) {
                
                c.getlEnvioDestinatario().insertar(documento);
                
                boolean ciudadExiste = verificarCiudad(c.getCiudad());
                
                if(ciudadExiste){
                    for (int i = 0; i < ListaCiudades.size(); i++) {
                    Ciudad ciudad = ListaCiudades.get(i);
                        if(ciudad.getNombre().equals(c.getCiudad())){
                            
                            ciudad.setCantRecibidos(ciudad.getCantRecibidos()+1);
                            
                        }
                    }
                }
                
            }
        }
        
    }

    @Override
    public void ingresarEncomienda(String codigo, String rutRemitente, String rutDestinatario, Double peso, Double largo, Double ancho, Double profundidad) {
        Envio encomienda = new Encomienda(codigo, peso,  largo,  ancho,  profundidad);
        encomienda.setRutDestinatario(rutDestinatario);
        encomienda.setRutRemitente(rutRemitente);       
        ListaEntregas.insertar(encomienda);
        
        for(int j=0;j<ListaClientes.size();j++) {
            Cliente c =ListaClientes.get(j);
            String rutpersona = c.getRut();
            if(rutpersona.equals(rutRemitente) ) {
                c.getlEnvioRemitente().insertar(encomienda);
                boolean ciudadExiste = verificarCiudad(c.getCiudad());
                if(ciudadExiste){
                    for (int i = 0; i < ListaCiudades.size(); i++) {
                        Ciudad ciudad = ListaCiudades.get(i);
                        if(ciudad.getNombre().equals(c.getCiudad())){
                            ciudad.setCantEnviados(ciudad.getCantEnviados()+1);                               
                            ciudad.setGanancia(ciudad.getGanancia()+encomienda.valor());
                        }
                    }
                }
                
                
            }else if(rutpersona.equals(rutDestinatario)) {
                c.getlEnvioDestinatario().insertar(encomienda);
                boolean ciudadExiste = verificarCiudad(c.getCiudad());
                
                if(ciudadExiste){
                    for (int i = 0; i < ListaCiudades.size(); i++) {
                    Ciudad ciudad = ListaCiudades.get(i);
                        if(ciudad.getNombre().equals(c.getCiudad())){
                            ciudad.setCantRecibidos(ciudad.getCantRecibidos()+1);
                        }
                    }
                }
                
            }
        }
    }

    @Override
    public void ingresarValija(String codigo, String rutRemitente, String rutDestinatario, String material, Double peso) {
        Envio valija = new Valija(codigo, peso, material);  
        valija.setRutDestinatario(rutDestinatario);
        valija.setRutRemitente(rutRemitente);   
        ListaEntregas.insertar(valija);
        
        for(int j=0;j<ListaClientes.size();j++) {
            Cliente c =ListaClientes.get(j);
            String rutpersona = c.getRut();
            if(rutpersona.equals(rutRemitente) ) {
                c.getlEnvioRemitente().insertar(valija);
                boolean ciudadExiste = verificarCiudad(c.getCiudad());
                if(ciudadExiste){
                    for (int i = 0; i < ListaCiudades.size(); i++) {
                        Ciudad ciudad = ListaCiudades.get(i);
                        if(ciudad.getNombre().equals(c.getCiudad())){
                            ciudad.setCantEnviados(ciudad.getCantEnviados()+1);
                            ciudad.setGanancia(ciudad.getGanancia()+valija.valor());
                        }
                    }
                }
                
                
            }else if(rutpersona.equals(rutDestinatario)) {
                c.getlEnvioDestinatario().insertar(valija);
                boolean ciudadExiste = verificarCiudad(c.getCiudad());
                if(ciudadExiste){
                    for (int i = 0; i < ListaCiudades.size(); i++) {
                    Ciudad ciudad = ListaCiudades.get(i);
                        if(ciudad.getNombre().equals(c.getCiudad())){
                            ciudad.setCantRecibidos(ciudad.getCantRecibidos()+1);
                        }
                    }
                }
                
            }
        }
        
    }

    @Override
    public boolean verificarParametro(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material){
        switch (tipoEntrega) {
            case "Documento":
            {
                Double pesoVer = peso/1000;
                
                Double grosorVer = grosor/10;
                
                if(pesoVer <= 1.5 && grosorVer <= 5){
                    return true;
                }else{
                    return false;
                }
            }
            case "Encomienda":
            {
                Double pesoVer = peso/1000;
                Double largoVer = largo/1000;
                Double anchoVer = ancho/1000;                
                Double profundidadVer = profundidad/1000;
                
                if(pesoVer<50 && largoVer <1.2 && anchoVer < 0.8 && profundidadVer < 0.8){
                    return true;
                }else{
                    return false;
                }
            }
            case "Valija":
                Double pesoVer = peso/1000;
                if((material.equals("cuero") || material.equals("plastico") || material.equals("tela")) && pesoVer <2){
                    return true;
                }else{
                    return false;
                }
            default:
                break;
        }
        return false;
        
    }
    
    @Override
    public boolean verificarRut(String rut) {
        for (int i = 0; i < ListaClientes.size(); i++) {
            Cliente cliente = ListaClientes.get(i);
            if(cliente.getRut().equals(rut)){
                return true;
            }
        }
        return false;
    }

    
    
    @Override
    public boolean descontarVerificarSueldo(String rut, int pago) { 
        for (int i = 0; i < ListaClientes.size(); i++) {
            Cliente cliente = ListaClientes.get(i);
            if(cliente.getRut().equals(rut)){
                if(cliente.getSaldo()<pago){
                    return false;
                }
                else{
                    cliente.setSaldo(cliente.getSaldo()-pago);
                    for (int j = 0; j < ListaCiudades.size(); j++) {
                        Ciudad ciudad = ListaCiudades.get(j);
                        if(cliente.getCiudad().equals(ciudad.getNombre())){
                            ciudad.setGanancia(ciudad.getGanancia()+pago);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean entregaConfirmada(String tipoEntrega, String rutRemitente, String rutDestinatario, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material){
        Random r = new Random();
        int codigoNew = r.nextInt(999999);
        String codigoNuevo= String.valueOf(codigoNew);
        switch (tipoEntrega) {
            case "Documento":
            {   
                Envio documento = new Documento( null, peso, grosor);
                if(documento instanceof Documento){
                    documento.setCodigo(codigoNuevo);
                    documento.setRutDestinatario(rutDestinatario);
                    documento.setRutRemitente(rutRemitente);
                    
                    for(int j=0;j<ListaClientes.size();j++) {
                        Cliente c =ListaClientes.get(j);
                        String rutpersona = c.getRut();
                        if(rutpersona.equals(rutRemitente) ) {
                            c.getlEnvioRemitente().insertar(documento);
                            boolean ciudadExiste = verificarCiudad(c.getCiudad());

                            if(ciudadExiste){
                                for (int i = 0; i < ListaCiudades.size(); i++) {
                                    Ciudad ciudad = ListaCiudades.get(i);
                                    if(ciudad.getNombre().equals(c.getCiudad())){
                                        ciudad.setCantEnviados(ciudad.getCantEnviados()+1);    
                                        ciudad.setGanancia(ciudad.getGanancia()+documento.valor());


                                    }
                                }
                            }


                        }else if(rutpersona.equals(rutDestinatario)) {

                            c.getlEnvioDestinatario().insertar(documento);

                            boolean ciudadExiste = verificarCiudad(c.getCiudad());

                            if(ciudadExiste){
                                for (int i = 0; i < ListaCiudades.size(); i++) {
                                Ciudad ciudad = ListaCiudades.get(i);
                                    if(ciudad.getNombre().equals(c.getCiudad())){

                                        ciudad.setCantRecibidos(ciudad.getCantRecibidos()+1);

                                    }
                                }
                            }

                        }
                    }
                    
                    return true;
                }
                
            }
            case "Encomienda":
            {
                Envio encomienda = new Encomienda ( null,  peso,  largo,  ancho,  profundidad);
                
                if(encomienda instanceof Encomienda){
                    encomienda.setCodigo(codigoNuevo);
                    encomienda.setRutDestinatario(rutDestinatario);
                    encomienda.setRutRemitente(rutRemitente);
                    
                    for(int j=0;j<ListaClientes.size();j++) {
                        Cliente c =ListaClientes.get(j);
                        String rutpersona = c.getRut();
                        if(rutpersona.equals(rutRemitente) ) {
                            c.getlEnvioRemitente().insertar(encomienda);
                            boolean ciudadExiste = verificarCiudad(c.getCiudad());
                            if(ciudadExiste){
                                for (int i = 0; i < ListaCiudades.size(); i++) {
                                    Ciudad ciudad = ListaCiudades.get(i);
                                    if(ciudad.getNombre().equals(c.getCiudad())){
                                        ciudad.setCantEnviados(ciudad.getCantEnviados()+1);                               
                                        ciudad.setGanancia(ciudad.getGanancia()+encomienda.valor());
                                    }
                                }
                            }


                        }else if(rutpersona.equals(rutDestinatario)) {
                            c.getlEnvioDestinatario().insertar(encomienda);
                            boolean ciudadExiste = verificarCiudad(c.getCiudad());

                            if(ciudadExiste){
                                for (int i = 0; i < ListaCiudades.size(); i++) {
                                Ciudad ciudad = ListaCiudades.get(i);
                                    if(ciudad.getNombre().equals(c.getCiudad())){
                                        ciudad.setCantRecibidos(ciudad.getCantRecibidos()+1);
                                    }
                                }
                            }

                        }
                    }
                    
                    
                    return true;
                }
                
            }
            case "Valija":
            {
                Envio valija = new Valija( null,  peso,  material);
                if(valija instanceof Valija){
                    valija.setCodigo(codigoNuevo);
                    valija.setRutDestinatario(rutDestinatario);
                    valija.setRutRemitente(rutRemitente);
                    
                    for(int j=0;j<ListaClientes.size();j++) {
                        Cliente c =ListaClientes.get(j);
                        String rutpersona = c.getRut();
                        if(rutpersona.equals(rutRemitente) ) {
                            c.getlEnvioRemitente().insertar(valija);
                            boolean ciudadExiste = verificarCiudad(c.getCiudad());
                            if(ciudadExiste){
                                for (int i = 0; i < ListaCiudades.size(); i++) {
                                    Ciudad ciudad = ListaCiudades.get(i);
                                    if(ciudad.getNombre().equals(c.getCiudad())){
                                        ciudad.setCantEnviados(ciudad.getCantEnviados()+1);
                                        ciudad.setGanancia(ciudad.getGanancia()+valija.valor());
                                    }
                                }
                            }


                        }else if(rutpersona.equals(rutDestinatario)) {
                            c.getlEnvioDestinatario().insertar(valija);
                            boolean ciudadExiste = verificarCiudad(c.getCiudad());
                            if(ciudadExiste){
                                for (int i = 0; i < ListaCiudades.size(); i++) {
                                Ciudad ciudad = ListaCiudades.get(i);
                                    if(ciudad.getNombre().equals(c.getCiudad())){
                                        ciudad.setCantRecibidos(ciudad.getCantRecibidos()+1);
                                    }
                                }
                            }

                        }
                    }
                    
                    return true;
                }
                
            }
            default:
                break;
        }
        return false;
        
    }

    @Override
    public void recargarSaldo(String rut, int saldo) {
        for (int i = 0; i < ListaClientes.size(); i++) {
            Cliente cliente = ListaClientes.get(i);
            if(cliente.getRut().equals(rut)){
                cliente.setSaldo(cliente.getSaldo()+saldo);
            }
        }
    }

    @Override
    public String obtenerEntregas(String rut) {
        String salida = "";
        for (int i = 0; i < ListaClientes.size(); i++) {
            Cliente cliente = ListaClientes.get(i);
            if(cliente.getRut().equals(rut)){
                ListaDobleNexo lremitente = cliente.getlEnvioRemitente();
                ListaDobleNexo ldestinatario = cliente.getlEnvioDestinatario();
                
                salida += "La cantidad de envios son: "+lremitente.size();
                for (int j = 0; j < lremitente.size(); j++) {
                    Envio envio = lremitente.getElemento(j);
                    if(envio instanceof Documento){
                        Documento documento = (Documento) envio;
                        salida += "\n\tCodigo: "+ documento.getCodigo()+", Peso: "+documento.getPeso()+", grosor: "+documento.getGrosor();
                    }else if(envio instanceof Encomienda){
                        Encomienda encomienda = (Encomienda) envio;
                        salida += "\n\tCodigo: "+ encomienda.getCodigo()+", Peso: "+encomienda.getPeso()+", Largo: "+encomienda.getLargo()+", Ancho: "+encomienda.getAncho()+", Profundidad: "+encomienda.getProfundidad();
                    }
                    else{
                        Valija valija = (Valija) envio;
                        salida += "\n\tCodigo: "+ valija.getCodigo()+", Peso: "+valija.getPeso()+", Material: "+valija.getMaterial();
                    }
                }
                
                salida += "\nLa cantidad de recivos son: "+ldestinatario.size();
                for (int j = 0; j < ldestinatario.size(); j++) {
                    Envio envio = ldestinatario.getElemento(j);
                    if(envio instanceof Documento){
                        Documento documento = (Documento) envio;
                        salida += "\n\tCodigo: "+ documento.getCodigo()+", Peso: "+documento.getPeso()+", grosor: "+documento.getGrosor();
                    }else if(envio instanceof Encomienda){
                        Encomienda encomienda = (Encomienda) envio;
                        salida += "\n\tCodigo: "+ encomienda.getCodigo()+", Peso: "+encomienda.getPeso()+", Largo: "+encomienda.getLargo()+", Ancho: "+encomienda.getAncho()+", Profundidad: "+encomienda.getProfundidad();
                    }
                    else{
                        Valija valija = (Valija) envio;
                        salida += "\n\tCodigo: "+ valija.getCodigo()+", Peso: "+valija.getPeso()+", Material: "+valija.getMaterial();
                    }
                }
            }
        }
        return salida;
    }

    @Override
    public String obtenerEntregasPorTipo() {
        String salida = "";
        for (int i = 0; i < ListaEntregas.size(); i++) {
            Envio envio = ListaEntregas.getElemento(i);
            if(envio instanceof Documento){
                Documento documento = (Documento) envio;
                salida +="\n\tTipo Entrega: Documento, Codigo: "+documento.getCodigo()+", Rut Remitente: "+documento.getRutRemitente()+", Rut Destinatario: "+documento.getRutDestinatario()
                            +", Peso: "+documento.getPeso()+", Grosor: "+documento.getGrosor()+", Valor: "+documento.valor()+" CLP";
            }else if (envio instanceof Encomienda){
                Encomienda encomienda = (Encomienda) envio;
                salida +="\n\tTipo Entrega: Documento, Codigo: "+encomienda.getCodigo()+", Rut Remitente: "+encomienda.getRutRemitente()+", Rut Destinatario: "
                            +encomienda.getRutDestinatario()+ ", Peso: "+encomienda.getPeso()+", Largo: "+encomienda.getLargo()+", Ancho: "+encomienda.getAncho()+", Profundidad: "+encomienda.getProfundidad()+", Valor: "+encomienda.valor()+" CLP";
            }else{
                Valija valija = (Valija) envio;
                salida +="\n\tTipo Entrega: Documento, Codigo: "+valija.getCodigo()+", Rut Remitente: "+valija.getRutRemitente()+", Rut Destinatario: "+valija.getRutDestinatario()
                            +", Peso: "+valija.getPeso()+", Material: "+valija.getMaterial()+", Valor: "+valija.valor()+" CLP";
            }
        }
        return salida;
    }

    @Override
    public String obtenerEntregasPorLocalizacion() {
        String salida ="";
        for (int i = 0; i < ListaCiudades.size(); i++) {
            Ciudad ciudad = ListaCiudades.get(i);
            salida +="\n"+ciudad.getNombre()+" realizo "+ciudad.getCantEnviados()+" envíos y recibió "+ciudad.getCantRecibidos()+" envios";
            
        }
        return salida;
    }

    @Override
    public String obtenerEntregasCliente() {
        String salida = "";
        for (int i = 0; i < ListaClientes.size(); i++) {
            Cliente cliente = ListaClientes.get(i);
             ListaDobleNexo ListaEntregasCliente = cliente.getlEnvioRemitente();
             for (int j = 0; j < ListaEntregasCliente.size(); j++) {
                Envio envio = ListaEntregasCliente.getElemento(j);
                if(envio instanceof Documento){
                    Documento documento = (Documento) envio;
                    salida +="\n\tTipo Entrega: Documento, Codigo: "+documento.getCodigo()+", Rut Remitente: "+documento.getRutRemitente()+", Rut Destinatario: "+documento.getRutDestinatario()
                            +", Peso: "+documento.getPeso()+", Grosor: "+documento.getGrosor();
                }else if (envio instanceof Encomienda){
                    Encomienda encomienda = (Encomienda) envio;
                    salida +="\n\tTipo Entrega: Encomienda, Codigo: "+encomienda.getCodigo()+", Rut Remitente: "+encomienda.getRutRemitente()+", Rut Destinatario: "
                            +encomienda.getRutDestinatario()+ ", Peso: "+encomienda.getPeso()+", Largo: "+encomienda.getLargo()+", Ancho: "+encomienda.getAncho()+", Profundidad: "+encomienda.getProfundidad();
                }else{
                    Valija valija = (Valija) envio;
                    salida +="\n\tTipo Entrega: Valija, Codigo: "+valija.getCodigo()+", Rut Remitente: "+valija.getRutRemitente()+", Rut Destinatario: "+valija.getRutDestinatario()
                            +", Peso: "+valija.getPeso()+", Material: "+valija.getMaterial();
                }
            }
        }
        return salida;
    }

    @Override
    public String obtenerBalanceOficina() {
        String salida = "";
        salida += "Balance por oficina Stakon: ";
        for (int i = 0; i < ListaCiudades.size(); i++) {
            Ciudad ciudad = ListaCiudades.get(i);
            salida += "\nNombre ciudad oficina: "+ciudad.getNombre()+", Recaudaci+on: "+ciudad.getGanancia();
        }
        return salida;
    }

    @Override
    public String obtenerBalanceTotal() {
       int balanceTotal = 0;
       String salida = "";
       
        for (int i = 0; i < ListaCiudades.size(); i++) {
            Ciudad ciudad = ListaCiudades.get(i);
            balanceTotal += ciudad.getGanancia();
        }
        
        return salida +="Balance total Stakon: "+balanceTotal;
    }

    @Override
    public String obtenerClientesSobrescribir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerEntregasSobrescribir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerPrecio(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material) {
        switch (tipoEntrega) {
            case "Documento":
            {   
                Envio documento = new Documento( null, peso, grosor);
                if(documento instanceof Documento){
                    
                    int pago = documento.valor();
                    System.out.println(pago);
                    
                    return pago;
                }
                
            }
            case "Encomienda":
            {
                Envio encomienda = new Encomienda ( null,  peso,  largo,  ancho,  profundidad);
                
                if(encomienda instanceof Encomienda){
                    int pago = encomienda.valor();
                    
                    return pago;
                }
                
            }
            case "Valija":
            {
                Envio valija = new Valija( null,  peso,  material);
                if(valija instanceof Valija){
                    int pago = valija.valor();
                    
                    return pago;
                }
                
            }
            default:
                break;
        }
        return -1;
    }
    
}
