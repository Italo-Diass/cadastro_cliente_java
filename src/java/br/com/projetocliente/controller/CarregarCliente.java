package br.com.projetocliente.controller;

import br.com.projetocliente.dao.ClienteDAOImpl;
import br.com.projetocliente.dao.GenericDAO;
import br.com.projetocliente.dao.ProfissaoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CarregarCliente", urlPatterns = {"/CarregarCliente"})
public class CarregarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
             Integer idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
            
            try{
                GenericDAO dao = new ClienteDAOImpl();
                request.setAttribute("cliente", dao.carregar(idPessoa));
                
                ProfissaoDAOImpl daop = new ProfissaoDAOImpl();
                request.setAttribute("profissoes", daop.carregarProfissoes());
                
                request.getRequestDispatcher("carregarcliente.jsp").forward(request, response);
                                    
            }catch(Exception e){
                System.out.println("Problemas na Servlet ao carregar cliente. Erro: " + e.getMessage());
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
