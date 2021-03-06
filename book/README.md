# Build
## Build as a standard Swarm jar (uberjar)
 ```
 mvn clean install package -U
 ```

## Build as a hollow Swarm jar (all dependencies minus final war app file)
```
mvn clean package -Dswarm.hollow=true
```

# Deploy
## Wildfly
The following command assumes that the wildfly `JBOSS_HOME` environment variable is defined
```
mvn clean install wildfly:deploy
```

## Wildfly Swarm
*(nothing to do as the `target/book-swarm.jar` will be created during the `package` stage)*

# Run (Wildfly Swarm)
## Run with the uberjar using the default profile
This will use the values in `src/resources/project-defaults.yaml`
```
java -Xms64m -Xmx512m -jar target/book-swarm.jar -Dswarm.http.port=9090
```

## Run with the hollow jar using the default profile
This will use the values in `src/resources/project-defaults.yaml`
```
java -Xms64m -Xmx512m -jar target/book-hollow-swarm.jar target/book.war -Dswarm.http.port=9090
```

## Production profile option 1
This will use the values in `src/resources/project-prod.yaml
```
java -Xms64m -Xmx512m -jar target/book-swarm.jar -S prod -Dswarm.http.port=9090
```
## Production profile option 2
This wil use the (external to the jar file `project-postgres-prod.yaml`)
```
java -Xms64m -Xmx512m -jar target/book-swarm.jar project-postgres-prod.yaml -Dswarm.http.port=9090
```
## Development profile option 1
This will use the values in `src/resources/project-dev.yaml
```
java -Xms64m -Xmx512m -jar target/book-swarm.jar -S dev -Dswarm.http.port=9090
```
## Development profile option 2
This wil use the (external to the jar file `project-postgres-dev.yaml`)
```
java -Xms64m -Xmx512m -jar target/book-swarm.jar project-postgres-dev.yaml -Dswarm.http.port=9090
```

# Test with siege
## Wildfly deployment (50 concurrent users for 3 seconds fetching books list)
```
siege --concurrent=50 -t3S 'http://localhost:8080/book/api/book'
```
## Wildfly Swarm deployment (50 concurrent users for 3 seconds fetching books list)
```
siege --concurrent=50 -t3S 'http://localhost:9090/api/book'
```