/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BELLA
 */
public class MaquinaModel {

    private Integer idMaquina;

    public MaquinaModel(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public MaquinaModel() {
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    @Override
    public String toString() {
        return "\nMaquinaModel: " + idMaquina;
    }

}
