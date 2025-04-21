package com.javaweb.repository;

import com.javaweb.entity.UserEntity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
//    List<UserEntity> findAll();
    List<UserEntity> findByFullNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String str,String str2);
    List<UserEntity> findByStatus(Boolean status);

    @Query(
            value = "SELECT * FROM user",
            countQuery = "SELECT COUNT(*) FROM user",
            nativeQuery = true
    )
    List<UserEntity> getAllUsers(Pageable pageable);

}
