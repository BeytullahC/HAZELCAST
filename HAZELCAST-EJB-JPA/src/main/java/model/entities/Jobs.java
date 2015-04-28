/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * @author 912867
 */
@Entity
@Table(name = "jobs")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Jobs.findAll", query = "SELECT j FROM Jobs j"),
        @NamedQuery(name = "Jobs.findByJobId", query = "SELECT j FROM Jobs j WHERE j.jobId = :jobId"),
        @NamedQuery(name = "Jobs.findByJobTitle", query = "SELECT j FROM Jobs j WHERE j.jobTitle = :jobTitle"),
        @NamedQuery(name = "Jobs.findByMinSalary", query = "SELECT j FROM Jobs j WHERE j.minSalary = :minSalary"),
        @NamedQuery(name = "Jobs.findByMaxSalary", query = "SELECT j FROM Jobs j WHERE j.maxSalary = :maxSalary")})
public class Jobs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "job_id")
    private String jobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "min_salary")
    private Integer minSalary;
    @Column(name = "max_salary")
    private Integer maxSalary;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobId", fetch = FetchType.LAZY)
    private List<model.entities.Employees> employeesList;

    public Jobs() {
    }

    public Jobs(String jobId) {
        this.jobId = jobId;
    }

    public Jobs(String jobId, String jobTitle) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    @XmlTransient
    public List<model.entities.Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof model.entities.Jobs)) {
            return false;
        }
        model.entities.Jobs other = (model.entities.Jobs) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.project.hazelcast.jpa.com.beto.project.hazelcast.jpa.model.Jobs[ jobId=" + jobId + " ]";
    }

}