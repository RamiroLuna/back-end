/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petstar.service;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.petstar.configurations.Configuration;
import org.petstar.controller.ControllerEquipoAmut;
import org.petstar.model.OutputJson;
import org.petstar.model.ResponseJson;

/**
 * Servlet de Equipos Amut
 * Clase que administra el acceso a Equipos Amut
 * @author Tech-Pro
 */
@WebServlet(name = "EquipoAmut", urlPatterns = {"/EquipoAmut"})
public class EquipoAmut extends HttpServlet {

    /**
     * Procesa las peticiones HTTP, ya sean métodos <code>GET</code> o
     * <code>POST</code> respectivamente.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Configuration.setHeadersJson(response);
    
        PrintWriter out = response.getWriter();
        OutputJson output = new OutputJson();
        ControllerEquipoAmut controller = new ControllerEquipoAmut();
        
        Gson gson = new Gson();
        try {
            String action = request.getParameter("action");
            switch (action) {
                case "getEquipos":
                    output =  controller.getEquiposAmutList(request);
                    break;
                case "insertNewEquipos":
                    output = controller.insertNewEquipoAmut(request);
                    break;
                case "updateEquipos":
                    output = controller.updateEquipoAmut(request);
                    break;
                case "deleteEquipos":
                    output = controller.deleteEquipoAmut(request);
                    break;
                case "getDataByID":
                    output = controller.getDataEquipoAmoutById(request);
                    break;
            }
        } catch (Exception ex) {
            ResponseJson reponseJson = new ResponseJson();
            reponseJson.setSucessfull(false);
            reponseJson.setMessage(ex.getMessage());
            output.setResponse(reponseJson);
        } finally {
            out.print(gson.toJson(output));
            out.close();
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
     * @param req
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Configuration.setHeadersJson(response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "EquipoAmut";
    }// </editor-fold>

}
