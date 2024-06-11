import classes.BankAccount;
import classes.Database;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("account.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BankAccount fromAccount = (BankAccount) session.getAttribute("account");

        if (fromAccount != null) {
            String toPhoneNumber = request.getParameter("toPhoneNumber");
            double amount = Double.parseDouble(request.getParameter("amount"));

            Database db = Database.getInstance();
            BankAccount toAccount = db.getAccount(toPhoneNumber);

            if (toAccount != null && amount > 0 && fromAccount.getBalance() >= amount) {
                fromAccount.transfer(toAccount, amount);
            }
            request.getRequestDispatcher("account.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}

