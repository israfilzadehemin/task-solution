package com.task.helmestask.controller;

import com.task.helmestask.dto.FormDto;
import com.task.helmestask.dto.UserDto;
import com.task.helmestask.service.SectorService;
import com.task.helmestask.service.UserService;
import com.task.helmestask.util.ValidationTool;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Log4j2
@AllArgsConstructor
public class IndexController {
    private final UserService userService;
    private final SectorService sectorService;

    /**
     * http://localhost:8080/index
     */
    @GetMapping("/index")
    public String indexGet(Model model, HttpServletRequest httpServletRequest) {
        String userId = httpServletRequest.getSession().getId();
        Pair<UserDto, List<String>> loggedUserData = userService.getLoggedUserData(userId);

        model.addAttribute("sectors", sectorService.getAllSectors());
        model.addAttribute("user", loggedUserData.getFirst());
        model.addAttribute("ids", loggedUserData.getSecond());
        return "index";
    }

    @PostMapping("/index")
    public String indexPost(Model model, @ModelAttribute FormDto formDto, HttpServletRequest httpServletRequest) {

        String userId = httpServletRequest.getSession().getId();
        model.addAttribute("message", "Your data has been saved successfully!");

        log.info("User entered data: {}", formDto);
        ValidationTool.validateFormData(formDto);

        Pair<UserDto, List<String>> userData = userService.handleUserInput(formDto, userId);

        model.addAttribute("sectors", sectorService.getAllSectors());
        model.addAttribute("user", userData.getFirst());
        model.addAttribute("ids", userData.getSecond());
        return "index";
    }

    @RequestMapping("/*")
    public RedirectView redirectUnexpectedRequests() {
        return new RedirectView("/index");
    }
}
