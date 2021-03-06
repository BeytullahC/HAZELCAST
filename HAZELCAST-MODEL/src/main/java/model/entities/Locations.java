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
@Table(name = "locations")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Locations.findAll", query = "SELECT l FROM Locations l"),
        @NamedQuery(name = "Locations.findByLocationId", query = "SELECT l FROM Locations l WHERE l.locationId = :locationId"),
        @NamedQuery(name = "Locations.findByStreetAddress", query = "SELECT l FROM Locations l WHERE l.streetAddress = :streetAddress"),
        @NamedQuery(name = "Locations.findByPostalCode", query = "SELECT l FROM Locations l WHERE l.postalCode = :postalCode"),
        @NamedQuery(name = "Locations.findByCity", query = "SELECT l FROM Locations l WHERE l.city = :city"),
        @NamedQuery(name = "Locations.findByStateProvince", query = "SELECT l FROM Locations l WHERE l.stateProvince = :stateProvince")})
public class Locations implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Integer locationId;
    @Size(max = 40)
    @Column(name = "street_address")
    private String streetAddress;
    @Size(max = 12)
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "city")
    private String city;
    @Size(max = 25)
    @Column(name = "state_province")
    private String stateProvince;
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Countries countryId;
    @OneToMany(mappedBy = "locationId", fetch = FetchType.LAZY)
    private List<Departments> departmentsList;

    public Locations() {
    }

    public Locations(Integer locationId) {
        this.locationId = locationId;
    }

    public Locations(Integer locationId, String city) {
        this.locationId = locationId;
        this.city = city;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Countries getCountryId() {
        return countryId;
    }

    public void setCountryId(Countries countryId) {
        this.countryId = countryId;
    }

    @XmlTransient
    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Locations)) {
            return false;
        }
        Locations other = (Locations) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.beto.project.hazelcast.jpa.com.beto.project.hazelcast.jpa.model.entities.Locations[ locationId=" + locationId + " ]";
    }

}
