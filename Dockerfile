#Phase I [VCS] - Fetch code from github
FROM alpine/git as VCS
WORKDIR /tmp
RUN git clone https://github.com/milanbojovic/d-dev-asignment.git

#Phase II [BUILDER] - Use Maven for packaging jar file
FROM maven as BUILDER
WORKDIR /code
# Copy source code from PHASE I into current work dir
COPY --from=VCS /tmp/d-dev-asignment/BackendEngineerAssignment/ .
RUN mvn package 

#Phase III [RUNNER] - Use JRE image for running jar file
FROM java:8-jre as RUNNER
WORKDIR /app
COPY --from=BUILDER /code/target/BackendEngineerAssignment-1.0-SNAPSHOT.jar .
CMD java -jar /app/BackendEngineerAssignment-1.0-SNAPSHOT.jar

# Make ports available to the world outside this container
EXPOSE 8080 8080
