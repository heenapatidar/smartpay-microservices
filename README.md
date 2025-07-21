# SmartPay Microservices

A demo microservices architecture using Spring Boot, Flyway, JPA, MySQL, and indexing techniques.

## Modules
- `customer-service`: 1NF schema
- `account-service`: 2NF schema + index on customer_id
- `payment-service`: 3NF schema + indexes for performance

## Features
- Normalized schema (1NF, 2NF, 3NF)
- Flyway-based versioned migrations
- SQL indexing for query performance
- `EXPLAIN` query testing to validate index usage

## Usage
1. Start MySQL and Eureka using Docker (optional)
2. Run each Spring Boot service individually
3. Observe Flyway running migration scripts
4. Query MySQL to verify schema and performance

## Performance Tuning
Example:
```sql
EXPLAIN SELECT * FROM payment WHERE sender_account_id = 101;
-----------------------------------------------------------------------------------------------------
smartpay-microservices/
├── customer-service/
│   ├── src/main/java/com/smartpay/customer/...
│   ├── src/main/resources/db/migration/V1__init_schema.sql
│   ├── ...
├── account-service/
│   ├── src/main/java/com/smartpay/account/...
│   ├── src/main/resources/db/migration/V1__init_schema.sql
│   ├── src/main/resources/db/migration/V2__add_index.sql
│   ├── ...
├── payment-service/
│   ├── src/main/java/com/smartpay/payment/...
│   ├── src/main/resources/db/migration/V1__init_schema.sql
│   ├── src/main/resources/db/migration/V2__add_index.sql
│   ├── ...
├── README.md
└── docker-compose.yml (optional for MySQL & Eureka)
