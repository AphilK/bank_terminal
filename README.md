# Bank Terminal X 🏦

A simple console-based banking application written in Java that simulates basic banking operations like account creation, login, deposits, withdrawals, and balance checking.

## 📋 Features

- **Account Creation**: Create new bank accounts with secure password protection
- **Multiple Agency Support**: Choose from different agency locations (São Paulo, Rio de Janeiro, Belo Horizonte)
- **Random Account Number Generation**: Automatically generates unique 4-digit account numbers
- **Secure Login System**: Password-protected login with 3 attempts maximum
- **Banking Operations**:
  - Deposit money
  - Withdraw money
  - Check account balance
  - Logout functionality
- **Password Security**: Hidden password input when running from terminal
- **Multiple Account Management**: Support for multiple accounts using HashMap storage

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- A terminal or command prompt for best password security experience

### Installation

1. Clone this repository:
```bash
git clone https://github.com/AphilK/bank_terminal.git
cd bank_terminal
```

2. Compile the Java file:
```bash
javac src/TerminalAccount.java -d bin
```

3. Run the application:
```bash
java -cp bin TerminalAccount
```

## 🏗️ Project Structure

```
bank_terminal/
├── src/
│   └── TerminalAccount.java    # Main application source code
├── bin/
│   └── TerminalAccount.class   # Compiled bytecode
├── lib/                        # Dependencies (if any)
└── README.md                   # Project documentation
```

## 💻 Usage

### Main Menu Options

When you start the application, you'll see:

```
**************************************
** Welcome to the bank terminal X!  **
**      What do you wanna do?       **
** 1 - Open a new account           **
** 2 - Log-in                       **
** 3 - Exit                         **
**************************************
```

### Creating a New Account

1. Select option `1` from the main menu
2. Enter your full name
3. Choose your preferred agency location:
   - 1 - São Paulo (Agency: 000-1)
   - 2 - Rio de Janeiro (Agency: 000-2)
   - 3 - Belo Horizonte (Agency: 000-3)
4. Create a secure password (confirm by typing it twice)
5. Make an initial deposit (or enter 0 to skip)
6. Your account will be created with a randomly generated account number

### Logging In

1. Select option `2` from the main menu
2. Enter your account number
3. Enter your password (you have 3 attempts)
4. Access the banking menu upon successful login

### Banking Operations Menu

After logging in, you can:

```
What do you wanna do next?
1 - Deposit
2 - Extract
3 - Check balance
4 - Log out
```

## 🔒 Security Features

- **Password Hiding**: When running from terminal, passwords are hidden during input
- **Limited Login Attempts**: Maximum of 3 password attempts before lockout
- **Unique Account Numbers**: Automatically generated to prevent duplicates
- **Input Validation**: Handles invalid inputs gracefully

## 🛠️ Technical Details

### Key Classes and Methods

- `TerminalAccount`: Main class containing all banking functionality
- `deposit(double value)`: Adds money to account balance
- `extract(double value)`: Withdraws money from account balance
- `balance()`: Displays current account balance
- `menu(TerminalAccount account)`: Main banking operations interface
- `getPasswordInput()`: Secure password input handling

### Data Storage

- Uses `HashMap<Integer, TerminalAccount>` for in-memory account storage
- Account numbers serve as unique keys for account retrieval
- Data is not persisted between application runs

## 🔧 Development

### Running in IDE vs Terminal

- **Terminal**: Full password hiding functionality
- **IDE**: Password input will be visible (fallback mode)

### Compiling and Running

```bash
# Compile
javac src/TerminalAccount.java -d bin

# Run
java -cp bin TerminalAccount
```

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Future Improvements

- [ ] Data persistence (file or database storage)
- [ ] Account transfer functionality
- [ ] Transaction history
- [ ] Interest calculation
- [ ] Account closure feature
- [ ] Enhanced security with encryption
- [ ] GUI interface

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**AphilK** - [GitHub Profile](https://github.com/AphilK)

## 📞 Support

If you have any questions or need help with the project, please open an issue on GitHub.
