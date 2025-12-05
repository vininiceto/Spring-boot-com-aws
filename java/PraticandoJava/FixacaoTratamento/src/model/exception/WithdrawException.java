package model.exception;

import java.io.Serial;

public class WithdrawException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public WithdrawException(String msg){
        super(msg);
    }

}
