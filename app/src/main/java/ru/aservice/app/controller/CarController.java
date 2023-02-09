package ru.aservice.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.aservice.app.api.CarApi;
import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.api.model.ServiceDto;
import ru.aservice.app.service.api.CarService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {

    private final CarService service;

    @Override
    public ResponseEntity<Void> deleteCar(Integer carId) {
        service.deleteCar(carId.longValue());
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<CarDto>> getCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @Override
    public ResponseEntity<List<CarDto>> getCarsByOwnerId(Integer ownerId) {
        return ResponseEntity.ok(service.getCarByOwnerId(ownerId));
    }

    @Override
    public ResponseEntity<Void> saveCar(CarDto carDto, Integer carId) {
        service.saveCar(carDto, Long.valueOf(carId));
        return ResponseEntity.ok(null);
    }
}
