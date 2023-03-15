package pl.com.chrzanowski.scma.domain;

import pl.com.chrzanowski.scma.domain.enumeration.Country;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "workshops")
public class Workshop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200)
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "street")
    private String street;
    @Column(name = "building_no")
    private String buildingNo;
    @Column(name = "apartment_no")
    private String apartmentNo;

    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    @Enumerated(EnumType.ORDINAL)
    private Country country;
    @OneToMany(mappedBy = "serviceActionType")
    private Set<WorkshopServiceActionType> serviceActionTypeSet = new HashSet<>();
    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;

    public Workshop() {
    }

    public Workshop(Long id,
                    String name,
                    String taxNumber,
                    String street,
                    String buildingNo,
                    String apartmentNo,
                    String postalCode,
                    String city,
                    Country country,
                    Set<WorkshopServiceActionType> serviceActionTypeSet,
                    Instant createDate,
                    Instant modifyDate,
                    Instant removeDate) {
        this.id = id;
        this.name = name;
        this.taxNumber = taxNumber;
        this.street = street;
        this.buildingNo = buildingNo;
        this.apartmentNo = apartmentNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.serviceActionTypeSet = serviceActionTypeSet;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public Set<WorkshopServiceActionType> getServiceActionTypeSet() {
        return serviceActionTypeSet;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public Instant getModifyDate() {
        return modifyDate;
    }

    public Instant getRemoveDate() {
        return removeDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setServiceActionTypeSet(Set<WorkshopServiceActionType> serviceActionTypeSet) {
        this.serviceActionTypeSet = serviceActionTypeSet;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
    }

    public void setRemoveDate(Instant removeDate) {
        this.removeDate = removeDate;
    }


    public Workshop id(Long id) {
        this.id = id;
        return this;
    }

    public Workshop name(String name) {
        this.name = name;
        return this;
    }

    public Workshop taxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
        return this;
    }

    public Workshop street(String street) {
        this.street = street;
        return this;
    }

    public Workshop buildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
        return this;
    }

    public Workshop apartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
        return this;
    }

    public Workshop postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Workshop city(String city) {
        this.city = city;
        return this;
    }

    public Workshop country(Country country) {
        this.country = country;
        return this;
    }

    public Workshop actionTypes(Set<WorkshopServiceActionType> serviceActionTypeSet) {
        this.serviceActionTypeSet = serviceActionTypeSet;
        return this;
    }

    public Workshop createDate(Instant createDate) {
        this.createDate = createDate;
        return this;
    }

    public Workshop modifyDate(Instant modifyDate) {
        this.modifyDate = modifyDate;
        return this;
    }

    public Workshop removeDate(Instant removeDate) {
        this.removeDate = removeDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workshop workshop = (Workshop) o;

        if (!Objects.equals(id, workshop.id)) return false;
        if (!Objects.equals(name, workshop.name)) return false;
        if (!Objects.equals(taxNumber, workshop.taxNumber)) return false;
        if (!Objects.equals(street, workshop.street)) return false;
        if (!Objects.equals(buildingNo, workshop.buildingNo)) return false;
        if (!Objects.equals(apartmentNo, workshop.apartmentNo))
            return false;
        if (!Objects.equals(postalCode, workshop.postalCode)) return false;
        if (!Objects.equals(city, workshop.city)) return false;
        if (country != workshop.country) return false;
        if (!Objects.equals(serviceActionTypeSet, workshop.serviceActionTypeSet))
            return false;
        if (!Objects.equals(createDate, workshop.createDate)) return false;
        if (!Objects.equals(modifyDate, workshop.modifyDate)) return false;
        return Objects.equals(removeDate, workshop.removeDate);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (taxNumber != null ? taxNumber.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (buildingNo != null ? buildingNo.hashCode() : 0);
        result = 31 * result + (apartmentNo != null ? apartmentNo.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (serviceActionTypeSet != null ? serviceActionTypeSet.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", street='" + street + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", apartmentNo='" + apartmentNo + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", serviceActionTypeSet=" + serviceActionTypeSet +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                '}';
    }
}
