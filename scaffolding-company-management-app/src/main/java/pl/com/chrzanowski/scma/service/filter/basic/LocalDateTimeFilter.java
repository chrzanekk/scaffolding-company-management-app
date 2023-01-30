package pl.com.chrzanowski.scma.service.filter.basic;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class LocalDateTimeFilter extends RangeFilter<LocalDateTime> {
    private static final long serialVersionUID = 1L;

    public LocalDateTimeFilter() {
    }

    public LocalDateTimeFilter(LocalDateTimeFilter filter) {
        super(filter);
    }

    public LocalDateTimeFilter copy() {
        return new LocalDateTimeFilter(this);
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setEquals(LocalDateTime equals) {
        super.setEquals(equals);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setNotEquals(LocalDateTime equals) {
        super.setNotEquals(equals);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setIn(List<LocalDateTime> in) {
        super.setIn(in);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setNotIn(List<LocalDateTime> notIn) {
        super.setNotIn(notIn);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setGreaterThan(LocalDateTime equals) {
        super.setGreaterThan(equals);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setLessThan(LocalDateTime equals) {
        super.setLessThan(equals);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setGreaterThanOrEqual(LocalDateTime equals) {
        super.setGreaterThanOrEqual(equals);
        return this;
    }

    @DateTimeFormat(
            iso = DateTimeFormat.ISO.DATE
    )
    public LocalDateTimeFilter setLessThanOrEqual(LocalDateTime equals) {
        super.setLessThanOrEqual(equals);
        return this;
    }
}
