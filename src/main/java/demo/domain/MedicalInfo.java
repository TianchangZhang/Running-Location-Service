package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
@RequiredArgsConstructor
public class MedicalInfo {
    private final long bfr;

    private final long bmi;
}
