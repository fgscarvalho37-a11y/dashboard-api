package com.felipe.dashboard_api.service;

import com.felipe.dashboard_api.dto.SaleDTO;
import com.felipe.dashboard_api.model.Sale;
import com.felipe.dashboard_api.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SaleService {

    private final SaleRepository saleRepository;

    public List<Sale> findAll() { return saleRepository.findAll(); }

    public Sale findById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada: " + id));
    }

    public List<Sale> findByCategory(String category) {
        return saleRepository.findByCategory(category);
    }

    public List<Map<String, Object>> totalByCategory() {
        return saleRepository.totalByCategory();
    }

    public List<Map<String, Object>> totalByDate() {
        return saleRepository.totalByDate();
    }

    public Sale create(SaleDTO dto) {
        Sale sale = new Sale();
        sale.setProduct(dto.getProduct());
        sale.setCategory(dto.getCategory());
        sale.setAmount(dto.getAmount());
        sale.setQuantity(dto.getQuantity());
        sale.setDate(dto.getDate());
        return saleRepository.save(sale);
    }

    public void delete(Long id) {
        findById(id);
        saleRepository.deleteById(id);
    }

    public Map<String, Object> summary() {
        List<Sale> all = findAll();
        double total = all.stream().mapToDouble(Sale::getAmount).sum();
        int totalQty = all.stream().mapToInt(Sale::getQuantity).sum();
        return Map.of(
            "totalSales", all.size(),
            "totalRevenue", total,
            "totalQuantity", totalQty,
            "averageTicket", all.isEmpty() ? 0 : total / all.size()
        );
    }
}