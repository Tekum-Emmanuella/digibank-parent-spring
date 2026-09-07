# DigiBank Parent Spring

Multi-module Spring Boot 3.2 application for Digi Bank monolithic architecture, packaged as a WAR for deployment to WildFly.

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Cucumber 7.15.0 (BDD tests)
- Maven
- WildFly

## Project Structure

```
digibank-parent-spring/
├── digibank-shared/         # Common DTOs, base entities, utilities
├── digibank-customer/       # Customer domain (entities, repositories, services, controllers)
├── digibank-account/        # Account domain
├── digibank-transaction/    # Transaction domain
├── digibank-compliance/     # Compliance validation + Cucumber BDD tests
├── digibank-index/          # Home/index page controller
└── digibank-app/            # WAR deployment module (Spring Boot application)
```

## Prerequisites

- JDK 17
- Maven 3.8+
- PostgreSQL 12+
- WildFly 26+ (for deployment)

## Database Setup

Initialize the database using the provided script:

```bash
psql -U postgres -f init-db.sql
```

This creates the `digibank_db` database and `digibank_user` with password `digibank_pwd`.

## Building

Build all modules:

```bash
mvn clean install
```

Build without tests:

```bash
mvn clean install -DskipTests
```

## Running Locally

The application is configured for WildFly JNDI datasource by default. For local development, use the `local` Spring profile:

```bash
mvn spring-boot:run -pl digibank-app -Dspring-boot.run.profiles=local
```

Or run the packaged WAR directly with the local profile:

```bash
java -jar digibank-app/target/digibank-app.war --spring.profiles.active=local
```

Local profile properties (`application-local.properties`):
- JDBC URL: `jdbc:postgresql://localhost:5432/digibank_db`
- Username: `digibank_user`
- Password: `digibank_pwd`

## Deploying to WildFly

1. Configure a datasource in `standalone.xml`:
   - JNDI name: `java:/jdbc/DigiBankDS`
   - Connection URL: `jdbc:postgresql://localhost:5432/digibank_db`
   - Username: `digibank_user`
   - Password: `digibank_pwd`

2. Deploy using the WildFly Maven plugin:

```bash
mvn wildfly:deploy -pl digibank-app
```

The application context path is `/digibank-app`.

## Testing

Run all tests:

```bash
mvn test
```

Run Cucumber BDD tests in the compliance module:

```bash
mvn test -pl digibank-compliance
```

## Configuration

- Application properties: `digibank-app/src/main/resources/application.properties`
- Local overrides: `digibank-app/src/main/resources/application-local.properties`
- WildFly deployment descriptor: `digibank-app/src/main/webapp/WEB-INF/web.xml`
- WildFly context: `digibank-app/src/main/webapp/WEB-INF/jboss-web.xml`
