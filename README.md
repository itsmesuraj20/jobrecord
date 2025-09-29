# JobRecord 📊

A comprehensive job application tracking system to help you manage your job search efficiently. Track applications, monitor status changes, and never lose sight of your career opportunities.

## 🚀 Features

- **Application Tracking**: Record job applications with detailed information
- **Status Management**: Track application status (Applied, Interviewing, Rejected, Selected, Ghosted)
- **Interactive Dashboard**: View all applications in an organized, filterable interface
- **Search & Filter**: Find applications by company, position, status, or date
- **Notes & Follow-ups**: Add personal notes and set follow-up reminders
- **Contact Management**: Store recruiter and contact information
- **Analytics**: Visualize your job search progress and success rates

## 🛠️ Tech Stack

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.1.5** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Data persistence
- **JWT** - Token-based authentication
- **H2 Database** - In-memory database (development)
- **Maven** - Build tool

### Frontend
- **Angular 20** - Frontend framework
- **TypeScript** - Programming language
- **RxJS** - Reactive programming
- **Angular CLI** - Development tools

## 📋 Application Status Types

- **Applied** - Application submitted
- **Interviewing** - In interview process
- **Rejected** - Application rejected
- **Selected** - Job offer received
- **Ghosted** - No response from company

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Node.js 18 or higher
- Maven 3.6 or higher
- Git

### Quick Start (Both services with hot reload)

1. **Clone the repository**
   ```bash
   git clone https://github.com/itsmesuraj20/jobrecord.git
   cd jobrecord
   ```

2. **Start both backend and frontend**
   ```bash
   ./start-dev.sh
   ```

   This will start:
   - Backend on http://localhost:8080 (with hot reload)
   - Frontend on http://localhost:4200 (with hot reload)
   - H2 Console on http://localhost:8080/h2-console

### Individual Service Setup

#### Backend Only
```bash
./start-backend.sh
```

#### Frontend Only
```bash
./start-frontend.sh
```

### Manual Setup

#### Backend Setup
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

#### Frontend Setup
```bash
cd frontend
npm install
npm start
```

## 🔧 Development

### Hot Reload
Both backend and frontend support hot reload:

- **Backend**: Uses Spring Boot DevTools - automatically restarts when Java files change
- **Frontend**: Uses Angular CLI dev server - automatically recompiles and refreshes when TypeScript/HTML/CSS files change

### Database Access
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: `password`

## 📡 API Endpoints

### Authentication
- `POST /api/auth/signup` - Register new user
- `POST /api/auth/signin` - Login user

### Jobs
- `GET /api/jobs` - Get all job applications
- `POST /api/jobs` - Create new job application
- `GET /api/jobs/{id}` - Get specific job application
- `PUT /api/jobs/{id}` - Update job application
- `DELETE /api/jobs/{id}` - Delete job application
- `GET /api/jobs/search` - Search jobs with filters

## 🎯 Future Enhancements

- [ ] Email notifications for follow-ups
- [ ] Integration with job boards (LinkedIn, Indeed)
- [ ] Resume version tracking
- [ ] Interview preparation notes
- [ ] Salary negotiation tracker
- [ ] Mobile application
- [ ] Export data to PDF/Excel
- [ ] Advanced analytics and insights
- [ ] Real database integration (PostgreSQL/MySQL)

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m "Add some AmazingFeature"`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Suraj**
- GitHub: [@itsmesuraj20](https://github.com/itsmesuraj20)

---

**Star ⭐ this repository if it helps you in your job search!**
