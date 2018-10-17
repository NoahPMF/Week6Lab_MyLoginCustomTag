/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.User;
import domain.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 601354
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String logout = request.getParameter("logout");
        
        if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            request.setAttribute("message", "logout successful");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("rem");

        UserService us = new UserService();
        //User u = new User(name, pass, remember);

        if (name.equals(" ") || pass.equals(" ")) {
            request.setAttribute("message", "please enter both fields");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        try {
            if (!remember.equals("")) {
                Cookie c = new Cookie("userIdCookie", name);
                response.addCookie(c);
            }
        } catch (NullPointerException e) {

        }

        if (us.login(name, pass) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "incorrect username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
