package ir.bs.tenant_and_landlord.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 12:34 AM
 */

@Getter
@Setter
@NoArgsConstructor
public class LoginRegisterDTO {

    private String mobileNumber;

    private String password;
}
