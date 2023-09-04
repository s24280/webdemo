package com.example.webdemo.repository;

import com.example.webdemo.model.DbEntry;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NbpRepository extends JpaRepository<DbEntry, Integer> {
    @Query(value = "INSERT INTO java(currency, date_start, date_end, result, data_zapisu) VALUES(?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    @Transactional
    @Modifying
    void addEntry(String currency, String date_start, String date_end, double result, String data_zapisu);
}
