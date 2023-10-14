package br.com.projetocliente.controller;

import br.com.projetocliente.dao.UsuarioDAOImpl;
import br.com.projetocliente.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogarUsuario", urlPatterns = {"/LogarUsuario"})
public class LogarUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
            try{
                
                String loginUsuario = request.getParameter("loginUsuario");
                String senhaUsuario = request.getParameter("senhaUsuario");
                String message = null;  // messagem de entrada/ boas vindas
                
                if (!loginUsuario.equals("") && !senhaUsuario.equals("")){  // se o login e senha não forem vazios, sera obrigado a digitar e enviado mensagem, vai voltar pro login
                    
                    UsuarioDAOImpl dao = new UsuarioDAOImpl();
                    Usuario usuario = (Usuario) dao.logarUsuario(loginUsuario, senhaUsuario);
                    if (usuario != null) {
                        HttpSession sessao = request.getSession(true);  //nova classe, a httpsession gerencia sessoes, torna a verdadeira
                        sessao.setAttribute("usuario", usuario);
                        message = "Seja bem-vindo(a) " + usuario.getNomeUsuario();
                        sessao.setAttribute("message", message);
                        request.getRequestDispatcher("home.jsp").forward(request, response);
                    }else {
                        message = "Login ou Senha inválidos!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    }else {
                        message = "É necessário digitar Login e Senha!";
                        request.setAttribute("message", message);
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
            }catch(Exception e){
                System.out.println("Problemas ao logar! Erro: " + e.getMessage());
                e.printStackTrace();
                        
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
