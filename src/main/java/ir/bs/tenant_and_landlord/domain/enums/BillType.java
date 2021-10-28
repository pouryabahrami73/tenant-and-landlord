package ir.bs.tenant_and_landlord.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by : Pourya Bahrami
 * Date : 10/28/21
 * Time : 8:45 PM
 */

@Getter
@AllArgsConstructor
public enum BillType {
    WATER, GAS, POWER, TELEPHONE;
}
