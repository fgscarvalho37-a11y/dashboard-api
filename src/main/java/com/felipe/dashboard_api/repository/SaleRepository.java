package com.felipe.dashboard_api.repository;

import com.felipe.dashboard_api.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Map;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCategory(String category);

    @Query("SELECT s.category as category, SUM(s.amount) as total FROM Sale s GROUP BY s.category")
    List<Map<String, Object>> totalByCategory();

    @Query("SELECT s.date as date, SUM(s.amount) as total FROM Sale s GROUP BY s.date ORDER BY s.date")
    List<Map<String, Object>> totalByDate();
}