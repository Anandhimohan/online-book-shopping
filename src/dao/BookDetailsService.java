package dao;

import model.Book;

public interface BookDetailsService {

	public String insertBook(Book b);

	public String updateBook(Book b);

	public String deleteBook(int bookID);
    
	public String PurchaseBook(int bookID);

}
