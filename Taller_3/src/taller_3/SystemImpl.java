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
    
    /**
     * Enter a customer into the system and associate it with a city
     * pos:
     *      Login a customer to the system
     * @param rut "rut" identifier of the person
     * @param nombre Name of person
     * @param apellido surname of the person
     * @param saldo person´s balance
     * @param ciudad name of the city
     * @return returns a boolean with the result of the operation
     */
    public boolean ingresarAsociarCliente(String rut, String nombre, String apellido, int saldo, String ciudad);
    
    /**
     * Enter a city to the system
     * pos:
     *      Enter a city to system
     * @param nombre name of the city
     * @return returns a boolean with the result of the operation
     */
    public boolean ingresarCiudad(String nombre);
    
    /**
     * Check if the city is on the list
     * @param nombreCiudad name of the city
     * @return returns a boolean with the result of the operation
     */
    public boolean verificarCiudad (String nombreCiudad);
    
    /**
     * enter a document to the person and system
     * pos:
     *      associate a shipment with a city and a person
     * @param codigo shipping code
     * @param rutRemitente "rut" identifier of the person who delivers the shipment
     * @param rutDestinatario "rut" identifier of the person who receives the shipment
     * @param peso shipping weight
     * @param grosor shipping thickness
     */
    public void ingresarDocumento(String codigo, String rutRemitente, String rutDestinatario, Double peso, Double grosor);
    
    /**
     * enter a entrust to the person and system
     * pos:
     *      associate a shipment with a city and a person
     * @param codigo shipping code
     * @param rutRemitente "rut" identifier of the person who delivers the shipment
     * @param rutDestinatario "rut" identifier of the person who receives the shipment
     * @param peso shipping weight
     * @param largo shipping length
     * @param ancho shipping width
     * @param profundidad shipping depth
     */
    public void ingresarEncomienda(String codigo, String rutRemitente, String rutDestinatario, Double peso, Double largo, Double ancho, Double profundidad );
    
    /**
     * You get the shipping cost
     * @param tipoEntrega delivery type
     * @param peso shipping weight
     * @param grosor shipping thickness
     * @param largo shipping length
     * @param ancho shipping width
     * @param profundidad shipping depth
     * @param material type of material
     * @return return a int with the price of the delivery
     */
    public int obtenerPrecio(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material); 
    
    /**
     * enter a suitcase to the person and system
     * pos:
     *      associate a shipment with a city and a person
     * @param codigo shipping code
     * @param rutRemitente "rut" identifier of the person who delivers the shipment
     * @param rutDestinatario "rut" identifier of the person who receives the shipment
     * @param material type of material
     * @param peso shipping weight
     */
    public void ingresarValija(String codigo, String rutRemitente, String rutDestinatario, String material, Double peso );
    
    /**
     * verifies if the entered parameters comply with the company standards
     * @param tipoEntrega delivery type
     * @param peso shipping weight
     * @param grosor shipping thickness
     * @param largo shipping length
     * @param ancho shipping width
     * @param profundidad shipping depth
     * @param material type of material
     * @return returns a boolean with the result of the operation
     */
    public boolean verificarParametro(String tipoEntrega, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material);
    /**
     * check if the rut is in the system
     * @param rut "rut" identifier of the person
     * @return returns a boolean with the result of the operation
     */
    public boolean verificarRut(String rut);
    
    /**
     * Balance is deducted from an account
     * pre:
     *      that account exits
     * pos:
     *      discount account balance
     * @param rut "rut" identifier of the person
     * @param saldo customer balance
     * @return returns a boolean with the result of the operation
     */
    public boolean descontarVerificarSueldo (String rut, int saldo);
    
    /**
     * confirm a shipment made
     * pos:
     *      a shipment is entered to the associated rout and to the city
     * @param tipoEntrega delivery type
     * @param rutRemitente "rut" identifier of the person who delivers the shipment
     * @param rutDestinatario "rut" identifier of the person who receives the shipment
     * @param peso shipping weight
     * @param grosor shipping thickness
     * @param largo shipping length
     * @param ancho shipping width
     * @param profundidad shipping depth
     * @param material type of material
     * @return returns a boolean with the result of the operation
     */
    public boolean entregaConfirmada(String tipoEntrega, String rutRemitente, String rutDestinatario, Double peso, Double grosor, Double largo, Double ancho, Double profundidad, String material);
    
    /**
     * top up the balance to an account
     * pos:
     *      Balance is recharged to the account
     * @param rut "rut" identifier of the person
     * @param saldo customer balance
     */
    public void recargarSaldo(String rut, int saldo);
    
    /**
     * get deliveries by entered rut
     * @param rut "rut" identifier of the person
     * @return return a String with the deliveries by entered rut
     */
    public String obtenerEntregas(String rut);
    
    /**
     * get deliveries for each type
     * @return return a String with deliveries for eacht type
     */
    public String obtenerEntregasPorTipo ();
    
    /**
     * get the number of deliveries and receipts from each office
     * @return returns a String with the information of each office
     */
    public String obtenerEntregasPorLocalizacion ();
    
    /**
     * get deliveries from each customer
     * @return return a String with deliveries from each customer
     */
    public String obtenerEntregasCliente();
    
    /**
     * Obtain the balance of each office of the company
     * @return return a String with the balance of each office
     */
    public String obtenerBalanceOficina();
    
    /**
     * The total balance of the company is obtained
     * @return return a String that contains the balance of the company
     */
    public String obtenerBalanceTotal();
    
    /**
     * Get You get clients for overwrite
     * @return return a String with the news clients
     */
    public String obtenerClientesSobrescribir();
    
    /**
     * You get deliveries for overwrite
     * @return return a String with the deliveries
     */
    public String obtenerEntregasSobrescribir();
}
