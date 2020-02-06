package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.dto.OrderDTO;
import project.dto.OrderSearchForm;
import project.model.Order;
import project.repository.OrderRepository;
import project.repository.OrderSpecification;
import project.service.OrderService;
import project.util.exception.ResourceException;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(OrderDTO orderDTO) {
        Order order = new Order().setId(orderDTO.getId())
                .setBirthDay(orderDTO.getBirthDay())
                .setGender(orderDTO.getGender())
                .setComment(orderDTO.getComment())
                .setName(orderDTO.getName());
        return orderRepository.save(order);
    }

    @Override
    public Order read(Long id) {
        return orderRepository.findById(id).orElseThrow(
                () -> new ResourceException("This object not found!")
        );
    }

    @Override
    public Page<Order> search(OrderSearchForm form, Pageable pageable) {
        return form.getQuery() != null ?
                orderRepository.findAll(OrderSpecification.searchForm(form)
                        .and(OrderSpecification.filter(form.getQuery())), pageable) :
                orderRepository.findAll(OrderSpecification.searchForm(form), pageable);
    }

    @Override
    public Order update(OrderDTO order) {
        if (!orderRepository.existsById(order.getId())) {
            throw new ResourceException("This object doesn't exist!");
        }
        return create(order);
    }

    @Override
    public void delete(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new ResourceException("This object doesn't exist!");
        }
        orderRepository.deleteById(id);
    }
}
