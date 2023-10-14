package br.com.projetocliente.dao;

import br.com.projetocliente.model.Profissao;
import br.com.projetocliente.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfissaoDAOImpl {

    private Connection conn;

    public ProfissaoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Object> carregarProfissoes() {

        List<Object> profissoes = new ArrayList<>(); //variável do tipo vetor
        PreparedStatement stmt = null; //classe para executar um sql
        ResultSet rs = null; //só utiliza-se para consultar o banco de dados

        String sql = "select * from profissao;"; // * -> all = todos / profissao -> nome da tabela

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(); // rs possui todos os registros que estão no banco de dados
            while (rs.next()) { //enquanto existir um próximo registro no ResultSet faça ...
                Profissao profissao = new Profissao(); //criar objeto
                profissao.setIdProfissao(rs.getInt("idprofissao"));
                profissao.setNomeProfissao(rs.getString("nomeprofissao"));//pega minha profissão já existente/cadastrado
                profissoes.add(profissao); //adicionar no vetor
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar profissões. " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e) {
                System.out.println("Erro ao fechar a conexão. " + e.getMessage());
                e.printStackTrace();
            }
        }
        return profissoes; //retornar para a servlet
    }
}
