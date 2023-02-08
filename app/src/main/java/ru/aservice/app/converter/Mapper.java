package ru.aservice.app.converter;

public interface Mapper<Dto, Entity> {

    Dto toDto(Entity entity);
    Entity toEntity(Dto dto);
}
