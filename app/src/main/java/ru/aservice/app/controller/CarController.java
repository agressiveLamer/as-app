package ru.aservice.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.aservice.app.api.CarApi;
import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.api.model.ServiceDto;
import ru.aservice.app.service.api.CarService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CarController implements CarApi {

    private final CarService service;

    @Override
    public ResponseEntity<Void> addService(Integer carId, ServiceDto serviceDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCar(Integer carId) {
        service.deleteCar(carId.longValue());
        return null;
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
        service.saveCar(carDto, carId);
        return null;
    }
}
