/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BELLA
 */
public class ComponenteModel {

    private Integer componenteId;
    private Integer tipoComponenteFk;

    public ComponenteModel(Integer componenteId, Integer tipoComponenteFk) {
        this.componenteId = componenteId;
        this.tipoComponenteFk = tipoComponenteFk;
    }

    public ComponenteModel() {
    }

    
    
    public Integer getComponenteId() {
        return componenteId;
    }

    public Integer getTipoComponenteFk() {
        return tipoComponenteFk;
    }

    public void setComponenteId(Integer componenteId) {
        this.componenteId = componenteId;
    }

    public void setTipoComponenteFk(Integer tipoComponenteFk) {
        this.tipoComponenteFk = tipoComponenteFk;
    }

    @Override
    public String toString() {
        return "\nComponenteModel: \n"
                + "componenteId: " + componenteId
                + "\ntipoComponenteFk: " + tipoComponenteFk;
    }

}
