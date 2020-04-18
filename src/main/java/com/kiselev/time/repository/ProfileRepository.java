package com.kiselev.time.repository;

import com.kiselev.time.model.dto.db.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Transactional
    Profile findByUsernameAndAnonymousFalse(String username);
}
