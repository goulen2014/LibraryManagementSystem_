
import com.lms.dao.LibrarianLoginDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "LibrarianLoginServlet", urlPatterns = {"/LibrarianLoginServlet"})
public class LibrarianLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        LibrarianLoginDAO login = new LibrarianLoginDAO();
                
        if(login.check(email, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            response.sendRedirect("librarianDashboard.jsp");
        } else {
            out.println("Invalid email or password!");
            response.sendRedirect("librarianLoginPage.jsp");            
        }
        out.close();
    }
    
}
