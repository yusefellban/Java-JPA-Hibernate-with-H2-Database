# Java JPA Hibernate with H2 Database

## 📌 Project Overview
This project demonstrates how to integrate **JPA (Java Persistence API)** with **Hibernate** and **H2 Database** using **Maven** in a Java application. It reads tender data from a **CSV file**, stores it in an **H2 in-memory database**, and retrieves it using **JPQL queries**.

## 🚀 Features
- **Java 21** & **Maven-based project**
- **JPA & Hibernate ORM integration**
- **H2 in-memory database** for persistence
- **Reading tenders from a CSV file**
- **Storing data in a relational database**
- **Executing JPQL queries** to fetch and display data
- **JUnit 5 test cases for all functionalities**

## 🛠️ Technologies Used
- **Java 21**
- **JPA (Jakarta Persistence API)**
- **Hibernate ORM**
- **H2 Database**
- **JUnit 5**
- **Maven**

## 📂 Project Structure
```
📦 task-JPA-hibernate-H2Database
 ┣ 📂 src/main/java/com/h2Database
 ┃ ┣ 📜 Ausschreibung.java  # JPA Entity Class
 ┃ ┣ 📜 Program.java        # Main Execution Program
 ┣ 📂 src/main/resources/META-INF
 ┃ ┣ 📜 persistence.xml    # Hibernate Configuration
 ┣ 📂 src/test/java/com/h2Database
 ┃ ┣ 📜 ProgramTest.java   # JUnit 5 Test Cases
 ┣ 📜 meerbusch-aktuelle-ausschreibungen.csv  # CSV Data File
 ┣ 📜 pom.xml  # Maven Configuration
 ┣ 📜 README.md  # Project Documentation
```

## 🔧 Setup & Installation
### 1️⃣ Clone the repository
```sh
git clone https://github.com/YOUSEF-EL-LLBAN/task-JPA-hibernate-H2Database.git
cd task-JPA-hibernate-H2Database
```

### 2️⃣ Build the project
Make sure you have **Java 21** and **Maven** installed, then run:
```sh
mvn clean install
```

### 3️⃣ Run the application
Execute the main class:
```sh
mvn exec:java -Dexec.mainClass="com.h2Database.Program"
```

### 4️⃣ Run Tests
Execute all test cases using:
```sh
mvn test
```

## 📊 How It Works
1️⃣ Reads tender data from `meerbusch-aktuelle-ausschreibungen.csv`
2️⃣ Parses and stores them in an **H2 database**
3️⃣ Runs a **JPQL query** to retrieve and display tenders in a structured format
4️⃣ Validates functionalities using **JUnit 5 test cases**

## 📜 Example Output
```
Titel: M ST 24076 Reinigung von Sandflächen im Stadtgebiet von Meerbusch
Link: https://www.subreport-elvis.de/browseVerdingungsunterlagen.html#ELVISID:E46157663
Auftraggeber: Stadt Meerbusch, 40668 Meerbusch
Vergabenummer: M ST 24076
Ausschreibungsart: Öffentliche Ausschreibung  nach UVgO
Angebotsabgabefrist: 2025-01-22
...
```

## 🏗️ Contributing
1️⃣ Fork the repository
2️⃣ Create a new branch (`feature-name`)
3️⃣ Commit your changes (`git commit -m "Added feature XYZ"`)
4️⃣ Push to your branch (`git push origin feature-name`)
5️⃣ Open a Pull Request 🚀

---
🔗 **Follow Me:** [GitHub](https://github.com/yusefellban) | [LinkedIn](https://linkedin.com/in/youssef-ellban)

