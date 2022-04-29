package ir.bs.tenant_and_landlord.domain.mapper;

import ir.bs.tenant_and_landlord.domain.User;
import ir.bs.tenant_and_landlord.domain.dto.LoginRegisterDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by : Pourya Bahrami
 * Date : 4/29/22
 * Time : 12:58 PM
 */

@Mapper(componentModel = "spring", uses = PasswordEncoder.class, injectionStrategy = InjectionStrategy.FIELD)
public interface UserMapper {


    @Mapping(target = "password", expression = "java(passwordEncoder.encode(loginRegisterDTO.getPassword()))")
    User toEntity(LoginRegisterDTO loginRegisterDTO);
}
