package com.task.helmestask.repository;

import com.task.helmestask.entity.Subcategory;
import com.task.helmestask.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findAllByUsersIsContaining(User user);

    List<Subcategory> findAllBySelectionIdIn(List<String> ids);

}
