/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entidades.Usuario;
import SessionBeans.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ServletListado", urlPatterns = {"/ServletListado"})
public class ServletListado extends HttpServlet {

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
            throws ServletException, IOException {
        List<Usuario> listaUsuario = usuarioFacade.findAll();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletListado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado: Usuarios</h1>");
            out.println("<table border=1>");
            out.println("<th>ID</th><th>Nombre</th><th>Apellido</th><th>Edad</th><th>Sexo</th><th>Válido</th><th>ID Ciudad</th><th>Ciudad</th><th>Válido</th>");
            for (int i = 0; i < listaUsuario.size(); i++) {
                out.println("<tr><td>"+listaUsuario.get(i).getId()+"</td><td>"+listaUsuario.get(i).getNombre()+"</td><td>"+listaUsuario.get(i).getApellido()+"</td>"
                        + "<td>"+listaUsuario.get(i).getEdad()+"</td><td>"+listaUsuario.get(i).getSexo()+"</td><td>"+listaUsuario.get(i).getEstado()+"</td>"
                        + "<td>"+listaUsuario.get(i).getIDCiudad().getId()+"</td><td>"+listaUsuario.get(i).getIDCiudad().getNombre()+"</td>"
                        + "<td>"+listaUsuario.get(i).getIDCiudad().getEstado()+"</td>"
                        + "<td><a href='ServletEliminar?IdUsuario="+listaUsuario.get(i).getId()+"'> <img src='imagenes/eliminar.png' width=25 heigth=25> </a></td>"
                        + "<td><a href='FormularioModificacion.jsp?IdUsuario="+listaUsuario.get(i).getId()+"'> <img src='imagenes/modificar.png' width=25 heigth=25> </a></td></tr>");
            }
            out.println("</table>");
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
