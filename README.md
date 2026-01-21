# Premier Zone API

Spring Boot REST API for football (Premier League) player statistics, featuring network programming components and external API integration.

The application provides CRUD operations and basic filtering for player data stored in a PostgreSQL database.

## 🔎 Data Source

Player statistics were collected using a custom web scraper written in Python.

The scraper extracts publicly available football statistics from the fbref.com website and was used to populate the PostgreSQL database used by this application.

The scraping process is not part of this repository and was executed only to obtain initial data. 
All data is used strictly for educational and non-commercial purposes.

## 🚀 Features

### ⚽ Football Stats (REST CRUD) 
- **Full CRUD operations** for players (Create, Read, Update, Delete).
- **Advanced Filtering**: Filter players by team, name, position, or nation.
- **Persistence**: Data stored in a **PostgreSQL** database using Spring Data JPA.

### 🌐 Network Programming 
- **DNS Resolver**: Endpoint `/api/v1/network/dns/{domain}` to resolve hostnames to IP addresses using `InetAddress`.
- **UDP Server**: A multi-threaded UDP server running on port `9999`.
  - **DB Integration**: Responds to `GET_COUNT` datagrams by querying the database and returning the total player count to the client.
- **UDP Client Test**: Includes a test client (`UdpClientTest.java`) demonstrating request-response communication over UDP.

### 🔌 External API Integration 
- **Wikipedia Integration**: Endpoint `/api/v1/external/wiki?clubName=...` fetches real-time club descriptions.
- **Advanced HTTP**: Uses `RestTemplate` with custom `User-Agent` headers to bypass automated request blocking.

## 🧱 Tech Stack
- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## 📦 API Endpoints

### 1. Player Controller (`/api/v1/player`)
- **GET** `/api/v1/player`
  - Optional query parameters: `team`, `name`, `position`, `nation`.
  - *Example*: `/api/v1/player?team=Leeds-United&position=DF`
- **POST** `/api/v1/player` (Add new player)
- **PUT** `/api/v1/player` (Update player data)
- **DELETE** `/api/v1/player/{playerName}` (Remove player)

### 2. Network Controller (`/api/v1/network`)
- **GET** `/api/v1/network/dns/{domain}` - Returns list of IP addresses for a given domain.

### 3. External API Controller (`/api/v1/external`)
- **GET** `/api/v1/external/wiki?clubName=Arsenal_F.C.` - Fetches summary from Wikipedia.

## 🛰️ UDP Communication
The application starts a UDP server in the background. You can interact with it using the provided `UdpClientTest` class.
- **Port**: 9999
- **Command**: `GET_COUNT`
- **Action**: Queries PostgreSQL and returns the number of players currently in the database.

## ▶️ Running the application
1. Clone the repository.
2. Configure PostgreSQL connection in `src/main/resources/application.properties`.
3. Run the application:
   ```bash
   mvn spring-boot:run
4. The API will be available at: http://localhost:8081/api/v1/player
5. (Optional) Run UdpClientTest.java as a separate process to test UDP network capabilities.
