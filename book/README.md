#Build
    mvn clean install package -U

#Deploy
## Wildfly
The following command assumes that the wildfly `JBOSS_HOME` environment variable is defined
    mvn clean install wildfly:deploy

## Wildfly Swarm
(nothing to do as the `target/book-swarm.jar` will be created during the `package` stage)

#Run (Wildfly Swarm)
## Default profile
This will use the values in `src/resources/project-defaults.yaml`
    java -jar target/book-swarm.jar -Dswarm.http.port=9090

## Production profile option 1
This will use the values in `src/resources/project-prod.yaml
    java -jar target/book-swarm.jar -S prod -Dswarm.http.port=9090
## Production profile option 2
This wil use the (external to the jar file `project-postgres-prod.yaml`)
    java -jar target/book-swarm.jar project-postgres-prod.yaml -Dswarm.http.port=9090
## Development profile option 1
This will use the values in `src/resources/project-dev.yaml
    java -jar target/book-swarm.jar -S dev -Dswarm.http.port=9090
## Development profile option 2
This wil use the (external to the jar file `project-postgres-dev.yaml`)
    java -jar target/book-swarm.jar project-postgres-dev.yaml -Dswarm.http.port=9090
