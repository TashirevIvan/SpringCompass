package ru.appline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.appline.service.DataModel;

import java.util.Map;

@RestController
public class Controller {

    private static final DataModel dataModel = DataModel.getInstance();

    @PostMapping(value = "/reset", consumes = "application/json")
    public void resetCompass(@RequestBody Map<String, String> compassParam) {
        dataModel.resetCompassDirections(compassParam);
    }

    @GetMapping(value = "/measure", consumes = "application/json", produces = "application/json")
    public Map<String, String> measure(@RequestBody Map<String, Integer> degreeRequest) {
        return dataModel.measure(degreeRequest.get("Degree"));
    }
}
