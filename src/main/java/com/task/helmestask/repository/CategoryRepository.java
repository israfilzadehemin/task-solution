package com.task.helmestask.repository;

import com.task.helmestask.entity.Category;
import com.task.helmestask.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByUsersIsContaining(User user);

    List<Category> findAllBySelectionIdIn(List<String> ids);

}
