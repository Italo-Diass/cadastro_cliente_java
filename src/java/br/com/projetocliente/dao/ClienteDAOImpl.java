package br.com.projetocliente.dao;
import br.com.projetocliente.model.Cliente;
import br.com.projetocliente.model.Profissao;
import br.com.projetocliente.util.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ClienteDAOImpl implements GenericDAO {

    private Connection conn;
    
    public ClienteDAOImpl() throws Exception {
        try{
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    @Override // sobrescrita
    public Boolean cadastrar(Object object) {
        
        Cliente cliente = (Cliente) object;
        PreparedStatement stmt = null;
        
        String sql = "insert into cliente(telefonecliente, idprofissao, idpessoa) values(?, ?, ?);";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getTelefoneCliente());
            stmt.setInt(2, cliente.getProfissaoCliente().getIdProfissao());
            stmt.setInt(3, new PessoaDAOImpl().cadastrar(cliente));
            stmt.execute(); //é a persistência com o banco de dados
            return true; // retorna para a dao Verdadeiro - funfo
        }catch(Exception e){
            System.out.println("Problemas ao cadastrar o cliente. Erro" + e.getMessage());
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

    @Override
    public List<Object> listar() {
     
        List<Object> clientes = new ArrayList<>(); //variável do tipo vetor
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados
        
        String sql = "select c.*, p.*, pe.* from cliente c, profissao p, pessoa pe where c.idprofissao = p.idprofissao and c.idpessoa = pe.idpessoa;"; // * -> all = todos, o c* e p* (cliente e profissao) encurtam o comando, da um novo nome as tabelas
        
        try{
         stmt = conn.prepareStatement(sql);
         rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
         while(rs.next()){ //enquanto existir um próximo registro no ResultSet faça ...
             Cliente cliente = new Cliente(); //criar objeto
             cliente.setIdCliente(rs.getInt("idcliente"));
             cliente.setIdPessoa(rs.getInt("idpessoa"));
             cliente.setNomePessoa(rs.getString("nomepessoa"));
             cliente.setEnderecoPessoa(rs.getString("enderecopessoa"));
             cliente.setTelefoneCliente(rs.getString("telefonecliente")); //pega meu cliente já existente/cadastrado
             cliente.setCidadePessoa(rs.getString("cidadepessoa"));
             cliente.setEstadoPessoa(rs.getString("estadopessoa"));
             cliente.setProfissaoCliente(new Profissao(rs.getInt("idprofissao")));
             cliente.setProfissaoCliente(new Profissao(rs.getString("nomeprofissao")));
             
             clientes.add(cliente); //adicionar no vetor
            }
        }catch(SQLException ex){
            System.out.println("Erro ao listar clientes. " + ex.getMessage());
            ex.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception e){
                 System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                 e.printStackTrace();
            }
        }
        return clientes; //retornar para a servlet
    }

    @Override
    public Boolean excluir(int idObject){
        PreparedStatement stmt = null;
        String sql = "delete from cliente where idpessoa = ?; commit; delete from pessoa where idpessoa = ?;"; // commit confirma as alterações feitas na base, como se salvasse a alteração, rollback desfaz tudo oq vc fez dps  do commit
        
        try{
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1, idObject);
           stmt.setInt(2, idObject);
           stmt.executeUpdate();
           return true;
        }catch(Exception e){
            System.out.println("Problemas ao excluir cliente. Erro " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object carregar(int idObject) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        String sql = "select c.*, p.*, pr.* from cliente c, pessoa p, profissao pr where c.idpessoa = p.idpessoa and c.idprofissao =pr.idprofissao and p.idpessoa = ?;";
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setIdPessoa(rs.getInt("idPessoa"));
                cliente.setNomePessoa(rs.getString("nomePessoa"));
                cliente.setEnderecoPessoa(rs.getString("enderecoPessoa"));
                cliente.setTelefoneCliente(rs.getString("telefoneCliente"));
                cliente.setCidadePessoa(rs.getString("cidadePessoa"));
                cliente.setEstadoPessoa(rs.getString("estadoPessoa"));
                cliente.setProfissaoCliente(new Profissao(rs.getInt("idProfissao")));
                cliente.setProfissaoCliente(new Profissao(rs.getString("nomeprofissao")));
                
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao carregar cliente. Erro: " + e.getMessage());
            e.printStackTrace();
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt, rs);
            }catch(Exception e){
                System.out.println("Erro ao fechar a conexão. Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return cliente;
    }

    @Override
    public Boolean alterar(Object object) {
        Cliente cliente = (Cliente) object;
        PreparedStatement stmt = null;
        
        String sql = "update cliente set telefonecliente = ?, idprofissao = ? where idpessoa = ?;"; 
        
        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getTelefoneCliente());
            stmt.setInt(2, cliente.getProfissaoCliente().getIdProfissao());
            stmt.setInt(3, cliente.getIdPessoa());
            if (new PessoaDAOImpl().alterar(cliente)) {
                
            stmt.executeUpdate();
            return true;
            } else {
                return false;
            }
        }catch(Exception e){
            System.out.println("Problemas ao alterar cliente. Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        finally{
            try{
                ConnectionFactory.closeConnection(conn, stmt);
            }catch(Exception ex){
                System.out.println("Problemas ao fechar a conexão. Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}