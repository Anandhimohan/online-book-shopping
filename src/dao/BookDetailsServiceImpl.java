package dao;

import model.Book;
import respository.BookDetailsDAO;

public class BookDetailsServiceImpl implements BookDetailsService {

	BookDetailsDAO bookDAO = new BookDetailsDAO();

	@Override
	public String insertBook(Book b) {
		return bookDAO.insertBook(b);

	}

	@Override
	public String updateBook(Book b) {
		return bookDAO.updateBook(b);

	}

	@Override
	public String deleteBook(int bookID) {
		return bookDAO.deleteBook(bookID);

	}

	@Override
	public String PurchaseBook(int bookID) {
		return bookDAO.PurchaseBook(bookID);
	}
}
