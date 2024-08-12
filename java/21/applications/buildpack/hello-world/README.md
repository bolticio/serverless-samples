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

## Build and run Docker image via Buildpacks

- Requirements
    - [Docker](https://docs.docker.com/get-docker/)
    - [Pack CLI](https://buildpacks.io/docs/tools/pack/)

```bash
# Build
pack build java-buildpack-app-sample-java21 --path . --builder paketobuildpacks/builder-jammy-base --buildpack paketo-buildpacks/java

# Run
docker run -p 8080:8080 java-buildpack-app-sample-java21
```
