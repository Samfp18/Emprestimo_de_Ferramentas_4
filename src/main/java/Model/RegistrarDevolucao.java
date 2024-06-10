/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author samue
 */
public class RegistrarDevolucao extends visao.FrmRegistrarDevolucao {
    private int DataD;

    public RegistrarDevolucao() {
        this(0);
    }

    public RegistrarDevolucao(int DataD) {
        this.DataD = DataD;
    }

    public int getDataD() {
        return DataD;
    }

    public void setDataD(int DataD) {
        this.DataD = DataD;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

