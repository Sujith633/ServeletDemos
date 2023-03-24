
public class Book {
	private String bookname;
	private int bookid;
	public Book(String bookname, int bookid) {
		super();
		this.bookname = bookname;
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
}
