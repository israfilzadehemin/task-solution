package com.task.helmestask.repository;

import com.task.helmestask.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllBySelectionIdIn(List<String> ids);
}
