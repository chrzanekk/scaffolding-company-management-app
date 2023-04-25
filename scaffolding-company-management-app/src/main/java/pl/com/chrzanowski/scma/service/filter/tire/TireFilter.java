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

    public TireFilter(Long id,
                      String brand,
                      String model,
                      Integer widthStartsWith,
                      Integer widthEndWith,
                      Integer profileStartsWith,
                      Integer profileEndWith,
                      Integer diameterStartsWith,
                      Integer diameterEndWith,
                      TireType type,
                      TireReinforcedIndex reinforcedIndex,
                      TireSpeedIndex speedIndex,
                      TireLoadCapacityIndex loadCapacityIndex,
                      TireSeasonType seasonType,
                      Boolean runOnFlat,
                      Instant createDateStartsWith,
                      Instant createDateEndWith,
                      Instant modifyDateStartsWith,
                      Instant modifyDateEndWith,
                      Instant removeDateStartsWith,
                      Instant removeDateEndWith) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.widthStartsWith = widthStartsWith;
        this.widthEndWith = widthEndWith;
        this.profileStartsWith = profileStartsWith;
        this.profileEndWith = profileEndWith;
        this.diameterStartsWith = diameterStartsWith;
        this.diameterEndWith = diameterEndWith;
        this.type = type;
        this.reinforcedIndex = reinforcedIndex;
        this.speedIndex = speedIndex;
        this.loadCapacityIndex = loadCapacityIndex;
        this.seasonType = seasonType;
        this.runOnFlat = runOnFlat;
        this.createDateStartsWith = createDateStartsWith;
        this.createDateEndWith = createDateEndWith;
        this.modifyDateStartsWith = modifyDateStartsWith;
        this.modifyDateEndWith = modifyDateEndWith;
        this.removeDateStartsWith = removeDateStartsWith;
        this.removeDateEndWith = removeDateEndWith;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getWidthStartsWith() {
        return widthStartsWith;
    }

    public void setWidthStartsWith(Integer widthStartsWith) {
        this.widthStartsWith = widthStartsWith;
    }

    public Integer getWidthEndWith() {
        return widthEndWith;
    }

    public void setWidthEndWith(Integer widthEndWith) {
        this.widthEndWith = widthEndWith;
    }

    public Integer getProfileStartsWith() {
        return profileStartsWith;
    }

    public void setProfileStartsWith(Integer profileStartsWith) {
        this.profileStartsWith = profileStartsWith;
    }

    public Integer getProfileEndWith() {
        return profileEndWith;
    }

    public void setProfileEndWith(Integer profileEndWith) {
        this.profileEndWith = profileEndWith;
    }

    public Integer getDiameterStartsWith() {
        return diameterStartsWith;
    }

    public void setDiameterStartsWith(Integer diameterStartsWith) {
        this.diameterStartsWith = diameterStartsWith;
    }

    public Integer getDiameterEndWith() {
        return diameterEndWith;
    }

    public void setDiameterEndWith(Integer diameterEndWith) {
        this.diameterEndWith = diameterEndWith;
    }

    public TireType getType() {
        return type;
    }

    public void setType(TireType type) {
        this.type = type;
    }

    public TireReinforcedIndex getReinforcedIndex() {
        return reinforcedIndex;
    }

    public void setReinforcedIndex(TireReinforcedIndex reinforcedIndex) {
        this.reinforcedIndex = reinforcedIndex;
    }

    public TireSpeedIndex getSpeedIndex() {
        return speedIndex;
    }

    public void setSpeedIndex(TireSpeedIndex speedIndex) {
        this.speedIndex = speedIndex;
    }

    public TireLoadCapacityIndex getLoadCapacityIndex() {
        return loadCapacityIndex;
    }

    public void setLoadCapacityIndex(TireLoadCapacityIndex loadCapacityIndex) {
        this.loadCapacityIndex = loadCapacityIndex;
    }

    public TireSeasonType getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(TireSeasonType seasonType) {
        this.seasonType = seasonType;
    }

    public Boolean getRunOnFlat() {
        return runOnFlat;
    }

    public void setRunOnFlat(Boolean runOnFlat) {
        this.runOnFlat = runOnFlat;
    }

    public Instant getCreateDateStartsWith() {
        return createDateStartsWith;
    }

    public void setCreateDateStartsWith(Instant createDateStartsWith) {
        this.createDateStartsWith = createDateStartsWith;
    }

    public Instant getCreateDateEndWith() {
        return createDateEndWith;
    }

    public void setCreateDateEndWith(Instant createDateEndWith) {
        this.createDateEndWith = createDateEndWith;
    }

    public Instant getModifyDateStartsWith() {
        return modifyDateStartsWith;
    }

    public void setModifyDateStartsWith(Instant modifyDateStartsWith) {
        this.modifyDateStartsWith = modifyDateStartsWith;
    }

    public Instant getModifyDateEndWith() {
        return modifyDateEndWith;
    }

    public void setModifyDateEndWith(Instant modifyDateEndWith) {
        this.modifyDateEndWith = modifyDateEndWith;
    }

    public Instant getRemoveDateStartsWith() {
        return removeDateStartsWith;
    }

    public void setRemoveDateStartsWith(Instant removeDateStartsWith) {
        this.removeDateStartsWith = removeDateStartsWith;
    }

    public Instant getRemoveDateEndWith() {
        return removeDateEndWith;
    }

    public void setRemoveDateEndWith(Instant removeDateEndWith) {
        this.removeDateEndWith = removeDateEndWith;
    }
}
