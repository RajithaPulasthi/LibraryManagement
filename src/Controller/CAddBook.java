package Controller;
import Model.MAddBook;
import java.util.Date;

public class CAddBook {
    public void addNewBook(int Book_ID, String Book_Name, String Auther, int Published_Year, String Genre){
        MAddBook mab = new MAddBook();
        mab.addNewBook(Book_ID, Book_Name, Auther, Published_Year, Genre);
    }
}
