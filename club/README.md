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
