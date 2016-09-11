/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;

/**
 *
 * @author Usuario
 */
public class RegistrarPersonaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("txtNombre");
        String edad = request.getParameter("txtEdad");
        
         if(nombre.equals("") || edad.equals("")){
            String error = "campos vacios";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        PersonaControlador perControlador = new PersonaControlador();
        Persona per = new Persona();
        per.setNombre(nombre);
        per.setEdad(Integer.parseInt(edad));
        
        
        System.out.println("NOMBRE Y EDAD "+per.getNombre() + per.getEdad());
        if(perControlador.insertar(per) == true){
            request.getRequestDispatcher("exito.jsp").forward(request, response);
        }else{
            String error = "error al insertar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
       
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
    }
    
  }