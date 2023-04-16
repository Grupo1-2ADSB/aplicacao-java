/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BELLA
 */
public class ConfigModel {

    private Integer configId;
    private Integer maquinaFk;
    private Integer componenteFk;

    public ConfigModel(Integer configId, Integer maquinaFk, Integer componenteFk) {
        this.configId = configId;
        this.maquinaFk = maquinaFk;
        this.componenteFk = componenteFk;
    }

    public ConfigModel() {
    }
    
    

    public Integer getConfigId() {
        return configId;
    }

    public Integer getMaquinaFk() {
        return maquinaFk;
    }

    public Integer getComponenteFk() {
        return componenteFk;
    }

    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    public void setMaquinaFk(Integer maquinaFk) {
        this.maquinaFk = maquinaFk;
    }

    public void setComponenteFk(Integer componenteFk) {
        this.componenteFk = componenteFk;
    }

    @Override
    public String toString() {
        return "\nConfigModel: \n"
                + "configId: " + configId
                + "\nmaquinaFk: " + maquinaFk
                + "\ncomponenteFk: " + componenteFk;
    }

}
