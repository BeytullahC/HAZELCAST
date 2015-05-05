package com.beto.test.hz.sh.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
public class Countries implements Serializable {
    private String countryId;
    private String countryName;

    @Id
    @Column(name = "country_id", nullable = false, insertable = true, updatable = true, length = 2)
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "country_name", nullable = true, insertable = true, updatable = true, length = 40)
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Countries countries = (Countries) o;

        if (countryId != null ? !countryId.equals(countries.countryId) : countries.countryId != null) return false;
        if (countryName != null ? !countryName.equals(countries.countryName) : countries.countryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId != null ? countryId.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Countries{");
        sb.append("countryId='").append(countryId).append('\'');
        sb.append(", countryName='").append(countryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
