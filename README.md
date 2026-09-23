# Vehicle Service & Maintenance Management System

A Java-based desktop application for managing vehicle information and service records. The project started as a console-based application and was enhanced with a graphical user interface using **Java Swing**.

## 📌 Project Overview

The **Vehicle Service & Maintenance Management System** allows users to maintain basic vehicle information and keep track of their service records through a simple desktop GUI.

The project demonstrates practical implementation of **Java OOP concepts, ArrayList, event handling, input validation, and Swing GUI components**.

## ✨ Features

* 🚗 **Add Vehicle**

  * Add vehicle number
  * Add owner name
  * Add vehicle model
  * Prevent duplicate vehicle numbers

* 📋 **View Vehicles**

  * Display all registered vehicles
  * View vehicle information in a table

* 🔧 **Add Service Record**

  * Add vehicle number
  * Add service type
  * Add service date
  * Add service cost
  * Validate service cost

* 📜 **Service History**

  * Search service records using vehicle number
  * Display matching service records in a table

* 🗑️ **Delete Vehicle**

  * Delete a vehicle using its vehicle number
  * Display an appropriate message when the vehicle is not found

## 🖥️ GUI

The application uses **Java Swing** to provide a graphical interface with:

* Dashboard-style main window
* Buttons for different operations
* Input forms using `JTextField`
* Message dialogs using `JOptionPane`
* Data tables using `JTable`
* Scrollable tables using `JScrollPane`

## 🛠️ Technologies Used

| Technology         | Purpose                              |
| ------------------ | ------------------------------------ |
| Java               | Core programming language            |
| Java Swing         | Graphical User Interface             |
| ArrayList          | Storing vehicles and service records |
| OOP                | Classes and objects                  |
| JTable             | Displaying data                      |
| JOptionPane        | User input and messages              |
| Exception Handling | Validating service cost input        |

## 📂 Project Structure

```text
VehicleServiceManagement/
│
├── Main.java
├── GUI.java
├── Vehicle.java
├── ServiceRecord.java
└── README.md
```

### File Description

**`Vehicle.java`**
Contains the `Vehicle` class and stores vehicle information such as vehicle number, owner name, and vehicle model.

**`ServiceRecord.java`**
Contains the `ServiceRecord` class and stores service information such as vehicle number, service type, service date, and service cost.

**`Main.java`**
Contains the original console-based version of the application.

**`GUI.java`**
Contains the graphical version of the application built using Java Swing.

## ⚙️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/YOUR-USERNAME/Vehicle-Service-Management-System.git
```

### 2. Open the project

Open the project folder in **VS Code**, IntelliJ IDEA, Eclipse, or another Java IDE.

### 3. Compile the project

Open the terminal inside the project folder and run:

```bash
javac *.java
```

### 4. Run the GUI application

```bash
java GUI
```

The Vehicle Service Management System window will open.

## 📸 Screenshots

### Main Dashboard

*Add a screenshot of the main GUI here.*

```text
![Main Dashboard](screenshots/main-dashboard.png)
```

### Add Vehicle

*Add a screenshot of the Add Vehicle form here.*

```text
![Add Vehicle](screenshots/add-vehicle.png)
```

### Vehicle List

*Add a screenshot of the vehicle table here.*

```text
![Vehicle List](screenshots/vehicle-list.png)
```

### Service History

*Add a screenshot of the service history table here.*

```text
![Service History](screenshots/service-history.png)
```

## 🧠 Concepts Demonstrated

This project helped implement and practice:

* Classes and Objects
* Constructors
* `this` keyword
* Encapsulation basics
* ArrayList
* For loops
* Enhanced for loops
* Conditional statements
* Boolean variables
* Exception handling
* Event listeners
* Java Swing components
* JTable
* JOptionPane
* Basic input validation

## 🎯 Project Objective

The main objective of this project was to build a practical Java application while applying fundamental programming and object-oriented programming concepts in a real-world style use case.

## 🚀 Future Scope

The current project intentionally focuses on basic vehicle and service management. Possible future improvements could include:

* Database integration
* User authentication
* Editing existing vehicle records
* Advanced search and filtering
* Service reminders
* Report generation

## 👨‍💻 Author

**Mashood Khan**

BE Computer Engineering Student

---

⭐ If you found this project useful, feel free to explore the source code and provide feedback.
