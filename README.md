# Premier Zone API

Spring Boot REST API for football (Premier League) player statistics.

The application provides CRUD operations and basic filtering for player data stored in a PostgreSQL database.



## 🔎 Data Source

Player statistics were collected using a custom web scraper written in Python.

The scraper extracts publicly available football statistics from the fbref.com website and was used to populate the PostgreSQL database used by this application.

The scraping process is not part of this repository and was executed only to obtain initial data.
All data is used strictly for educational and non-commercial purposes.

## 🚀 Features

- CRUD operations for players
- Filtering players by:
  - team
  - name
  - position
  - nation
- RESTful API
- PostgreSQL database
- Spring Data JPA



## 🧱 Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven



## 📦 API Endpoints

### Get players 

GET /api/v1/player

Optional query parameters:

GET /api/v1/player?team=Leeds-United  
GET /api/v1/player?name=Rodon
GET /api/v1/player?position=DF
GET /api/v1/player?nation=ENG
GET /api/v1/player?team=Leeds-United&position=DF


### Add player
POST /api/v1/player

Example request body:
```json
{
  "playerName": "Erling Haaland",
  "nation": "NOR",
  "position": "FW",
  "age": "24-090",
  "matchesPlayed": 20,
  "starts": 20,
  "minutesPlayed": "1780.0",
  "goals": 18,
  "assists": 4,
  "penaltiesScored": 5,
  "yellowCards": 2,
  "redCards": 0,
  "expectedGoals": 16.3,
  "expectedAssists": 3.1,
  "teamName": "Manchester City"
}
```

##Update player:

PUT /api/v1/player

##Delete player:

DELETE /api/v1/player/{playerName}

🗄️ Database
The application uses a PostgreSQL database with a table mapped to the Player entity

▶️ Running the application
1.Clone the repository
2.Configure PostgreSQL connection in application.properties
3.Run the application:

mvn spring-boot:run

The API will be available at:
http://localhost:8081/api/v1/player



