# Spring Boot ELK Stack Sample

A comprehensive sample application demonstrating the integration of **Spring Boot** with the **ELK Stack** (
Elasticsearch, Logstash, and Kibana) for centralized logging and monitoring.

## 🏗️ Architecture Overview

This project showcases a modern logging architecture using:

- **Spring Boot 3.5.6** - Main application framework
- **Elasticsearch 9.1.4** - Search and analytics engine for log storage
- **Logstash 9.1.4** - Log processing pipeline for parsing and transforming logs
- **Kibana 9.1.4** - Visualization and analytics dashboard
- **MySQL** - Primary database for application data
- **Logback with Logstash Encoder** - Structured logging in JSON format

## 🚀 Features

- RESTful Customer API with CRUD operations
- Structured JSON logging using Logstash Logback Encoder
- Real-time log streaming to Elasticsearch via Logstash
- Interactive log visualization with Kibana dashboards
- Docker Compose setup for easy deployment
- Global exception handling with detailed error logging
- JPA/Hibernate integration for database operations

## 📋 Prerequisites

Before running this application, ensure you have:

- **Java 25** or higher
- **Maven 3.6+**
- **Docker** and **Docker Compose**
- **MySQL** (configured via Docker Compose)

## 🛠️ Technology Stack

### Backend

- **Spring Boot 3.5.6** - Application framework
- **Spring Data JPA** - Data persistence layer
- **Spring Web** - REST API development
- **MySQL Connector/J** - Database connectivity
- **Lombok** - Boilerplate code reduction

### Logging & Monitoring

- **Logstash Logback Encoder 8.1** - JSON structured logging
- **SLF4J** - Logging facade
- **Logback** - Logging implementation

### Infrastructure

- **Elasticsearch 9.1.4** - Document storage and search
- **Logstash 9.1.4** - Log processing pipeline
- **Kibana 9.1.4** - Data visualization
- **Docker Compose** - Container orchestration

## 🚀 Quick Start

### 1. Clone the Repository

```bash
git clone https://github.com/hendisantika/spring-boot-elk-sample.git
cd spring-boot-elk-sample
```

### 2. Start the ELK Stack

```bash
docker-compose up -d
```

This command will start:

- **Elasticsearch** on `http://localhost:9200`
- **Logstash** on port `5044`
- **Kibana** on `http://localhost:5601`

### 3. Build and Run the Application

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## 📡 API Endpoints

### Customer Management API

#### Get All Customers

```http
GET /api/v1/customers/all
```

#### Get Customer by ID

```http
GET /api/v1/customers?customerId={id}
```

### Example Usage

```bash
# Get all customers
curl -X GET http://localhost:8080/api/v1/customers/all

# Get specific customer
curl -X GET "http://localhost:8080/api/v1/customers?customerId=123"
```

## 🏗️ Project Structure

```
spring-boot-elk-sample/
├── src/
│   ├── main/
│   │   ├── java/id/my/hendisantika/elksample/
│   │   │   ├── controller/          # REST API controllers
│   │   │   ├── entity/              # JPA entities
│   │   │   ├── handler/             # Exception handlers
│   │   │   ├── repository/          # Data access layer
│   │   │   ├── service/             # Business logic layer
│   │   │   └── SpringBootElkSampleApplication.java
│   │   └── resources/
│   │       ├── application.yml      # Application configuration
│   │       └── logback-spring.xml   # Logging configuration
│   └── test/                        # Unit and integration tests
├── compose.yaml                     # Docker Compose configuration
├── Dockerfile                       # Application containerization
└── pom.xml                         # Maven dependencies
```

## 📊 Monitoring and Logging

### Accessing Kibana

1. Navigate to `http://localhost:5601`
2. Create an index pattern for your application logs
3. Explore logs in the Discover section
4. Create custom dashboards for monitoring

### Log Format

The application generates structured JSON logs that include:

- Timestamp
- Log level
- Logger name
- Thread name
- Message
- MDC (Mapped Diagnostic Context) data
- Stack traces (for errors)

### Sample Log Entry

```json
{
  "@timestamp": "2024-09-25T10:30:00.123Z",
  "level": "INFO",
  "logger_name": "id.my.hendisantika.elksample.controller.CustomerController",
  "thread_name": "http-nio-8080-exec-1",
  "message": "START - getAllCustomers",
  "mdc": {
    "traceId": "abc123",
    "spanId": "def456"
  }
}
```

## 🐳 Docker Configuration

### Services Overview

- **Elasticsearch**: Document store with disabled security for local development
- **Logstash**: Processes logs from the application on port 5044
- **Kibana**: Web interface for log visualization
- **Network**: All services communicate via the `elk-network` bridge network

### Resource Allocation

- **Elasticsearch**: 256MB heap size
- **Logstash**: 256MB heap size
- **Kibana**: Default resource allocation

## 🧪 Testing

Run the test suite:

```bash
./mvnw test
```

The project includes:

- Unit tests for service layer
- Integration tests for API endpoints
- Repository tests with in-memory database

## 📈 Performance Considerations

- **Elasticsearch**: Configured for single-node deployment (development only)
- **Logstash**: Optimized for local processing with minimal resource usage
- **Connection Pooling**: MySQL connections are managed by HikariCP (Spring Boot default)
- **Async Logging**: Logback configured for optimal performance

## 🚨 Production Considerations

Before deploying to production:

1. **Security**: Enable Elasticsearch security features
2. **Persistence**: Configure proper volume mounts for data persistence
3. **Resource Limits**: Adjust heap sizes based on production requirements
4. **Load Balancing**: Consider multiple Elasticsearch nodes
5. **Monitoring**: Add application metrics with Micrometer/Prometheus
6. **SSL/TLS**: Enable encryption for all communication channels

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Hendi Santika**

- Email: hendisantika@yahoo.co.id
- Telegram: [@hendisantika34](https://t.me/hendisantika34)
- Link: [s.id/hendisantika](https://s.id/hendisantika)

## 🆘 Troubleshooting

### Common Issues

#### Elasticsearch fails to start

- **Issue**: `max virtual memory areas vm.max_map_count [65530] is too low`
- **Solution**:
  ```bash
  sudo sysctl -w vm.max_map_count=262144
  ```

#### Logstash connection errors

- **Issue**: Cannot connect to Elasticsearch
- **Solution**: Ensure Elasticsearch is running and healthy before starting Logstash

#### Application cannot connect to MySQL

- **Issue**: Database connection refused
- **Solution**: Verify MySQL container is running via `docker-compose ps`

### Health Checks

```bash
# Check Elasticsearch
curl -X GET "localhost:9200/_health?wait_for_status=yellow&timeout=50s"

# Check Kibana
curl -X GET "localhost:5601/api/status"

# Check application
curl -X GET "localhost:8080/actuator/health"
```

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Elastic Stack Guide](https://www.elastic.co/guide/index.html)
- [Logstash Configuration](https://www.elastic.co/guide/en/logstash/current/configuration.html)
- [Kibana User Guide](https://www.elastic.co/guide/en/kibana/current/index.html)