# Simple GPS-Track-Service

## Run

### dev
Run these in parallel

- `gps-track-service-backend` as Java-Application in Eclipse
- `webpack-dev-server --inline --hot` in `gps-track-service-frontend`

Goto http://localhost:8080 (the webpack devmode server)

### release
`mvn package && java -jar gps-track-service-backend/target/gps-track-service-backend-0.0.1-SNAPSHOT.war` 
Goto http://localhost:8090 (the embedded tomcat)
