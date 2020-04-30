package demo.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@Data
@Embeddable
@RequiredArgsConstructor
public class MedicalInfo {
    private final long bfr;

    private final long bmi;
}
