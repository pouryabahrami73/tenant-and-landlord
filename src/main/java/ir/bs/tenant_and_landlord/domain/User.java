package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by : Pourya Bahrami
 * Date : 10/28/21
 * Time : 9:17 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "national_code", unique = true)
    private String nationalCode;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserRoleContractJunction> userRoleContractJunctions;
}
