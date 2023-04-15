/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BELLA
 */
public class LeituraModel {
    /* o que o looca pega
    
       Sistema sistema;
       Memoria memoria;
       Processador processador;
       Temperatura temperatura;
       DiscoGrupo grupoDeDiscos;
       ServicoGrupo grupoDeServicos;
       ProcessoGrupo grupoDeProcessos;*/
    
    /*tabela leitura
    CREATE TABLE tbLeitura(
	idLeitura INT PRIMARY KEY AUTO_INCREMENT,
	leitura DOUBLE NOT NULL, 
    dataHoraLeitura DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    fkConfig INT,
		CONSTRAINT fkConfig 
			FOREIGN KEY(fkConfig) REFERENCES tbConfig(idConfig),
	fkAlertaComponente INT,
		CONSTRAINT fkAlertaComponente
			FOREIGN KEY(fkAlertaComponente) REFERENCES tbAlertaComponente(idAlertaComponente)
);
    
    */    
    private Double leitura;

    public LeituraModel(Double leitura) {
        this.leitura = leitura;
    }

    public LeituraModel() {
    }
    
    
    public Double getLeitura() {
        return leitura;
    }

    public void setLeitura(Double leitura) {
        this.leitura = leitura;
    }

    @Override
    public String toString() {
        return "LeituraModel{" + "leitura=" + leitura + '}';
    }
    
    
   
    
    
}
