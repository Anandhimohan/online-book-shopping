package model;

public class Book {
	
		private int bookID;
		private String bookName;
		private String author;
		private String price;
		
		public int getBookID() {
			return bookID;
		}
		public void setBookID(int bookID) {
			this.bookID = bookID;
		}
		
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public void PurchaseBookID( int bookID) {
			// TODO Auto-generated method stub
			this.bookID = bookID;
		}
}
