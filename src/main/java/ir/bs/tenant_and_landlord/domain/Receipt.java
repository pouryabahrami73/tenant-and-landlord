package ir.bs.tenant_and_landlord.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by : Pourya Bahrami
 * Date : 10/28/21
 * Time : 11:44 PM
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "recrips")
public class Receipt extends BaseEntity {

    @Column(name = "amount")
    private double amount;

    @Column(name = "land_lord_seen")
    private boolean landLordSeen;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "tenant_message")
    private String tenantMessage;

    @Column(name = "land_lord_message")
    private String landLordMessage;

    @Lob
    @Column(name = "file", columnDefinition = "longblob")
    private String file;
}
