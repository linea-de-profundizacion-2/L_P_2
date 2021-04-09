/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.servlets;

import controlador.jpa.entities.UsuariJpaController;

import encriptacion.sha256;
import entities.Usuari;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author kefab
 */
@WebServlet(name = "control_reg", urlPatterns = {"/control_reg"})
public class control_reg extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try (PrintWriter out = response.getWriter()) {
           
         UsuariJpaController us = new UsuariJpaController();
        Usuari usu = new Usuari();
            sha256 en=new sha256();
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String usuarioo = request.getParameter("usuario");
        String correo = request.getParameter("email");
        String contrasena = request.getParameter("clave");
        
        
        if (nombre!=null && apellido !=null && usuarioo!=null && correo!=null && contrasena !=null){                    
                    
                
      //  String re = en.encrypt(contrasena, "ander", "keyy");
        
// out.write(nombre + apellido + usuario+ correo+ contrasena);
 //encriptar
 
  String contra_enc = en.sha256(contrasena);
 
     //  EntityManagerFactory en = Persistence.createEntityManagerFactory("jpa_2PU");
    //  EntityManager em = en.createEntityManager();
     //  EntityTransaction et = em.getTransaction();

       usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setUsuario(usuarioo);
        usu.setCorreo(correo);
        usu.setContrasena(contra_enc);

      us.create(usu);
     
        response.sendRedirect("index.jsp");
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(control_reg.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(control_reg.class.getName()).log(Level.SEVERE, null, ex);
        }
      

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
