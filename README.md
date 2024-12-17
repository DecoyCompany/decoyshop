# E-Commerce Mobile Application
## DECOY SHOP MOBILE APPLİCATİON

## Table of Contents
1. [Project Description](#project-description)
2. [Installation Instructions](#installation-instructions)
3. [Usage](#usage)
4. [Features](#features)
5. [Technologies Used](#technologies-used)
6. [Screenshots](#screenshots)
7. [Contributing](#contributing)
8. [License](#license)
9. [Acknowledgments](#acknowledgments)

## Project Description
- **Overview**:
  The goal of this project was to create an e-commerce mobile application that mimics the functionalities commonly found in e-commerce platforms.
Users can browse products, add items to their cart, and proceed with a seamless shopping experience, similar to what is offered by major e-commerce apps.
The application allows users to register, log in, and manage their cart, with data being sent and retrieved from a MySQL database through a Spring Boot API.
The backend and frontend of the application communicate through HTTP requests, enabling smooth interaction between the user interface and the server.


- **Motivation**:
  This project was created as part of a learning experience for understanding how to build a complete e-commerce application.
Our primary objective was to learn how to communicate between the frontend and backend, specifically through HTTP requests.
By using **Spring Boot** for the backend, we focused on developing a robust API to handle user authentication, product selection, and cart management, while also interacting
with the **MySQL database** to store and retrieve information. The project provided hands-on experience with real-world technologies that are commonly used in
modern mobile applications.

- **Objective**:
  The main objective of this project was to build a fully functional e-commerce mobile application, with a focus on mastering the database integration and HTTP request handling. We aimed to:
- Implement user registration and login functionalities with secure data storage.
- Enable users to browse products, add them to their cart, and view their cart items.
- Build an API using **Spring Boot** that communicates with the **MySQL** database.
- Learn to manage relationships in a database using **JPA**.
- Create a seamless frontend experience with **Android Studio**, where users can interact with the backend and view real-time product and cart information.

Although the project has some limitations, it served as an important learning step in mastering backend development, database management, and mobile app integration.

## Installation Instructions
## Requirements


1. This application is designed specifically for Android devices.
2. Minimum JDK version: **23**
   - Recommended: **JDK 23** or higher.
3. Minimum Gradle version: **8.7**
   - Gradle versions below **8.7** are not supported due to build errors.
4. IntelliJ IDEA version: **2024.2**
5. Android Studio version: **Android Studio Koala Feature Drop | 2024.1.2**
   - Build: #AI-241.18034.62.2412.12266719
   - Runtime version: 17.0.11+0--11852314 amd64
   - VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
6. Operating System: **Windows 11.0**
   - GC: G1 Young Generation, G1 Old Generation
   - Memory: 2048M
   - Cores: 16
   - Registry: ide.experimental.ui=true


## Emulator Configuration

```plaint
- Default Emulator: **Medium Phone API 35**
```

## Gradle Dependencies

```gradle
dependencies {
    // Core dependencies
    implementation 'org.springframework.boot:spring-boot-starter:3.4.0'
    implementation 'org.springframework.boot:spring-boot-starter-web:3.4.0'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa:3.4.0'
    implementation 'mysql:mysql-connector-java:8.0.34'

    // Security
    implementation 'org.springframework.boot:spring-boot-starter-security:3.4.0'
    implementation 'io.jsonwebtoken:jjwt-api:0.11.5'
    implementation 'io.jsonwebtoken:jjwt-impl:0.11.5'
    implementation 'io.jsonwebtoken:jjwt-jackson:0.11.5'

    // Testing
    testImplementation 'org.springframework.boot:spring-boot-starter-test:3.4.0'
    testImplementation 'org.junit.jupiter:junit-jupiter:5.11.3'

    // Additional Libraries
    implementation 'com.squareup.okhttp3:okhttp:4.11.0'
    implementation 'com.github.bumptech.glide:glide:4.15.1'
}
```

## Android-Specific Libraries Used

```plaintext
- OkHttp
- Jackson
- Glide
- RecyclerView
```

## Execution Steps

1. **API Testing**
    - Direct HTTP requests were sent from IntelliJ IDEA.
    - No additional `./gradlew bootRun` was used.

2. **Building and Running**
    - Use the emulator **Medium Phone API 35** configured in Android Studio to test the app.

## Additional Notes


This project is fully public. Ensure the necessary Gradle dependencies are added before building the application.


## Usage

### How to Use the Project

This mobile application is designed for an e-commerce platform. Users can utilize the application by following the steps below:

1. **Starting the API**:
   - Navigate to the backend folder of the project and run the command `./mvnw spring-boot:run` in the terminal.
   - This will start the Spring Boot-based API.

2. **Running the Mobile Application**:
   - Open Android Studio and load the project.
   - Start the emulator to test the application.

3. **Database and Connections**:
   - Ensure that database connections are correctly configured. MySQL must be running.

---

### Example Usage Scenarios

#### **Registration:**
1. When the application opens, a registration screen is presented to the user.
2. The user enters their **first name, last name, email address**, and **password** to register.
3. Upon successful registration, the user sees a **"Register Successful"** message.
4. If the user tries to register with an already existing email address, a **"This account already exists"** message is displayed.

#### **Logging In:**
1. After registering, the user is redirected to the login screen.
2. The user enters the email address and password provided during registration.
3. If the login details are correct, a **"Login Successful"** message is displayed, and a JWT token is generated, allowing the user to perform actions.
4. If incorrect details are entered, a **"Login Failed"** message is shown.

#### **Browsing Categories:**
1. On the home screen, category buttons are displayed for the user.
2. By clicking on a category, the user can access subcategories. For example:
   - Clicking on the **"Technology"** category will show subcategories such as **Tablet**, **Phone**, and **Computer**.
3. The user can access products within subcategories and view detailed information.

#### **Managing Products:**
1. The user can add desired products to their cart.
2. Products in the cart can be managed later for placing orders.

---

### Commands and Parameters

- **Category Buttons**: Users can easily navigate categories and subcategories by clicking on buttons.
- **JWT Token**: A JWT token generated during registration and login is used for authentication across all in-app operations.
- **Feedback Messages**:
  - **"Register Successful"**: Registration was successful.
  - **"Login Successful"**: Login was successful.
  - **"This account already exists"**: The user is already registered.
  - **"Login Failed"**: Incorrect login credentials.

---

### Expected Outputs

- **After Registration**: The user's information is saved in the database, and a success message is displayed.
- **After Login**: The user's identity is verified using a JWT token. Successful login redirects to the homepage, while unsuccessful login shows an error message.
- **After Selecting a Category**: Subcategories and related products are displayed in a list format.
- **Cart Management**: Users can view and manage products added to their cart.





## Technologies Used

- **Languages**:
  - Java (Backend)
  - Java (Frontend)

- **Frameworks/Libraries**:
  - Spring Boot (Backend API)
  - OkHttp (HTTP requests in the mobile app)

- **Tools**:
  - MySQL (Database)
  - Android Studio (Mobile development)
  - IntelliJ IDEA (Backend development)
  - Gradle (Build automation)


## Contributing

We welcome contributions! To contribute, please follow these steps:

1. **Fork the repository**  
   Click the "Fork" button at the top right of this repository's page.

2. **Create a new branch**  
   Create a new branch for your feature or bugfix:
   ```bash
   git checkout -b feature-name

3. **Make Changes
   Implement your changes and test them.

4. **Commit your changes
  Commit your changes with a clear message:
  git commit -m "Description of changes"

5.**Push Changes
  Push your changes to your forked repository:
  
  git push origin feature-name

6. Submit a Pull Request
   Create a pull request with a description of your changes.

7. Development Process
   Pull requests will be reviewed, and revisions may be requested before merging.

8.Code of Conduct
  Be respectful and follow best practices.
  

## License

This project is publicly available for educational purposes. No official license is applied, and the code is free to use and modify for personal or educational projects.


## Acknowledgments
- DECOY Tıcaret Development Team : Melik YALÇINKAYA & Altay GÖK

