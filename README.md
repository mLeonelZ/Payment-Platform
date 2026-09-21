# Payment Platform

An educational backend project designed to simulate the architecture and development challenges of a modern payment platform.

The project is being built incrementally with **Java and Spring Boot**, starting as a modular monolith and evolving gradually as new technical requirements are introduced.

The main goal is not to build a real banking system, but to create a controlled environment for studying and applying backend engineering concepts commonly used in financial and enterprise applications.

---

## 🎯 Project Goals

This project was created to practice backend engineering concepts through a single evolving system.

The main learning objectives are:

* Build RESTful APIs with Java and Spring Boot
* Design and implement a relational database
* Apply object-oriented programming and SOLID principles
* Work with DTOs and domain models
* Implement business rules and transactional operations
* Write unit and integration tests
* Apply exception handling and validation
* Document APIs with OpenAPI
* Containerize applications with Docker
* Implement CI/CD pipelines
* Study asynchronous communication and messaging
* Explore microservices architecture
* Implement authentication and authorization
* Apply observability practices
* Study scalability, caching and resilience
* Deploy backend services to AWS
* Understand how architectural decisions evolve as system requirements grow

---

## 🏗️ Current Architecture

The project starts as a **modular monolith**.

The initial architecture is intentionally simple:

```text
Client
   │
   ▼
REST Controllers
   │
   ▼
Application / Services
   │
   ▼
Domain
   │
   ▼
Repositories
   │
   ▼
PostgreSQL
```

The purpose of starting with a monolith is to establish a solid domain and application structure before introducing distributed-system complexity.

Microservices will only be introduced when there is a concrete technical reason to study them.

---

## 💳 Initial Domain

The first version of the platform is centered around three main concepts:

### Customer

Represents a platform customer.

Main attributes include:

* Identifier
* Name
* CPF
* Email
* Status
* Creation date

A customer can own multiple accounts.

### Account

Represents a customer's payment account.

Main attributes include:

* Identifier
* Account number
* Customer
* Balance
* Status
* Creation date

The account number is a business identifier and is independent from the database primary key.

### Transaction

Represents financial movements within the platform.

The initial transaction types are:

* Deposit
* Transfer

Transactions contain information such as:

* Source account
* Destination account
* Amount
* Type
* Status
* Creation date
* Completion date

---

## 🔐 Business Rules

The system will implement basic rules commonly associated with financial transactions.

For example:

### Deposits

* The destination account must exist
* The destination account must be active
* The amount must be greater than zero
* The amount is added to the account balance
* The transaction is persisted
* The operation must be atomic

### Transfers

* The source account must exist
* The destination account must exist
* Both accounts must be active
* Source and destination accounts must be different
* The amount must be greater than zero
* The source account must have sufficient balance
* The source balance is decreased
* The destination balance is increased
* The transaction is persisted
* The entire operation must be atomic

The project does not handle real money or connect to real financial institutions.

---

## 🛠️ Technology Stack

The technology stack will evolve throughout the project.

### Current / Initial Stack

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Git
* GitHub

### Technologies Planned for Future Phases

* JUnit
* Mockito
* Bean Validation
* OpenAPI / Swagger
* Docker
* GitHub Actions
* RabbitMQ and/or Kafka
* Redis
* Spring Security
* JWT
* OAuth 2.0 / OpenID Connect
* Keycloak
* AWS
* Grafana
* Distributed tracing
* Kubernetes

Technologies will be introduced progressively instead of being added all at once.

---

## 🚀 Project Evolution

The project follows an incremental roadmap.

### Phase 1 — Foundation

Focus:

* Java
* Spring Boot
* REST
* PostgreSQL
* JPA
* Maven
* Git

Goal:

Build the first functional version of the platform.

---

### Phase 2 — Backend Engineering

Focus:

* DTOs
* Validation
* Exception handling
* Clean Code
* SOLID
* Unit testing
* Integration testing
* OpenAPI

Goal:

Improve code quality, maintainability and API reliability.

---

### Phase 3 — DevOps

Focus:

* Docker
* Linux
* CI/CD
* GitHub Actions

Goal:

Automate application building, testing and delivery.

---

### Phase 4 — Distributed Systems

Focus:

* Microservices
* RabbitMQ and/or Kafka
* Asynchronous processing
* Retry mechanisms
* Dead Letter Queues
* Idempotency

Possible future services:

```text
API Gateway
    │
    ├── Account Service
    │
    ├── Transaction Service
    │
    └── Notification Service
```

This architecture is exploratory and will only be adopted when it provides a meaningful technical problem to solve.

---

### Phase 5 — Cloud & Observability

Focus:

* AWS
* Application logs
* Metrics
* Monitoring
* Grafana
* Distributed tracing

Goal:

Understand how backend systems are operated and monitored in cloud environments.

---

### Phase 6 — Security

Focus:

* Spring Security
* JWT
* OAuth 2.0
* OpenID Connect
* Keycloak
* Authentication
* Authorization

Goal:

Implement a more complete security model for the platform.

---

### Phase 7 — Scalability & Resilience

Focus:

* Redis
* Caching
* Performance optimization
* Retry
* Circuit Breaker
* Resilience patterns
* Concurrent processing

Goal:

Study how backend systems behave under higher load and partial failures.

---

### Phase 8 — Container Orchestration

Focus:

* Kubernetes
* Containers
* Service deployment
* Configuration
* Scaling

Goal:

Understand how distributed applications can be deployed and operated in a container orchestration environment.

---

## 🧪 Testing Strategy

Testing will evolve together with the application.

The project intends to cover:

* Unit tests
* Integration tests
* Repository tests
* Controller tests
* Service tests
* Business rule validation
* Transactional behavior
* Error scenarios

Particular attention will be given to transaction-related business rules because operations such as transfers must preserve data consistency.

---

## 📌 API

The initial API will use versioned endpoints:

```text
/api/v1
```

Initial endpoints include:

```text
POST   /api/v1/customers
GET    /api/v1/customers/{id}

POST   /api/v1/accounts
GET    /api/v1/accounts/{id}
GET    /api/v1/accounts/{id}/balance

POST   /api/v1/transactions/deposits
POST   /api/v1/transactions
GET    /api/v1/transactions/{id}
GET    /api/v1/accounts/{id}/transactions
```

The API will evolve as the domain and technical requirements evolve.

---

## 🗄️ Database

The initial relational database is PostgreSQL.

The first version is based on three main tables:

```text
cliente
   │
   │ 1:N
   ▼
conta
   │
   │
   ├──────────────┐
   ▼              ▼
transacao      transacao
```

The database will enforce important integrity rules whenever appropriate, while business rules will remain implemented at the application/domain level.

---

## 🔄 Development Philosophy

The project follows a few principles:

### Start simple

Complexity should be introduced only when there is a reason for it.

### Learn through implementation

Each new technology should solve a concrete problem within the project.

### Understand before abstracting

Abstractions should emerge from real requirements rather than being created prematurely.

### Prefer evolution over premature architecture

The project starts as a modular monolith and may evolve into distributed services later.

### Keep the scope controlled

This is an educational project, not an attempt to reproduce a complete banking infrastructure.

It will not implement:

* Real financial transactions
* Real PIX integration
* Real card processing
* Real banking integrations
* Regulatory compliance systems
* Production banking infrastructure

The goal is to study engineering concepts, not reproduce an actual financial institution.

---

## 📚 Learning Outcomes

By completing the project, the goal is to gain practical experience with:

* Java backend development
* Spring Boot
* REST API design
* Relational database modeling
* JPA and Hibernate
* Transaction management
* Software architecture
* Clean Code
* SOLID
* Automated testing
* Messaging systems
* Distributed systems
* Authentication and authorization
* Docker
* CI/CD
* Cloud infrastructure
* Observability
* Scalability
* Resilience patterns
* Kubernetes

---

## 📈 Project Status

**Current stage:** Planning

The initial domain, architecture and development roadmap are being defined before implementation begins.

The project will be developed incrementally, with each phase introducing new concepts while keeping the system functional and understandable.

---

## ⚠️ Disclaimer

This project is intended exclusively for **educational purposes**.

It does not process real money, connect to real financial institutions, or provide financial services.

Any resemblance to real payment or banking systems is used solely for educational and architectural purposes.
