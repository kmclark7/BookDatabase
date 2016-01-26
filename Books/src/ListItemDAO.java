import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListItemDAO {

	ArrayList<ListItem> arrayList = new ArrayList<ListItem>();
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ListItemDAO() {

		makeConnection();

		try{
			String q = "SELECT * from items";
		
			st = con.createStatement();
			rs = st.executeQuery(q);
			
			while(rs.next()){
				String tempStore = rs.getString(2);
				String tempItem = rs.getString(3);
				
				ListItem e = new ListItem(tempStore, tempItem);
				arrayList.add(e);
			}
		
			if(rs != null){
				rs.close();
			}
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
		
		}catch (SQLException ex){
			System.out.println("Error with table or data");
		}catch (NullPointerException npe){
			System.out.println("Null Pointer Exception");
		}
		
	}

	public String getCurrentList() {

		String str = "";
		
		return str;
	}

	public String getCurrentListFromStore(String s) {
		String str = "";
		for(int i = 0; i < arrayList.size(); i++){
			if(arrayList.get(i).getStore().equals(s)){
				str += arrayList.get(i).getItem();
				str += "\n";
			}
			
		}
		return str;
	}

	public void insertNewItem(ListItem i) {
		makeConnection();

		try{
			String q = "insert into items (store, item) values ('"+i.getStore()+"', '"+i.getItem()+"');";
		
			st = con.createStatement();
			st.executeUpdate(q);
			
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
		
		}catch (SQLException ex){
			System.out.println("Error with table or data");
		}
		
	}

	public void deleteItem(ListItem i) {
		makeConnection();
		try{
			String q = "delete from items where store = '"+i.getStore()+"' and item = '"+ i.getItem()+"' limit 1";
		
			st = con.createStatement();
			st.executeUpdate(q);
			
			if(st != null){
				st.close();
			}
			if(con != null){
				con.close();
			}
		
		}catch (SQLException ex){
			System.out.println("Error with table or data");
		}
	
	}

	public void makeConnection() {
		System.out.println("Make Connection");
		String url = "jdbc:mysql://localhost:3306/shopping";
		String user = "root";
		String password = "Mommyof5SQL!";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection made");

		} catch (Exception ex) {
			Logger lgr = Logger.getLogger(ListItemDAO.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			System.out.println("Sql Exception");

		}

	}
}
