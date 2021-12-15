/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller_3;

/**
 *
 * @author crist
 */
public class Cliente {
    private String rut;
    private String nombre;
    private String apellido;
    private int saldo;
    private String ciudad;
    private ListaDobleNexo lEnvio;
    
    private ListaDobleNexo lEnvioRemitente;
    private ListaDobleNexo lEnvioDestinatario;

    public Cliente(String rut, String nombre, String apellido, int saldo, String ciudad) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
        this.ciudad = ciudad;
        lEnvioRemitente = new ListaDobleNexo();
        lEnvioDestinatario = new ListaDobleNexo();
        
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ListaDobleNexo getlEnvio() {
        return lEnvio;
    }

    public void setlEnvio(ListaDobleNexo lEnvio) {
        this.lEnvio = lEnvio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public ListaDobleNexo getlEnvioRemitente() {
        return lEnvioRemitente;
    }

    public ListaDobleNexo getlEnvioDestinatario() {
        return lEnvioDestinatario;
    }
    
    
}
