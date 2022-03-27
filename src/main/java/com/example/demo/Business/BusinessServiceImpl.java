package com.example.demo.Business;

import com.example.demo.Table.TableRepository;
import com.example.demo.Table.TableService;
import com.example.demo.Table.Tables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{
    private BusinessRepository businessRepository;
    private TableService tableService;
    private TableRepository tableRepository;

    @Autowired
    @Lazy
    public BusinessServiceImpl(BusinessRepository businessRepository, TableService tableService, TableRepository tableRepository) {
        this.businessRepository = businessRepository;
        this.tableService = tableService;
        this.tableRepository = tableRepository;
    }

    @Override
    public List<Business> getAllBusinesses() {
        return businessRepository.findAll();
    }

    @Override
    public Business getBusinessById(Long businessId) throws BusinessNotFoundException {
        return businessRepository.findById(businessId)
                                 .orElseThrow(() -> new BusinessNotFoundException(businessId));
    }

    @Override
    public Business getBusinessByUEN(String UEN) throws BusinessNotFoundException {
        return businessRepository.findByUEN(UEN)
                                 .orElseThrow(() -> new BusinessNotFoundException(UEN));
    }

    @Override
    public List<Business> getBusinessesByMid(Long mid) {
        return businessRepository.findByMid(mid);
    }

    @Override
    public Business addBusiness(Business business) throws BusinessAlreadyRegisteredException {
        String UEN = business.getUEN();
        if (businessRepository.existsByUEN(UEN)) {
            throw new BusinessAlreadyRegisteredException(UEN);
        }
        return businessRepository.save(business);
    }

    public LocalDateTime getWaitingTime(Long bid, int noOfPax) {
        Business business = getBusinessById(bid);

        if (noOfPax > 0 && noOfPax < 3) {
            LocalDateTime waiting_time = getWaitingTime2Pax(bid);
            business.setWaiting_time_2pax(waiting_time);
            return waiting_time;
        } else if (noOfPax > 2 && noOfPax < 6) {
            LocalDateTime waiting_time = getWaitingTime5Pax(bid);
            business.setWaiting_time_5pax(waiting_time);
            return waiting_time;
        } else {
            System.out.println("invalid pax");
            return java.time.LocalDateTime.now();
        }
    }

    public LocalDateTime getWaitingTime2Pax(Long bid) {
        LocalDateTime current = java.time.LocalDateTime.now();
        LocalDateTime toReturn = current;
        LocalDateTime earliest = current.plusDays(5);
        List<Tables> tablesOf2pax = tableService.getTablesByBusinessIdAndType(bid, 2);

        for (Tables t : tablesOf2pax) {
            LocalDateTime waitingTime = t.getWaiting_time();
            if (waitingTime.isBefore(current) || waitingTime.isEqual(current)) { // stored waiting time is outdated
                t.setWaiting_time(current.plusMinutes(40));
                return toReturn; // returns current time which gives 0 waiting time
            } else { // after current 
                if (waitingTime.isBefore(earliest)) {
                    earliest = waitingTime;
                }
            }
        }
        toReturn = earliest;

        for (Tables t : tablesOf2pax) {
            if (earliest == t.getWaiting_time()) {
                t.setWaiting_time((t.getWaiting_time()).plusMinutes(40));
            }
        }
        return toReturn;
    }

    public LocalDateTime getWaitingTime5Pax(Long bid) {
        LocalDateTime current = java.time.LocalDateTime.now();
        LocalDateTime toReturn = current;
        LocalDateTime earliest = current.plusDays(5);
        List<Tables> tablesOf5pax = tableService.getTablesByBusinessIdAndType(bid, 5);

        for (Tables t : tablesOf5pax) {
            LocalDateTime waitingTime = t.getWaiting_time();
            System.out.println(waitingTime);
            if (waitingTime.isBefore(current) || waitingTime.isEqual(current)) { // stored waiting time is outdated
                t.setWaiting_time(current.plusMinutes(40));
                return toReturn;
            } else {
                if (waitingTime.isBefore(earliest)) {
                    earliest = waitingTime;
                }
            }
        }
        toReturn = earliest;

        for (Tables t : tablesOf5pax) {
            if (earliest == t.getWaiting_time()) {
                t.setWaiting_time((t.getWaiting_time()).plusMinutes(40));
            }
        }
        return toReturn;
    }
}
