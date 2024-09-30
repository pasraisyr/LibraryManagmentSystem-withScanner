import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addBook(new Book("Harry Potter", "J.K.Rowling", "1234"));
        library.addBook(new Book("Lord of the Rings", "J.R.R. Tolkien", "6789"));
        
        // // Adding books 
        // System.out.println("Enter the number of books to add:");
        // int numOfBooks = scanner.nextInt();
        // scanner.nextLine(); // consume newline
        
        // for (int i = 0; i < numOfBooks; i++) {
        //     System.out.println("Enter book " + (i + 1) + " title:");
        //     String title = scanner.nextLine();
            
        //     System.out.println("Enter book " + (i + 1) + " author:");
        //     String author = scanner.nextLine();
            
        //     System.out.println("Enter book " + (i + 1) + " ISBN:");
        //     String isbn = scanner.nextLine();
            
        //     library.addBook(new Book(title, author, isbn));
        // }

        System.out.println("Enter the number of users to add:");
        int numOfUsers = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < numOfUsers; i++) {
            System.out.println("Enter user " + (i + 1) + " name:");
            String userName = scanner.nextLine();
            
            System.out.println("Enter user " + userName + "'s" + " age:");
            int age = scanner.nextInt();
            scanner.nextLine();

            library.addUser(new User(userName, age));
        }

        library.listAvailableBooks();

       
        for (int i = 0; i < numOfUsers; i++) {
            System.out.println("User " + (i + 1) + ": Enter the name of the book to borrow:");
            String bookTitle = scanner.nextLine();
            
            System.out.println("Enter the user's name who is borrowing:");
            String borrowerName = scanner.nextLine();
            
            for (User user : library.getUsers()) {
                if (user.getName().equalsIgnoreCase(borrowerName)) {
                    library.borrowBook(user, bookTitle);
                    break;
                }
            }
        }

        library.getBorrowedBooksForAllUsers();
        library.checkOverdueBooks();

        scanner.close();
    }
}