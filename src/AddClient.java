

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddClient")
public class AddClient extends HttpServlet {

       
	private static final long serialVersionUID = 1L;


	public AddClient() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// get data from FORMS ...
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		// set data in Object
		Client client = new Client();
		
		client.setName(name);
		client.setPassword(password);
		client.setEmail(email);
		client.setCountry(country);
		
		// get connect and add the object to database ..
		int num = ClientDB.save(client) ; 
		
		if ( num > 0) {
			request.setAttribute( "result", "<h2 class='alert alert-success'> Saved Successfly ! </h2> <br/> " );
		}else {
			request.setAttribute( "result", "<h2 class='alert alert-danger'> Sorry not saved :( </h2> <br/> " );
		}
		
		// redirect to index.jsp .. 
		request.getRequestDispatcher("index.jsp").include(request, response);
		
	}

}
