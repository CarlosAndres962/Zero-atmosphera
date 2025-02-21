/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zeroatmosf;

public abstract class Nave {

    protected int nruedas;
    protected double potencia;
    protected int nuMotores;
    protected String laboratorio;
    protected int tunCiclo;

    public Nave() {
    }

    public Nave(int nruedas, double potencia, int nuMotores, String laboratorio, int tunCiclo) {
        this.nruedas = nruedas;
        this.potencia = potencia;
        this.nuMotores = nuMotores;
        this.laboratorio = laboratorio;
        this.tunCiclo = tunCiclo;
    }

    public int getNruedas() {
        return nruedas;
    }

    public void setNruedas(int nruedas) {
        this.nruedas = nruedas;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public int getNuMotores() {
        return nuMotores;
    }

    public void setNuMotores(int nuMotores) {
        this.nuMotores = nuMotores;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getTunCiclo() {
        return tunCiclo;
    }

    public void setTunCiclo(int tunCiclo) {
        this.tunCiclo = tunCiclo;
    }

    @Override
    public String toString() {
        return "Nave" + "nruedas:" + nruedas + ", potencia: " + potencia + ", nuMotores:" + nuMotores + ", laboratorio:" + laboratorio + ", tunCiclo:" + tunCiclo;
    }

}