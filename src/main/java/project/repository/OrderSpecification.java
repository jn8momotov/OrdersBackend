package project.repository;

import org.springframework.data.jpa.domain.Specification;
import project.dto.OrderSearchForm;
import project.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderSpecification {
    public static Specification<Order> searchForm(OrderSearchForm form) {
        List<Specification<Order>> specifications = new ArrayList<>();
        if (form.getGender() != null) {
            specifications.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("gender"), form.getGender())));
        }
        if (form.getBirthDayStart() != null) {
            specifications.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.greaterThanOrEqualTo(root.get("birthDay"), form.getBirthDayStart())));
        }
        if (form.getBirthDayEnd() != null) {
            specifications.add(((root, query, criteriaBuilder) ->
                    criteriaBuilder.lessThanOrEqualTo(root.get("birthDay"), form.getBirthDayEnd())));
        }
        return specifications.stream().reduce(Specification::and).orElse(null);
    }

    public static Specification<Order> filter(String query) {
        return ((root, query1, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                        "%" + query.toLowerCase() + "%"));
    }
}
