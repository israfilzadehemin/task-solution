package com.task.helmestask.service.impl;

import com.task.helmestask.dto.SectorResponseDto;
import com.task.helmestask.mapper.SectorMapper;
import com.task.helmestask.repository.SectorRepository;
import com.task.helmestask.service.SectorService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SectorServiceImpl implements SectorService {
    private final SectorRepository sectorRepository;

    @Override
    public List<SectorResponseDto> getAllSectors() {
        return sectorRepository.findAll()
                .stream()
                .map(SectorMapper.INSTANCE::mapToResponseDto)
                .collect(Collectors.toList());
    }
}
