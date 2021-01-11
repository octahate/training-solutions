package exceptionclass.bank;

public class InvalidBankOperationException extends RuntimeException {

    ErrorCode errorcode;

    public InvalidBankOperationException(ErrorCode errorcode) {
        this.errorcode = errorcode;
    }

    public ErrorCode getErrorCode() {
        return errorcode;
    }
}
