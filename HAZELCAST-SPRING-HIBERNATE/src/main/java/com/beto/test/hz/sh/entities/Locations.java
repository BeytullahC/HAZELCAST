package com.beto.test.hz.sh.entities;

import javax.persistence.*;

/**
 * Created by 912867 on 30.04.2015.
 */
@Entity
public class Locations {
    private int locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private Countries countriesByCountryId;

    @Id
    @Column(name = "location_id", nullable = false, insertable = true, updatable = true)
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "street_address", nullable = true, insertable = true, updatable = true, length = 40)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "postal_code", nullable = true, insertable = true, updatable = true, length = 12)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "city", nullable = false, insertable = true, updatable = true, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state_province", nullable = true, insertable = true, updatable = true, length = 25)
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locations locations = (Locations) o;

        if (locationId != locations.locationId) return false;
        if (streetAddress != null ? !streetAddress.equals(locations.streetAddress) : locations.streetAddress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(locations.postalCode) : locations.postalCode != null) return false;
        if (city != null ? !city.equals(locations.city) : locations.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(locations.stateProvince) : locations.stateProvince != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationId;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    public Countries getCountriesByCountryId() {
        return countriesByCountryId;
    }

    public void setCountriesByCountryId(Countries countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }
}
