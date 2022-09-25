package ir.bs.tenant_and_landlord.domain.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Created by : Pourya Bahrami
 * Date : 9/22/22
 * Time : 4:10 PM
 */

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class ErrorDTO {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}
