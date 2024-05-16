### SYSTEM GENERATED FILE, MAKE CHANGES AS NEEDED ###

# Use a specific version as the base image for the builder stage
FROM golang:1.21-alpine AS builder

# Set /app as the working directory in the builder stage
WORKDIR /app

### UNCOMMENT AS NEEDED ###
# Copy go.mod and go.sum files into the builder stage
# This allows the dependencies to be installed before copying the rest of the application code
COPY go.sum ./
COPY go.mod ./

### DEFAULT BOOTSTRAP BUILD CODE, RUN LOCALLY TO GENERATE go.mod ###
# If go.mod exists and not empty, install the listed packages
# If it doesn't exist or is empty, print a message and skip the installation
RUN if [ -s go.mod ]; then \
        go mod download; \
    else \
        echo "No go.mod found, continuing with default settings"; \
        go mod init app; \
    fi

# Copy the rest of the application code into the builder stage
COPY . /app

# Build the application
RUN go build -v -o app .

# Start a new stage with a distroless image for smaller image size and improved security
FROM gcr.io/distroless/static-debian11

# Copy the /app directory from the builder stage into the current stage
# This includes the application code and the installed packages
COPY --from=builder /app /app

# Set /app as the working directory in the current stage
WORKDIR /app

# Set the command to run when the container starts
# This will start the application
CMD [ "./app" ]