# Use CentOS 7 as the base image
FROM centos:7

# Update the system
RUN yum -y update && yum clean all

# Install dependencies
RUN yum -y install java-1.8.0-openjdk-devel wget && yum clean all

# Install wget
RUN yum -y install wget && yum clean all

# Install Maven
RUN wget --no-check-certificate 'https://docs.google.com/uc?export=download&id=1yegLa3aKN9b1UukuHDQzywRli6V3a0dQ' -O apache-maven-3.6.3-bin.tar.gz \
    && tar -xzvf apache-maven-3.6.3-bin.tar.gz -C /opt \
    && ln -s /opt/apache-maven-3.6.3 /opt/maven \
    && rm apache-maven-3.6.3-bin.tar.gz

# Set environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
ENV M2_HOME=/opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=$M2_HOME/bin:$PATH

# Source the profile
RUN echo "source /etc/profile" >> ~/.bashrc

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
