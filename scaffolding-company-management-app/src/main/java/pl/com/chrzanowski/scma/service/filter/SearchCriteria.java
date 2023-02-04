package pl.com.chrzanowski.scma.service.filter;

public class SearchCriteria {
    private String key;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public SearchCriteria() {
    }

    private SearchCriteria(Builder builder) {
        setKey(builder.key);
        setValue(builder.value);
        setOperation(builder.operation);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public SearchOperation getOperation() {
        return operation;
    }

    public void setOperation(SearchOperation operation) {
        this.operation = operation;
    }


    public static final class Builder {
        private String key;
        private Object value;
        private SearchOperation operation;

        private Builder() {
        }

        public Builder key(String val) {
            key = val;
            return this;
        }

        public Builder value(Object val) {
            value = val;
            return this;
        }

        public Builder operation(SearchOperation val) {
            operation = val;
            return this;
        }

        public SearchCriteria build() {
            return new SearchCriteria(this);
        }
    }
}
