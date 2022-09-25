package ir.bs.tenant_and_landlord.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by : Pourya Bahrami
 * Date : 11/20/21
 * Time : 11:15 PM
 */

@Getter
@Setter
@NoArgsConstructor
public class LoginRegisterResponseDTO extends BaseDTO {

    private String token;

    private LocalDateTime expiresAt;
}
