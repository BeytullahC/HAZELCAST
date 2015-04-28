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
@Table(name = "regions")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Regions.findAll", query = "SELECT r FROM Regions r"),
        @NamedQuery(name = "Regions.findByRegionId", query = "SELECT r FROM Regions r WHERE r.regionId = :regionId"),
        @NamedQuery(name = "Regions.findByRegionName", query = "SELECT r FROM Regions r WHERE r.regionName = :regionName")})
public class Regions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "region_id")
    private Integer regionId;
    @Size(max = 25)
    @Column(name = "region_name")
    private String regionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId", fetch = FetchType.LAZY)
    private List<Countries> countriesList;

    public Regions() {
    }

    public Regions(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @XmlTransient
    public List<Countries> getCountriesList() {
        return countriesList;
    }

    public void setCountriesList(List<Countries> countriesList) {
        this.countriesList = countriesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof model.entities.Regions)) {
            return false;
        }
        model.entities.Regions other = (model.entities.Regions) object;
        if ((this.regionId == null && other.regionId != null) || (this.regionId != null && !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.project.hazelcast.jpa.com.beto.project.hazelcast.jpa.model.Regions[ regionId=" + regionId + " ]";
    }

}
