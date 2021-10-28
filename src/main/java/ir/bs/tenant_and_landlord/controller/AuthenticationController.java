package ir.bs.tenant_and_landlord.controller;

import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 12:12 AM
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRegisterDTO loginDTO,
                                HttpServletRequest request) {
        return null;
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody LoginRegisterDTO registerDTO,
                                   HttpServletRequest request) {
        return null;
    }
}
