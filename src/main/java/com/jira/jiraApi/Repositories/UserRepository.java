package com.jira.jiraApi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jira.jiraApi.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public abstract User findByCorreoElectronico(String correoElectronico);
}