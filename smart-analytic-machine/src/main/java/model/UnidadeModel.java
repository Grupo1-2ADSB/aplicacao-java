/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BELLA
 */
public class UnidadeModel {

    private Integer unidadeId;
    private Integer leituraFk;

    public UnidadeModel(Integer unidadeId, Integer leituraFk) {
        this.unidadeId = unidadeId;
        this.leituraFk = leituraFk;
    }

    public UnidadeModel() {
    }
    
    

    public Integer getUnidadeId() {
        return unidadeId;
    }

    public Integer getLeituraFk() {
        return leituraFk;
    }

    public void setUnidadeId(Integer unidadeId) {
        this.unidadeId = unidadeId;
    }

    public void setLeituraFk(Integer leituraFk) {
        this.leituraFk = leituraFk;
    }

    @Override
    public String toString() {
        return "UnidadeModel{" + "unidadeId=" + unidadeId + ", leituraFk=" + leituraFk + '}';
    }
    
    

}
