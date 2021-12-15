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
public interface SystemImpl {
    
    public boolean ingresarAsociarCliente(String rut, String nombre, String apellido, int saldo, String ciudad);
    
    public boolean ingresarCiudad(String nombre);
    
    public boolean verificarCiudad (String nombreCiudad);
    
    public void ingresarDocumento(String codigo, String rutRemitente, String rutDestinatario, Double peso, Double grosor);
    
    public void ingresarEncomienda(String codigo, String rutRemitente, String rutDestinatario, Double peso, Double largo, Double ancho, Double profundidad );
    
    public void ingresarValija(String codigo, String rutRemitente, String rutDestinatario, String material, Double peso );
    
    public boolean verificarParametro(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material);
    
    public boolean verificarRut(String rut);
    
    public boolean descontarVerificarSueldo (String rut, int saldo);
    
    public void recargarSaldo(String rut, int saldo);
    
    public String obtenerEntregas(String rut);
    
    public String obtenerEntregasPorTipo ();
    
    public String obtenerEntregasPorLocalizacion ();
    
    public String obtenerEntregasCliente();
    
    public String obtenerBalanceOficina();
    
    public String obtenerBalanceTotal();
    
    public String obtenerClientesSobrescribir();
    
    public String obtenerEntregasSobrescribir();
}
