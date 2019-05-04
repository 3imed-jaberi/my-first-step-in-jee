

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/DeleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DeleteClient() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get data from FORMS and parse to the integer .. 
		int ClientID = Integer.parseInt(request.getParameter("id"));

		// delete form database ..   
		ClientDB.destroy(ClientID);
		// go the client list .. 
		response.sendRedirect("DisplayClients");

	}



}
