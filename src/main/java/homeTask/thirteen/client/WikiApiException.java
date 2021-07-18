package homeTask.thirteen.client;

public class WikiApiException extends RuntimeException {

    private static final long serialVersionUID = 127365123182381L;

    private WikiApiError error;

    public WikiApiException(WikiApiError error) {
        this.error = error;
    }

    public WikiApiException() {
        super();
    }

    public WikiApiException(String message) {
        super(message);
    }

    public WikiApiException(Throwable cause) {
        super(cause);
    }
    public WikiApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public WikiApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }

}
