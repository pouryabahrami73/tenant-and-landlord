package ir.bs.tenant_and_landlord.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by : Pourya Bahrami
 * Date : 4/29/22
 * Time : 12:27 PM
 */

@Getter
public class AuthenticationException extends RuntimeException {

    private String msg;
    private HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;

    public AuthenticationException(String msg, HttpStatus statusCode) {
        super(msg);
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
