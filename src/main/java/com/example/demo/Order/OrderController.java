package com.example.demo.Order;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.Business.BusinessService;
import com.example.demo.Queue.OrdersInQueueService;

@RestController
@CrossOrigin
public class OrderController {

    private OrderRepository orderRepository;
    private OrderService orderService;
    private BusinessService businessService;
    private OrdersInQueueService ordersInQueueService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService, BusinessService businessService, OrdersInQueueService ordersInQueueService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.businessService = businessService;
        this.ordersInQueueService = ordersInQueueService;
    }

    @PostMapping(value = "/create_order/{bid}/{cid}")
    public void createOrder(@RequestBody Order newOrder, @PathVariable("bid") Long bid, @PathVariable("cid") Long cid) {
        orderService.createOrder(newOrder, bid, cid);
    }

    @PostMapping(value = "/create_order", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order createOrder(@RequestBody Order newOrder) {
        long bid = newOrder.getBid();
        newOrder.setOrder_status(0);
        newOrder.setPayment_status(0);
        newOrder.setPrice((float) 0.00);
        newOrder.setDate(LocalDateTime.now());
        LocalDateTime waiting_time = businessService.getWaitingTime(bid, newOrder.getPax());
        newOrder.setWaiting_time(waiting_time);
        Order order = orderRepository.save(newOrder);
        ordersInQueueService.addOrderToQueue(bid, order);
        System.out.println("im here+");
        return order;
    }
  
    // order history - list of all orders made by customer
    @GetMapping(value = "/get_all_order/{cid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrderByCid(@PathVariable Long cid) {
        return orderRepository.listOrderByCid(cid);
    }

    // business order history - list of all orders made by customer
    @GetMapping(value = "/get_all_order_business/{bid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrderByBid(@PathVariable Long bid) {
        return orderRepository.listOrderByBid(bid);
    }

    // order history - order details
    @GetMapping(value = "/get_order/{oid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@PathVariable Long oid) {
        return orderRepository.getOrder(oid);
    }

    @PostMapping(value = "submit_order/{oid}")
    public void submitOrder(@RequestPart List<Order_Food> order_FoodList, @RequestPart String price, @PathVariable Long oid){
        orderService.submitOrder(order_FoodList, price, oid);
    }

    @PostMapping(value = "pay_order/{oid}")
    public void makePayment(@PathVariable Long oid){
        orderService.payOrder(oid);
    }

    @PostMapping(value = "serve_order/{oid}")
    public void serveOrder(@PathVariable Long oid){
        orderService.serveOrder(oid);
    }
}
