package com.task.helmestask.repository;

import com.task.helmestask.entity.Selection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectionRepository extends JpaRepository<Selection, Long> {

    List<Selection> findAllBySelectionIdIn(List<String> ids);

}
