== What is it?

Sample project to demonstrate how to expose REST api using JAX-RS with Jersey as a provider

== How to setup tomcat server and database

Docker-compose file is provided in the project root directory.
hit command
[source, shell]
docker-compose up

=== Import data in database
http://www.postgresqltutorial.com/postgresql-sample-database/

== How to start application

package application using
[source, shell]
mvn clean package

===deploy using tomcat console
