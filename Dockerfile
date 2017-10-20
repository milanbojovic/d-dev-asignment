# Use an Maven as a parent image
FROM maven as builder

# Set the working directory to /code
WORKDIR /code
# Copy source code into container at path /code
ADD ./BackendEngineerAssignment /code
RUN mvn package 

#Use JRE image 
FROM java:8-jre
WORKDIR /app
COPY --from=builder /code/target/BackendEngineerAssignment-1.0-SNAPSHOT.jar .
#CMD java -jar /app/BackendEngineerAssignment-1.0-SNAPSHOT.jar
CMD /bin/sh

# Make ports available to the world outside this container
EXPOSE 8080 8080
