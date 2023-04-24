package pl.com.chrzanowski.scma.service.filter.tire;

import pl.com.chrzanowski.scma.domain.enumeration.*;

import java.time.Instant;

public class TireFilter {

    private Long id;
    private String brand;
    private String model;
    private Integer widthStartsWith;
    private Integer widthEndWith;
    private Integer profileStartsWith;
    private Integer profileEndWith;
    private Integer diameterStartsWith;
    private Integer diameterEndWith;
    private TireType type;
    private TireReinforcedIndex reinforcedIndex;
    private TireSpeedIndex speedIndex;
    private TireLoadCapacityIndex loadCapacityIndex;
    private TireSeasonType seasonType;
    private Boolean runOnFlat;
    private Instant createDateStartsWith;
    private Instant createDateEndWith;
    private Instant modifyDateStartsWith;
    private Instant modifyDateEndWith;
    private Instant removeDateStartsWith;
    private Instant removeDateEndWith;

    public TireFilter() {
    }

    private TireFilter(Builder builder) {
        setId(builder.id);
        setBrand(builder.brand);
        setModel(builder.model);
        setWidthStartsWith(builder.widthStartsWith);
        setWidthEndWith(builder.widthEndWith);
        setProfileStartsWith(builder.profileStartsWith);
        setProfileEndWith(builder.profileEndWith);
        setDiameterStartsWith(builder.diameterStartsWith);
        setDiameterEndWith(builder.diameterEndWith);
        setType(builder.type);
        setReinforcedIndex(builder.reinforcedIndex);
        setSpeedIndex(builder.speedIndex);
        setLoadCapacityIndex(builder.loadCapacityIndex);
        setSeasonType(builder.seasonType);
        setRunOnFlat(builder.runOnFlat);
        setCreateDateStartsWith(builder.createDateStartsWith);
        setCreateDateEndWith(builder.createDateEndWith);
        setModifyDateStartsWith(builder.modifyDateStartsWith);
        setModifyDateEndWith(builder.modifyDateEndWith);
        setRemoveDateStartsWith(builder.removeDateStartsWith);
        setRemoveDateEndWith(builder.removeDateEndWith);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public TireFilter setId(Long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public TireFilter setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public TireFilter setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getWidthStartsWith() {
        return widthStartsWith;
    }

    public TireFilter setWidthStartsWith(Integer widthStartsWith) {
        this.widthStartsWith = widthStartsWith;
        return this;
    }

    public Integer getWidthEndWith() {
        return widthEndWith;
    }

    public TireFilter setWidthEndWith(Integer widthEndWith) {
        this.widthEndWith = widthEndWith;
        return this;
    }

    public Integer getProfileStartsWith() {
        return profileStartsWith;
    }

    public TireFilter setProfileStartsWith(Integer profileStartsWith) {
        this.profileStartsWith = profileStartsWith;
        return this;
    }

    public Integer getProfileEndWith() {
        return profileEndWith;
    }

    public TireFilter setProfileEndWith(Integer profileEndWith) {
        this.profileEndWith = profileEndWith;
        return this;
    }

    public Integer getDiameterStartsWith() {
        return diameterStartsWith;
    }

    public TireFilter setDiameterStartsWith(Integer diameterStartsWith) {
        this.diameterStartsWith = diameterStartsWith;
        return this;
    }

    public Integer getDiameterEndWith() {
        return diameterEndWith;
    }

    public TireFilter setDiameterEndWith(Integer diameterEndWith) {
        this.diameterEndWith = diameterEndWith;
        return this;
    }

    public TireType getType() {
        return type;
    }

    public TireFilter setType(TireType type) {
        this.type = type;
        return this;
    }

    public TireReinforcedIndex getReinforcedIndex() {
        return reinforcedIndex;
    }

    public TireFilter setReinforcedIndex(TireReinforcedIndex reinforcedIndex) {
        this.reinforcedIndex = reinforcedIndex;
        return this;
    }

    public TireSpeedIndex getSpeedIndex() {
        return speedIndex;
    }

    public TireFilter setSpeedIndex(TireSpeedIndex speedIndex) {
        this.speedIndex = speedIndex;
        return this;
    }

    public TireLoadCapacityIndex getLoadCapacityIndex() {
        return loadCapacityIndex;
    }

    public TireFilter setLoadCapacityIndex(TireLoadCapacityIndex loadCapacityIndex) {
        this.loadCapacityIndex = loadCapacityIndex;
        return this;
    }

    public TireSeasonType getSeasonType() {
        return seasonType;
    }

    public TireFilter setSeasonType(TireSeasonType seasonType) {
        this.seasonType = seasonType;
        return this;
    }

    public Boolean getRunOnFlat() {
        return runOnFlat;
    }

    public TireFilter setRunOnFlat(Boolean runOnFlat) {
        this.runOnFlat = runOnFlat;
        return this;
    }

    public Instant getCreateDateStartsWith() {
        return createDateStartsWith;
    }

    public TireFilter setCreateDateStartsWith(Instant createDateStartsWith) {
        this.createDateStartsWith = createDateStartsWith;
        return this;
    }

    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    public TireFilter setCreateDateEndWith(Instant createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
        return this;
    }

    public Instant getModifyDateStartsWith() {
        return modifyDateStartsWith;
    }

    public TireFilter setModifyDateStartsWith(Instant modifyDateStartsWith) {
        this.modifyDateStartsWith = modifyDateStartsWith;
        return this;
    }

    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    public TireFilter setModifyDateEndWith(Instant modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
        return this;
    }

    public Instant getRemoveDateStartsWith() {
        return removeDateStartsWith;
    }

    public TireFilter setRemoveDateStartsWith(Instant removeDateStartsWith) {
        this.removeDateStartsWith = removeDateStartsWith;
        return this;
    }

    public Instant getRemoveDateEndWith() {
        return removeDateEndWith;
    }

    public TireFilter setRemoveDateEndWith(Instant removeDateEndWith) {
        this.removeDateEndWith = removeDateEndWith;
        return this;
    }



    public static final class Builder {
        private Long id;
        private String brand;
        private String model;
        private Integer widthStartsWith;
        private Integer widthEndWith;
        private Integer profileStartsWith;
        private Integer profileEndWith;
        private Integer diameterStartsWith;
        private Integer diameterEndWith;
        private TireType type;
        private TireReinforcedIndex reinforcedIndex;
        private TireSpeedIndex speedIndex;
        private TireLoadCapacityIndex loadCapacityIndex;
        private TireSeasonType seasonType;
        private Boolean runOnFlat;
        private Instant createDateStartsWith;
        private Instant createDateEndWith;
        private Instant modifyDateStartsWith;
        private Instant modifyDateEndWith;
        private Instant removeDateStartsWith;
        private Instant removeDateEndWith;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder widthStartsWith(Integer widthStartsWith) {
            this.widthStartsWith = widthStartsWith;
            return this;
        }

        public Builder widthEndWith(Integer widthEndWith) {
            this.widthEndWith = widthEndWith;
            return this;
        }

        public Builder profileStartsWith(Integer profileStartsWith) {
            this.profileStartsWith = profileStartsWith;
            return this;
        }

        public Builder profileEndWith(Integer profileEndWith) {
            this.profileEndWith = profileEndWith;
            return this;
        }

        public Builder diameterStartsWith(Integer diameterStartsWith) {
            this.diameterStartsWith = diameterStartsWith;
            return this;
        }

        public Builder diameterEndWith(Integer diameterEndWith) {
            this.diameterEndWith = diameterEndWith;
            return this;
        }

        public Builder type(TireType type) {
            this.type = type;
            return this;
        }

        public Builder reinforcedIndex(TireReinforcedIndex reinforcedIndex) {
            this.reinforcedIndex = reinforcedIndex;
            return this;
        }

        public Builder speedIndex(TireSpeedIndex speedIndex) {
            this.speedIndex = speedIndex;
            return this;
        }

        public Builder loadCapacityIndex(TireLoadCapacityIndex loadCapacityIndex) {
            this.loadCapacityIndex = loadCapacityIndex;
            return this;
        }

        public Builder seasonType(TireSeasonType seasonType) {
            this.seasonType = seasonType;
            return this;
        }

        public Builder runOnFlat(Boolean runOnFlat) {
            this.runOnFlat = runOnFlat;
            return this;
        }

        public Builder createDateStartsWith(Instant createDateStartsWith) {
            this.createDateStartsWith = createDateStartsWith;
            return this;
        }

        public Builder createDateEndWith(Instant createDateEndWith) {
            this.createDateEndWith = createDateEndWith;
            return this;
        }

        public Builder modifyDateStartsWith(Instant modifyDateStartsWith) {
            this.modifyDateStartsWith = modifyDateStartsWith;
            return this;
        }

        public Builder modifyDateEndWith(Instant modifyDateEndWith) {
            this.modifyDateEndWith = modifyDateEndWith;
            return this;
        }

        public Builder removeDateStartsWith(Instant removeDateStartsWith) {
            this.removeDateStartsWith = removeDateStartsWith;
            return this;
        }

        public Builder removeDateEndWith(Instant removeDateEndWith) {
            this.removeDateEndWith = removeDateEndWith;
            return this;
        }

        public TireFilter build() {
            return new TireFilter(this);
        }
    }
}
