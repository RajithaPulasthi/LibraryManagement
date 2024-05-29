package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class MBorrowBook {
    public void issueBook(int bookId, int memberId, String issuedDate) {
        String insertSQL = "INSERT INTO book_issue_return (book_id, member_id, issued_date) VALUES (?, ?, ?)";
        String updateSQL = "UPDATE books SET Availability = 'issued' WHERE book_id = ?";
        String checkBookSQL = "SELECT * FROM books WHERE Book_ID = ? AND Availability = 'Available'";
        String checkMemberSQL = "SELECT * FROM member WHERE member_id = ?";
        
        try (Connection conn = MDbConnector.getDbConnection();
             PreparedStatement checkBookStmt = conn.prepareStatement(checkBookSQL);
             PreparedStatement checkMemberStmt = conn.prepareStatement(checkMemberSQL);
             PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
             PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
            
            // Check if the book exists and is available
            checkBookStmt.setInt(1, bookId);
            ResultSet bookResult = checkBookStmt.executeQuery();
            if (!bookResult.next()) {
                JOptionPane.showMessageDialog(null, "Book not available or does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Check if the member exists
            checkMemberStmt.setInt(1, memberId);
            ResultSet memberResult = checkMemberStmt.executeQuery();
            if (!memberResult.next()) {
                JOptionPane.showMessageDialog(null, "Member does not exist", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Insert into book_issue_return
            insertStmt.setInt(1, bookId);
            insertStmt.setInt(2, memberId);
            insertStmt.setString(3, issuedDate);
            
            int row_count = insertStmt.executeUpdate();
            if (row_count > 0) {
                // Update books table
                updateStmt.setInt(1, bookId);
                updateStmt.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Book issued successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Issue operation failed, try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}
    
    public String getBookName(int bookId) {
        String bookName = null;
        String sql = "SELECT book_name FROM books WHERE book_id = ?";
        
        try (Connection conn = MDbConnector.getDbConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, bookId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                bookName = rs.getString("book_name");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return bookName;
    }
}