# Hello World

Sample hello world application in Java.

## Run without building

```bash
mvn spring-boot:run
```

## Build

```bash
mvn clean install
```

## Run

```bash
java -jar target/serverless-app.jar
```

## Build and run Docker image

```bash
# Build
docker build -t java-dockerfile-app-sample-java17 .

# Run
docker run -p 8080:8080 java-dockerfile-app-sample-java17
```
