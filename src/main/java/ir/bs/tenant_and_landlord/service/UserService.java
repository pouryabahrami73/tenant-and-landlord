package ir.bs.tenant_and_landlord.service;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 10:05 PM
 */
public interface UserService {

    void register(LoginRegisterDTO registerDTO);

    User loadUserByPhoneNumber(String phoneNumber);

    User findByNationalCode(long nationalCode);
}
