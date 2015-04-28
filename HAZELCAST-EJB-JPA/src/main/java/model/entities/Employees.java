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
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 912867
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
        @NamedQuery(name = "Employees.findByEmployeeId", query = "SELECT e FROM Employees e WHERE e.employeeId = :employeeId"),
        @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
        @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
        @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
        @NamedQuery(name = "Employees.findByPhoneNumber", query = "SELECT e FROM Employees e WHERE e.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "Employees.findByHireDate", query = "SELECT e FROM Employees e WHERE e.hireDate = :hireDate"),
        @NamedQuery(name = "Employees.findBySalary", query = "SELECT e FROM Employees e WHERE e.salary = :salary"),
        @NamedQuery(name = "Employees.findByCommissionPct", query = "SELECT e FROM Employees e WHERE e.commissionPct = :commissionPct")})
public class Employees implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "employee_id")
    private Integer employeeId;
    @Size(max = 20)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "last_name")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "commission_pct")
    private BigDecimal commissionPct;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<Departments> departmentsList;
    @OneToMany(mappedBy = "managerId", fetch = FetchType.LAZY)
    private List<model.entities.Employees> employeesList;
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private model.entities.Employees managerId;
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Departments departmentId;
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jobs jobId;

    public Employees() {
    }

    public Employees(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employees(Integer employeeId, String lastName, String email, Date hireDate, BigDecimal salary) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    @XmlTransient
    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    @XmlTransient
    public List<model.entities.Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<model.entities.Employees> employeesList) {
        this.employeesList = employeesList;
    }

    public model.entities.Employees getManagerId() {
        return managerId;
    }

    public void setManagerId(model.entities.Employees managerId) {
        this.managerId = managerId;
    }

    public Departments getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Departments departmentId) {
        this.departmentId = departmentId;
    }

    public Jobs getJobId() {
        return jobId;
    }

    public void setJobId(Jobs jobId) {
        this.jobId = jobId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof model.entities.Employees)) {
            return false;
        }
        model.entities.Employees other = (model.entities.Employees) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.project.hazelcast.jpa.com.beto.project.hazelcast.jpa.model.Employees[ employeeId=" + employeeId + " ]";
    }

}
