/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Projeto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
/**
 *
 * @author pablo
 */
public class ProjetoController {
    public void cadastrar(Projeto projeto){
        String sql = "INSERT INTO projetos (Nome, "
                + "Descricao, "
                + "DataCriacao, "
                + "DataAtualizacao) VALUES (?,?,?,?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
             // Estabelecendo a conexão com o banco
            conn = ConnectionFactory.getConnection();
            // Preparando a querry
            statement = conn.prepareStatement(sql);
            // Setando os valores
            statement.setString(1,projeto.getNome());
            statement.setString(2,projeto.getDescricao());
            statement.setDate(3,new Date(projeto.getDataCriacao().getTime()));
            statement.setDate(4,new Date(projeto.getDataAtualizacao().getTime()));
            //Executando a querry
            statement.execute();
        }catch(SQLException ex){
             throw new RuntimeException("Erro ao salvar o projeto "+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void atualizar(Projeto projeto){
        String sql = "UPDATE projetos SET "
                + "Nome = ?,"
                + "Descricao = ?,"
                + "DataCriacao = ?,"
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
            statement.setString(1,projeto.getNome());
            statement.setString(2,projeto.getDescricao());
            statement.setDate(3,new Date(projeto.getDataCriacao().getTime()));
            statement.setDate(4,new Date(projeto.getDataAtualizacao().getTime()));
            statement.setInt(5,projeto.getId());
            //Executando a querry
            statement.execute();
        }catch(SQLException ex){
             throw new RuntimeException("Erro ao atualizar o projeto "+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public List<Projeto> buscarTodos(){
        String sql = "SELECT * FROM projetos";
        List<Projeto> projetos = new ArrayList<Projeto>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultset = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultset = statement.executeQuery();
            
            while(resultset.next()){
                Projeto projeto = new Projeto();
                
                projeto.setId(resultset.getInt("Id"));
                projeto.setNome(resultset.getString("Nome"));
                projeto.setDescricao(resultset.getString("Descricao"));
                projeto.setDataCriacao(resultset.getDate("DataCriacao"));
                projeto.setDataAtualizacao(resultset.getDate("DataAtualizacao"));
                projetos.add(projeto);
            }
                
        }catch(SQLException ex){
             throw new RuntimeException("Erro ao buscar os projetos"+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement, resultset);
        }
        return projetos;
    }
    
    public void removerPorId(int Idprojeto){
        String sql = "DELETE FROM projetos WHERE Id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1,Idprojeto);
            statement.execute();
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao deletar os projetos"+ex.getMessage(),ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
}
