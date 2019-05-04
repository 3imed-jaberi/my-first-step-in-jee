

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/UpdateClient")
public class UpdateClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateClient() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// get data from FORMS ...
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		// set data in Object
		Client client = new Client();
		
		client.setId(id);
		client.setName(name);
		client.setPassword(password);
		client.setEmail(email);
		client.setCountry(country);
		
		// get connect and update data from the object ..
		int num = ClientDB.update(client); 
		
		if ( num > 0) {
			request.setAttribute( "result", "<h2 class='alert alert-success'> Updated Successfly ! </h2> <br/> " );
		}else {
			request.setAttribute( "result", "<h2 class='alert alert-danger'>  Sorry not updated ! </h2> <br/> " );;
		}
		
		// go the client list .. 
		response.sendRedirect("DisplayClients");
		
	}
}
