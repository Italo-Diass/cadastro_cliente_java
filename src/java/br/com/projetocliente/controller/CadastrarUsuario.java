package br.com.projetocliente.controller;


import br.com.projetocliente.dao.GenericDAO;
import br.com.projetocliente.dao.UsuarioDAOImpl;
import br.com.projetocliente.model.Profissao;
import br.com.projetocliente.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //recebe os parametros do formulario por meio do (name="nomeDoInput")
            //nome do input tem que ser igual do request.parameter.
          String nomeUsuario = request.getParameter("nomeUsuario");
          String loginUsuario = request.getParameter("loginUsuario");
          String senhaUsuario = request.getParameter("senhaUsuario");
          
          
          String message;
          
          Usuario usuario = new Usuario();
          
          usuario.setNomeUsuario(nomeUsuario);
          usuario.setLoginUsuario(loginUsuario);
          usuario.setSenhaUsuario(senhaUsuario);
        
         
          
          //devolvendo para a camada controller tratando as excessões
          try{
              GenericDAO dao = new UsuarioDAOImpl();
                if(dao.cadastrar(usuario)){
                    message = "Usuário cadastrado com sucesso!!!"; //deu bom
                }else{
                    message = "Problemas ao cadastrar o usuário"; //deu ruim, reve ai
                }
                request.setAttribute("message", message);
                request.getRequestDispatcher("index.jsp").forward(request, response);
          }catch(Exception e){
              System.out.println("Problemas na servlet ao cadastrar usuário. "
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