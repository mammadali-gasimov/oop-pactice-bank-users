import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Bank bank = new Bank();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            getUserChoice();
        }
    }

    public static User getUser() {
        scanner.nextLine();
        System.out.println("Enter user name:");
        String name = scanner.nextLine();
        System.out.println("Enter user surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter user email:");
        String email = scanner.nextLine();
        System.out.println("Enter user password:");
        String password = scanner.nextLine();

        return new User(name, surname, email, password);
    }

    public static void createUser() {
        User user = getUser();
        bank.addUser(user);
    };

    public static void updateUser() {
        int id = getId();
        User user = getUser();
        boolean isUpdated = bank.updateUserById(id, user);
        if (isUpdated) {
            System.out.println("User was updated successfully!");
        }
    };

    public static void removeUser() {
        int id = getId();
        boolean isRemoved = bank.removeUserById(id);
        if (isRemoved) {
            System.out.println("User was removed successfully!");
        }
    }

    public static void showAllUsers() {
        User[] users = bank.getAllUsers();
        if (users.length > 0) {
            for (User user : bank.users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("No users were found!");
        }
    };

    public static void showUserById() {
        int id = getId();
        User user = bank.getUserById(id);
        if (user != null) {
            System.out.println(user.toString());
        } else {
            System.out.println("User was not found!");
        }
    };

    public static int getId() {
        System.out.println("Enter user id:");
        int id = scanner.nextInt();
        while (id <= 0) {
            System.out.println("Wrong user id! Enter user id:");
            id = scanner.nextInt();
        };
        return id;
    }

    public static void showMenu() {
        System.out.println("Enter 1 to see all bank users:");
        System.out.println("Enter 2 to see user by id:");
        System.out.println("Enter 3 to add user to list:");
        System.out.println("Enter 4 to update user by id:");
        System.out.println("Enter 5 to remove user by id:");
    }

    public static void getUserChoice() {
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                showAllUsers();
                break;
            case 2:
                showUserById();
                break;
            case 3:
                createUser();
                break;
            case 4:
                updateUser();
                break;
            case 5:
                removeUser();
                break;
        }
    }
}