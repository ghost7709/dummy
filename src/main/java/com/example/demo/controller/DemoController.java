package com.example.demo.controller;

import com.example.demo.model.DemoModel;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController
{
    @Autowired
    private DemoService demoService;

    @GetMapping("/api/readExcel")
    public ResponseEntity<List<DemoModel>> readExcel(/*@RequestParam(required = false) String filePath*/) {
        try {
            List<DemoModel> data = demoService.readExcel();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
