package com.beto.test.hz.sh.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
public class Jobs {
    private String jobId;
    private String jobTitle;
    private Integer minSalary;
    private Integer maxSalary;

    @Id
    @Column(name = "job_id", nullable = false, insertable = true, updatable = true, length = 10)
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_title", nullable = false, insertable = true, updatable = true, length = 35)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "min_salary", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "max_salary", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jobs jobs = (Jobs) o;

        if (jobId != null ? !jobId.equals(jobs.jobId) : jobs.jobId != null) return false;
        if (jobTitle != null ? !jobTitle.equals(jobs.jobTitle) : jobs.jobTitle != null) return false;
        if (minSalary != null ? !minSalary.equals(jobs.minSalary) : jobs.minSalary != null) return false;
        if (maxSalary != null ? !maxSalary.equals(jobs.maxSalary) : jobs.maxSalary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId != null ? jobId.hashCode() : 0;
        result = 31 * result + (jobTitle != null ? jobTitle.hashCode() : 0);
        result = 31 * result + (minSalary != null ? minSalary.hashCode() : 0);
        result = 31 * result + (maxSalary != null ? maxSalary.hashCode() : 0);
        return result;
    }
}
