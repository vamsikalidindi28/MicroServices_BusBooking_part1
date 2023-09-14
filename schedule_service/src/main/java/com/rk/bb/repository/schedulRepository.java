package com.rk.bb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rk.bb.entity.Schedule;

public interface schedulRepository extends JpaRepository<Schedule, Long> {

}
