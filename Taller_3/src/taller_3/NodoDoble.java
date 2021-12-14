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
public class NodoDoble {
    private Envio envio;
    private NodoDoble prev;
    private NodoDoble next;

    public NodoDoble(Envio envio) {
        this.envio = envio;
        
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public NodoDoble getPrev() {
        return prev;
    }

    public void setPrev(NodoDoble prev) {
        this.prev = prev;
    }

    public NodoDoble getNext() {
        return next;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }
    
    
}
