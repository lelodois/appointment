package com.lelo.appointment;

@org.springframework.web.bind.annotation.RestController
public class AppointmentController {

    private final Service service;

    public AppointmentController(Service service) {
        this.service = service;
    }

    @org.springframework.web.bind.annotation.GetMapping("/appointments")
    public Iterable<com.lelo.appointment.model.Appointment> getAll() {
        return service.findAll();
    }

    @org.springframework.web.bind.annotation.GetMapping("/appointments/available")
    public Iterable<com.lelo.appointment.model.Response> getAvailable() {
        return com.lelo.appointment.tools.Converter.toResponse(service.findAvailable());
    }

    @org.springframework.web.bind.annotation.PostMapping("/appointment")
    public void add(@org.springframework.web.bind.annotation.RequestBody com.lelo.appointment.model.Request request) {
        service.save(com.lelo.appointment.tools.Converter.toModel(request));
    }

    @org.springframework.web.bind.annotation.DeleteMapping("/appointments/all")
    public void deleteAll() {
        service.deleteAll();
    }


}
