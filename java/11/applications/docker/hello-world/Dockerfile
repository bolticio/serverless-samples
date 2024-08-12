### SYSTEM GENERATED FILE, MAKE CHANGES AS NEEDED ###

# Use a specific version of OpenJDK as the base image for the builder stage
FROM jelastic/maven:3.9.8-openjdk-11.0.24-almalinux-9 AS builder

# Set /java-dockerfile-app-sample as the working directory in the builder stage
WORKDIR /java-dockerfile-app-sample

### UNCOMMENT AS NEEDED ###
# Copy pom.xml and any other necessary files into the builder stage
COPY pom.xml ./
COPY src /java-dockerfile-app-sample/src

### Install dependencies and build the application
# Maven will download dependencies and compile the application
RUN mvn clean package

# Use a new base image for the final stage, which has a smaller footprint
FROM eclipse-temurin:11-jre-jammy

# Set /java-dockerfile-app-sample as the working directory in the current stage
WORKDIR /java-dockerfile-app-sample

# Copy the compiled JAR file from the builder stage
COPY --from=builder /java-dockerfile-app-sample/target/serverless-app.jar /java-dockerfile-app-sample/serverless-app.jar

# Set the command to run when the container starts
# This will start the application by running the JAR file
CMD ["java", "-jar", "serverless-app.jar"]
