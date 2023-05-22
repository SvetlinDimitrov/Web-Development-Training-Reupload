package vaccopsjava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VaccOps implements IVaccOps {
    HashMap<String , Doctor> doctorHashMap ;
    HashMap<Doctor ,List<Patient>> clinic;
    HashMap<String , Patient> patientHashMap;

    public VaccOps() {
        doctorHashMap = new LinkedHashMap<>();
        clinic = new LinkedHashMap<>();
        patientHashMap = new LinkedHashMap<>();
    }

    public void addDoctor(Doctor d) {
        String doctorName = d.name;
        if(doctorHashMap.containsKey(doctorName)){
            throw new IllegalArgumentException();
        }
        doctorHashMap.put(doctorName , d);
        clinic.put(d  , new ArrayList<>());
    }

    public void addPatient(Doctor d, Patient p) {
        if(doctorHashMap.containsKey(d.name)){
            if(!patientHashMap.containsKey(p.name)) {
                patientHashMap.put(p.name , p);
                clinic.get(d).add(p);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<Doctor> getDoctors() {
        return doctorHashMap.values();
    }

    public Collection<Patient> getPatients() {
        return patientHashMap.values();
    }

    public boolean exist(Doctor d) {
        return doctorHashMap.containsKey(d.name);
    }

    public boolean exist(Patient p) {
        return patientHashMap.containsKey(p.name);
    }


    public Doctor removeDoctor(String name) {
        Doctor doctorToRemove = null;
        if(doctorHashMap.containsKey(name)){
            doctorToRemove = doctorHashMap.get(name);
            doctorHashMap.remove(name);
            for (Patient patient : clinic.get(doctorToRemove)) {
                patientHashMap.remove(patient.name);
            }
            clinic.remove(doctorToRemove);
        }else{
            throw new IllegalArgumentException();
        }
        return doctorToRemove;
    }

    public void changeDoctor(Doctor from, Doctor to, Patient p) {
        if(doctorHashMap.containsKey(from.name) && doctorHashMap.containsKey(to.name)){
            boolean removed = clinic.get(from).remove(p);
            if(removed){
                clinic.get(to).add(p);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<Doctor> getDoctorsByPopularity(int populariry) {

        return doctorHashMap.values().stream()
                .filter(e->e.popularity == populariry)
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsByTown(String town) {

        return patientHashMap.values().stream()
                .filter(e->e.town.equals(town))
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsInAgeRange(int lo, int hi) {

        return patientHashMap.values().stream()
                .filter(e->e.age >= lo && e.age <=hi)
                .collect(Collectors.toList());
    }

    public Collection<Doctor> getDoctorsSortedByPatientsCountDescAndNameAsc() {
        return null;
    }

    public Collection<Patient> getPatientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge() {
        return null;
    }
}
