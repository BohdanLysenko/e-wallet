# eWallet

The e-wallet project is a microservice-based application that enables users to manage their funds with features like 
withdrawal, deposit, transfer, and payment. Users can create various cards, conduct transactions, and 
view transaction histories, all within a secure environment. The system is designed to offer a seamless and safe 
experience for managing electronic funds and transactions.

## Key Features
* Users can create new accounts by providing their email and password. 
Registered users can then sign in to receive a JWT token, which is required for any subsequent actions.
* Upon registration, users are automatically assigned a wallet that can store multiple credit cards. 
Users can view detailed information about their wallet and its attached cards, or deactivate the wallet if they wish to
discontinue using the application.
* Users can deposit or withdraw funds from their cards by providing the card number and the desired amount. 
Additionally, users can transfer funds to other registered cards or make payments to external merchants.
* All transactions are validated to ensure security and compliance. 
Users cannot withdraw funds from other users' cards or transfer amounts exceeding their balance. 
Furthermore, security measures enforce a maximum single transaction limit of 2000 EUR and a daily
withdrawal limit of 5000 EUR.

## Technologies Used
* **Spring Boot**: For building microservices.
* **gRPC**: For inter-service communication.
* **Docker**: For containerization of services and databases.
* **Spring Cloud**: For service discovery and configuration management.
* **FlyWay**: For applying consistent db migrations
* **Quartz Scheduler**: For managing schedules jobs

## Getting Started

### Project Structure
The project consists of several services, each responsible for a specific functionality:

* **banking-service**: Handles banking operations.
* **config-service**: Manages centralized configuration.
* **gateway-service**: Serves as the entry point for client requests.
* **grpc-common-service**: Contains common gRPC configurations and utilities.
* **quartz-service**: Manages scheduled tasks and background jobs.
* **user-service**: Manages user-related operations.

### Prerequisites

* Java 17
* Docker and Docker Compose
* Postman/Apidog/Insomnia for testing

### Installation

1) Clone the repository `git clone https://github.com/BohdanLysenko/e-wallet.git`
2) Run `mvn clean install` in [banking-service](banking-service), [config-service](config-service),
[gateway-service](gateway-service), [quartz-service](quartz-service), [user-service](user-service) to generate
jar files in target.
3) Run `docker-compose build` in the root directory.
4) Run `docker-compose up` to start the application. 
Please refer to [docker-compose.yml](..%2Fdocker-compose.yml) alongside [envs](..%2Fenvs) for the containers 
configuration. 
If you want to start any of the services separately you can run `docker-compose -f docker-compose-db.yml up`
to create databases and then run/debug any of the desired service.
If you need to adjust any of the application properties you would be able to do that by changing values inside
[configurations](src%2Fmain%2Fresources%2Fconfigurations) folder of the **config-service** and application.yml of the
service.
5) Make sure that the application is **_up_** by sending GET request to [localhost:8080/actuator/health]().
6) The example of the requests can be found here: 
[Postman shared folder](https://app.getpostman.com/join-team?invite_code=d0d98acb5e96910fbb64b04c0920f888)
/[Postman JSON collection](Bank%20Service.postman_collection.json)

## General workflow
1) Create a user by providing your credentials (this will also create a wallet and generate JWT token)
2) Create a new card by providing the JWT token
3) Deposit/withdraw funds to your card by providing JWT token and card number
4) Transfer funds to other cards that exist in the system by providing JWT token, card number and the destination
card number.
5) Send payments to external merchants by providing JWT token, card number and merchant identifier.
6) Get the transaction history by providing JWT token and a card number.

## Contributing
Contributions to the project are highly appreciated! 
If you are interested in contributing, please follow these steps:

1) Fork the repository and clone it to your local machine.
2) Create a new branch for your feature or bug fix. `git checkout -b my-feature`
3) Make the necessary code changes and cover them with tests.
4) Commit your changes `git commit -m "Add new feature/ Fix bug"`
5) Push your changes to your forked repository `git push origin my-feature`
6) Create a Pull Request with the detailed description of the changes.


# Additional
## Points to be improved
1. MapStruct has issues with Booleans prefixed with "is," so I would adjust the mapping logic to use manually written mappers.
2. Endpoints should be moved to the gateway service, as it currently only handles simple redirects. The gateway could also parse JWT tokens, but this requires additional filters. I created an AuthorizationHeaderFilter but haven't incorporated it yet.
3. With endpoints on the gateway, controllers can be fully removed from services, turning them into plain gRPC services.
4. Eureka Discovery can be added to scale the microservices, but it will require additional configuration for stubbing channels.

