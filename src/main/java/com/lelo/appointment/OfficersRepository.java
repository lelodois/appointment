package com.lelo.appointment;

public class OfficersRepository {

    private static final java.util.List<com.lelo.appointment.model.Officer> OFFICERS =
            new java.util.ArrayList<com.lelo.appointment.model.Officer>();

    public static com.lelo.appointment.model.Officer getOrAdd(String name) {
        for (com.lelo.appointment.model.Officer official : OFFICERS) {
            if (official.getName().equals(name))
                return official;
        }
        com.lelo.appointment.model.Officer officer = new com.lelo.appointment.model.Officer(name);
        OFFICERS.add(officer);
        return officer;
    }

    public static boolean isAvailable(Integer id) {
        for (com.lelo.appointment.model.Officer official : com.lelo.appointment.OfficersRepository.getOfficers()) {
            for (com.lelo.appointment.model.Appointment appointment : official.getAppointments()) {
                if(appointment.getId() == id){
                    return false;
                }
            }
        }
        return true;
    }

    public static Iterable<com.lelo.appointment.model.Officer> getOfficers() {
        return OFFICERS;
    }
}
