package vaccopsjava;

import java.util.Collection;

public interface IVaccOps {

    void addDoctor(Doctor d);

    void addPatient(Doctor d, Patient p);

    Collection<Doctor> getDoctors();

    Collection<Patient> getPatients();

    boolean exist(Doctor d);

    boolean exist(Patient p);

    Doctor removeDoctor(String name);

    void changeDoctor(Doctor from, Doctor to, Patient p);

    Collection<Doctor> getDoctorsByPopularity(int populariry);

    Collection<Patient> getPatientsByTown(String town);

    Collection<Patient> getPatientsInAgeRange(int lo, int hi);

    Collection<Doctor> getDoctorsSortedByPatientsCountDescAndNameAsc();

    Collection<Patient> getPatientsSortedByDoctorsPopularityAscThenByHeightDescThenByAge();
}
