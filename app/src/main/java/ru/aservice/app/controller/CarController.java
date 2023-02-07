package ru.aservice.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.aservice.app.api.CarApi;
import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.api.model.ServiceDto;

import java.util.List;


@RestController
public class CarController implements CarApi {


    @Override
    public ResponseEntity<Void> addService(Integer carId, ServiceDto serviceDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCar(Integer carId) {
        return null;
    }

    @Override
    public ResponseEntity<List<CarDto>> getCars() {
        return null;
    }

    @Override
    public ResponseEntity<CarDto> getCarsByOwnerId(Integer ownerId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> saveCar(CarDto carDto, Integer carId) {
        return null;
    }
}
