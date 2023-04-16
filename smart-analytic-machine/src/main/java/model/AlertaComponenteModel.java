/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BELLA
 */
public class AlertaComponenteModel {

    private Integer alertaComponenteId;
    private Integer componenteFk;
    private Integer alertaFk;

    public AlertaComponenteModel(Integer alertaComponenteId, Integer componenteFk, Integer alertaFk) {
        this.alertaComponenteId = alertaComponenteId;
        this.componenteFk = componenteFk;
        this.alertaFk = alertaFk;
    }

    public AlertaComponenteModel() {
    }
    
    

    public Integer getAlertaComponenteId() {
        return alertaComponenteId;
    }

    public Integer getComponenteFk() {
        return componenteFk;
    }

    public Integer getAlertaFk() {
        return alertaFk;
    }

    public void setAlertaComponenteId(Integer alertaComponenteId) {
        this.alertaComponenteId = alertaComponenteId;
    }

    public void setComponenteFk(Integer componenteFk) {
        this.componenteFk = componenteFk;
    }

    public void setAlertaFk(Integer alertaFk) {
        this.alertaFk = alertaFk;
    }

    @Override
    public String toString() {
        return "\nAlertaComponenteModel: "
                + "\nalertaComponenteId: " + alertaComponenteId
                + "\ncomponenteFk: " + componenteFk
                + "\nalertaFk: " + alertaFk;
    }

}
