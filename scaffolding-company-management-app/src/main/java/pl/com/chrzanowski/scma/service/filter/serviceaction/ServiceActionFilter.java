package pl.com.chrzanowski.scma.service.filter.serviceaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class ServiceActionFilter {

    private Long id;
    private Integer carMileageStartsWith;
    private Integer carMileageEndWith;
    private String invoiceNumber;
    private BigDecimal grossValueStartsWith;
    private BigDecimal grossValueEndWith;
    private BigDecimal taxValueStartsWith;
    private BigDecimal taxValueEndWith;
    private BigDecimal netValueStartsWith;
    private BigDecimal netValueEndWith;
    private BigDecimal taxRateStartsWith;
    private BigDecimal taxRateEndWith;
    private LocalDate serviceDateStartsWith;
    private LocalDate serviceDateEndWith;
    private String description;
    private Long workshopId;
    private String workshopName;
    private Instant createDateStartWith;
    private Instant createDateEndWith;
    private Instant modifyDateStartWith;
    private Instant modifyDateEndWith;

    public ServiceActionFilter(Long id,
                               Integer carMileageStartsWith,
                               Integer carMileageEndWith,
                               String invoiceNumber,
                               BigDecimal grossValueStartsWith,
                               BigDecimal grossValueEndWith,
                               BigDecimal taxValueStartsWith,
                               BigDecimal taxValueEndWith,
                               BigDecimal netValueStartsWith,
                               BigDecimal netValueEndWith,
                               BigDecimal taxRateStartsWith,
                               BigDecimal taxRateEndWith,
                               LocalDate serviceDateStartsWith,
                               LocalDate serviceDateEndWith,
                               String description,
                               Long workshopId,
                               String workshopName,
                               Instant createDateStartWith,
                               Instant createDateEndWith,
                               Instant modifyDateStartWith,
                               Instant modifyDateEndWith) {
        this.id = id;
        this.carMileageStartsWith = carMileageStartsWith;
        this.carMileageEndWith = carMileageEndWith;
        this.invoiceNumber = invoiceNumber;
        this.grossValueStartsWith = grossValueStartsWith;
        this.grossValueEndWith = grossValueEndWith;
        this.taxValueStartsWith = taxValueStartsWith;
        this.taxValueEndWith = taxValueEndWith;
        this.netValueStartsWith = netValueStartsWith;
        this.netValueEndWith = netValueEndWith;
        this.taxRateStartsWith = taxRateStartsWith;
        this.taxRateEndWith = taxRateEndWith;
        this.serviceDateStartsWith = serviceDateStartsWith;
        this.serviceDateEndWith = serviceDateEndWith;
        this.description = description;
        this.workshopId = workshopId;
        this.workshopName = workshopName;
        this.createDateStartWith = createDateStartWith;
        this.createDateEndWith = createDateEndWith;
        this.modifyDateStartWith = modifyDateStartWith;
        this.modifyDateEndWith = modifyDateEndWith;
    }

    public ServiceActionFilter() {
    }

    private ServiceActionFilter(Builder builder) {
        id = builder.id;
        carMileageStartsWith = builder.carMileageStartsWith;
        carMileageEndWith = builder.carMileageEndWith;
        invoiceNumber = builder.invoiceNumber;
        grossValueStartsWith = builder.grossValueStartsWith;
        grossValueEndWith = builder.grossValueEndWith;
        taxValueStartsWith = builder.taxValueStartsWith;
        taxValueEndWith = builder.taxValueEndWith;
        netValueStartsWith = builder.netValueStartsWith;
        netValueEndWith = builder.netValueEndWith;
        taxRateStartsWith = builder.taxRateStartsWith;
        taxRateEndWith = builder.taxRateEndWith;
        serviceDateStartsWith = builder.serviceDateStartsWith;
        serviceDateEndWith = builder.serviceDateEndWith;
        description = builder.description;
        workshopId = builder.workshopId;
        workshopName = builder.workshopName;
        createDateStartWith = builder.createDateStartWith;
        createDateEndWith = builder.createDateEndWith;
        modifyDateStartWith = builder.modifyDateStartWith;
        modifyDateEndWith = builder.modifyDateEndWith;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ServiceActionFilter copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.carMileageStartsWith = copy.getCarMileageStartsWith();
        builder.carMileageEndWith = copy.getCarMileageEndWith();
        builder.invoiceNumber = copy.getInvoiceNumber();
        builder.grossValueStartsWith = copy.getGrossValueStartsWith();
        builder.grossValueEndWith = copy.getGrossValueEndWith();
        builder.taxValueStartsWith = copy.getTaxValueStartsWith();
        builder.taxValueEndWith = copy.getTaxValueEndWith();
        builder.netValueStartsWith = copy.getNetValueStartsWith();
        builder.netValueEndWith = copy.getNetValueEndWith();
        builder.taxRateStartsWith = copy.getTaxRateStartsWith();
        builder.taxRateEndWith = copy.getTaxRateEndWith();
        builder.serviceDateStartsWith = copy.getServiceDateStartsWith();
        builder.serviceDateEndWith = copy.getServiceDateEndWith();
        builder.description = copy.getDescription();
        builder.workshopId = copy.getWorkshopId();
        builder.workshopName = copy.getWorkshopName();
        builder.createDateStartWith = copy.getCreateDateStartWith();
        builder.createDateEndWith = copy.getCreateDateEndWith();
        builder.modifyDateStartWith = copy.getModifyDateStartWith();
        builder.modifyDateEndWith = copy.getModifyDateEndWith();
        return builder;
    }

    public Long getId() {
        return id;
    }

    public Integer getCarMileageStartsWith() {
        return carMileageStartsWith;
    }

    public Integer getCarMileageEndWith() {
        return carMileageEndWith;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public BigDecimal getGrossValueStartsWith() {
        return grossValueStartsWith;
    }

    public BigDecimal getGrossValueEndWith() {
        return grossValueEndWith;
    }

    public BigDecimal getTaxValueStartsWith() {
        return taxValueStartsWith;
    }

    public BigDecimal getTaxValueEndWith() {
        return taxValueEndWith;
    }

    public BigDecimal getNetValueStartsWith() {
        return netValueStartsWith;
    }

    public BigDecimal getNetValueEndWith() {
        return netValueEndWith;
    }

    public BigDecimal getTaxRateStartsWith() {
        return taxRateStartsWith;
    }

    public BigDecimal getTaxRateEndWith() {
        return taxRateEndWith;
    }

    public LocalDate getServiceDateStartsWith() {
        return serviceDateStartsWith;
    }

    public LocalDate getServiceDateEndWith() {
        return serviceDateEndWith;
    }

    public String getDescription() {
        return description;
    }

    public Long getWorkshopId() {
        return workshopId;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public Instant getCreateDateStartWith() {
        return createDateStartWith;
    }

    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    public Instant getModifyDateStartWith() {
        return modifyDateStartWith;
    }

    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }


    public static final class Builder {
        private Long id;
        private Integer carMileageStartsWith;
        private Integer carMileageEndWith;
        private String invoiceNumber;
        private BigDecimal grossValueStartsWith;
        private BigDecimal grossValueEndWith;
        private BigDecimal taxValueStartsWith;
        private BigDecimal taxValueEndWith;
        private BigDecimal netValueStartsWith;
        private BigDecimal netValueEndWith;
        private BigDecimal taxRateStartsWith;
        private BigDecimal taxRateEndWith;
        private LocalDate serviceDateStartsWith;
        private LocalDate serviceDateEndWith;
        private String description;
        private Long workshopId;
        private String workshopName;
        private Instant createDateStartWith;
        private Instant createDateEndWith;
        private Instant modifyDateStartWith;
        private Instant modifyDateEndWith;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder carMileageStartsWith(Integer carMileageStartsWith) {
            this.carMileageStartsWith = carMileageStartsWith;
            return this;
        }

        public Builder carMileageEndWith(Integer carMileageEndWith) {
            this.carMileageEndWith = carMileageEndWith;
            return this;
        }

        public Builder invoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder grossValueStartsWith(BigDecimal grossValueStartsWith) {
            this.grossValueStartsWith = grossValueStartsWith;
            return this;
        }

        public Builder grossValueEndWith(BigDecimal grossValueEndWith) {
            this.grossValueEndWith = grossValueEndWith;
            return this;
        }

        public Builder taxValueStartsWith(BigDecimal taxValueStartsWith) {
            this.taxValueStartsWith = taxValueStartsWith;
            return this;
        }

        public Builder taxValueEndWith(BigDecimal taxValueEndWith) {
            this.taxValueEndWith = taxValueEndWith;
            return this;
        }

        public Builder netValueStartsWith(BigDecimal netValueStartsWith) {
            this.netValueStartsWith = netValueStartsWith;
            return this;
        }

        public Builder netValueEndWith(BigDecimal netValueEndWith) {
            this.netValueEndWith = netValueEndWith;
            return this;
        }

        public Builder taxRateStartsWith(BigDecimal taxRateStartsWith) {
            this.taxRateStartsWith = taxRateStartsWith;
            return this;
        }

        public Builder taxRateEndWith(BigDecimal taxRateEndWith) {
            this.taxRateEndWith = taxRateEndWith;
            return this;
        }

        public Builder serviceDateStartsWith(LocalDate serviceDateStartsWith) {
            this.serviceDateStartsWith = serviceDateStartsWith;
            return this;
        }

        public Builder serviceDateEndWith(LocalDate serviceDateEndWith) {
            this.serviceDateEndWith = serviceDateEndWith;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder workshopId(Long workshopId) {
            this.workshopId = workshopId;
            return this;
        }

        public Builder workshopName(String workshopName) {
            this.workshopName = workshopName;
            return this;
        }

        public Builder createDateStartWith(Instant createDateStartWith) {
            this.createDateStartWith = createDateStartWith;
            return this;
        }

        public Builder createDateEndWith(Instant createDateEndWith) {
            this.createDateEndWith = createDateEndWith;
            return this;
        }

        public Builder modifyDateStartWith(Instant modifyDateStartWith) {
            this.modifyDateStartWith = modifyDateStartWith;
            return this;
        }

        public Builder modifyDateEndWith(Instant modifyDateEndWith) {
            this.modifyDateEndWith = modifyDateEndWith;
            return this;
        }

        public ServiceActionFilter build() {
            return new ServiceActionFilter(this);
        }
    }
}
