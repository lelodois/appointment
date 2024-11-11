package com.lelo;

public class AppointmentFixture {

    com.github.javafaker.Faker faker = new com.github.javafaker.Faker();

    public com.lelo.appointment.model.Request buildNew(int size) {
        com.lelo.appointment.model.Request request = new com.lelo.appointment.model.Request();
        request.setOwner(faker.name().name());
        request.setSubject(faker.country().capital());
        request.setSize(size);
        return request;
    }
}
