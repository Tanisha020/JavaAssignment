# Java Course Assignment  

**Submission for:** DE Shaw DESIS Ascend Educare 2024

This repository contains solutions to **Question 6** and **Question 7** of the Java Course Assignment. Answers to Question 1 - 5 (theory questions) are provided in the pdf attached.


## 📁 Repository Structure 
```plaintext
JavaAssignment
├── Ques6/
│ ├── Main.java
│ ├── MainSynchronized.java
├── Ques7/
│ ├── Employee.java
│ ├── EmployeeOperations.java
│ ├── Main.java
│ ├── employees.txt
│ ├── employees1.txt
│ └── employees2.txt
|
|___ JavaAssignment.pdf
|
└── README.md
```

## 💡 Solutions  
### Question 6: Single Instance Implementation  
This part ensures that a class can have only one instance, even in a multithreaded environment.  
- **Basic Single Instance**: Demonstrated in Main.java.  
- **Thread-Safe Single Instance**: Demonstrated in MainSynchronized.java.  

Path: Ques6/  

### Question 7: Employee Class with File Persistence and Multithreading  
This solution focuses on creating an Employee class and performing file operations in a multithreaded environment.  
- **Employee Class**: Includes id, name, and salary attributes, with necessary constructors, getters, setters, and an overridden toString() method.  
- **Employee Operations**: Writing employee data to employees.txt in a structured format. Also reads alternate lines from employees1.txt and employees2.txt using threads  (handled in EmployeeOperations.java).  
- **Main Class**: For demonstration

Path: Ques7/  

Input Files: employees1.txt, employees2.txt  
Output: Alternate lines from employees1.txt and employees2.txt are printed on the console.  
