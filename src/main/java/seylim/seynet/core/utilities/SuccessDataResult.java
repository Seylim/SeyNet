package seylim.seynet.core.utilities;

public class SuccessDataResult<T> extends DataResult{

    public SuccessDataResult(){
        super(null, true);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(Object data, String message) {
        super(data, true, message);
    }
}
