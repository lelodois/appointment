package com.lelo.appointment;

@org.springframework.stereotype.Service
public class Service {

    private final AppointmentRepository appointmentRepository;

    public Service(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void save(com.lelo.appointment.model.Appointment novo) {
        appointmentRepository.save(novo);
    }

    public Iterable<com.lelo.appointment.model.Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Iterable<com.lelo.appointment.model.Appointment> findAvailable() {
        java.util.List<com.lelo.appointment.model.Appointment> available = new java.util.ArrayList<>();
        for (com.lelo.appointment.model.Appointment appointment : findAll()) {
            if(org.apache.commons.lang3.StringUtils.isEmpty(appointment.getOfficer())){
                available.add(appointment);
            }
        }
        return available;
    }

    public void attach(String officialName, Integer id) {

        java.util.Optional<com.lelo.appointment.model.Appointment> agendamentoOptional
                = appointmentRepository.findById(id);

        if (agendamentoOptional.isEmpty())
            throw new com.lelo.appointment.tools.NotFoundException(id);

        if(!com.lelo.appointment.OfficersRepository.isAvailable(id))
            throw new com.lelo.appointment.tools.AlreadyAttachedException(id);

        com.lelo.appointment.model.Officer official = com.lelo.appointment.OfficersRepository.getOrAdd(officialName);
        com.lelo.appointment.model.Appointment appointment = agendamentoOptional.get();
        official.add(appointment);
        appointment.setOfficer(official.getName());
        appointmentRepository.save(appointment);
    }

    public Iterable<com.lelo.appointment.model.Officer> findOfficers() {
        return com.lelo.appointment.OfficersRepository.getOfficers();
    }

    public void deleteAll() {
        appointmentRepository.deleteAll();
    }
}
