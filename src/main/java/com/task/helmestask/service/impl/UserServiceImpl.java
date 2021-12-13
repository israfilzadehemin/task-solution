package com.task.helmestask.service.impl;

import com.task.helmestask.dto.FormDto;
import com.task.helmestask.dto.UserDto;
import com.task.helmestask.entity.Selection;
import com.task.helmestask.entity.User;
import com.task.helmestask.mapper.SelectionMapper;
import com.task.helmestask.mapper.UserMapper;
import com.task.helmestask.repository.UserRepository;
import com.task.helmestask.service.SelectionService;
import com.task.helmestask.service.UserService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SelectionService selectionService;

    @Override
    public Pair<UserDto, List<String>> getLoggedUserData(String userId) {
        Optional<User> user = userRepository.findByUserIdIgnoreCase(userId);

        if (user.isEmpty()) {
            log.info("Current user has not logged in.");
            return Pair.of(UserDto.builder().build(), Collections.emptyList());
        } else {
            UserDto userData = UserMapper.INSTANCE.mapToResponseDto(user.get());
            log.info("Logged user: {}", userData);

            List<String> selectionIds = user.get()
                    .getSelections()
                    .stream()
                    .map(Selection::getSelectionId)
                    .collect(Collectors.toList());

            return Pair.of(userData, selectionIds);
        }

    }

    @Override
    public Pair<UserDto, List<String>> handleUserInput(FormDto userInput, String userId) {

        List<Selection> selections = selectionService.getSelectionsByIds(userInput.getSelections());
        log.info("Fields chosen by current user: {}",
                selections
                        .stream().map(SelectionMapper.INSTANCE::mapToResponseDto)
                        .collect(Collectors.toList()));

        UserDto user = saveUserData(userInput, userId, selections);
        log.info("Saved user: {}", user);

        return Pair.of(user, selections.stream().map(Selection::getSelectionId).collect(Collectors.toList()));
    }

    private UserDto saveUserData(FormDto userInput, String userId, List<Selection> selections) {
        User user = userRepository.findByUserIdIgnoreCase(userId).orElseGet(() -> User.builder().build());
        user.setName(userInput.getName());
        user.setUserId(userId);
        user.setSelections(selections);
        user.setAgreed(userInput.getAgree());

        userRepository.save(user);
        return UserMapper.INSTANCE.mapToResponseDto(user);
    }

}
