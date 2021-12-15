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
    private int size;

    public ListaDobleNexo() {
        first = null;
        size = 0;
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
        size++;
        
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
    
    public int size(){
        return size;
    }
    
    public Envio getElemento (int posicion){
        NodoDoble current = first;
        int posCurrent = 0;
        do{
            if(posCurrent == posicion){
                return current.getEnvio();
            }
            posCurrent++;
            current = current.getNext();
        }
        while (current != first);
        return null;
    }
    
    
    
}
