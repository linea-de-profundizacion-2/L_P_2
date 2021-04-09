/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.jpa.entities;

import controlador.capcha.Paso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kefab
 */
@WebServlet(name = "proceso", urlPatterns = {"/control"}, initParams = {
    @WebInitParam(name = "user", value = "anderson")
    , @WebInitParam(name = "contraseña", value = "123")})
public class proceso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String usuario= request.getParameter("usua");
         String clave= request.getParameter("pass");
         
         String captcha = request.getParameter("g-recaptcha");
         boolean verif=Paso.verificar(captcha);
        String us= getServletConfig().getInitParameter(usuario);
        String passw= getServletConfig().getInitParameter(clave);
        
       
        try (PrintWriter out = response.getWriter()) {
           if (usuario == us && clave==passw && captcha.equals(verif)) {
            out.write("HA INGRESADO CON EXITO");
           //  response.sendRedirect("newjsp.jsp"); 
        }else{
           out.write("NO HA PODIDO INGRESAR DE MANERA ADECUADA");
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
