package pl.com.chrzanowski.scma.service.filter;


import pl.com.chrzanowski.scma.service.filter.basic.LocalDateTimeFilter;
import pl.com.chrzanowski.scma.service.filter.basic.LongFilter;
import pl.com.chrzanowski.scma.service.filter.basic.StringFilter;

import java.io.Serializable;
import java.util.Objects;

public class FuelTypeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;
    private StringFilter name;
    private LocalDateTimeFilter createDate;
    private LocalDateTimeFilter modifyDate;
    private LocalDateTimeFilter removeDate;

    public FuelTypeCriteria(FuelTypeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.createDate = other.createDate == null ? null : other.createDate.copy();
        this.modifyDate = other.modifyDate == null ? null : other.modifyDate.copy();
        this.removeDate = other.removeDate == null ? null : other.removeDate.copy();
    }

    @Override
    public FuelTypeCriteria copy() {
        return new FuelTypeCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public LocalDateTimeFilter getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTimeFilter createDate) {
        this.createDate = createDate;
    }

    public LocalDateTimeFilter getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTimeFilter modifyDate) {
        this.modifyDate = modifyDate;
    }

    public LocalDateTimeFilter getRemoveDate() {
        return removeDate;
    }

    public void setRemoveDate(LocalDateTimeFilter removeDate) {
        this.removeDate = removeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuelTypeCriteria that = (FuelTypeCriteria) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(createDate, that.createDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(removeDate, that.removeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, modifyDate, removeDate);
    }

    @Override
    public String toString() {
        return "FuelTypeFilter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                ", removeDate=" + removeDate +
                '}';
    }
}


