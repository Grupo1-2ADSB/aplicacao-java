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
    private Integer nSerie;
    private String statusMaquina;
    private String modeloMaquina;
    private String tipoDisco;
    private String marca;
    private String tipoMaquina;
    private String dataManutencao;
    private String sistemaOperacional;
    private Integer arquiteturaCPU;
    private Integer fkUsuario;

    public MaquinaModel(Integer idMaquina, Integer nSerie,
            String statusMaquina, String modeloMaquina,
            String tipoDisco, String marca, String tipoMaquina,
            String dataManutencao, String sistemaOperacional,
            Integer arquiteturaCPU, Integer fkUsuario) {

        this.idMaquina = idMaquina;
        this.nSerie = nSerie;
        this.statusMaquina = statusMaquina;
        this.modeloMaquina = modeloMaquina;
        this.tipoDisco = tipoDisco;
        this.marca = marca;
        this.tipoMaquina = tipoMaquina;
        this.dataManutencao = dataManutencao;
        this.sistemaOperacional = sistemaOperacional;
        this.arquiteturaCPU = arquiteturaCPU;
        this.fkUsuario = fkUsuario;
    }

    public MaquinaModel() {
    }
    
    

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Integer getnSerie() {
        return nSerie;
    }

    public void setnSerie(Integer nSerie) {
        this.nSerie = nSerie;
    }

    public String getStatusMaquina() {
        return statusMaquina;
    }

    public void setStatusMaquina(String statusMaquina) {
        this.statusMaquina = statusMaquina;
    }

    public String getModeloMaquina() {
        return modeloMaquina;
    }

    public void setModeloMaquina(String modeloMaquina) {
        this.modeloMaquina = modeloMaquina;
    }

    public String getTipoDisco() {
        return tipoDisco;
    }

    public void setTipoDisco(String tipoDisco) {
        this.tipoDisco = tipoDisco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoMaquina() {
        return tipoMaquina;
    }

    public void setTipoMaquina(String tipoMaquina) {
        this.tipoMaquina = tipoMaquina;
    }

    public String getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(String dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public Integer getArquiteturaCPU() {
        return arquiteturaCPU;
    }

    public void setArquiteturaCPU(Integer arquiteturaCPU) {
        this.arquiteturaCPU = arquiteturaCPU;
    }

    public Integer getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Integer fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public String toString() {
        return String.format(
         """
         MaquinaModel
         idMaquina: %d | nSerie: %d | statusMaquina: %s | modeloMaquina: %s
         tipoDisco: %s | marca: %s | tipoMaquina: %s | dataManutencao: %s   
         sistemaOperacional: %s | arquiteturaCPU: %d | fkUsuario: %d
         """,
                idMaquina, nSerie, statusMaquina, modeloMaquina,
                tipoDisco, marca, tipoMaquina, dataManutencao,
                sistemaOperacional, arquiteturaCPU, fkUsuario
        );

    }

}
