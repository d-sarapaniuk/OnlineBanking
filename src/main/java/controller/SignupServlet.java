package controller;

import model.BankAccount;
import model.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet("/sign-up")
public class SignupServlet extends HttpServlet {

    Database db = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        BankAccount newAccount = new BankAccount(firstName, lastName, phone, password, 5);
        db.addAccount(newAccount);

        HttpSession session = request.getSession();
        session.setAttribute("account", newAccount);
        response.sendRedirect("/account");
//        request.getRequestDispatcher("/account").forward(request, response);
    }
}
