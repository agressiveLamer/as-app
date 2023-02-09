create sequence hibernate_sequence start 1 increment 1;

create table public.car
(
    id                  int8 not null,
    created             timestamp,
    updated             timestamp,
    color               varchar(255),
    make                varchar(255),
    mileage             int4,
    model               varchar(255),
    notes               varchar(255),
    registration_number varchar(255),
    vin                 varchar(255),
    year                int4,
    primary key (id)
);
create table public.service
(
    id               int8 not null,
    created          timestamp,
    updated          timestamp,
    master_full_name varchar(255),
    primary key (id)
);
create table public.spares
(
    id         int8 not null,
    created    timestamp,
    updated    timestamp,
    cost       float8,
    describe   varchar(255),
    service_id int8,
    primary key (id)
);
create table public.user
(
    id           int8 not null,
    created      timestamp,
    updated      timestamp,
    email        varchar(255),
    last_name    varchar(255),
    login        varchar(255),
    name         varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    primary key (id)
);
create table public.works
(
    id         int8 not null,
    created    timestamp,
    updated    timestamp,
    cost       float8,
    describe   varchar(255),
    service_id int8,
    primary key (id)
);

create table car_user
(
    car_id  int8 not null,
    user_id int8 not null
);
alter table if exists public.spares
    add constraint FKrfhwv4ju8bx4rkv1bwh96vp9u foreign key (service_id) references public.service;
alter table if exists public.works
    add constraint FK3qoocx7bkd1ag4jsnvrahqi9x foreign key (service_id) references public.service;
alter table if exists car_user
    add constraint FKgexqa94bkfm3mqcwes5oih126 foreign key (user_id) references public.user;
alter table if exists car_user
    add constraint FK1k6olg9agm5y983l80o277o6x foreign key (car_id) references public.car;