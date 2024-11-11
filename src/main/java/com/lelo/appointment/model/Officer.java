package com.lelo.appointment.model;

public class Officer {

    private final String name;
    private final java.util.List<com.lelo.appointment.model.Appointment> appointments;

    public Officer(String name) {
        this.name = name;
        this.appointments = new java.util.ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public java.util.List<com.lelo.appointment.model.Appointment> getAppointments() {
        return appointments;
    }

    public void add(com.lelo.appointment.model.Appointment newAppointment) {
        for (com.lelo.appointment.model.Appointment appointment : getAppointments())
            if(appointment.getId() == newAppointment.getId())
                return;
        getAppointments().add(newAppointment);
    }
}
