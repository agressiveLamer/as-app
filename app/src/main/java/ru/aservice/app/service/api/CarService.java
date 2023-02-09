package ru.aservice.app.service.api;

import ru.aservice.app.api.model.CarDto;

import java.util.List;

public interface CarService {

    void saveCar(CarDto dto, Long carId);

    void deleteCar(Long carId);

    List<CarDto> getCarByOwnerId(Integer ownerId);

    List<CarDto> getAllCars();


}
