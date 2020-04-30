package demo.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RUNNING_LOCATIONS")
public class Location {
    enum GpsStatus {
        EXCELLENT, OK, UNRELIABLE, BAD, NOTFIX, UNKNOW;
    }

    public enum RunnerMovementType {
        STOPPED, IN_MOTION;

        public boolean isMoving() {
            return this != STOPPED;
        }
    }

    @Id
    @GeneratedValue
    private long id;

    @Embedded
    @AttributeOverride(name = "bandMake",column = @Column(name = "unit_band_name"))
    private final UnitInfo unitInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="fmi", column = @Column(name="medical_fmi")),
            @AttributeOverride(name="bfr", column = @Column(name="medical_bfr"))
    })
    private MedicalInfo medicalInfo;

    private double latitude;
    private double longitude;

    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus;
    private double odometer;
    private double totalRunningTime;
    private double totalIdleTime;
    private double totalCalorieBurnt;
    private String address;
    private Date timestamp = new Date();
    private String gearProvider;
    private RunnerMovementType runnerMovementType = RunnerMovementType.STOPPED;
    private String serviceType;

    private Location(String runningId) {
        this.unitInfo = new UnitInfo(runningId);
    }

}
