/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Tarefa;
import java.sql.SQLException;
import util.ConnectionFactory;

/**
 *
 * @author pablo
 */
public class TarefaController {
    public void cadastrar(Tarefa tarefa){
        String sql = "INSERT INTO tarefa (IdProjeto,"
                + "Nome,"
                + "Descricao,"
                + "Completado,"
                + "Observacao,"
                + "Prazo,"
                + "DataCriacao,"
                + "DataAtualizacao) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            // Estabelecendo a conexão com o banco
            conn = ConnectionFactory.getConnection();
            // Preparando a querry
            statement = conn.prepareStatement(sql);
            // Setando os valores
            statement.setInt(1,tarefa.getIdProjeto());
            statement.setString(2,tarefa.getNome());
            statement.setString(3,tarefa.getDescricao());
            statement.setBoolean(4,tarefa.isCompletado());
            statement.setString(5,tarefa.getObservacao());
            statement.setDate(6,new Date(tarefa.getPrazo().getTime()));
            statement.setDate(7,new Date(tarefa.getDataCriacao().getTime()));
            statement.setDate(8,new Date(tarefa.getDataAtualizacao().getTime()));
            //Executando a querry
            statement.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao salvar a tarefa "+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn,statement);
        }
    }
    
    public void atualizar(Tarefa tarefa){
        String sql = "UPDATE tarefa SET "
                + "IdProjeto = ?, "
                + "Nome = ?,"
                + "Descricao = ?, "
                + "Completado = ?, "
                + "Observacao = ?, "
                + "Prazo = ?,"
                + "DataCriacao = ?, "
                + "DataAtualizacao = ? "
                + "WHERE Id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        try{
            // Estabelecendo a conexão com o banco
            conn = ConnectionFactory.getConnection();
             // Preparando a querry
            statement = conn.prepareStatement(sql);
             // Setando os valores
            statement.setInt(1,tarefa.getIdProjeto());
            statement.setString(2,tarefa.getNome());
            statement.setString(3,tarefa.getDescricao());
            statement.setBoolean(4,tarefa.isCompletado());
            statement.setString(5,tarefa.getObservacao());
            statement.setDate(6,new Date(tarefa.getPrazo().getTime()));
            statement.setDate(7,new Date(tarefa.getDataCriacao().getTime()));
            statement.setDate(8,new Date(tarefa.getDataAtualizacao().getTime()));
            statement.setInt(9,tarefa.getId());
            //Executando a querry
            statement.execute();
            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao atualizar a tarefa"+ex.getMessage(),ex);
        }
    }
    
    public void removerPorId(int Idtarefa){
        String sql = "DELETE FROM tarefa WHERE Id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            // Estabelecendo a conexão com o banco
            conn = ConnectionFactory.getConnection();
            // Preparando a querry
            statement = conn.prepareStatement(sql);
             // Setando os valores
            statement.setInt(1, Idtarefa);
            //Executando a querry
            statement.execute();
        }catch(SQLException ex){
           throw new RuntimeException("Erro ao deletar a tarefa"+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn,statement);
        }
    }
    
    public List<Tarefa> buscarTodos(int Idprojeto){
        String sql = "SELECT * FROM tarefa WHERE IdProjeto = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultset = null;
        List<Tarefa> tarefas = new ArrayList<Tarefa>();
        
        try{
            // Estabelecendo a conexão com o banco
            conn = ConnectionFactory.getConnection();
            // Preparando a querry
            statement = conn.prepareStatement(sql);
             // Setando o valor que corresponde ao filtro de busca
            statement.setInt(1,Idprojeto);
            //Executando a querry
            resultset = statement.executeQuery();
            
            //Enquanto houverem valores a serem percorridos  no meu resultset
            while(resultset.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultset.getInt("Id"));
                tarefa.setIdProjeto(resultset.getInt("IdProjeto"));
                tarefa.setNome(resultset.getString("Nome"));
                tarefa.setDescricao(resultset.getString("Descricao"));
                tarefa.setObservacao(resultset.getString("Observacao"));
                tarefa.setCompletado(resultset.getBoolean("Completado"));
                tarefa.setPrazo(resultset.getDate("Prazo"));
                tarefa.setDataCriacao(resultset.getDate("DataCriacao"));
                tarefa.setDataAtualizacao(resultset.getDate("DataAtualizacao"));
                tarefas.add(tarefa);
            }
        }catch(SQLException ex){
             throw new RuntimeException("Erro ao buscar as tarefa"+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn,statement,resultset);
        }
        //Lista de tarefas que foi criada e carregada do banco de dados
        return tarefas;
    }
}
