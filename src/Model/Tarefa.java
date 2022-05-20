/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author pablo
 */
public class Tarefa {
    private int Id;
    private int IdProjeto;
    private String Nome;
    private String descricao;
    private boolean Completado;
    private String Observacao;
    private Date Prazo;
    private Date DataCriacao;
    private Date DataAtualizacao;

    public Tarefa(int Id, int IdProjeto, String Nome, String descricao, boolean Completado, String Observacao, Date Prazo, Date DataCriacao, Date DataAtualizacao) {
        this.Id = Id;
        this.IdProjeto = IdProjeto;
        this.Nome = Nome;
        this.descricao = descricao;
        this.Completado = Completado;
        this.Observacao = Observacao;
        this.Prazo = Prazo;
        this.DataCriacao = DataCriacao;
        this.DataAtualizacao = DataAtualizacao;
    }

    public Tarefa() {
        this.DataCriacao = new Date();
        this.DataAtualizacao = new Date();
    }


    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdProjeto() {
        return IdProjeto;
    }

    public void setIdProjeto(int IdProjeto) {
        this.IdProjeto = IdProjeto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCompletado() {
        return Completado;
    }

    public void setCompletado(boolean Completado) {
        this.Completado = Completado;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public Date getPrazo() {
        return Prazo;
    }

    public void setPrazo(Date Prazo) {
        this.Prazo = Prazo;
    }

    public Date getDataCriacao() {
        return DataCriacao;
    }

    public void setDataCriacao(Date DataCriacao) {
        this.DataCriacao = DataCriacao;
    }

    public Date getDataAtualizacao() {
        return DataAtualizacao;
    }

    public void setDataAtualizacao(Date DataAtualizacao) {
        this.DataAtualizacao = DataAtualizacao;
    }

    
    @Override
    public String toString() {
        return "Tarefa{" + "Id=" + Id + ", IdProjeto=" + IdProjeto + ", Nome=" + Nome + ", descricao=" + descricao + ", Completado=" + Completado + ", Observacao=" + Observacao + ", Prazo=" + Prazo + ", DataCriacao=" + DataCriacao + ", DataAtualizacao=" + DataAtualizacao + '}';
    }
    
    
}
