## Use maven:3.6.3 as the base image
FROM maven:3.6.3-jdk-8-slim

# Copy the current directory contents into the container at /app
COPY . /app

# Set the working directory
WORKDIR /app

# Build the application
RUN mvn clean install

# Expose the port the application runs on
EXPOSE 8080

# Define the entry point to run the application with Jetty
ENTRYPOINT ["mvn", "jetty:run"]
