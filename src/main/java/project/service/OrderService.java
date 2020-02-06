package project.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import project.dto.OrderDTO;
import project.dto.OrderSearchForm;
import project.model.Order;

public interface OrderService {

    Order create(OrderDTO order);

    Order read(Long id);

    Page<Order> search(OrderSearchForm form, Pageable pageable);

    Order update(OrderDTO order);

    void delete(Long id);
}
