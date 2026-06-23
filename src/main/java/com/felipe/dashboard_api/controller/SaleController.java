package com.felipe.dashboard_api.controller;

import com.felipe.dashboard_api.dto.SaleDTO;
import com.felipe.dashboard_api.model.Sale;
import com.felipe.dashboard_api.service.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.findById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Sale>> findByCategory(@PathVariable String category) {
        return ResponseEntity.ok(saleService.findByCategory(category));
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> summary() {
        return ResponseEntity.ok(saleService.summary());
    }

    @GetMapping("/by-category")
    public ResponseEntity<List<Map<String, Object>>> byCategory() {
        return ResponseEntity.ok(saleService.totalByCategory());
    }

    @GetMapping("/by-date")
    public ResponseEntity<List<Map<String, Object>>> byDate() {
        return ResponseEntity.ok(saleService.totalByDate());
    }

    @PostMapping
    public ResponseEntity<Sale> create(@Valid @RequestBody SaleDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        saleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}