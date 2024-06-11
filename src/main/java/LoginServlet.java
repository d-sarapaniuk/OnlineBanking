import classes.BankAccount;
import classes.Database;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        Database db = Database.getInstance();
        BankAccount account = db.getAccount(phone);

        if (account != null && account.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            response.sendRedirect("account.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
