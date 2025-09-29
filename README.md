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
- **Node.js** - Runtime environment
- **Express.js** - Web framework
- **MongoDB** - Database
- **Mongoose** - MongoDB object modeling

### Frontend
- **React** - UI library
- **React Router** - Client-side routing
- **Axios** - HTTP client
- **CSS3** - Styling

## 📋 Application Status Types

- **Applied** - Application submitted
- **Interviewing** - In interview process
- **Rejected** - Application rejected
- **Selected** - Job offer received
- **Ghosted** - No response from company

## 🚀 Getting Started

### Prerequisites
- Node.js (v14 or higher)
- MongoDB (local installation or MongoDB Atlas)
- Git

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/jobrecord.git
   cd jobrecord
   ```

2. **Setup Backend**
   ```bash
   cd backend
   npm install
   ```

3. **Setup Frontend**
   ```bash
   cd ../frontend
   npm install
   ```

## 📡 API Endpoints

### Jobs
- `GET /api/jobs` - Get all job applications
- `POST /api/jobs` - Create new job application
- `GET /api/jobs/:id` - Get specific job application
- `PUT /api/jobs/:id` - Update job application
- `DELETE /api/jobs/:id` - Delete job application

## 🎯 Future Enhancements

- [ ] Email notifications for follow-ups
- [ ] Integration with job boards (LinkedIn, Indeed)
- [ ] Resume version tracking
- [ ] Interview preparation notes
- [ ] Salary negotiation tracker
- [ ] Mobile application
- [ ] Export data to PDF/Excel
- [ ] Advanced analytics and insights

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m "Add some AmazingFeature"`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License.

## 👨‍💻 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn](https://linkedin.com/in/yourprofile)

---

**Star ⭐ this repository if it helps you in your job search!**
