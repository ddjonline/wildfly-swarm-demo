# Build
```
mvn clean package
```

# Run
## Run the application using Payara Micro's hollow jar using HTTP port 7070 (prod)
```
java -Ddbhost=localhost -Ddbport=5432 -Ddb=memberprod -Ddbuser=confighub -Ddbpass=confighub -jar payara-micro-5.181.jar --deploy target/member.war --port 7070
```

## Run the application using Payara Micro's hollow jar using HTTP port 7070 (dev)
```
java -Ddbhost=localhost -Ddbport=5432 -Ddb=memberdev -Ddbuser=confighub -Ddbpass=confighub -jar payara-micro-5.181.jar --deploy target/member.war --port 7070
```

# Test with siege
## Payara deployment (50 concurrent users for 3 seconds fetching books list)
```
siege --concurrent=50 -t3S 'http://localhost:7070/member/api/member'
```