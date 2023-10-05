# BookBusBindaas
deploy link: https://melodious-cassata-4c43f9.netlify.app/

**BookBusBindaas** is a collaborative project developed by a team of 5 dedicated individuals. This innovative online platform serves as a one-stop solution for bus ticket booking. The project is designed with both administrators and users in mind, providing a seamless and user-friendly experience.

## Key Features

### Admin Panel

- **Bus Management:** Admins can effortlessly add new bus details, including routes, schedules, and other relevant information.
- **Route Management:** The system allows administrators to create and manage bus routes efficiently, ensuring accurate and up-to-date route information.
- **Bus Deletion:** Admins have the capability to remove buses from the system when necessary, maintaining a clean and updated database.

### User Account Creation

- **User Registration:** Users can easily create their accounts, providing personal information securely for future bookings.
- **Ticket Booking:** The platform offers a convenient ticket booking process, enabling users to choose their preferred routes, seats, and schedules.
- **Ticket Cancellation:** Users have the flexibility to cancel their booked tickets, adhering to defined cancellation policies.

**BookBusBindaas** aims to streamline the bus ticket booking experience, making it hassle-free for users while providing administrators with the tools they need to manage the service effectively. This project embodies teamwork and a commitment to enhancing the user experience in the world of bus travel.


## Tech Stack

#### Java | Hibernate | Spring Framework | Spring Security | MySQL | Maven | Swagger UI | Lombok | HTML | CSS | JavaScript

## Modules
- Login Module
- Admin Module
- Operator Module
- Customer Module

## Prerequisites

- Java 8 or higher
- Maven
- MySQL Server

## Installation & Run
```bash
# To run this project locally:

# Clone the repository and navigate to the directory
git clone https://github.com/pranaytandel09/tart-clover-1298
cd tart-clover-1298

# Configure your MySQL credentials in application.properties
# located in src/main/resources directory
# Replace with your actual MySQL credentials
spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
spring.datasource.username=your-username
spring.datasource.password=your-password

# Use Maven to build the project
mvn clean install

# After successful build, navigate to target directory and run the jar file
java -jar target/decisive-iron-5903-0.0.1-SNAPSHOT.jar

# Your application should be up and running at http://localhost:8080.
```
## API Root Endpoint

```
https://localhost:8080/
```

```
http://localhost:8080/swagger-ui/index.html
```

## Collaborators

- [Pranay Tandel](https://github.com/pranaytandel09) (Team Lead)
- [Kishor Kamble](https://github.com/kishork18)
- [Prashant Upadhayay](https://github.com/Prashantomm)
- [Aman Choure](https://github.com/amanacr0358)
- [Md Faizan Raza](https://github.com/Fiza32)
