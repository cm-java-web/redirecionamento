/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.java.web.redirecionamento.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author escm
 */
public class LoginServlet extends HttpServlet {

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
        
        String usuarioBanco = "admin";
        String senhaBanco = "1234";
        
        String usuarioPagina = request.getParameter("usuario");
        String senhaPagina = request.getParameter("senha");
        
        PrintWriter saida = response.getWriter();
        saida.println("<html>");
        
        HttpSession sessaoUsuario = request.getSession();
        
        if((usuarioBanco.equals(usuarioPagina)) && (senhaBanco.equals(senhaPagina))  ){
            saida.println("Usuario OK");
            sessaoUsuario.setAttribute("usuario", usuarioPagina);
            RequestDispatcher despachador = request.getRequestDispatcher("/areaUsuario");
            despachador.forward(request, response);
            
            
        }else{
            saida.println("Usuario ou senha incorreta");
            saida.println("<a href=\"http://localhost:8080/ExemploRedirecionarServlet\">Voltar a tela de login</a>") ;
            
            
        }
        
                
        saida.println("</html>");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws  ServletException, IOException {
        doPost(req, res);
    }

}
