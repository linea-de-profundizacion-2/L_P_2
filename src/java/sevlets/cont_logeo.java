/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevlets;

import cl.Paso;
import controlador.UsuariJpaController;
import encriptacion.AES256;
import entities.Usuari;
import entities.Usuari_;
import static entities.Usuari_.contrasena;
import static entities.Usuari_.usuario;
import static java.awt.SystemColor.text;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kefab
 */
 @PersistenceUnit        
 
@SuppressWarnings("unchequet")
@WebServlet(name = "cont_logeo", urlPatterns = {"/cont_logeo"})

public class cont_logeo extends HttpServlet {
 private EntityManagerFactory emf;
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
        try {
        String usuarii = request.getParameter("usuario");
        String contrasen = request.getParameter("clave");
         
       String captcha = request.getParameter("g-recaptcha-response");
         boolean verif=Paso.verificar(captcha);
        String us= getServletConfig().getInitParameter(usuarii);
        String passw= getServletConfig().getInitParameter(contrasen);
        
    
          Usuari usu = new Usuari();
          AES256 en=new AES256();
       
      
        String contr = en.encrypt(contrasen);
            System.out.println("valor :"+verif +Paso.verificar(captcha) );
            
            if (verif) {
                
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_2PU");
      EntityManager em = emf.createEntityManager();
       EntityTransaction et = em.getTransaction();
        CriteriaBuilder cb = emf.getCriteriaBuilder();
        CriteriaQuery <Usuari> cq=cb.createQuery(Usuari.class);
        
        Root <Usuari> root =cq.from(Usuari.class);
        cq.where(
                cb.equal(root.get(Usuari_.usuario),usuarii),
                cb.equal(root.get(Usuari_.contrasena),contr));

            TypedQuery<Usuari> q=em.createQuery(cq);
            Usuari usuari =q.getSingleResult();
            usuari.getUsuario();
                 response.sendRedirect("ingreso.jsp");
             }else{
               
               response.sendRedirect("index_ec.jsp");
               
               //  response.sendRedirect("index.jsp");
                 
                }
        } catch (Exception e) {
            
             response.sendRedirect("index_eu.jsp");
        }
        try (PrintWriter out = response.getWriter()) {
          
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
