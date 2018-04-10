# Build
```
mvn clean package
```

# Run
## Run the application using Payara Micro's hollow jar using HTTP port 7070
```
java -Ddbhost=localhost -Ddbport=5432 -Ddb=memberprod -Ddbuser=confighub -Ddbpass=confighub -jar payara-micro-5.181.jar --deploy target/member.war --port 7070
```