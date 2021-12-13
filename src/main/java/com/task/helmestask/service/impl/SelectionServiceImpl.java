package com.task.helmestask.service.impl;

import com.task.helmestask.entity.Selection;
import com.task.helmestask.repository.SelectionRepository;
import com.task.helmestask.service.SelectionService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SelectionServiceImpl implements SelectionService {
    private final SelectionRepository selectionRepository;

    @Override
    public List<Selection> getSelectionsByIds(List<String> selectionIds) {
        return selectionRepository.findAllBySelectionIdIn(selectionIds);
    }
}
