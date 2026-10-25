# Telemetry-
Fleet Telemetry and Maintenance Platform
A Java backend learning project that will grow into a platform for tracking equipment, processing simulated machine telemetry, and managing maintenance needs.
Project Status
Early development. The current implementation is a Java console application that calculates maintenance status from engine hours and a service interval. The API, database, telemetry ingestion, and access controls described below are planned features.
Project Vision
Build a backend that allows fleet teams to register equipment, review operating data, identify maintenance needs, and record completed services.
Planned capabilities include:
- Equipment registration and management.
- Simulated telemetry ingestion for engine hours, temperature, fuel level, and location.
- Latest readings and historical telemetry retrieval.
- Maintenance reminders and alerts for readings outside defined limits.
- Service records and maintenance history.
- Authentication and permissions for administrators, technicians, and viewers.
Current Functionality
The console application:
1. Stores engine hours and a service interval in variables.
2. Calculates hours remaining until service.
3. Displays one of three messages: hours remaining, maintenance due now, or an overdue warning.
The current calculation is:
hoursRemaining = serviceInterval - engineHours
This assumes the last service occurred at zero engine hours. A future version will account for the engine-hour reading at the last service.
Technology
Technology	Status	Purpose
Java 17	Current	Application language and console logic
Spring Boot	Planned	REST API and application configuration
PostgreSQL	Planned	Equipment, telemetry, and service record storage
Spring Data JPA	Planned	Database access
Flyway	Planned	Versioned database migrations
Spring Security	Planned	Authentication and authorization
JUnit	Planned	Automated testing
Docker and CI	Planned	Repeatable execution and automated checks


Framework versions and supporting tools will be selected and documented as each stage is implemented.
Running the Current Application
1. Install JDK 17 and open the Java project in your IDE.
2. Configure the project SDK to use JDK 17.
3. Open Main.java in the com.telemetry package.
4. Run its main method.
5. Change engineHours and run again to explore different maintenance states.
The current application requires no database or external service.
Manual Verification
With serviceInterval set to 250, check these scenarios:
Engine hours	Expected output
120	Hours until service: 130
250	Maintenance is due now
300	Overdue Warning


These are expected results for manual checks. Automated tests have not yet been added.
Planned Architecture
The initial backend design is one Spring Boot application with these responsibilities:
Component	Responsibility
Controllers	Receive HTTP requests and return responses
Services	Apply maintenance rules and coordinate operations
Repositories	Read and write stored data
PostgreSQL	Persist records and enforce database constraints


The existing maintenance calculation will be developed into reusable, tested Java logic. API responses will eventually replace console output for backend clients. This architecture is a proposal and will evolve as requirements are clarified.
Development Roadmap
- [ ] Account for engine hours at the last service.
- [ ] Validate readings and service intervals.
- [ ] Organize the code into methods and equipment classes.
- [ ] Add automated tests for maintenance rules and invalid inputs.
- [ ] Build equipment and maintenance REST endpoints.
- [ ] Add PostgreSQL persistence and database migrations.
- [ ] Accept simulated telemetry and retrieve its history.
- [ ] Add maintenance and telemetry threshold alerts.
- [ ] Add authentication and enforce role-based permissions.
- [ ] Verify access controls with automated tests.
- [ ] Add logging, externalized configuration, Docker support, and CI checks.
- [ ] Document deployment and recovery procedures.
Security requirements will be considered throughout development, and access controls will be implemented before protected functionality is exposed.
Current Limitations
- Inputs are hardcoded in the source code.
- Only whole operating hours are represented.
- Previous maintenance is not yet included in the calculation.
- Invalid inputs are not yet rejected.
- Data is not persisted between runs.
- There are no API endpoints, user accounts, or permissions yet.
- Telemetry hardware integration and a user interface are outside the current scope.
Learning Goals
Build practical skills in Java, debugging, testing, SQL, API design, software architecture, authentication, authorization, and deployment by implementing and explaining one feature at a time.
The project is intended for learning and portfolio development. Production readiness has not been established.
