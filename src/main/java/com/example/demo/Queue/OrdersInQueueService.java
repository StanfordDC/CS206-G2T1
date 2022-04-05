package com.example.demo.Queue;

import java.util.List;

import com.example.demo.Business.BusinessNotFoundException;
import com.example.demo.Business.BusinessRepository;
import com.example.demo.Order.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersInQueueService {
    
    public OrdersInQueueRepository queueRepository;
    public BusinessRepository businessRepository;

    @Autowired
    public OrdersInQueueService(OrdersInQueueRepository queueRepository, BusinessRepository businessRepository) {
        this.queueRepository = queueRepository;
        this.businessRepository = businessRepository;
    }

    public List<OrdersInQueue> getAllOrdersInQueue() {
        return queueRepository.findAll();
    }

    public List<OrdersInQueue> getOrdersInQueueByBid(Long bid) {
        return queueRepository.findOrdersInQueueByBid(bid);
    }

    public List<OrdersInQueue> getOrdersInQueueByBidAndStatus(Long bid, int status) {
        return queueRepository.findAllOrdersInQueueByBidAndStatus(bid, status);
    }

    public List<OrdersInQueue> getOrdersInQueueByBidAndStatusAndType(Long bid, int status, int type) {
        return queueRepository.findAllOrdersInQueueByBidAndStatusAndType(bid, status, type);
    }

    public OrdersInQueue addOrderToQueue(Long bid, Order newOrder) throws BusinessNotFoundException {
        return businessRepository.findById(bid).map(business -> {
            OrdersInQueue order = new OrdersInQueue(newOrder.getOid());
            order.setBusiness(business);
            order.setBid(bid);
            order.setType(newOrder.getPax());
            return queueRepository.save(order);
        }).orElseThrow(() -> new BusinessNotFoundException(bid));
    }

    public OrdersInQueue updateQueueToStore(Long bid, Long oid) throws BusinessNotFoundException {
        System.out.println("bid: " + bid + ", oid: " + oid);
        OrdersInQueue order = queueRepository.findOrderByBidAndOid(bid, oid);
        order.setStatus(1);
        return queueRepository.save(order);
    }

    public OrdersInQueue removeOrderFromQueue(Long bid, Long oid) throws BusinessNotFoundException {
        OrdersInQueue order = queueRepository.findOrderByBidAndOid(bid, oid);
        queueRepository.deleteById(order.getOqid());
        return order;
    }
}
