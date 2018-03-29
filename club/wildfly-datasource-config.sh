./jboss-cli.sh

module add --name=org.postgres --resources=/tmp/postgresql-42.2.2.jar --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

/subsystem=datasources/data-source=clubDS/:add(connection-url=jdbc:postgresql://localhost:5432/clubprod,driver-name=postgres,jndi-name=java:/jboss/datasources/clubDS,initial-pool-size=4,max-pool-size=64,min-pool-size=4,password=confighub,user-name=confighub)

exit