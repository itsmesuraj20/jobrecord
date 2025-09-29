#!/bin/bash

echo "🔧 Starting Spring Boot Backend with Hot Reload..."
echo "================================================"

cd backend

# Add spring-boot-devtools for hot reload
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev -Dspring.devtools.restart.enabled=true"