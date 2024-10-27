package com.example.MoskvinaProject.repository;

import com.example.MoskvinaProject.entity.UserActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActionsRepository extends JpaRepository<UserActions,Long> {

}
