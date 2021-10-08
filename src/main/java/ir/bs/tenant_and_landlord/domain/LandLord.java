package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:06 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "land_lord")
public class LandLord extends BaseEntity {
}
