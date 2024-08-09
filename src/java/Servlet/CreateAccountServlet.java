package Servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Business.Address;
import Business.Customer;
import Business.Person;

/**********************************
 * Adv Sys Proj
 * Create Account Servlet
 *********************************/

@WebServlet(urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

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
        System.out.println("Executing Edit Servlet...");
        String cid, fname, lname, email, phone, street, city, state, aptno, zip, uname, pass, pass2;
        
        try {
            
            fname = request.getParameter("fname");
            System.out.println("fname        = " + fname);
            lname = request.getParameter("lname");
            System.out.println("lname        = " + lname);
            email = request.getParameter("email");
            System.out.println("email        = " + email);
            phone = request.getParameter("phone");
            System.out.println("phone        = " + phone);
            street = request.getParameter("street");
            System.out.println("street       = " + street);
            city = request.getParameter("city");
            System.out.println("city         = " + city);
            state = request.getParameter("state");
            System.out.println("state        = " + state);
            aptno = request.getParameter("aptno");
            System.out.println("aptno        = " + aptno);
            zip = request.getParameter("zip");
            System.out.println("zip          = " + zip);
            uname = request.getParameter("uname");
            System.out.println("uname        = " + uname);
            pass = request.getParameter("pass");
            System.out.println("pass         = " + pass);
            pass2 = request.getParameter("pass2");
            System.out.println("pass2        = " + pass2);
            
// Validate Password //            
            if (pass.equals(pass2)) {
                
                Address a1 = new Address();
                Person p1 = new Person();
                Customer c1 = new Customer();
                
                c1.createID();
                cid = c1.getCustID();
                
                p1.insertDB(fname, lname, email, phone);
                c1.insertDBC(cid, uname, pass, email);                
                a1.insertDB(street, city, state, cid, null, zip, aptno);
                
                RequestDispatcher rdss = request.getRequestDispatcher("/login.html");
                rdss.forward(request, response);
            }
            else {
                RequestDispatcher rds2 = request.getRequestDispatcher("/account.html");
                rds2.forward(request, response);
            }
            
            out.close();
        }
        catch(Exception e) {
            System.out.println("error in Create Account Servlet");
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
