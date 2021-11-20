package ir.bs.tenant_and_landlord.domain.dto;

/**
 * Created by : Pourya Bahrami
 * Date : 10/29/21
 * Time : 9:48 PM
 */
public class ResponseDTO<T extends BaseDTO> {

    private T payload;
    private String message;
}
