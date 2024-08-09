package Servlet;

import Business.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**********************************
 * Adv Sys Proj
 * Login Servlet
 *********************************/

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        String uname, pass, cid, aid, cpass, apass;
        
        try {
            
            uname = request.getParameter("uname");
            System.out.println("Username      = " + uname);
            pass = request.getParameter("pass");
            System.out.println("Password      = " + pass);

// Get Customer data from DB //            
            Customer c1 = new Customer();
            c1.selectDBC(uname);
            c1.displayC();
            cid = c1.getCustID();
            cpass = c1.getPassword();
            
// Get Admin data from DB //            
            Admin a1 = new Admin();
            a1.selectDB(uname);
            a1.display();
            aid = a1.getId();
            apass = a1.getPassword();
            
// Customer Login Validation //            
            if (cid.startsWith("C")) {
                
                if (pass.matches(cpass)) {
                    HttpSession ses1;
                    ses1 = request.getSession();
                    ses1.setAttribute("c1", c1);
                    RequestDispatcher rdss = request.getRequestDispatcher("/accountdetail.html");
                    rdss.forward(request, response);
                }
                else {
                
                    RequestDispatcher rdss = request.getRequestDispatcher("/login.html");
                    rdss.forward(request, response);
                }
            }
            
// Admin Login Validation //            
            else if (aid.startsWith("A")) {
                
                if (pass.matches(apass)) {
                    
                    //HttpSession ses1;
                    //ses1 = request.getSession();
                    //ses1.setAttribute("a1", a1);
                    RequestDispatcher rdss = request.getRequestDispatcher("/admin.html");
                    rdss.forward(request, response);
                }
                
                else {
                
                    RequestDispatcher rdss = request.getRequestDispatcher("/login.html");
                    rdss.forward(request, response);
                }
            } 
        }
        catch(Exception e) {
            System.out.println("error in Login Servlet");
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
