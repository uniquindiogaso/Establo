/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package establo;

public class Caballo {

    private String nombre;
    private char establo;
    private int numero;
    private Jinete[] jinetes;

    public Caballo(String nombre, char establo, int numero) {
        this.nombre = nombre;
        this.establo = establo;
        this.numero = numero;

        jinetes = new Jinete[5];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getEstablo() {
        return establo;
    }

    public void setEstablo(char establo) {
        this.establo = establo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Jinete[] getJinetes() {
        return jinetes;
    }

    public void setJinetes(Jinete[] jinetes) {
        this.jinetes = jinetes;
    }

    public int contarJinetes() {
        int cont = 0;
        for (int i = 0; i < jinetes.length; i++) {
            if (jinetes[i] == null) {
                cont++;
            }
        }
        return cont;
    }
    
    public double mejorTiempo(){
        
        double mejor = Double.MAX_VALUE;
        
        for (int i = 0; i < jinetes.length; i++) {
            if ( jinetes[i] != null){
                if (jinetes[i].getTiempo() < mejor){
                    mejor = jinetes[i].getTiempo();
                }
            }
        }
        
        return mejor;
        
        
    }
}
