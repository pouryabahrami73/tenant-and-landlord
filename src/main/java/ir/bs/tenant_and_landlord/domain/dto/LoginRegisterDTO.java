package ir.bs.tenant_and_landlord.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 12:34 AM
 */

@Getter
@Setter
@NoArgsConstructor
public class LoginRegisterDTO {

    @NotNull(message = "Mobile number can't be null.")
    @NotBlank(message = "Mobile number can't be blank.")
    private String phoneNumber;

    @NotNull(message = "Password can't be null.")
    @NotBlank(message = "Password can't be blank.")
    private String password;
}
