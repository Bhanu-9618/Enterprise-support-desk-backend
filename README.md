# 🚀 Enterprise Support Desk (Backend)

The **Enterprise Support Desk Backend** is a high-performance, enterprise-grade ticketing engine built with the latest Java ecosystem. It is designed to manage the entire lifecycle of support requests with built-in auditing, system observability, and a robust RESTful architecture.

---

## 🛠️ Tech Stack

- **Language:** Java 22 (Latest release)
- **Framework:** Spring Boot 4.0.2 (Modern/Experimental version)
- **Database:** PostgreSQL (Production-ready relational DB)
- **ORM Layer:** Spring Data JPA / Hibernate
- **Mapping:** ModelMapper 3.2.6
- **Monitoring:** Spring Boot Actuator
- **Utilities:** Lombok, Jakarta Bean Validation

---

## ✨ Key Features

### 1. Advanced Ticket Lifecycle Management
A complete engine for handling support requests from creation to resolution.
- **Automated Validation:** Ensures data integrity at entry point.
- **State Machine:** Discrete states: `OPEN`, `IN_PROGRESS`, and `RESOLVED`.
- **Smart Defaulting:** New tickets are automatically initialized as `OPEN`.

### 2. Automated Auditing & Observability
Compliance-ready tracking for every system modification.
- **Dynamic Logging:** Every ticket creation and status transition is recorded in a dedicated `AuditLog` table.
- **Health Monitoring:** Real-time system metrics via Spring Boot Actuator.

### 3. Clean Architecture & Data Integrity
- **DTO Pattern:** Decouples internal entities from external API layers for security.
- **Transactional Integrity:** Uses `@Transactional` to ensure ACID compliance during database operations.
- **Relational Schema:** Optimized PostgreSQL schema for `Users`, `Tickets`, and `AuditLogs`.
