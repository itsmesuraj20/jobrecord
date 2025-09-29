import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Job {
    id?: number;
    companyName: string;
    position: string;
    location: string;
    status: string;
    applicationDate?: string;
    jobUrl?: string;
    salaryRange?: string;
    recruiterName?: string;
    recruiterEmail?: string;
    recruiterPhone?: string;
    notes?: string;
    followUpDate?: string;
}

@Injectable({
    providedIn: 'root'
})
export class JobService {
    private apiUrl = 'http://localhost:8080/api/jobs';

    constructor(private http: HttpClient) { }

    getAllJobs(): Observable<Job[]> {
        return this.http.get<Job[]>(this.apiUrl);
    }

    getJobById(id: number): Observable<Job> {
        return this.http.get<Job>(`${this.apiUrl}/${id}`);
    }

    createJob(job: Job): Observable<Job> {
        return this.http.post<Job>(this.apiUrl, job);
    }

    updateJob(id: number, job: Job): Observable<Job> {
        return this.http.put<Job>(`${this.apiUrl}/${id}`, job);
    }

    deleteJob(id: number): Observable<any> {
        return this.http.delete(`${this.apiUrl}/${id}`);
    }

    searchJobs(companyName?: string, position?: string, status?: string): Observable<Job[]> {
        let params: any = {};
        if (companyName) params.companyName = companyName;
        if (position) params.position = position;
        if (status) params.status = status;

        return this.http.get<Job[]>(`${this.apiUrl}/search`, { params });
    }
}