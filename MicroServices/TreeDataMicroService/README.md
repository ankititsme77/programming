# README

# Tree Service

This service manages and manipulates trees.

# Setup

1.Clone the repository to your local machine.

2.Ensure you have Java JDK (version 8 or above) and Apache Maven installed.

3.Open a terminal or command prompt and navigate to the project root directory.

4.Build the project using the following command:

mvn clean install

# Running the Service

After the build is successful, you can run the service using the following command:

mvn spring-boot:run

This will start the service on http://localhost:3001.

# Running the Tests

The project includes JUnit tests to ensure the correctness of the service. To run the tests, use the following command:

mvn test

This will execute all the test cases and display the results in the console.

# Design Choices

1.Spring Boot: The service is built using the Spring Boot framework, which provides a robust and easy-to-use infrastructure for developing Java applications.

2.Dependency management : Used maven for dependency management 

3.In-Memory Storage: For simplicity, the tree data is stored in memory using a data structure. In a real-world scenario, a database or persistent storage would be used.

4.DTO Pattern: The service utilizes Data Transfer Objects (DTOs) to encapsulate data and ensure separation between the API and the internal domain model.

5.Logging: The service uses Java's built-in logging framework to record important events and errors. Logs can be found in the console output or in log files depending on the logging configuration.

6.Exceptions : Custom exception has been used to handle edge cases 

7.Persistence : In real world scenario, JPA can be used to interact with database, sample queries has been provided to retrieve tree and add children

8.Testing : Added junit test cases to test get and add child end points using rest template 



