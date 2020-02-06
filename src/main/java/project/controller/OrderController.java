package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.dto.OrderDTO;
import project.dto.OrderSearchForm;
import project.model.Order;
import project.service.OrderService;
import project.util.mapper.OrderMapper;
import project.util.validation.Validation;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping
    public OrderDTO create(@Validated(Validation.New.class) @RequestBody OrderDTO order) {
        return orderMapper.toDTO(orderService.create(order));
    }

    @GetMapping(path = "/{id}")
    public OrderDTO read(@PathVariable Long id) {
        return orderMapper.toDTO(orderService.read(id));
    }

    @GetMapping
    public Page<OrderDTO> read(OrderSearchForm form,
                               @RequestParam(required = false, defaultValue = "0") Integer page,
                               @RequestParam(required = false, defaultValue = "25") Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc("id")));
        Page<Order> orders = orderService.search(form, pageable);
        return new PageImpl<>(orderMapper.toListDTOs(orders.getContent()), orders.getPageable(), orders.getTotalElements());
    }

    @PutMapping
    public OrderDTO update(@Validated(Validation.Exist.class) @RequestBody OrderDTO order) {
        return orderMapper.toDTO(orderService.update(order));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
