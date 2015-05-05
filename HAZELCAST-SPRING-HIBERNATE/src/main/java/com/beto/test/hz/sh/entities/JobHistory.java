package com.beto.test.hz.sh.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
@Table(name = "job_history", schema = "", catalog = "hr")
public class JobHistory {

    private Date startDate;
    private Date endDate;
    private Departments departmentsByDepartmentId;
    private Employees employeesByEmployeeId;


    @Column(name = "start_date", nullable = false, insertable = true, updatable = true)
    @Id
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = false, insertable = true, updatable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobHistory that = (JobHistory) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public Departments getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    public Employees getEmployeesByEmployeeId() {
        return employeesByEmployeeId;
    }

    public void setEmployeesByEmployeeId(Employees employeesByEmployeeId) {
        this.employeesByEmployeeId = employeesByEmployeeId;
    }
}
