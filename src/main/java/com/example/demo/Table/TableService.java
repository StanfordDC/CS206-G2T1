package com.example.demo.Table;

import java.util.List;

import com.example.demo.Business.BusinessNotFoundException;
import com.example.demo.Business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {
    public TableRepository tableRepository;
    public BusinessRepository businessRepository;

    @Autowired
    public TableService(TableRepository tableRepository, BusinessRepository businessRepository) {
        this.tableRepository = tableRepository;
        this.businessRepository = businessRepository;
    }

    public List<Tables> getAllTables() {
        return tableRepository.findAll();
    }

    public List<Tables> getTablesByBusinessId(Long businessId) { //  throws BusinessNotFoundException 
        return (tableRepository.findTablesByBid(businessId));
                                //  .orElseThrow(() -> new BusinessNotFoundException(businessId));
    }

    public List<Tables> getTablesByBusinessIdAndType(Long businessId, int type) { //  throws BusinessNotFoundException 
        return (tableRepository.findTablesByBusinessIdAndType(businessId, type));
                                //  .orElseThrow(() -> new BusinessNotFoundException(businessId));
    }

    public Tables addTable(Long bid, Tables newTable) throws BusinessNotFoundException {
        return businessRepository.findById(bid).map(business -> {
            newTable.setBusiness(business);
            newTable.setBid(bid);
            return tableRepository.save(newTable);
        }).orElseThrow(() -> new BusinessNotFoundException(bid));
    }

    public Tables freeTable(Long tid) { // throws BusinessNotFoundException 
        // return businessRepository.findById(bid).map(business -> {
            Tables table = tableRepository.findByTid(tid);
            table.setAvailability(true);
            tableRepository.save(table);
            return table;
        // }).orElseThrow(() -> new BusinessNotFoundException(bid));
    }

    public Tables occupyTable(Long tid) { // throws BusinessNotFoundException
        // return businessRepository.findById(bid).map(business -> {
            Tables table = tableRepository.findByTid(tid);
            table.setAvailability(false);
            tableRepository.save(table);
            return table;
        // }).orElseThrow(() -> new BusinessNotFoundException(bid));
    }
}
