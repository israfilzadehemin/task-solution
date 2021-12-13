package com.task.helmestask.service;

import com.task.helmestask.dto.FormDto;
import com.task.helmestask.dto.UserDto;
import java.util.List;
import org.springframework.data.util.Pair;

public interface UserService {

    Pair<UserDto, List<String>> getLoggedUserData(String userId);

    Pair<UserDto, List<String>> handleUserInput(FormDto formData, String userId);
}
