# Build
```
mvn clean install
```

# Run
## Deploy to Wildfly (target JBoss platform determined by the `JBOSS_HOME` environment variable)
*Note: the target wildfly platform needs to be running as the deployment will notify the admin service on port `9990`*
```
mvn clean install wildfly:deploy
```

## Undeploy from Wildfly (wildfly must be running)
```
mvn wildfly:undeploy
```

# Test with siege (50 concurrent users for 10 seconds fetching clubs list)
```
siege --concurrent=50 -t10S 'http://localhost:8080/club/api/club'
```
