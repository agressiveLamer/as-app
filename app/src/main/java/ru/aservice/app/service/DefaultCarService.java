package ru.aservice.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aservice.app.api.model.CarDto;
import ru.aservice.app.converter.CarConverter;
import ru.aservice.app.entity.repository.CarRepository;
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
    public void saveCar(CarDto carDto, Integer carId) {

        //TODO: Добавить обновление по айди
        carRepository.save(carConverter.toEntity(carDto));
    }

    @Override
    @Transactional
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    @Transactional
    public List<CarDto> getCarByOwnerId(Integer ownerId) {
        return carRepository.findAllByOwnerId(ownerId.longValue())
                .stream()
                .map(carConverter::toDto)
                .collect(Collectors.toList());
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
