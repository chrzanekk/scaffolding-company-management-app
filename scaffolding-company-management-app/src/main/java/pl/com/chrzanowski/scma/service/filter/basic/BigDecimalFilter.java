package pl.com.chrzanowski.scma.service.filter.basic;

import java.math.BigDecimal;

public class BigDecimalFilter extends RangeFilter<BigDecimal> {
    private static final long serialVersionUID = 1L;

    public BigDecimalFilter() {
    }

    public BigDecimalFilter(BigDecimalFilter filter) {
        super(filter);
    }

    public BigDecimalFilter copy() {
        return new BigDecimalFilter(this);
    }
}

