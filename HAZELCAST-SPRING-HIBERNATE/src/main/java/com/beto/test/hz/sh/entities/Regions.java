package com.beto.test.hz.sh.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
public class Regions {
    private int regionId;
    private String regionName;

    @Id
    @Column(name = "region_id", nullable = false, insertable = true, updatable = true)
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "region_name", nullable = true, insertable = true, updatable = true, length = 25)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Regions regions = (Regions) o;

        if (regionId != regions.regionId) return false;
        if (regionName != null ? !regionName.equals(regions.regionName) : regions.regionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionId;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }
}
