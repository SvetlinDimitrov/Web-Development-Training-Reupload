package vaccopsjava11;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.CharSequence.compare;

public class VaccOps implements IVaccOps {

   HashMap<String , Patient> patientMap;
   HashMap<Doctor , List<Patient>> clinic;

    public VaccOps() {
        patientMap = new LinkedHashMap<>();
        clinic = new LinkedHashMap<>();
    }

    public void addDoctor(Doctor d) {
        if(!clinic.containsKey(d)){
            clinic.put(d , new ArrayList<>());
            return;
        }
        throw new IllegalArgumentException();
    }

    public void addPatient(Doctor d, Patient p) {
        if(clinic.containsKey(d)){
            if(!patientMap.containsKey(p.name)){
                patientMap.put(p.name , p);
                clinic.get(d).add(p);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<Doctor> getDoctors() {
        return clinic.keySet();
    }

    public Collection<Patient> getPatients() {
        return patientMap.values();
    }

    public boolean exist(Doctor d) {
        return clinic.containsKey(d);
    }

    public boolean exist(Patient p) {
        return patientMap.containsKey(p.name);
    }


    public Doctor removeDoctor(String name) {
        Doctor doctorRetire = null;
        for (Doctor doctor : clinic.keySet()) {
            if(doctor.name.equals(name)){
                doctorRetire = doctor;
                break;
            }
        }
        if(doctorRetire == null){
            throw new IllegalArgumentException();
        }
        clinic.remove(doctorRetire);
        return doctorRetire;
    }

    public void changeDoctor(Doctor from, Doctor to, Patient p) {

        if(clinic.containsKey(from) &&
                clinic.containsKey(to)){
            if(clinic.get(from).contains(p)){
                clinic.get(from).remove(p);
                clinic.get(to).add(p);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<Doctor> getDoctorsByPopularity(int populariry) {

        return clinic.keySet()
                .stream().filter(e->e.popularity == populariry)
                .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsByTown(String town) {

        return patientMap.values().stream()
                .filter(e->e.town.equals(town))
                .collect(Collectors.toList());

    }

    public Collection<Patient> getPatientsInAgeRange(int lo, int hi) {

        return patientMap.values().stream()
                .filter(e->e.age >=lo && e.age<=hi)
                .collect(Collectors.toList());

    }

    public List<Doctor> getDoctorsSortedByPatientsCountDescAndNameAsc() {
         return  clinic.entrySet().stream()
                .sorted((f,s)->{
                    boolean isEqual = Integer.compare(s.getValue().size() , f.getValue().size()) ==0;
                    if(isEqual){
                        return compare(f.getKey().name , s.getKey().name);
                    }
                    return Integer.compare(s.getValue().size() , f.getValue().size());
                })
                 .map(Map.Entry::getKey)
                 .collect(Collectors.toList());
    }

    public Collection<Patient> getPatientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge() {
        return clinic.entrySet().stream()
                .sorted((f,s)->{
                    boolean ifDoctorPopularityIsEqual = Integer.compare(f.getKey().popularity , s.getKey().popularity) == 0;
                    if(ifDoctorPopularityIsEqual){

                    }
                    return Integer.compare(f.getKey().popularity , s.getKey().popularity);
                })

    }

}
