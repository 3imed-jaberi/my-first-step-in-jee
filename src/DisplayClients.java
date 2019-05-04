

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;


@WebServlet("/DisplayClients")
public class DisplayClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayClients() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter Write = response.getWriter() ;
		
		
		List<Client> clientstList = ClientDB.findAll();
        int index = 0 ;
		Write.print("<html><head><title> Client List </title></head>");
		Write.print("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'></head>");

        Write.print("<body><div class='container'><br/><div><a href='/crudJDBCwithServlet/index.jsp' class='btn btn-success' > Add Client</a></div><br/><center><h1 class='text-info'> CLIENTS LIST </h1></center><br/><br/>");
        Write.print("<table class='table table-striped table-hover'><tr class='thead-light'><th>ID</th><th>Name</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for ( Client client:clientstList) {
                  index++; 
               Write.print("<tr>");  
               Write.print("<td><input type='hidden' value='"+client.getId()+"'/>"+ index +"</td>");
               Write.print("<td>"+ client.getName() +"</td>");
               Write.print("<td>"+ client.getEmail() +"</td>");
               Write.print("<td>"+ client.getCountry() +"</td>");
               Write.print("<td><a class='btn btn-primary' href='EditClient?id="+client.getId()+"'> Edit </a></td>");
               Write.print("<td><a class='btn btn-danger' href='DeleteClient?id="+client.getId()+"'> Delete </a></td>");
               Write.print("</tr>");  
         }
		 Write.print("</table></div></body></html>");
		 		
	}

}
