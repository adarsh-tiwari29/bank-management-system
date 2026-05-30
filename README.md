# Bank Management System (ATM Simulator)

A robust, secure, and fully functional desktop application simulating a real-world ATM and Bank Management System. Built to demonstrate secure financial transactions, account management, and advanced user authentication.

##  Key Features
* **Two-Factor Authentication (2FA):** Enhanced security layer ensuring that only authorized users can access sensitive banking functions.
* **Comprehensive Account Creation:** Multi-step signup process (Personal details, Additional details, Account/Card generation) capturing full user KYC.
* **End-to-End ATM Operations:** * **Cash Withdrawal & Deposit:** Real-time balance updates processed securely in INR (₹).
  * **Fast Cash:** Quick withdrawal options for standard amounts.
  * **PIN Change:** Secure mechanism to update ATM PINs.
* **Mini Statements:** Dynamically generated transaction history using `rs2xml` to display tabular data.
* **Robust Data Integrity:** Backed by a relational MySQL database handling transactional data securely.

##  Tech Stack
* **Language:** Java (JDK 17)
* **GUI Framework:** Java Swing / AWT
* **Database:** MySQL
* **IDE:** Apache NetBeans
* **Libraries Used:**
  * `mysql-connector-java` (Database connectivity)
  * `javax.mail` & `activation` (Email/OTP for 2FA)
  * `jcalendar` (UI component for dates)
  * `rs2xml` (Table generation for statements)

## Prerequisites:
1. **Java Development Kit (JDK 17 or higher)** installed.
2. **MySQL Server** installed and running.
3. An IDE like **Apache NetBeans** or **Eclipse/IntelliJ**.

## Step-by-Step Setup:
1. **Clone the repository:**
   git clone https://github.com/adarsh-tiwari29/bank-management-system
2. **Database Setup:**
   Open your MySQL Workbench or command line.
   Create a new database: CREATE DATABASE bankmanagementsystem;
   Use that database: use bankmanagementsystem;
   Import the provided db.sql file (found in the root folder) to set up the required tables.
   Open Conn.java in the project and update the MySQL username and password to match your local database credentials.
3. **Importing the Project:**
   Open your IDE (e.g., NetBeans) and select Open Project.
   Navigate to the cloned folder and open it.
4. **Add External Libraries:**
   Ensure all the .jar files located in the Libraries folder (mysql-connector, jcalendar, rs2xml, etc.) are added to the project's build path/classpath.
5. **For OTP Authentication:**
   Go to Login.java page and add your email-id and your google account password.
6. **Run the Application:**
   Right-click on Login.java and select Run File.

## Project Screenshots:
1. Login Screen
<p align="center">
<img width="750" alt="Login Screen" src="https://github.com/user-attachments/assets/594a9bc7-3c0b-400e-a4ce-89789c9536d5" />
</p>
2. Sign-Up Form
<p align="center">
<img width="600" alt="Sign-Up Form" src="https://github.com/user-attachments/assets/b84e4ee9-02e7-491b-88c5-7d26e26009ab" />
</p>
3. Main Dashboard
<p align="center">
<img width="600" alt="Main Dashboard" src="https://github.com/user-attachments/assets/540c6440-118d-4887-b749-7031347bdd65" />
</p>
4. Cash Deposit
<p align="center">
<img width="670" alt="Cash Deposit" src="https://github.com/user-attachments/assets/6bc48987-114e-465e-8534-f55b56fa996c" />
</p>
5. Cash Withdrawal
<p align="center">
<img width="600" alt="Cash Withdrawal" src="https://github.com/user-attachments/assets/d4df7088-17cb-4e37-aa27-814a67595df3" />
</p>
6. Mini-Statement Form
<p align="center">
<img width="350" alt="Mini-Statement Form" src="https://github.com/user-attachments/assets/5a8e8a90-34fe-4f63-9a4c-c9dcbf534e8d" />
</p>
