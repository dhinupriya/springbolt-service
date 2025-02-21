# Use OpenJDK 21 as the base image
FROM openjdk:21

# Set working directory
WORKDIR /app

# Create necessary directories for New Relic and logs
RUN mkdir -p /app/newrelic /app/logs

# Download New Relic agent - this didn't work so manually downloaded & copying the jar to container
#RUN curl -fsSL -o /app/newrelic/newrelic-agent-8.18.0.jar https://download.newrelic.com/newrelic/java-agent/newrelic-agent/8.18.0/newrelic-agent-8.18.0.jar && \
#    chmod 755 /app/newrelic/newrelic-agent-8.18.0.jar

# Copy New Relic Config and agent jar from `newrelic/` directory
COPY ./newrelic/newrelic.yml /app/newrelic/newrelic.yml
COPY ./newrelic/newrelic-agent.jar /app/newrelic/newrelic-agent.jar

# Copy Logback configuration from the `logback/` directory
COPY ./logback/logback.xml /app/logback.xml

# Copy the application JAR
COPY target/springbolt-service-0.0.1-SNAPSHOT.jar app.jar

ENV JAVA_OPTS="-javaagent:/app/newrelic/newrelic-agent.jar -Dnewrelic.config.file=/app/newrelic/newrelic.yml -Dlogging.config=/app/logback.xml"

# Expose required ports
EXPOSE 8080

# Run the application with New Relic agent and Logback config
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]

# you can try if below works
#ENTRYPOINT ["java", "-javaagent:/app/newrelic/newrelic.jar", "-Dnewrelic.config.file=/app/newrelic/newrelic.yml", "-Dlogging.config=/app/logback.xml", "-jar", "app.jar"]