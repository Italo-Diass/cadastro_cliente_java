package br.com.projetocliente.controller;

import br.com.projetocliente.dao.ClienteDAOImpl;
import br.com.projetocliente.dao.GenericDAO;
import br.com.projetocliente.model.Cliente;
import br.com.projetocliente.model.Profissao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente"})
public class CadastrarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //recebe os parametros do formulario por meio do (name="nomeDoInput")
            //nome do input tem que ser igual do request.parameter.
          String nomePessoa = request.getParameter("nomePessoa");
          String enderecoPessoa = request.getParameter("enderecoPessoa");
          String telefoneCliente = request.getParameter("telefoneCliente");
          String cidadePessoa = request.getParameter("cidadePessoa");
          String estadoPessoa = request.getParameter("estadoPessoa");
          Integer idProfissao = Integer.parseInt(request.getParameter("idProfissao"));
          
          String mensagem;
          
          Cliente cliente = new Cliente();
          
          cliente.setNomePessoa(nomePessoa);
          cliente.setEnderecoPessoa(enderecoPessoa);
          cliente.setTelefoneCliente(telefoneCliente);
          cliente.setCidadePessoa(cidadePessoa);
          cliente.setEstadoPessoa(estadoPessoa);
          cliente.setProfissaoCliente(new Profissao(idProfissao));
         
          
          //devolvendo para a camada controller tratando as excessões
          try{
              GenericDAO dao = new ClienteDAOImpl();
                if(dao.cadastrar(cliente)){
                    mensagem = "Cliente cadastrado com sucesso!!!"; //deu bom
                }else{
                    mensagem = "Problemas ao cadastrar o cliente"; //deu ruim, reve ai
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("cadastrarcliente.jsp").forward(request, response);
          }catch(Exception e){
              System.out.println("Problemas na servlet ao cadastrar cliente. "
              + "Erro: " 
              + e.getMessage()); e.printStackTrace();
          }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}