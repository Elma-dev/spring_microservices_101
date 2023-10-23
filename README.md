# spring_microservices_101
## About Repo

The "All You Need About MicroServices" repository contains two applications that will teach you everything there is to know about microservices architects using Spring Boot:

  * **First One:** has the basics to build your first microservice using Spring Cloud, Eureka Discovery, and other technologies.
  * **Second App:** is like the first application but with new technology like ConsulDiscovery ,Vault and also using dynamic methods to load parameters by the microservices...

## 📚Prerequisite
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F.svg?style=for-the-badge&logo=Spring-Boot&logoColor=white)
![Consul](https://img.shields.io/badge/Consul-F24C53.svg?style=for-the-badge&logo=Consul&logoColor=white)
![Vault](https://img.shields.io/badge/Vault-FFEC6E.svg?style=for-the-badge&logo=Vault&logoColor=black)
![Git](https://img.shields.io/badge/Git-F05032.svg?style=for-the-badge&logo=Git&logoColor=white)

## Project Tree

The project is organized into several modules:

 * **Config-service:** Responsible for managing configuration properties for all services.
 * **Gateway-service:** Acts as an API gateway, routing requests to the appropriate microservices.
 * **Customer-service:** Handles customer-related operations.
 * **Inventory-service:** Manages inventory and stock-related operations.
 * **Order-service:** Deals with order processing and management.
 * **Billing-service:** Manages billing and payment operations.

```
 .
 ├── Application_Architecture_Consul_Config_Gateway_Feign_Resilience4J
     ├── billing_service
     │   │   ├── HELP.md
     │   │   ├── mvnw
     │   │   ├── mvnw.cmd
     │   │   ├── pom.xml
 │   │   ├── src
 │   │   │   ├── main
 │   │   │   │   ├── java
 │   │   │   │   │   └── dev
 │   │   │   │   │       └── elma
 │   │   │   │   │           └── billing_service
 │   │   │   │   │               ├── BillingServiceApplication.java
 │   │   │   │   │               ├── configurations
 │   │   │   │   │               │   ├── ConsulConfigs.java
 │   │   │   │   │               │   └── VaultConfigs.java
 │   │   │   │   │               └── webApi
 │   │   │   │   │                   └── BillingRestController.java
 │   │   │   │   └── resources
 │   │   │   │       ├── application.properties
 │   │   │   │       ├── static
 │   │   │   │       └── templates
     ├── configuration_ms
 │   │   ├── HELP.md
 │   │   ├── mvnw
 │   │   ├── mvnw.cmd
 │   │   ├── pom.xml
 │   │   ├── src
 │   │   │   ├── main
 │   │   │   │   ├── java
 │   │   │   │   │   └── dev
 │   │   │   │   │       └── elma
 │   │   │   │   │           └── configuration_ms
 │   │   │   │   │               └── ConfigurationMsApplication.java
 │   │   │   │   └── resources
 │   │   │   │       └── application.properties
 │   ├── customer_service
 │   │   ├── HELP.md
 │   │   ├── mvnw
 │   │   ├── mvnw.cmd
 │   │   ├── pom.xml
 │   │   ├── src
 │   │   │   ├── main
 │   │   │   │   ├── java
 │   │   │   │   │   └── dev
 │   │   │   │   │       └── elma
 │   │   │   │   │           └── customer_service
 │   │   │   │   │               ├── CustomerServiceApplication.java
 │   │   │   │   │               ├── entities
 │   │   │   │   │               │   ├── Customer.java
 │   │   │   │   │               │   └── CustomerProjection.java
 │   │   │   │   │               ├── repositories
 │   │   │   │   │               │   └── CustomerRepository.java
 │   │   │   │   │               └── webApi
 │   │   │   │   │                   └── CustomerRestController.java
 │   │   │   │   └── resources
 │   │   │   │       ├── application.properties
 │   │   │   │       ├── static
 │   │   │   │       └── templates
 │   ├── gateway_service
 │   │   ├── HELP.md
 │   │   ├── mvnw
 │   │   ├── mvnw.cmd
 │   │   ├── pom.xml
 │   │   ├── src
 │   │   │   ├── main
 │   │   │   │   ├── java
 │   │   │   │   │   └── dev
 │   │   │   │   │       └── elma
 │   │   │   │   │           └── gateway_service
 │   │   │   │   │               └── GatewayServiceApplication.java
 │   │   │   │   └── resources
 │   │   │   │       └── application.properties
 │   │   │   └── test
 │   │   │       └── java
 │   │   │           └── dev
 │   │   │               └── elma
 │   │   │                   └── gateway_service
 │   │   │                       └── GatewayServiceApplicationTests.java
 │   ├── inventory_service
 │   │   ├── HELP.md
 │   │   ├── mvnw
 │   │   ├── mvnw.cmd
 │   │   ├── pom.xml
 │   │   ├── src
 │   │   │   ├── main
 │   │   │   │   ├── java
 │   │   │   │   │   └── dev
 │   │   │   │   │       └── elma
 │   │   │   │   │           └── inventory_service
 │   │   │   │   │               ├── InventoryServiceApplication.java
 │   │   │   │   │               ├── entities
 │   │   │   │   │               │   ├── Inventory.java
 │   │   │   │   │               │   └── InventoryProjection.java
 │   │   │   │   │               ├── repositories
 │   │   │   │   │               │   └── InventoryRepository.java
 │   │   │   │   │               └── webApi
 │   │   │   │   └── resources
 │   │   │   │       ├── application.properties
 │   │   │   │       ├── static
 │   │   │   │       └── templates
 │   └── order_service
 │       ├── HELP.md
 │       ├── mvnw
 │       ├── mvnw.cmd
 │       ├── pom.xml
 │       ├── src
 │       │   ├── main
 │       │   │   ├── java
 │       │   │   │   └── dev
 │       │   │   │       └── elma
 │       │   │   │           └── orderservice
 │       │   │   │               ├── OrderServiceApplication.java
 │       │   │   │               ├── entities
 │       │   │   │               │   ├── Order.java
 │       │   │   │               │   └── ProductItem.java
 │       │   │   │               ├── enums
 │       │   │   │               │   └── OrderStatus.java
 │       │   │   │               ├── modes
 │       │   │   │               │   ├── Customer.java
 │       │   │   │               │   └── Product.java
 │       │   │   │               ├── repositories
 │       │   │   │               │   ├── OrderRepository.java
 │       │   │   │               │   └── ProductItemRepository.java
 │       │   │   │               ├── services
 │       │   │   │               │   ├── CustomerRestClient.java
 │       │   │   │               │   └── ProductRestClient.java
 │       │   │   │               └── webApi
 │       │   │   │                   └── OrderRestController.java
 │       │   │   └── resources
 │       │   │       └── application.properties
 │       │   └── test
 │       │       └── java
 │       │           └── dev
 │       │               └── elma
 │       │                   └── orderservice
 │       │                       └── OrderServiceApplicationTests.java
 ├── configs_file
 │   ├── application.properties
 │   ├── customer_service-dev.properties
 │   ├── customer_service-prod.properties
 │   ├── customer_service.properties
 │   ├── gateway_service.properties
 │   ├── inventory_service.properties
 │   └── order_service.properties
 └── spring_microservices_101.iml

```
