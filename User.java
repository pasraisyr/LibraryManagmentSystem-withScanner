import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks;
    private Map<String, LocalDate> borrowedBooksDueDates;

    public User(String name,int age){
        this.name = name;
        this.age = age ;
        this.borrowedBooks = new ArrayList<>();
        this.borrowedBooksDueDates = new HashMap<>();

    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    
    public void borrowBook(String bookTitle){
        borrowedBooks.add(bookTitle);
        LocalDate dueDate = LocalDate.now().plusDays(14);
        borrowedBooksDueDates.put(bookTitle, dueDate);
    }

    public void returnBook(String bookTitle){
        borrowedBooks.remove(bookTitle);
    }

    public void printBorrowedBooks() {
        for (String book : borrowedBooks) {
            System.out.println("User :" + name + ","+" "+ "Borrowed : " + book);
        }
    }
   

    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        for (Map.Entry<String, LocalDate> entry : borrowedBooksDueDates.entrySet()) {
            String book = entry.getKey();
            LocalDate dueDate = entry.getValue();
            String overdueMessage = today.isAfter(dueDate) 
                ? "Overdue by " + (today.toEpochDay() - dueDate.toEpochDay()) + " days"
                : "Not overdue";
            System.out.println(name + " " + "Book: " + book + " "+", Due Date:" + " " + dueDate +", Status: " + overdueMessage);
        }
    }
}


    



