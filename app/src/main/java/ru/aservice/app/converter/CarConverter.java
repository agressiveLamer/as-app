package ru.aservice.app.converter;

import org.springframework.stereotype.Component;
import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.entity.Car;

@Component
public class CarConverter  {

    public CarDto toDto(Car entity) {
        CarDto dto = new CarDto();
        dto.setColor(entity.getColor());
        dto.setMake(entity.getMake());
        dto.setMileage(entity.getMileage());
        dto.setModel(entity.getModel());
        dto.setId(entity.getId().intValue());
        dto.setNotes(entity.getNotes());
        dto.setYear(entity.getYear());
        dto.setVin(entity.getVin());
        dto.setRegistrationNumber(entity.getRegistrationNumber());
        return dto;
    }

    public Car toEntity(CarDto dto) {
        Car entity = new Car();
        entity.setColor(dto.getColor());
        entity.setMake(dto.getMake());
        entity.setMileage(dto.getMileage());
        entity.setModel(dto.getModel());
        entity.setNotes(dto.getNotes());
        entity.setYear(dto.getYear());
        entity.setVin(dto.getVin());
        entity.setRegistrationNumber(dto.getRegistrationNumber());
        return entity;
    }
}
