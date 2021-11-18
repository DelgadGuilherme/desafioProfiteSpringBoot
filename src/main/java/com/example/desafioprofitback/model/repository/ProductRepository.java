package com.example.desafioprofitback.model.repository;

import com.example.desafioprofitback.model.entity.Installments;
import com.example.desafioprofitback.model.entity.Product;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductRepository {

    private JdbcTemplate jdbcTemplate;
    private InstallmentsRepository installmentsRepository;

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
        this.installmentsRepository = new InstallmentsRepository(jdbcTemplate);
    }

    public List<Product> searchAllProduct() {
        String sql = "select * from product";

        List<Product> listProduct = jdbcTemplate.query(sql, new ProductMapper());

        listProduct.forEach(product -> {
            Installments installments = installmentsRepository.searchInstallments(product.getInstallments_id());
            product.setInstallments(installments);
        });

        return listProduct;
    }
}
