package br.com.projetocliente.dao;
import br.com.projetocliente.model.Carro;
import br.com.projetocliente.util.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarroDAOImpl implements GenericDAO {

    private Connection conn;
    
    public CarroDAOImpl() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override // sobrescrita
    public Boolean cadastrar(Object object) {

        Carro carro = (Carro) object;

        PreparedStatement stmt = null;
        
        String sql = "insert into carro(marcacarro, modelocarro, anocarro, corcarro) values(?, ?, ?, ?);";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, carro.getMarcaCarro());
            stmt.setString(2, carro.getModeloCarro());
            stmt.setInt(3, carro.getAnoCarro());
            stmt.setString(4, carro.getCorCarro());
            stmt.execute();
            return true;
        }catch(Exception e){
            System.out.println("Problemas ao cadastrar o carro. Erro" + e.getMessage());
            e.printStackTrace();
            return false;
        }finally{
            try{
               ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão! Erro" + ex.getMessage());
            }
        }
        
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