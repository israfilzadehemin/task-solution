package com.task.helmestask.repository;

import com.task.helmestask.entity.Sector;
import com.task.helmestask.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector, Long> {
    List<Sector> findAllByUsersIsContaining(User user);

    List<Sector> findAllBySelectionIdIn(List<String> ids);
}
