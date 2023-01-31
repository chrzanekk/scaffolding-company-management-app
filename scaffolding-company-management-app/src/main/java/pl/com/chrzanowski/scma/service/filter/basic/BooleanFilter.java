package pl.com.chrzanowski.scma.service.filter.basic;



public class BooleanFilter extends Filter<Boolean> {
    private static final long serialVersionUID = 1L;

    public BooleanFilter() {
    }

    public BooleanFilter(BooleanFilter filter) {
        super(filter);
    }

    public BooleanFilter copy() {
        return new BooleanFilter(this);
    }
}
