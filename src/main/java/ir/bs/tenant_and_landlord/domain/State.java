package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by : Pourya Bahrami
 * Date : 10/8/21
 * Time : 9:05 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "state")
public class State extends BaseEntity {
}
