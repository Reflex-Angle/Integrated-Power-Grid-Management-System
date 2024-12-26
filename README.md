# Integrated Power Grid Management System (IPGMS)

## Overview
The **Integrated Power Grid Management System (IPGMS)** is a robust Database Management System (DBMS) developed to efficiently manage and monitor a city's power grid. This system enables seamless interaction between two primary user groups:
- **Registered Users:** To log in, view energy usage, billing details, and service updates.
- **Administrators:** To monitor grid performance, manage power supply, predict demand, and address inefficiencies.

The project combines powerful OracleSQL database capabilities with a versatile Java-based backend and an intuitive JavaFX-based user interface, delivering a scalable and efficient solution for modern energy management.

## Key Features
1. **Dual-Mode Operation:**
   - Registered users can sign in to access personalized information.
   - Administrators can manage and control grid operations.
2. **Comprehensive Database Design:**
   - Includes tables for PowerPlant, Substation, Transformer, MaintenanceLog, Billing, Technician, UsageMeter, RegisteredUser, and ComplaintTicket.
3. **Real-Time Data Management:**
   - Enables predictive analysis, resource optimization, and quick anomaly response.
4. **Scalable Architecture:**
   - Built to handle increased complexity and future expansion.

## Technology Stack
- **Backend:** Java (BlueJ and Eclipse IDE)
- **Frontend:** JavaFX, integrated with FXML and CSS
- **Database:** OracleSQL (Oracle 11g)
- **Database Connection:** OJDBC driver

## Installation
### Prerequisites
- Oracle 11g Database
- Oracle SQL Developer
- Java Development Kit (JDK)
- Eclipse IDE

### Steps
1. **Database Setup:**
   - Import the database schema provided in the project repository.
   - Insert sample records into the tables.

2. **Backend Setup:**
   - Open the backend code in Eclipse IDE.
   - Ensure the `ojdbc.jar` file is included in the project's classpath for database connectivity.

3. **Frontend Setup:**
   - Integrate FXML and CSS files with the backend code.
   - Run the application to verify the UI functionality.

## Database Schema
### Tables
1. **PowerPlant:**
   - Stores details about power plants (ID, name, location, capacity).
2. **Substation:**
   - Stores details about substations (ID, name, location, capacity).
3. **Transformer:**
   - Stores transformer information and associated substations.
4. **MaintenanceLog:**
   - Logs maintenance activities and their statuses.
5. **Billing:**
   - Manages billing records for registered users.
6. **Technician:**
   - Stores technician details assigned to maintenance tasks.
7. **UsageMeter:**
   - Tracks energy usage data by users.
8. **RegisteredUser:**
   - Stores user credentials and profile information.
9. **ComplaintTicket:**
   - Tracks complaints raised by users and their resolutions.

## Sample Records
The database includes pre-populated sample records for demonstration purposes.

## Features Demonstration
### Registered Users
- View energy consumption details.
- Access billing history and due dates.
- Submit and track complaints.

### Administrators
- Monitor real-time energy usage.
- Control power distribution and supply.
- Manage maintenance schedules and technician assignments.

## License
This project is licensed under the [MIT License](LICENSE).

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes with descriptive messages.
4. Submit a pull request for review.

## Contact
For any queries or support, please contact:
- **Project Lead:** [Your Name]  
- **Email:** [Your Email]  
- **GitHub:** [Your GitHub Profile]

---
Thank you for exploring the Integrated Power Grid Management System (IPGMS). Together, let's build smarter, more sustainable energy solutions!
