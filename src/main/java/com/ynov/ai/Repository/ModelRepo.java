package com.ynov.ai.Repository;

import com.ynov.ai.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepo extends JpaRepository<ModelEntity, Long> {
}
