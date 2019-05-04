
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientDB {
	
	public static Connection getConnection() {
        Connection connect = null ;  
       
		try {
	        	String urlConnect = "jdbc:mysql://localhost:3306/YOUR_DB_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD_VALUE&useSSL=false&useTimezone=true&serverTimezone=UTC" ;
	        	 // load the package in the memory ..  
	        	Class.forName("com.mysql.cj.jdbc.Driver"); 
	        	connect = DriverManager.getConnection(urlConnect);
		}catch(Exception ex){
            System.out.println("error : "+ex);
        }
        return connect;
	}

	public static int save(Client client) {
		int statement = 0 ;
		try {
			Connection connect = ClientDB.getConnection();
			String requette_SQL = "INSERT INTO `clients` (`name`, `password`, `email`, `country`) VALUES (?,?,?,?)";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			preparedStatement.setString(1,client.getName());
			preparedStatement.setString(2,client.getPassword());
			preparedStatement.setString(3,client.getEmail());
			preparedStatement.setString(4,client.getCountry());

			statement = preparedStatement.executeUpdate();
			
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement ; 
	}

	public static int update(Client client) {
		int statement = 0 ;
		try {
			Connection connect = ClientDB.getConnection();
			String requette_SQL = "UPDATE `clients` SET `name` = ? , `password` = ? , `email` = ? , `country` = ?  WHERE (`id` = ?)";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			preparedStatement.setString(1,client.getName());
			preparedStatement.setString(2,client.getPassword());
			preparedStatement.setString(3,client.getEmail());
			preparedStatement.setString(4,client.getCountry());
			preparedStatement.setInt(5,client.getId());

			statement = preparedStatement.executeUpdate();
			
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement ; 
	}
	
	public static int destroy(int id) {
		int statement = 0 ;
		try {
			Connection connect = ClientDB.getConnection();
			String requette_SQL = "DELETE FROM `clients` WHERE (`id` = ?)";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			preparedStatement.setInt(1,id);

			statement = preparedStatement.executeUpdate();
			
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement ; 
	}
	
	public static Client findByPk(int id) {
		Client client = new Client();
		try {
			Connection connect = ClientDB.getConnection();
			String requette_SQL = "SELECT * FROM `clients` WHERE id = ? ";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			preparedStatement.setInt(1,id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if ( resultSet.next()){
				client.setId(resultSet.getInt(1));
				client.setName(resultSet.getString(2));
				client.setPassword(resultSet.getString(3));
				client.setEmail(resultSet.getString(4));
				client.setCountry(resultSet.getString(5));	
			}
			
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client ;
	}
	
	public static List<Client> findAll() {
		List<Client> clientsList = new ArrayList<Client>();
		
		try {
			Connection connect = ClientDB.getConnection();
			
			String requette_SQL = "SELECT * FROM `clients`";
			PreparedStatement preparedStatement = connect.prepareStatement(requette_SQL);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while( resultSet.next()){
				Client client = new Client();
				client.setId(resultSet.getInt(1));
				client.setName(resultSet.getString(2));
				client.setPassword(resultSet.getString(3));
				client.setEmail(resultSet.getString(4));
				client.setCountry(resultSet.getString(5));	
				clientsList.add(client);
			}
			
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsList ;
	}
	
}
