package Controller;
import Model.MAddBook;

public class CAddBook {
    public void addNewBook(String Book_Name, String Auther, int Published_Year, String Genre, String Availability){
        MAddBook mab = new MAddBook();
        mab.addNewBook(Book_Name, Auther, Published_Year, Genre, Availability);
    }
}
