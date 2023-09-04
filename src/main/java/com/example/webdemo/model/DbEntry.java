package com.example.webdemo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity(name = "java")
@Table(name = "java")
public class DbEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "date_start")
    @Schema(name = "Title", description = "Poczatkowa data")
    private String date_start;
    @Column(name = "date_end")
    @Schema(name = "Title", description ="Końcowa data")
    private String date_end;
    @Column(name = "result")
    @Schema(name = "Title", description ="Srednia z wybranego zakresu dni")
    private Double result;
    @Column(name = "data_zapisu")
    @Schema(name = "Title", description ="Data zapisu")
    private String data_zapisu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getData_zapisu() {
        return data_zapisu;
    }

    public void setData_zapisu(String data_zapisu) {
        this.data_zapisu = data_zapisu;
    }

    @Override
    public String toString() {
        return "DbEntry{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", date_start='" + date_start + '\'' +
                ", date_end='" + date_end + '\'' +
                ", result=" + result +
                ", data_zapisu='" + data_zapisu + '\'' +
                '}';
    }
}
