package pl.com.chrzanowski.scma.service.dto;

import pl.com.chrzanowski.scma.domain.enumeration.Country;

import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class WorkshopDTO {
    private Long id;
    private String name;
    private String taxNumber;
    private String street;
    private String buildingNo;
    private String apartmentNo;
    private String postalCode;
    private String city;
    private Country country;
    private Long[] actionTypes;
    private Set<ServiceActionTypeDTO> serviceActionTypeSet;
    private Instant createDate;
    private Instant modifyDate;
    private Instant removeDate;

    public WorkshopDTO(Long id,
                       String name,
                       String taxNumber,
                       String street,
                       String buildingNo,
                       String apartmentNo,
                       String postalCode,
                       String city,
                       Country country,
                       Long[] actionTypes,
                       Set<ServiceActionTypeDTO> serviceActionTypeDTOSet,
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
        this.actionTypes = actionTypes;
        this.serviceActionTypeSet = serviceActionTypeDTOSet;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.removeDate = removeDate;
    }

    public WorkshopDTO() {
    }

    private WorkshopDTO(Builder builder) {
        id = builder.id;
        name = builder.name;
        taxNumber = builder.taxNumber;
        street = builder.street;
        buildingNo = builder.buildingNo;
        apartmentNo = builder.apartmentNo;
        postalCode = builder.postalCode;
        city = builder.city;
        country = builder.country;
        actionTypes = builder.actionTypes;
        serviceActionTypeSet = builder.serviceActionTypeSet;
        createDate = builder.createDate;
        modifyDate = builder.modifyDate;
        removeDate = builder.removeDate;
    }

    public static Builder builder() {
        return new Builder();
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

    public Long[] getActionTypes() {
        return actionTypes;
    }

    public Set<ServiceActionTypeDTO> getServiceActionTypeSet() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkshopDTO that = (WorkshopDTO) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(taxNumber, that.taxNumber)) return false;
        if (!Objects.equals(street, that.street)) return false;
        if (!Objects.equals(buildingNo, that.buildingNo)) return false;
        if (!Objects.equals(apartmentNo, that.apartmentNo)) return false;
        if (!Objects.equals(postalCode, that.postalCode)) return false;
        if (!Objects.equals(city, that.city)) return false;
        if (country != that.country) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(actionTypes, that.actionTypes)) return false;
        if (!Objects.equals(serviceActionTypeSet, that.serviceActionTypeSet))
            return false;
        if (!Objects.equals(createDate, that.createDate)) return false;
        if (!Objects.equals(modifyDate, that.modifyDate)) return false;
        return Objects.equals(removeDate, that.removeDate);
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
        result = 31 * result + Arrays.hashCode(actionTypes);
        result = 31 * result + (serviceActionTypeSet != null ? serviceActionTypeSet.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (removeDate != null ? removeDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkshopDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taxNumber='" + taxNumber + '\'' +
                ", street='" + street + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", apartmentNo='" + apartmentNo + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", actionTypes=" + Arrays.toString(actionTypes) +
                ", serviceActionTypeDTOSet=" + serviceActionTypeSet +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                '}';
    }


    public static final class Builder {
        private Long id;
        private String name;
        private String taxNumber;
        private String street;
        private String buildingNo;
        private String apartmentNo;
        private String postalCode;
        private String city;
        private Country country;
        private Long[] actionTypes;
        private Set<ServiceActionTypeDTO> serviceActionTypeSet;
        private Instant createDate;
        private Instant modifyDate;
        private Instant removeDate;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder taxNumber(String taxNumber) {
            this.taxNumber = taxNumber;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder buildingNo(String buildingNo) {
            this.buildingNo = buildingNo;
            return this;
        }

        public Builder apartmentNo(String apartmentNo) {
            this.apartmentNo = apartmentNo;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder country(Country country) {
            this.country = country;
            return this;
        }

        public Builder actionTypes(Long[] actionTypes) {
            this.actionTypes = actionTypes;
            return this;
        }

        public Builder serviceActionTypeSet(Set<ServiceActionTypeDTO> serviceActionTypeSet) {
            this.serviceActionTypeSet = serviceActionTypeSet;
            return this;
        }

        public Builder createDate(Instant createDate) {
            this.createDate = createDate;
            return this;
        }

        public Builder modifyDate(Instant modifyDate) {
            this.modifyDate = modifyDate;
            return this;
        }

        public Builder removeDate(Instant removeDate) {
            this.removeDate = removeDate;
            return this;
        }

        public WorkshopDTO build() {
            return new WorkshopDTO(this);
        }
    }
}
