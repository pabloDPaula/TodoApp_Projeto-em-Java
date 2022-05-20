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
public class Projeto {
        private int Id;
        private String Nome;
        private String Descricao;
        private Date DataCriacao;
        private Date DataAtualizacao;

    public Projeto(int Id, String Nome, String Descricao, Date DataCriacao, Date DataAtualizacao) {
        this.Id = Id;
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.DataCriacao = DataCriacao;
        this.DataAtualizacao = DataAtualizacao;
    }

    public Projeto() {
        this.DataCriacao = new Date();
        this.DataAtualizacao = new Date();
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
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
        return this.Nome;
    }

        
    
        
}
