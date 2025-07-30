import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.io.Console;

public class TerminalAccount {
    private int accountNumber;
    private String agency;
    private String ownersName;
    private String password;
    private double accountBalance = 0;

    public void deposit(double value){
        this.accountBalance += value;
        System.out.println("You deposited $" + value);
    }

    public void extract(double value){
        this.accountBalance -= value;
        System.out.println("You extracted $" + value);
    }

    public void balance(){
        System.out.println("Your current balance is: $" + this.accountBalance);
    }

    public TerminalAccount(int accountNumber, String agency, String ownersName, double accountBalance, String password) {
        this.accountNumber = accountNumber;
        this.agency = agency;
        this.ownersName = ownersName;
        this.accountBalance = accountBalance;
        this.password = password;
    }

    public static void menu(TerminalAccount account){
        Scanner scanner = new Scanner(System.in);
        boolean continueMenu = true;
        double value;

        while(continueMenu){

            System.out.println("\nWhat do you wanna do next ?");
            System.out.println("1 - Deposit");
            System.out.println("2 - Extract");
            System.out.println("3 - Check balance");
            System.out.println("4 - log out");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("You choose the deposit option");    
                        System.out.println("How much you wanna deposit ? ($)");
                        value = scanner.nextDouble();
                        account.deposit(value);

                        System.out.println("Do you wanna do another operation ? (y/n)");

                        try {
                            String backToMenu = scanner.nextLine();
                            
                            if(backToMenu.equalsIgnoreCase("n")){
                                System.out.println("Exiting...");
                                continueMenu = false;
                            } else if (!backToMenu.equalsIgnoreCase("y")) {
                                System.out.println("Invalid option. Try again.");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option. Try again.");
                            scanner.nextLine();                        }
                        break;

                    case 2:
                        System.out.println("You choose the extract option");
                        System.out.println("How much you wanna extract ? ($)");
                        value = scanner.nextDouble();
                        account.extract(value);
            
                        System.out.println("Do you wanna do another operation ? (y/n)");

                        try {
                            String backToMenu = scanner.nextLine();
                            
                            if(backToMenu.equalsIgnoreCase("n")){
                                System.out.println("Exiting...");
                                continueMenu = false;
                            } else if (!backToMenu.equalsIgnoreCase("y")) {
                                System.out.println("Invalid option. Try again.");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option. Try again.");
                            scanner.nextLine();
                        }
                        break;

                    case 3:
                        account.balance();

                        System.out.println("Do you wanna do another operation ? (y/n)");

                        try {
                            String backToMenu = scanner.nextLine();
                            
                            if(backToMenu.equalsIgnoreCase("n")){
                                System.out.println("Exiting...");
                                continueMenu = false;
                            } else if (!backToMenu.equalsIgnoreCase("y")) {
                                System.out.println("Invalid option. Try again.");
                                scanner.nextLine();
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid option. Try again.");
                            scanner.nextLine();
                        }
                        break;
                        case 4:
                            System.out.println("Exiting...");
                            continueMenu = false;
                            break;
                    default:
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Please type a valid option.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static String getPasswordInput(String prompt, Scanner scanner) {
        Console console = System.console();
        System.out.print(prompt);

        if(console != null) {
            return new String(console.readPassword());
        } else {
            return scanner.nextLine();
        }
    }

    public static void main(String[] args) throws Exception {
        // Initializes the class Scanner for inputs
        Scanner scanner = new Scanner(System.in);
        Map<Integer, TerminalAccount> accounts = new HashMap<>();
        Random random = new Random();

        int accNum, option, agOption;
        String ag, ownName, passwd;
        double accBal;
        boolean menu = true;

        System.out.println("**************************************\n"
                    + "** Welcome to the bank terminal X!  **\n"
                    + "**      What do you wanna do?       **\n"
                    + "** 1 - Open a new account           **\n"
                    + "** 2 - Log-in                       **\n"
                    + "** 3 - Exit                         **\n"
                    + "**************************************");
        
        while(menu) {
            try {
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("What is your name ?");
                        ownName = scanner.nextLine();

                        System.out.println("\nWhat agency is more conventient to you ?");
                        System.out.println("1 - Sao Paulo");
                        System.out.println("2 - Rio de Janeiro");
                        System.out.println("3 - Belo Horizonte");

                        do {
                            agOption = scanner.nextInt();
                            scanner.nextLine();

                            switch (agOption) {
                                case 1:
                                    ag = "000-1";
                                    break;
                                
                                case 2:
                                    ag = "000-2";
                                    break;

                                case 3:
                                    ag = "000-3";
                                    break;

                                case 4:
                                    ag = "000-4";
                                    break;

                                default:
                                    System.out.println("Invalid option, try again.");
                                    ag = "0";
                                    break;
                            }
                        } while(ag.equalsIgnoreCase("0"));

                        do {
                            accNum = random.nextInt(9999);
                        } while(accounts.containsKey(accNum));

                        String checkPasswd;
                        do {
                            passwd = getPasswordInput("Please create a safe password: ", scanner);
                            checkPasswd = getPasswordInput("Please type again: ", scanner);

                            if(!passwd.equals(checkPasswd)){
                                System.out.println("Password did not match. Try again.");
                            }
                        } while (!passwd.contentEquals(checkPasswd));

                        System.out.print("\nPlease type the value of your initial deposit: $");
                        accBal = scanner.nextDouble();

                        TerminalAccount newAccount = new TerminalAccount(accNum, ag, ownName, accBal, passwd);
                        accounts.put(accNum, newAccount);
                        System.out.println("\nAccount created succesfully!\nAg: " + ag + "\nAccount number: " + accNum);
                        menu(newAccount);
                        break;

                    case 2:
                        System.out.println("Enter your account number:");
                        int loginAccNum = scanner.nextInt();
                        scanner.nextLine();

                        if (accounts.containsKey(loginAccNum)) {
                            TerminalAccount existingAccount = accounts.get(loginAccNum);

                            for(int i = 0; i < 3; i++){
                                String passwd1 = getPasswordInput("Please type your password: ", scanner);

                                if(passwd1.equals(existingAccount.password)){
                                    System.out.println("Congratulations! you entered.");
                                    menu(existingAccount);
                                } else {
                                    System.out.println("Wrong password, you have " + (2 - i) + " chances left.");
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        menu = false;
                        break;
                
                    default:
                        System.out.println("Not an option. Try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid option. Please enter a valid option:");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
