
# Java Logging Agent
This repository contains a Java agent that intercepts and logs messages from SLF4J and Log4j2 logging frameworks, used in a Spring application. The agent writes the intercepted logs to a file named agent-logs.txt.

## Features
Supports both static and dynamic attachment to a Java application
No dependencies on any logging frameworks
Works with SLF4J and Log4j2 logs
## Requirements
- Java 8 or later
- Maven 3.x
## Building the Agent
### Clone the repository:

```
git clone https://github.com/andreyrusa/untitled.git
cd untitled
```
### Build the agent JAR file:
```
mvn clean package
```
The agent JAR file will be created in the target directory.

## Using the Agent
### Static Attachment
To use the agent with a Spring application, add the following JVM argument when starting the application:
```
-javaagent:/path/to/your/agent-jar-file.jar
```
Replace /path/to/your/agent-jar-file.jar with the actual path to the built agent JAR file.

### Dynamic Attachment
To attach the agent to a running JVM, use the provided AgentAttacher class, which utilizes the VirtualMachine API. Update the AgentAttacher class with the correct path to your agent JAR file and a unique part of the display name of your target JVM (e.g., the main class name or package).

Build and run the AgentAttacher:

```
mvn clean compile exec:java -Dexec.mainClass="org.example.AgentAttacher"
```

## License
This project is licensed under the MIT License.
