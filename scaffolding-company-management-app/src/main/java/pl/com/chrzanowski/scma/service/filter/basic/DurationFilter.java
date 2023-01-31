package pl.com.chrzanowski.scma.service.filter.basic;

import java.time.Duration;

public class DurationFilter extends RangeFilter<Duration> {
    private static final long serialVersionUID = 1L;

    public DurationFilter() {
    }

    public DurationFilter(DurationFilter filter) {
        super(filter);
    }

    public DurationFilter copy() {
        return new DurationFilter(this);
    }
}

