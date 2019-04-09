import java.sql.*;
import com.mchange.v2.c3p0.*;
import java.util.ArrayList;

public class Database {
	
	private static ComboPooledDataSource dataSource;
	
	static {
		/* connection pool means we don't have to connect completely freshly
		 * every time
		 */
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch(Exception e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hw1p3?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		dataSource.setUser("root");
		dataSource.setPassword(null); 
		
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> ints = getCourseIds();
		
		System.out.println("hi");
		
		for (Integer  myInt : ints) {
			System.out.println(myInt);
		}
	}
	
	public static ArrayList<Integer> getCourseIds() {
		
		ArrayList<Integer> intList = new ArrayList<Integer>();
		//Connection conn = null;
		try (
		    Connection conn = dataSource.getConnection();
		    // ... get the stuff
			Statement stmt = conn.createStatement();	
				
		) {
	         // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
	         String strSelect = "select * from Dept";
	         System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
	 
	         ResultSet rset = stmt.executeQuery(strSelect);
	 
	         // Step 4: Process the ResultSet by scrolling the cursor forward via next().
	         //  For each row, retrieve the contents of the cells with getXxx(columnName).
	         System.out.println("The records selected are:");
	         int rowCount = 0;
	         while(rset.next()) {   // Move the cursor to the next row, return false if no more row
	            int did = rset.getInt("did");
	        	String dname = rset.getString("dname");
	            double budget = rset.getDouble("budget");
	            int managerid  = rset.getInt("managerid");
	            intList.add(new Integer(managerid));
	            System.out.println(did + ", " + dname + ", " + budget + ", " + managerid);
	            ++rowCount;
	         }
	         System.out.println("Total number of records = " + rowCount);
	         
	         conn.close();
	         
		} catch(SQLException ex) {
	         ex.printStackTrace();
	      } 
		
		return intList;
		
//		finally {
//		    // ...
//		    if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
//		}
	}

}
