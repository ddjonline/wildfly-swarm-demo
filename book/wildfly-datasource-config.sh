./jboss-cli.sh

module add --name=org.postgres --resources=/tmp/postgresql-42.2.2.jar --dependencies=javax.api,javax.transaction.api

/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

/subsystem=datasources/data-source=bookDS/:add(connection-url=jdbc:postgresql://localhost:5432/bookprod,driver-name=postgres,jndi-name=java:/jboss/datasources/bookDS,initial-pool-size=4,max-pool-size=64,min-pool-size=4,password=confighub,user-name=confighub)

exit
