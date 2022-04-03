package com.example.demo.Table;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PutMapping(value = "/business/table/{tid}/free", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Tables freeTable(@Validated @RequestBody Long tid) {
        return tableService.freeTable(tid);
    }

    @PutMapping(value = "/business/table/{tid}/occupy", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public Tables occupyTable(@Validated @RequestBody Long tid) {
        return tableService.occupyTable(tid);
    }
}
