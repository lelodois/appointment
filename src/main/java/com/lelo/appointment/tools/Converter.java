package com.lelo.appointment.tools;

public class Converter {

    private Converter(){
    }

    public static Iterable<com.lelo.appointment.model.Response> toResponse (Iterable <com.lelo.appointment.model.Appointment> appointments) {
        java.util.List<com.lelo.appointment.model.Response> list = new java.util.ArrayList<>();
        for (com.lelo.appointment.model.Appointment appointment : appointments) {
            com.lelo.appointment.model.Response response = new com.lelo.appointment.model.Response();
            response.setId(appointment.getId());
            response.setSize(appointment.getSize());
            response.setSubject(appointment.getSubject());
            response.setOfficer(appointment.getOfficer());
            list.add(response);
        }
        return list;
    }

    public static com.lelo.appointment.model.Appointment toModel(com.lelo.appointment.model.Request request) {
        com.lelo.appointment.model.Appointment appointmentModel = new com.lelo.appointment.model.Appointment();
        appointmentModel.setDate(java.time.LocalDate.now());
        appointmentModel.setOwner(request.getOwner());
        appointmentModel.setSize(request.getSize());
        appointmentModel.setSubject(request.getSubject());
        return appointmentModel;
    }
}