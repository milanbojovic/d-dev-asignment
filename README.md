# D * * * * E DEV ASSIGNMENT

Simple SpringBoot app for exposing data from MongoDB through REST (using Docker containerized environment)

## Getting Started

These instructions will get you a copy of the project on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

```bash
#Clone Github project
git clone https://github.com/milanbojovic/d-dev-asignment.git
```

### Prerequisites
Linux/Unix/Windows PC with latest version of Docker and Docker-compose

### Installing dependencies (Ubuntu):
https://www.digitalocean.com/community/tutorials/how-to-install-docker-compose-on-ubuntu-16-04
https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-16-04


## Running the app:
```bash
#Following command builds and runs all needed dependencies
git clone https://github.com/milanbojovic/d-dev-asignment.git
```
When app is started docker creates two main containers and two helper containers:
  1. MongoDB   (port: 27017)
  2. Web Server (port: 8080)
  3. Tmp container1 used for automatic database population (from file which is located in data/polls) 
  4. Tmp container2 used for creating index for full text search in database 
  
  Temp containers are stopped when their execution is finished.

## Container contents:
1. MongoDB has MongoDB database and script for initializing database with data from JSON file
2. WebServer clones git repository (fetches latest code from Github) and builds jar file for the app, deploys that jar file to java enabled container which will run it

## App usage
* http://localhost:8080/ - **BASE ENDPOINT** provides information to navigate the site's REST interfaces (HATEOAS)
 
* http://localhost:8080/polls{?page,size,sort} - - **POLLS ENDPOINT** provides list of all User polls

* http://localhost:8080/polls/search/findByInitiatedAfter{?time} - **CREATION DATE FILTERING ENDPOINT** provides all polls which were created after specific date (long value !!!)

* http://localhost:8080/polls/search/findByText{?text} - **TEXT SEARCH ENDPOINT** provides full text search functionality

## Deployment

This software can be deployed on any environment using Docker and Docker-compose

## Author

* **Milan Bojovic**

## Development chalenges:
I have chosen MongoDB for this project since I think that it is the best database for this since it supports JSON  natively and my test data was in JSON format.
This was my first Spring Boot application, so I needed to read a lot about Spring Boot itself, I have experienced a lot of troubles when I tried to create my custom repository for providing full text search functionality. Eventually I have succeeded with that but I had problem exposing that custom method implementation over REST, that is why I’ve moved to other approach and I have implemented custom query with @Query annotation with text index on database level.
This was also my first Docker app - I have used Docker before for running containers created by others, and this was my first Dockerfile and docker compose file. While I worked on this project I have created separate Dockerfiles for all parts of system and later I've decided to remove unnecessary one since docker-compose can help me to exclude one Dockerfile. I had troubles with connecting ports to host, for hitting localhost address in target container, importing data and creating indexes on database from container. 
Conclusion: Docker and Docker-compose are definitely the way to go in the future, since I didn't had too many issues running this code on remote server with Docker. And I have definitely spent more than 3 hours on this but it was worth it since I've learned a lot. Regarding improvements: I would change creation date filtering to accept real date instead of long value, and maybe I would add Swagger documentation and it would be much easier for anybody to check how these endpoints work.
## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
