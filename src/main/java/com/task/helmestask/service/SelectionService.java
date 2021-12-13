package com.task.helmestask.service;

import com.task.helmestask.entity.Selection;
import java.util.List;

public interface SelectionService {
    List<Selection> getSelectionsByIds(List<String> selectionIds);


}
