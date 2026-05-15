package web.handler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * HTTP end-point to handle the /reg registration request.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] GET");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[RegistrationServlet] POST");

        String fName    = req.getParameter("fname");
        String lName    = req.getParameter("lname");
        String username = req.getParameter("username");
        String email    = req.getParameter("email");
        String password = req.getParameter("passwd");
        String phone    = req.getParameter("phone");
        String dob      = req.getParameter("dob");
        String gender   = req.getParameter("gender");
        String address  = req.getParameter("address");
        String city     = req.getParameter("city");
        String country  = req.getParameter("country");

        System.out.println("[RegistrationServlet] username=" + username
                + ", email=" + email + ", dob=" + dob);

        String registrationStatus = RegistrationService.register(
                fName, lName, username, email, password,
                phone, dob, gender, address, city, country);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);

        String htmlResponse = "<html>";
        htmlResponse += "<head><title>" + registrationStatus + "</title></head>";
        htmlResponse += "<body>";
        htmlResponse += "<h2>Registration status: " + registrationStatus + "</h2>";
        if ("success".equals(registrationStatus)) {
            htmlResponse += "<p>Welcome, " + escapeHtml(fName) + "! Your account has been created.</p>";
        } else {
            htmlResponse += "<p>Registration failed: " + escapeHtml(registrationStatus) + "</p>";
        }
        htmlResponse += "</body></html>";

        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}