# Task S017 - Annotations

## Description
This project was created for academic purposes as part of the IT Academy Java & Spring specialization.
The goal is to test the annotations.

The project is structured in three levels of increasing complexity.

## 🛠 Technologies
- Java

##    Project Structure
````bash
├── pom.xml
├── README.md
└── src
    └── main
        └── java
            ├── level1
            │   ├── InPersonWorker.java
            │   ├── Main.java
            │   ├── OnlineWorker.java
            │   └── Worker.java
            └── level2And3
                ├── Init.java
                ├── JsonElement.java
                ├── JsonSerializable.java
                ├── JsonSerializationException.java
                ├── Main.java
                ├── ObjectToJsonConverter.java
                └── Worker.java

````

## 🚀 Instal.lation and Execution
1. Clone the repository:
````bash
git clone https://github.com/ArturViaderdev/TaskS017-Annotations
cd TaskS017-Annotations
````
You can do cd into the exercise folder you want to execute and execute with:
````
java Main.java
````
The projects are inside src/main/java.

Or run with IntelliJ IDEA.

## Task Overview

In this task, we will deepen our understanding of **annotations** in Java — a feature that allows us to add metadata to our source code to influence its behavior or enrich it with additional information.  
Annotations are a fundamental tool for understanding frameworks such as **Spring** or **JPA**, which make extensive use of them to configure behavior declaratively.

Through the proposed exercises, we will explore:

- Built-in Java annotations such as `@Override` and `@Deprecated`.
- The creation of your own custom annotations.
- The use of **Java Reflection** to read these annotations at runtime and act accordingly.

The approach of this practice is not only technical but also conceptual: you will learn **when and why to use annotations** and how they can improve your code’s readability and extensibility.

---

## Level 1: Basic Annotations

In this first level, you will learn to use built-in Java annotations such as `@Override` and `@Deprecated` to improve code clarity and maintainability.  
You’ll do this within a class hierarchy, applying **inheritance** and **polymorphism** in practice.  
Additionally, you’ll see how to mark methods as deprecated and handle those cases from a developer’s perspective.

**Objective:**  
Become familiar with the practical use of standard annotations and understand how they affect code execution and readability.

### Exercise 1 - Override

Create a hierarchy of objects with three classes: `Worker`, `OnlineWorker`, and `OnsiteWorker`.

- The `Worker` class should have the attributes: `name`, `surname`, `hourlyRate`, and a method `calculateSalary()` that takes the number of hours worked as a parameter and multiplies it by the hourly rate.
- The child classes must override this method using the `@Override` annotation.
- From the `main()` method of the `Main` class, make the necessary calls to demonstrate how the `@Override` annotation works.

In the **OnsiteWorker** class, the method to calculate salary will receive the number of hours worked per month as a parameter.  
When calculating the salary, multiply the number of hours by the hourly rate, and add the value of a **static attribute** called `fuel` that you will define in this class.

In the **OnlineWorker** class, the salary calculation method will also take the number of hours worked per month as a parameter.  
The salary is the hourly rate multiplied by the number of hours worked, plus the **flat internet fee**, which will be defined as a **constant** in the `OnlineWorker` class.

***Answer***

I created three classes with inheritance: `Worker`, `InPersonWorker`, and `OnlineWorker`.  
There is an abstract method called `calculateSalary()` in the `Worker` class, and the other classes override this method.

In the `InPersonWorker` class, there is a static variable called `fuel`.  
In the `OnlineWorker` class, there is a constant shared by all online workers called `INTERNET_PRICE`.

I called the overridden methods from the `main()` method.

### Exercise 2 - Deprecated

Add some deprecated methods to the child classes and use the corresponding annotation `@Deprecated`.  
Call these deprecated methods from an external class, suppressing the “deprecated” warnings using the appropriate annotation.

***Answer***

I created two deprecated methods and instructed the compiler to ignore the warnings using:

```java
@SuppressWarnings("deprecation")
```
---

## Level 2: Creating Custom Annotations

In this level, you’ll go a step further by creating your own annotation.  
This custom annotation will indicate that a Java object should be **serialized into JSON format**, receiving the **target directory** as a parameter.  
You’ll begin to understand how annotations can not only inform but also affect program logic when interpreted by additional tools.

**Objective:**  
Understand how to define custom annotations with parameters to enrich your code’s functionality.

### Exercise 1 - JSON Serialization

Create a custom annotation that allows a Java object to be serialized into a JSON file.  
The annotation should receive the directory path where the resulting file will be saved.

***Answer***

I created a custom annotation that allows converting an instance of a class into a JSON file.

---

## Level 3: Reading Annotations with Reflection

In this advanced level, you’ll use **Java Reflection** to detect and act upon custom annotations at runtime.  
This is a powerful technique widely used by frameworks and libraries to dynamically modify behaviors.  
Here you’ll learn how to read an annotation and execute code based on its presence.

**Objective:**  
Apply the concept of Reflection to detect and use annotations in real time, achieving an advanced level of abstraction and flexibility in your code.

### Exercise 1 - Java Reflection

Enable the annotation created in the previous level to be registered by the Java Virtual Machine at runtime.  
Demonstrate that the annotation is read and processed using **Java Reflection**.

***Answer***

I detected the annotations at runtime using Java Reflection.