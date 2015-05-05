package com.beto.test.hz.sh.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
public class Employees {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private BigDecimal salary;
    private BigDecimal commissionPct;
    private Departments departmentsByDepartmentId;
    private Employees employeesByManagerId;

    @Id
    @Column(name = "employee_id", nullable = false, insertable = true, updatable = true)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "first_name", nullable = true, insertable = true, updatable = true, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = false, insertable = true, updatable = true, length = 25)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 25)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, insertable = true, updatable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "hire_date", nullable = false, insertable = true, updatable = true)
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "salary", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "commission_pct", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employees employees = (Employees) o;

        if (employeeId != employees.employeeId) return false;
        if (firstName != null ? !firstName.equals(employees.firstName) : employees.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employees.lastName) : employees.lastName != null) return false;
        if (email != null ? !email.equals(employees.email) : employees.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(employees.phoneNumber) : employees.phoneNumber != null)
            return false;
        if (hireDate != null ? !hireDate.equals(employees.hireDate) : employees.hireDate != null) return false;
        if (salary != null ? !salary.equals(employees.salary) : employees.salary != null) return false;
        if (commissionPct != null ? !commissionPct.equals(employees.commissionPct) : employees.commissionPct != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (commissionPct != null ? commissionPct.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    public Departments getDepartmentsByDepartmentId() {
        return departmentsByDepartmentId;
    }

    public void setDepartmentsByDepartmentId(Departments departmentsByDepartmentId) {
        this.departmentsByDepartmentId = departmentsByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    public Employees getEmployeesByManagerId() {
        return employeesByManagerId;
    }

    public void setEmployeesByManagerId(Employees employeesByManagerId) {
        this.employeesByManagerId = employeesByManagerId;
    }
}
