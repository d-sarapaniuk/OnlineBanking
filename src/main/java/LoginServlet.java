import classes.BankAccount;
import classes.Database;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    Database db = Database.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        BankAccount account = db.getAccount(phone);

        if (account != null && account.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("account");
          //  request.getRequestDispatcher("/account").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid phone or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
