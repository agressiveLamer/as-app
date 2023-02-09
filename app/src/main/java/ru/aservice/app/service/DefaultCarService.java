package ru.aservice.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.converter.CarConverter;
import ru.aservice.app.entity.Car;
import ru.aservice.app.entity.repository.CarRepository;
import ru.aservice.app.exception.ResourceNotFoundException;
import ru.aservice.app.service.api.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultCarService implements CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    @Override
    @Transactional
    public void saveCar(CarDto dto, Long carId) {
        if (carId == null) {
            carRepository.save(carConverter.toEntity(dto));
            return;
        }
            Car entity = carRepository.findById(carId)
                    .orElseThrow(() -> new ResourceNotFoundException("Машина с " + carId + " не найдена"));
            entity.setColor(dto.getColor());
            entity.setMake(dto.getMake());
            entity.setMileage(dto.getMileage());
            entity.setModel(dto.getModel());
            entity.setNotes(dto.getNotes());
            entity.setYear(dto.getYear());
            entity.setVin(dto.getVin());
            entity.setRegistrationNumber(dto.getRegistrationNumber());
            carRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteCar(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Машина с id " + carId + " не найдена"));
        carRepository.delete(car);
    }

    @Override
    @Transactional
    public List<CarDto> getCarByOwnerId(Integer ownerId) {
        if (ownerId == null) {
            throw new NullPointerException();
        }

        List<CarDto> carList = carRepository.findAllByOwnerId(ownerId.longValue())
                .stream()
                .map(carConverter::toDto)
                .collect(Collectors.toList());
        if (carList.isEmpty()) {
            throw new ResourceNotFoundException("У клиента с id " + ownerId + " машин не найдено");
        }
        return carList;
    }

    @Override
    @Transactional
    public List<CarDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(carConverter::toDto)
                .collect(Collectors.toList());
    }
}
