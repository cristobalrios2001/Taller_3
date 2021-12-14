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
public class ListaDobleNexo {
    private NodoDoble first;
    

    public ListaDobleNexo() {
        first = null;
    }
    
    public boolean isEmpty(){
        if(first == null){
            return true;
        }
        return false;
    }
    
    
    public void insertar(Envio envio){
        NodoDoble nuevo = new NodoDoble(envio);
        if(isEmpty() == true){
            first = nuevo;
            first.setNext(first);
            first.setPrev(first);
            
        }else{
            nuevo.setNext(first);
            first.getPrev().setNext(nuevo);
            nuevo.setPrev(first.getPrev());
            first.setPrev(nuevo);                     
            
        }
        first = nuevo;
        
    }
    
    public Envio buscar (String codigo){
        NodoDoble current = first;
        
        do{
            if(current.getEnvio().getCodigo().equals(codigo)){
                return current.getEnvio();
                
            }
            current.getNext();
        }while(current != first);
        return null;
        
    }
    
    
    
}
