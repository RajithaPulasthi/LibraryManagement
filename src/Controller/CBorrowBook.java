package Controller;
import Model.MBorrowBook;
public class CBorrowBook {
    public void issueBook(int bookId, int memberId, String issuedDate) {
        MBorrowBook mrm = new MBorrowBook();
        mrm.issueBook(bookId, memberId, issuedDate);
    }
    
    public String getBookName(int bookId) {
        MBorrowBook mrm = new MBorrowBook();
        return mrm.getBookName(bookId);
    }
}
