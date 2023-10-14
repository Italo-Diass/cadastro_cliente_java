package br.com.projetocliente.dao;

import br.com.projetocliente.model.Pessoa;
import br.com.projetocliente.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;



public class PessoaDAOImpl {
    
     private Connection conn;
    
    public PessoaDAOImpl() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }
    
    public Integer cadastrar(Pessoa pessoa) {
        
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Integer idPessoa = null;
        
        String sql = "insert into pessoa(nomepessoa, enderecopessoa, cidadepessoa, estadopessoa) values(?, ?, ?, ?) returning idpessoa;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEnderecoPessoa());
            stmt.setString(3, pessoa.getCidadePessoa());
            stmt.setString(4, pessoa.getEstadoPessoa());
            rs = stmt.executeQuery(); //é a persistência com o banco de dados
           if (rs.next()) {
               idPessoa = rs.getInt("idpessoa");
           }
        } catch(SQLException e){
            System.out.println("Problemas ao cadastrar o cliente. Erro" + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
               ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão! Erro" + ex.getMessage());
            }
        } 
        return idPessoa;
    }
    
    public Boolean alterar(Pessoa pessoa) {
        PreparedStatement stmt = null;
        String sql = "update pessoa set nomepessoa = ?, enderecopessoa = ?, cidadepessoa = ?, estadopessoa = ? where idpessoa = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, pessoa.getNomePessoa());
            stmt.setString(2, pessoa.getEnderecoPessoa());
            stmt.setString(3, pessoa.getCidadePessoa());
            stmt.setString(4, pessoa.getEstadoPessoa());
            stmt.setInt(5, pessoa.getIdPessoa());
            stmt.executeUpdate();
            return true;
            
        }catch (SQLException ex) {
            System.out.println("Problemas ao alterar Pessoa! Erro" + ex.getMessage());
            return false;
        }finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            }catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro" + ex.getMessage());        
            }
        }
    }
}
