# rest-api-with-jaxrs
Exposed rest api example with JAX-RS with Jersey as a provider

#start tomat using command
docker run -it --rm -p 8888:8080 -e TOMCAT_USERNAME=user -e TOMCAT_PASSWORD=tomcat -e TOMCAT_ALLOW_REMOTE_MANAGEMENT=1  bitnami/tomcat:latest

#build project
mvn clean package

#deploy using tomcat console
