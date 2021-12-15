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
abstract class Envio {
    private String codigo;
    Double peso;
    private String rutRemitente;
    private String rutDestinatario;

    public Envio(String codigo, Double peso) {
        this.codigo = codigo;
        this.peso = peso;
        rutRemitente = null;
        rutDestinatario = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRutRemitente() {
        return rutRemitente;
    }

    public void setRutRemitente(String rutRemitente) {
        this.rutRemitente = rutRemitente;
    }

    public String getRutDestinatario() {
        return rutDestinatario;
    }

    public void setRutDestinatario(String rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }
    
    
    
    abstract int valor ();
    
    
}
