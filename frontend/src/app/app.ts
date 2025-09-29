import { Component, OnInit, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { JobService, Job } from './job.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent implements OnInit {
  title = 'JobRecord - Job Application Tracker';
  jobs: Job[] = [];
  private jobService = inject(JobService);

  ngOnInit() {
    this.loadJobs();
  }

  loadJobs() {
    this.jobService.getAllJobs().subscribe({
      next: (jobs) => {
        this.jobs = jobs;
        console.log('Jobs loaded:', jobs);
      },
      error: (error) => {
        console.error('Error loading jobs:', error);
        // For demo purposes, show some sample data when backend is not available
        this.jobs = [
          {
            id: 1,
            companyName: 'Tech Corp',
            position: 'Software Engineer',
            location: 'San Francisco, CA',
            status: 'APPLIED',
            applicationDate: new Date().toISOString()
          },
          {
            id: 2,
            companyName: 'StartupXYZ',
            position: 'Frontend Developer',
            location: 'New York, NY',
            status: 'INTERVIEWING',
            applicationDate: new Date().toISOString()
          }
        ];
      }
    });
  }
}
