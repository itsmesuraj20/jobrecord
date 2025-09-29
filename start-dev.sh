#!/bin/bash

# JobRecord - Development Startup Script
# This script starts both backend (Spring Boot) and frontend (Angular) with hot reload

echo "🚀 Starting JobRecord Development Environment..."
echo "================================================"

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 17 or higher."
    exit 1
fi

# Check if Node.js is installed
if ! command -v node &> /dev/null; then
    echo "❌ Node.js is not installed. Please install Node.js."
    exit 1
fi

# Check if Maven is installed
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven is not installed. Please install Maven."
    exit 1
fi

# Function to kill background processes on script exit
cleanup() {
    echo "🛑 Stopping development servers..."
    kill $BACKEND_PID $FRONTEND_PID 2>/dev/null
    exit
}

# Set up signal handlers
trap cleanup SIGINT SIGTERM

# Start Backend (Spring Boot with hot reload)
echo "🔧 Starting Spring Boot backend on port 8080..."
cd backend
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.profiles.active=dev" &
BACKEND_PID=$!
cd ..

# Wait a moment for backend to start
sleep 5

# Start Frontend (Angular with hot reload)
echo "🎨 Starting Angular frontend on port 4200..."
cd frontend
npm start &
FRONTEND_PID=$!
cd ..

echo ""
echo "✅ Development servers are starting up..."
echo "📱 Frontend: http://localhost:4200"
echo "🔧 Backend:  http://localhost:8080"
echo "🗄️  H2 Console: http://localhost:8080/h2-console"
echo ""
echo "💡 Both servers support hot reload - your changes will be reflected automatically!"
echo "🛑 Press Ctrl+C to stop both servers"
echo ""

# Wait for both processes
wait $BACKEND_PID $FRONTEND_PID