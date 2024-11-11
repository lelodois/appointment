package com.lelo.appointment;

@org.springframework.web.bind.annotation.RestController
public class OfficerController {

    private final com.lelo.appointment.Service service;

    public OfficerController(com.lelo.appointment.Service service) {
            this.service = service;
    }

    @org.springframework.web.bind.annotation.PutMapping(
            "/officer/{name}/attach/{id}"
    )
    public void attach(
            @org.springframework.web.bind.annotation.PathVariable String name,
            @org.springframework.web.bind.annotation.PathVariable Integer id
    ) {
        service.attach(name, id);
    }

    @org.springframework.web.bind.annotation.GetMapping("/officers")
    public Iterable<com.lelo.appointment.model.Officer> getAll() {
        return service.findOfficers();
    }

}
