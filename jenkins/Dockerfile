# Use Jenkins image with Java 21
FROM jenkins/jenkins:jdk21

USER root

# Ensure correct ownership of Jenkins home directory
RUN mkdir -p /var/jenkins_home && chown -R jenkins:jenkins /var/jenkins_home

# Install dependencies including wget and tar
RUN apt-get update && apt-get install -y wget tar

# Install Maven 3.9.6
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.tar.gz -O /tmp/maven.tar.gz \
    && tar -xzf /tmp/maven.tar.gz -C /opt \
    && ln -s /opt/apache-maven-3.9.6 /opt/maven \
    && rm /tmp/maven.tar.gz

# Set Maven environment variables
ENV MAVEN_HOME=/opt/maven
ENV PATH="${MAVEN_HOME}/bin:${PATH}"

USER jenkins
