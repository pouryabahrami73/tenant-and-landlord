package ir.bs.tenant_and_landlord.domain;

import ir.bs.tenant_and_landlord.domain.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by : Pourya Bahrami
 * Date : 10/28/21
 * Time : 9:17 PM
 */

@Getter
@Setter
@NoArgsConstructor
//@MappedSuperclass
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @OneToMany
    private List<Contract> contracts;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;

    @Column(name = "phone _number")
    private String phoneNumber;

    @Column(name = "national_code", unique = true, nullable = false)
    private String nationalCode;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
