package ir.bs.tenant_and_landlord.controller;

import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterResponseDTO;
import ir.bs.tenant_and_landlord.domain.dto.ResponseDTO;
import ir.bs.tenant_and_landlord.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 12:12 AM
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/authentication/v1")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRegisterDTO loginDTO) {

        return null;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<LoginRegisterResponseDTO>> register(@Valid @RequestBody LoginRegisterDTO registerDTO) {
        userService.tryToRegister(registerDTO);
        return null;
    }
}
