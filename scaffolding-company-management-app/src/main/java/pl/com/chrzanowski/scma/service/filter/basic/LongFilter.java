package pl.com.chrzanowski.scma.service.filter.basic;

public class LongFilter extends RangeFilter<Long> {
    private static final long serialVersionUID = 1L;

    public LongFilter() {
    }

    public LongFilter(LongFilter filter) {
        super(filter);
    }

    public LongFilter copy() {
        return new LongFilter(this);
    }
}
