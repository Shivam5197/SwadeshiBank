
# SwadeshiBank

SwadeshiBank is a comprehensive web-based banking application built using Spring MVC with JPA, Spring Security, AJAX, HTML, CSS, JavaScript, jQuery, MySQL, Lombok, JavaMail servers, and Twilio APIs. It provides a secure and efficient platform for managing banking operations and financial activities.

## Features

1. **Transaction Management**
   - **View Transaction History:** Users can see a detailed history of all their transactions, including deposits, withdrawals, and transfers.
   - **Transfer Funds:** Seamless transfer of funds between accounts with real-time balance updates and transaction receipts.

2. **Account Management**
   - **Open New Accounts:** Users can easily open new bank accounts online, with options to select account types and initial deposit amounts.
   - **Close Accounts:** Close accounts securely with appropriate checks on pending transactions and balances.
   - **View Account Details:** Detailed view of account balances, transaction history, and account-specific information.

3. **Cards Management**
   - **Issue Debit/Credit Cards:** Enable users to apply for and issue new debit or credit cards, with customizable limits and activation options.
   - **Manage Card Settings:** Users can manage card preferences, set spending limits, and deactivate or report lost/stolen cards.

4. **User Management**
   - **Register New Users:** Seamless registration process for new users, with validation and authentication steps.
   - **Update User Profiles:** Users can update their personal information, contact details, and preferences securely.
   - **Manage User Roles:** Admin capabilities to assign roles and permissions based on user responsibilities.

5. **Notifications**
   - **Real-Time Alerts:** Instant notifications for transactions, account updates, and security alerts through both email (JavaMail servers) and SMS (Twilio APIs).
   - **Customizable Preferences:** Users can choose their preferred notification methods and frequency.

6. **Loans Management**
   - **Apply for Loans:** Users can apply for various types of loans online, with options to view eligibility criteria and repayment terms.
   - **Loan Details:** Detailed loan status, repayment schedules, and interest calculations for informed financial planning.

7. **Investments**
   - **Stocks and Mutual Funds:** Users can explore and invest in stocks or mutual funds through integrated investment platforms.
   - **Portfolio Management:** Track investment performance, view holdings, and analyze trends for informed decision-making.

## Technology Stack

- **Backend**
  - Java 11
  - Spring MVC
  - Spring Security 
  - Spring Data JPA with MySQL for data persistence
  - Lombok for boilerplate code reduction

- **Frontend**
  - HTML5
  - CSS3
  - JavaScript
  - jQuery for DOM manipulation and AJAX calls

- **Integration**
  - JavaMail servers for email notifications
  - Twilio APIs for SMS notifications and alerts

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/shivam5197/SwadeshiBank.git
   cd SwadeshiBank
   ```

2. **Database setup:**

   - Create a MySQL database and update the application.properties file with your database configuration.

3. **Build and run the application:**

   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

4. **Access the application:**

   Open a web browser and go to `http://localhost:8080`

## Screenshots

_Insert screenshots here to visually showcase your application._

## Contributing

We welcome contributions from the community! If you find any bugs or have feature requests, please open an issue or submit a pull request following these steps:

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/YourFeature`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/YourFeature`
5. Open a pull request

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the open-source community for their valuable resources and inspiration.

---
