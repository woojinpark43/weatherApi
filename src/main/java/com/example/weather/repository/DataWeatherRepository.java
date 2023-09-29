package com.example.weather.repository;

import com.example.weather.domain.DateWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DataWeatherRepository extends JpaRepository<DateWeather, LocalDate> {
}
