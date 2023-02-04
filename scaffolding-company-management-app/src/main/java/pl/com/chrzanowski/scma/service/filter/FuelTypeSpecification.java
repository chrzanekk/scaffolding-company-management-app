package pl.com.chrzanowski.scma.service.filter;

import org.springframework.data.jpa.domain.Specification;
import pl.com.chrzanowski.scma.domain.FuelType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class FuelTypeSpecification implements Specification<FuelType> {

    private final FuelTypeFilter fuelTypeFilter;

    public FuelTypeSpecification(FuelTypeFilter fuelTypeFilter) {
        this.fuelTypeFilter = fuelTypeFilter;
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
        List<SearchCriteria> searchCriteria = createSearchCriteria(fuelTypeFilter);
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


    private List<SearchCriteria> createSearchCriteria(FuelTypeFilter fuelTypeFilter) {
        List<SearchCriteria> searchCriteria = new ArrayList<>();
        if (fuelTypeFilter.getId() != null) {
            searchCriteria.add(SearchCriteria.builder().key("id").value(fuelTypeFilter.getId()).operation(SearchOperation.EQUAL).build());
        }
        if (fuelTypeFilter.getName() != null) {
            searchCriteria.add(SearchCriteria.builder().key("name").value(fuelTypeFilter.getName()).operation(SearchOperation.MATCH_START).build());
        }
        if (fuelTypeFilter.getCreateDateStartWith() != null) {
            searchCriteria.add(SearchCriteria.builder().key("createDate").value(fuelTypeFilter.getCreateDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
        }
        if (fuelTypeFilter.getCreateDateEndWith() != null) {
            searchCriteria.add(SearchCriteria.builder().key("createDate").value(fuelTypeFilter.getCreateDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
        }
        if (fuelTypeFilter.getModifyDateStartWith() != null) {
            searchCriteria.add(SearchCriteria.builder().key("modifyDate").value(fuelTypeFilter.getModifyDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
        }
        if (fuelTypeFilter.getModifyDateEndWith() != null) {
            searchCriteria.add(SearchCriteria.builder().key("modifyDate").value(fuelTypeFilter.getModifyDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
        }
        if (fuelTypeFilter.getRemoveDateStartWith() != null) {
            searchCriteria.add(SearchCriteria.builder().key("removeDate").value(fuelTypeFilter.getRemoveDateStartWith()).operation(SearchOperation.GREATER_THAN_EQUAL).build());
        }
        if (fuelTypeFilter.getRemoveDateEndWith() != null) {
            searchCriteria.add(SearchCriteria.builder().key("removeDate").value(fuelTypeFilter.getModifyDateEndWith()).operation(SearchOperation.LESS_THAN_EQUAL).build());
        }
        return searchCriteria;
    }


}
