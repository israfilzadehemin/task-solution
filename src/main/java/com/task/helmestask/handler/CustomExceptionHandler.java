package com.task.helmestask.handler;

import com.task.helmestask.exception.InvalidDataException;
import com.task.helmestask.service.SectorService;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@ControllerAdvice
@AllArgsConstructor
public class CustomExceptionHandler {
    private final SectorService sectorService;

    @ExceptionHandler(InvalidDataException.class)
    public ModelAndView handleInvalidData(Model model, InvalidDataException exception) {
        model.addAttribute("error", exception.getMessage());
        model.addAttribute("sectors", sectorService.getAllSectors());
        model.addAttribute("ids", Collections.emptyList());
        log.warn(exception.getMessage());
        return new ModelAndView("index");
    }
}
