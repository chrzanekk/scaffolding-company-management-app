package pl.com.chrzanowski.scma.service.filter.basic;

public class IntegerFilter extends RangeFilter<Integer> {
    private static final long serialVersionUID = 1L;

    public IntegerFilter() {
    }

    public IntegerFilter(IntegerFilter filter) {
        super(filter);
    }

    public IntegerFilter copy() {
        return new IntegerFilter(this);
    }
}
