package project.util.mapper;

import org.mapstruct.Mapper;
import project.dto.OrderDTO;
import project.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper extends AbstractMapper<Order, OrderDTO> {
}
