package com.example.weather.controller;

import com.example.weather.domain.Diary;
import com.example.weather.service.DiaryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService){
        this.diaryService = diaryService;
    }

    @PostMapping("/create/diary")
    void createDiary(@RequestParam("date")
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                             LocalDate date,
                     @RequestBody String text){
        diaryService.createDiary(date, text);
    }

    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam("date")
                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                           LocalDate date){
        return diaryService.readDiary(date);
    }

    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                    LocalDate startDate,
                            @RequestParam
                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                    LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @PutMapping("/update/diary")
    void updateDiary(@RequestParam("date")
                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                              LocalDate date,
                      @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @DeleteMapping("/delete/diary")
    void deleteDiary(@RequestParam("date")
                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                             LocalDate date){
        diaryService.deleteDiary(date);
    }
}
