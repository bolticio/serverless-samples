### SYSTEM GENERATED FILE, MAKE CHANGES AS NEEDED ###

# Build dependencies and create virtual environment
FROM harbor-core.fynd.engineering/public/base-images/python/debian:11-slim AS builder

# Set /python-dockerfile-app-sample as the working directory in the current stage
WORKDIR /python-dockerfile-app-sample

### COMMENT AS NEEDED ###
# Check if requirements.txt exists before copying
COPY requirements.txt ./

### DEFAULT BOOTSTRAP BUILD CODE, RUN LOCALLY TO GENERATE requirements.txt ###
# If requirements.txt exists and not empty, install the listed packages
# If it doesn't exist or is empty, print a message and skip the installation
RUN if [ -s requirements.txt ]; then \
        /venv/bin/pip install --disable-pip-version-check -r requirements.txt; \
    else \
        echo "No requirements.txt found, skipping installation"; \
    fi

# Start a new stage with a distroless image for smaller image size and improved security
FROM gcr.io/distroless/python3-debian11

# Copy the /venv directory from the builder stage into the current stage
# This includes the application code and the dependencies
COPY --from=builder /venv /venv

# Copy the rest of the application code
COPY . /python-dockerfile-app-sample

# Set /python-dockerfile-app-sample as the working directory in the current stage
WORKDIR /python-dockerfile-app-sample

# Set the command to run when the container starts
# This will start the application by running entrypoint file
ENTRYPOINT [ "/venv/bin/python", "index.py" ]
