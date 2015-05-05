package com.beto.test.hz.sh.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
public class Departments {
    private int departmentId;
    private String departmentName;

    @Id
    @Column(name = "department_id", nullable = false, insertable = true, updatable = true)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name", nullable = false, insertable = true, updatable = true, length = 30)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departments that = (Departments) o;

        if (departmentId != that.departmentId) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        return result;
    }
}
