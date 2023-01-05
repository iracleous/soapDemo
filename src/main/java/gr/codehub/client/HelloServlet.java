/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.client;

import gr.codehub.soapdemo.account.Account;
import gr.codehub.soapdemo.account.AccountWSItf;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceRef;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author iracl
 */
//@WebServlet(name="HelloServlet", urlPatterns={"/HelloServlet"})
@WebServlet("/Simple")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class HelloServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/soapDemo/AccountWS?wsdl")
    private AccountWSItf service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        try {
            PrintWriter out = response.getWriter();

            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            try {
                String arg0 = "world";
                service.newAccount(arg0);
                Account account = service.findAccountByName(arg0);
                String ret = "-" + account.getName() + "-";
                out.println("<p>" + ret + "</p>");
            } catch (Exception d) {

                out.println("error " + d.getMessage());
            }
            out.println("</body>");
            out.println("</html>");
        } catch (IOException d) {

        }
    }

//    // doGet and doPost methods, which call processRequest, and
//    //   getServletInfo method
//    private String sayHello(String arg0) {
//        service.newAccount(arg0);
//        Account account = service.findAccountByName(arg0);
//        return "-" + account.getName() + "-";
//    }
}
