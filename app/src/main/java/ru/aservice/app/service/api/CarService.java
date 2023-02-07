package ru.aservice.app.service.api;

import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.api.model.ServiceDto;

public interface CarService {

    //TODO: привести нормальные типы возвращаемых объектов

    void saveCar(CarDto carDto, Integer carId);

    void saveService(Integer carId, ServiceDto serviceDto);

    void getOneByOwnerId(Integer ownerId);

    void getAllCars();
}
