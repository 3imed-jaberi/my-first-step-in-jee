<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Home Page </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container">
	      <div class="row">
    		<div class="col">
      			<div class="card card-body bg-light mt-5">
      			<%= ( request.getAttribute("result") == null ) ? "" : request.getAttribute("result") %>
			<center> <h1> <%= request.getAttribute("edit") != null ? "Update" : "Add" %> Client Info </h1> </center>
    	<form method="post" action="<%= request.getAttribute("edit") != null ? "UpdateClient" : "AddClient"  %>">
   			<div class="form-group" >
       			<label for="name">Name :</label>
   	   			<input type="text" name="name" class="form-control" value="<%= request.getAttribute("edit") != null ? request.getAttribute("ClientName") : "" %>" required/>
   			</div>   
   			<div class="form-group" >
       			<label for="password">Password :</label>
   	   			<input type="password" name="password" class="form-control" value="<%= request.getAttribute("edit") != null ? request.getAttribute("ClientPassword") : "" %>" required/>
   			</div>
   			<div class="form-group" >
       			<label for="email">Email :</label>
   	   			<input type="email" name="email" class="form-control" value="<%= request.getAttribute("edit") != null ? request.getAttribute("ClientEmail") : "" %>" required/>
   			</div>
   			<div class="form-group" >
       			<label for="country">Country :</label>
   	   			<input type="text" name="country" class="form-control" value="<%= request.getAttribute("edit") != null ? request.getAttribute("ClientCountry") : "" %>" required/>
   			</div>
   			<!-- Client ID -->
   			<input type="hidden" name="id" value="<%= request.getAttribute("edit") != null ? request.getAttribute("ClientID") : "" %>" />
   			<button type="submit" class="btn btn-primary form-control"> Submit </button>
    	</form>
    	<br/><br/><br/>
    			<div>
				    <!-- Make sure to change your folder name -->
				<a href="/YOUR_FOLDER_NAME/DisplayClients" class="btn btn-success" > View Client</a> <!-- button --> 
			</div>
	      		</div>
	      	</div>
	      </div>
	  </div>

</body>
</html>