package appmain;

import java.util.Scanner;

import dao.BookDetailsService;
import dao.BookDetailsServiceImpl;
import dao.LoginDetailsDao;
import dao.LoginDetailsDaoImpl;
import model.Book;
import model.UserDetails;
import respository.BookDetailsDAO;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***********Welcome to Amazon Online book shopping****************");

		System.out.println("1: Sign up");
		System.out.println("2: Sign In");
		System.out.println("3: Exit");
		System.out.println("*************************************************************");
		char ch;
		LoginDetailsDao LoginDao = new LoginDetailsDaoImpl();
		BookDetailsDAO bookDAO = new BookDetailsDAO();
		BookDetailsService bookService = new BookDetailsServiceImpl();
		String username, firstname, lastname, password, mobileno, role;
		String bookName, author, price;
		int bookID;
		do {
			System.out.println("What you do wish to check from the above list");

			Scanner sn = new Scanner(System.in);
			int option = sn.nextInt();

			switch (option) {
			case 1:
				System.out.println("enter the details to signup");

				System.out.println("Enter your firstname");
				firstname = sn.next();
				System.out.println("Enter your lastname");
				lastname = sn.next();
				System.out.println("Enter your password");
				password = sn.next();
				System.out.println("Enter your mobile number");
				mobileno = sn.next();
				System.out.println("Enter your role");
				role = sn.next();

				UserDetails user = new UserDetails();
				user.setUsername(firstname + lastname);
				user.setMobileno(mobileno);
				user.setPassword(password);
				user.setRole(role);

				System.out.println(LoginDao.signUp(user));

				/*
				 * create table userdetails( username varchar(20) primary key,
				 * password varchar(20) not null, firstname varchar(20) not
				 * null, lastname varchar(20), location varchar(20), mobileno
				 * varchar(10) not null )
				 */

				break;
			case 2:
				System.out.println("enter the username:");
				String usern = sn.next();
				System.out.println("enter the password:");
				String pass = sn.next();
				UserDetails details = new UserDetails();
				details.setUsername(usern);
				details.setPassword(pass);
				String res = LoginDao.signIn(details);
				if ((("Login failed").equals(res)))
					System.out.println("login failed");
				else {
					System.out.println("login successful");

					if ("customer".equals(res)) {
						System.out.println("***********Welcome CUSTOMER " + usern + "****************");
						System.out.println("1:List of Books");
						System.out.println("2:Purchase");
						System.out.println("*************************************************************");
						int Customeropt=sn.nextInt();
						switch (Customeropt){
						case 1:
							System.out.println("List of Books");
							LoginDao.getBooks();
							break;
						case 2:
							System.out.println("Purchase");
							System.out.println("Enter your bookID");
							bookID = sn.nextInt();
														
							System.out.println(bookService.PurchaseBook(bookID));
							break;
						}
						

					} else if ("admin".equals(res)) {
						System.out.println("***********Welcome ADMIN " + usern + "****************");

						System.out.println("1: Get books");
						System.out.println("2: Insert book");
						System.out.println("3: Update book");
						System.out.println("4: Delete book");
						System.out.println("5: Exit");
						System.out.println("*************************************************************");

						int Adminopt = sn.nextInt();

						switch (Adminopt) {
						case 1:
							System.out.println("List of Books");
							LoginDao.getBooks();
							break;

						case 2:
							System.out.println("enter the Bookdetails to Insert");

							System.out.println("Enter your bookID");
							bookID = sn.nextInt();
							System.out.println("Enter your bookName");
							bookName = sn.next();
							System.out.println("Enter your author");
							author = sn.next();
							System.out.println("Enter your price");
							price = sn.next();

							Book book = new Book();
							book.setBookID(bookID);
							book.setBookName(bookName);
							book.setAuthor(author);
							book.setPrice(price);

							System.out.println(bookService.insertBook(book));
							break;

						case 3:
							System.out.println("enter the Bookdetails to Update");

							System.out.println("Enter your bookID");
							bookID = sn.nextInt();
							System.out.println("Enter your bookName");
							bookName = sn.next();
							System.out.println("Enter your author");
							author = sn.next();
							System.out.println("Enter your price");
							price = sn.next();

							Book book1 = new Book();
							book1.setBookID(bookID);
							book1.setBookName(bookName);
							book1.setAuthor(author);
							book1.setPrice(price);

							System.out.println(bookService.updateBook(book1));
							break;

						case 4:
							System.out.println("enter the Bookdetails to Delete");

							System.out.println("Enter your bookID");
							bookID = sn.nextInt();

							System.out.println(bookService.deleteBook(bookID));
							break;
						case 5:
							System.exit(0);
						default:
							System.out.println("enter a valid option");
						}
					}
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("enter a valid option");
			}
			System.out.println("Do you wish to check other options");
			ch = sn.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
