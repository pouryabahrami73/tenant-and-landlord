package ir.bs.tenant_and_landlord.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by : Pourya Bahrami
 * Date : 10/28/21
 * Time : 11:59 PM
 */

@Getter
@AllArgsConstructor
public enum PaymentType {
    CASH, IPG, CARD_TO_CARD, COIN;
}
