/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entidades.Ciudad;
import Entidades.Usuario;
import SessionBeans.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumnospr
 */
@WebServlet(name = "ServletCreacion", urlPatterns = {"/ServletCreacion"})
public class ServletCreacion extends HttpServlet {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

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
                   
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String edad = request.getParameter("edad");
            String sexo = request.getParameter("sexo");
            String idciudad = request.getParameter("idciudad");
            
            Usuario objusuario = new Usuario();
            objusuario.setNombre(nombre);
            objusuario.setApellido(apellido);
            objusuario.setEdad(Short.valueOf(edad));
            objusuario.setSexo(sexo.charAt(0));
            objusuario.setEstado(true);
            objusuario.setIDCiudad(new Ciudad(Integer.valueOf(idciudad)));
            
            usuarioFacade.create(objusuario);
            

                
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {


            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Creación usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>EL USUARIO A SIDO REGISTRADO CORRECTAMENTE</h1>");
            out.println("</body>");
            out.println("</html>");
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
            Logger.getLogger(ServletCreacion.class.getName()).log(Level.SEVERE, null, ex);
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
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("GrupalJPAPU");
 
            try {
                processRequest(request, response);
            } catch (Exception ex) {
                Logger.getLogger(ServletCreacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletCreacion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
