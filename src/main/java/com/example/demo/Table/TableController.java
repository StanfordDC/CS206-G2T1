package com.example.demo.Table;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TableController {
    private TableService tableService;
    
    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping(value = "/business/{bid}/table", produces = "application/json")
    public List<Tables> getTablesByBid(@PathVariable Long bid) {
        return tableService.getTablesByBusinessId(bid);
    }

    @GetMapping(value = "/business/{bid}/table/{tabletype}", produces = "application/json")
    public List<Tables> getTablesByBid(@PathVariable Long bid, @PathVariable int tabletype) {
        return tableService.getTablesByBusinessIdAndType(bid, tabletype);
    }

    @PutMapping(value = "/business/table/{tid}/free", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Tables freeTable(@PathVariable Long tid) {
        return tableService.freeTable(tid);
    }

    @PutMapping(value = "/business/table/{tid}/occupy", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Tables occupyTable(@PathVariable Long tid) {
        return tableService.occupyTable(tid);
    }
}
