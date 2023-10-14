package br.com.projetocliente.dao;
import br.com.projetocliente.model.Profissao;
import br.com.projetocliente.model.Usuario;
import br.com.projetocliente.util.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class UsuarioDAOImpl implements GenericDAO {

    private Connection conn;
    
    public UsuarioDAOImpl() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override // sobrescrita
    public Boolean cadastrar(Object object) {
        
        Usuario usuario = (Usuario) object;
        PreparedStatement stmt = null;
        
        String sql = "insert into usuario(nomeusuario, loginusuario, senhausuario) values(?, ?, ?);";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeUsuario());
            stmt.setString(2, usuario.getLoginUsuario());
            stmt.setString(3,usuario.getSenhaUsuario());
            stmt.execute(); //é a persistência com o banco de dados
            return true; // retorna para a dao Verdadeiro - funfo
        }catch(Exception e){
            System.out.println("Problemas ao cadastrar o usuário. Erro" + e.getMessage());
            e.printStackTrace();
            return false; // vai retornar para dao Falso - deu ruim, não funfo
        }finally{
            try{
               ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão! Erro" + ex.getMessage());
            }
        }
    }
    
    public Object logarUsuario (String login, String senha) {
     
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        Usuario usuario = null;
        String sql = "select * from usuario where loginusuario = ? and senhausuario = ?;";
        
        try{
         stmt = conn.prepareStatement(sql);
         stmt.setString(1, login);
         stmt.setString(2, senha);
         rs = stmt.executeQuery();
         
         while(rs.next()){ //enquanto existir um próximo registro no ResultSet faça ...
             usuario = new Usuario(); //criar objeto
             usuario.setLoginUsuario(rs.getString("loginusuario"));
             usuario.setSenhaUsuario(rs.getString("senhausuario"));
             usuario.setNomeUsuario(rs.getString("nomeusuario"));
             
            }
        }catch(SQLException ex){
            System.out.println("Problemas ao encontrar usuário. " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception ex){
                 System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                 ex.printStackTrace();
            }
        }
        return usuario; //retornar para a servlet
    }

    
    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    

    