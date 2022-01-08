package respository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.Book;

public class BookDetailsDAO {

	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	public BookDetailsDAO()
	{
		try{
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
		}catch(Exception e){
			String s=e.getMessage();
		}
	}
	
	public String insertBook(Book b) {
		
		String sql = "INSERT INTO Userdetails.book ( `bookid`,`bookname`,`author`,`price`)  VALUES ('"+b.getBookID()+"','"+b.getBookName()+"','"+b.getAuthor()+"','"+b.getPrice()+"');";
		try {
			int i = statement.executeUpdate(sql);
			if(i==1)
			{
				return "Successfully Inserted !!!";
			}else
				return "Insert Failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Insert Failed";
		}
		
	}
	public String updateBook(Book b) {
		// TODO Auto-generated method stub
		String sql = "UPDATE Userdetails.book SET bookname='"+b.getBookName()+"',author='"+b.getAuthor()+"',price='"+b.getPrice()+"' WHERE bookid ='"+b.getBookID()+"';";
		try {
			int i = statement.executeUpdate(sql);
			if(i==1)
			{
				return "Successfully Updated !!!";
			}else
				return "Update Failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Update Failed";
		}
	}

	public String deleteBook(int bookID) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM Userdetails.book WHERE bookid='"+bookID+"';";
		try {
			int i = statement.executeUpdate(sql);
			if(i==1)
			{
				return "Successfully Deleted !!!";
			}else
				return "Delete Failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Delete Failed";
		}
		}
	
		public String PurchaseBook(int bookID) {
			// TODO Auto-generated method stub
			String sql = "SELECT * FROM Userdetails.book WHERE bookid='"+bookID+"';";
			try {
				ResultSet i = statement.executeQuery(sql);
				if(i.next())
				{
					return "Successfully Purchased !!!";
				}else
					return "Purchase Failed !!!";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Purchase Failed";
			}
		
	}

}
