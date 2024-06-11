package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {

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
            response.sendRedirect("AccountServlet");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}

