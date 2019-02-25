import Classes.person;
import Repositories.PersonRepository;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet
public class HomeController extends HttpServlet{

    @EJB
    PersonRepository personRepo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//
//        //region database that works
////        String name = "";
////        InitialContext ctx = null;
////        try {
////            ctx = new InitialContext();
////            DataSource ds = (DataSource)ctx.lookup("jdbc/mysqlpool");
////            Connection conn = ds.getConnection();
////            PreparedStatement prep = conn.prepareStatement("Select name from person where personid = 1");
////            ResultSet rs = prep.executeQuery();
////            if (rs.next()) {
////                name = rs.getString("name");
////            }
////        } catch (NamingException e) {
////            e.printStackTrace();
////            out.println(e.toString());
////        } catch (SQLException e) {
////            e.printStackTrace();
////            out.println(e.toString());
////        }
////        out.println("<h1>" + "Yes. It works. name is " + name + "</h1>");
//        //endregion
//
//        person person = new person();
//        person.setName("Adolf Hitler");
//        personRepo.addperson(person);
//        request.setAttribute("persons", personRepo.getAll());
//        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
//        view.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        person person = new person();
        person.setName("Adolf Hitler");
        personRepo.addperson(person);
        request.setAttribute("persons", personRepo.getAll());
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request,response);
    }
}
