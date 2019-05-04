

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/EditClient")
public class EditClient extends HttpServlet {

	private static final long serialVersionUID = 1L;



	public EditClient() {
        		super();
    	}


    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int clientID = Integer.parseInt(request.getParameter("id"));
		
		Client client = ClientDB.findByPk(clientID);
		
		request.setAttribute("ClientID", client.getId());
		request.setAttribute("ClientName", client.getName());
		request.setAttribute("ClientPassword", client.getPassword());
		request.setAttribute("ClientEmail", client.getEmail());
		request.setAttribute("ClientCountry", client.getCountry());
		
		  request.setAttribute("edit", "some_value");
		  getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

		
	}


}
