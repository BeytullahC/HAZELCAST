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
@Table(name = "countries")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c"),
        @NamedQuery(name = "Countries.findByCountryId", query = "SELECT c FROM Countries c WHERE c.countryId = :countryId"),
        @NamedQuery(name = "Countries.findByCountryName", query = "SELECT c FROM Countries c WHERE c.countryName = :countryName")})
public class Countries implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "country_id")
    private String countryId;
    @Size(max = 40)
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryId", fetch = FetchType.LAZY)
    private List<Locations> locationsList;
    @JoinColumn(name = "region_id", referencedColumnName = "region_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Regions regionId;

    public Countries() {
    }

    public Countries(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public List<Locations> getLocationsList() {
        return locationsList;
    }

    public void setLocationsList(List<Locations> locationsList) {
        this.locationsList = locationsList;
    }

    public Regions getRegionId() {
        return regionId;
    }

    public void setRegionId(Regions regionId) {
        this.regionId = regionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.project.hazelcast.jpa.com.beto.project.hazelcast.jpa.model.Countries[ countryId=" + countryId + " ]";
    }

}
