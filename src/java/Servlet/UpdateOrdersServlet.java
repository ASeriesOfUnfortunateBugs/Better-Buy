package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Business.Order;

/**********************************
 * Adv Sys Proj
 * Update Orders Servlet
 *********************************/

@WebServlet(urlPatterns = {"/UpdateOrdersServlet"})
public class UpdateOrdersServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
        PrintWriter out = response.getWriter();
            
// Code goes here //        
        System.out.println("Executing Update Servlet...");
        String custid, orderno, productno, status;
        int quantity;
        
        try {
            
            orderno = request.getParameter("orderno");
            status = request.getParameter("status");
            System.out.println("orderno = " + orderno);
            System.out.println("status = " + status);

            Order o1 = new Order();
            o1.selectDB(orderno);
            o1.display();
            
            custid = o1.getCustID();
            quantity = o1.getQuantity();
            productno = o1.getProductNo();
            
            o1.updateDB(custid, productno, quantity, status);
            
            RequestDispatcher rdss = request.getRequestDispatcher("/orders.jsp");
            rdss.forward(request, response);
            
            out.close();
        }
        catch(Exception e) {
            System.out.println("Error in Update Orders Servlet...");
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
