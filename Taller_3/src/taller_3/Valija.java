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
public class Valija extends Envio{
    private String material;

    public Valija(String codigo, Double peso, String material) {
        super(codigo, peso);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    int valor() {
        int precioMaterial = precioPorMaterial(material);
        Double pesoKg = peso/1000;
        int pago = (int) (precioMaterial*pesoKg*150);
        return pago;
    }
    
    public int precioPorMaterial(String material){
        switch(material){
            case("Cuero"):
                return 200;
            case("Plastico"):
                return 150;
            case("Tela"):
                return 100;
            default:
                throw new IllegalArgumentException("El tipo de material no existe en el sistema");
        }
    }
    
}
