package pl.com.chrzanowski.scma.service.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import pl.com.chrzanowski.scma.domain.FuelType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class FuelTypeSpecification implements Specification<FuelType> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CREATE_DATE = "createDate";
    public static final String MODIFY_DATE = "modifyDate";
    public static final String REMOVE_DATE = "removeDate";
    private FuelTypeFilter fuelTypeFilterAdd;

    public FuelTypeSpecification() {
        this.fuelTypeFilterAdd = new FuelTypeFilter();
    }

    private FuelTypeSpecification(Builder builder) {
        fuelTypeFilterAdd = builder.fuelTypeFilterAdd;
    }

    public static Builder builder() {
        return new Builder();
    }


    @Override
    public Specification<FuelType> and(Specification<FuelType> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<FuelType> or(Specification<FuelType> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<FuelType> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<SearchCriteria> searchCriteria = createSearchCriteria(fuelTypeFilterAdd);
        List<Predicate> predicates = new ArrayList<>();

        searchCriteria.forEach(
                criteria -> {
                    if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                        predicates.add(
                                builder.greaterThan(
                                        root.get(criteria.getKey()),
                                        criteria.getValue().toString())
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                        predicates.add(
                                builder.lessThan(
                                        root.get(criteria.getKey()),
                                        criteria.getValue().toString())
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                        predicates.add(
                                builder.greaterThanOrEqualTo(
                                        root.get(criteria.getKey()),
                                        criteria.getValue().toString()
                                )
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                        predicates.add(
                                builder.lessThanOrEqualTo(
                                        root.get(criteria.getKey()),
                                        criteria.getValue().toString()
                                ));
                    } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                        predicates.add(
                                builder.notEqual(root.get(
                                        criteria.getKey()), criteria.getValue())
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                        predicates.add(
                                builder.equal(root.get(
                                        criteria.getKey()), criteria.getValue()));
                    } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                        predicates.add(
                                builder.like(
                                        builder.lower(root.get(criteria.getKey()))
                                        , "%" + criteria.getValue().toString().toLowerCase() + "%")
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                        predicates.add(
                                builder.like(
                                        builder.lower(root.get(criteria.getKey())),
                                        criteria.getValue().toString().toLowerCase() + "%")
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                        predicates.add
                                (builder.like(
                                        builder.lower(root.get(criteria.getKey())),
                                        "%" + criteria.getValue().toString().toLowerCase())
                                );
                    } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                        predicates.add(
                                builder.in(
                                        root.get(criteria.getKey())
                                ).value(criteria.getValue())
                        );
                    } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                        predicates.add(
                                builder.not(
                                        root.get(criteria.getKey())
                                ).in(criteria.getValue()));
                    }
                }
        );

        return builder.and(predicates.toArray(new Predicate[0]));
    }


    public List<SearchCriteria> createSearchCriteria(FuelTypeFilter fuelTypeFilter) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        if (fuelTypeFilter != null) {
            if (fuelTypeFilter.getId() != null) {
                searchCriteria.add(SearchCriteria.builder().key(ID).value(fuelTypeFilter.getId()).operation(SearchOperation.EQUAL).build());
            }
            if (fuelTypeFilter.getName() != null) {
                searchCriteria.add(SearchCriteria.builder().key(NAME).value(fuelTypeFilter.getName()).operation(SearchOperation.MATCH_START).build());
            }
            if (fuelTypeFilter.getCreateDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(CREATE_DATE).value(fuelTypeFilter.getCreateDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
            }
            if (fuelTypeFilter.getCreateDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(CREATE_DATE).value(fuelTypeFilter.getCreateDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
            }
            if (fuelTypeFilter.getModifyDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(MODIFY_DATE).value(fuelTypeFilter.getModifyDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
            }
            if (fuelTypeFilter.getModifyDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(MODIFY_DATE).value(fuelTypeFilter.getModifyDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
            }
            if (fuelTypeFilter.getRemoveDateStartWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(REMOVE_DATE).value(fuelTypeFilter.getRemoveDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
            }
            if (fuelTypeFilter.getRemoveDateEndWith() != null) {
                searchCriteria.add(SearchCriteria.builder().key(REMOVE_DATE).value(fuelTypeFilter.getModifyDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
            }
        }
        return searchCriteria;
    }


    public static final class Builder {
        private FuelTypeFilter fuelTypeFilterAdd;

        private Builder() {
        }

        public Builder fuelTypeFilterAdd(FuelTypeFilter val) {
            fuelTypeFilterAdd = val;
            return this;
        }

        public FuelTypeSpecification build() {
            return new FuelTypeSpecification(this);
        }
    }
}
