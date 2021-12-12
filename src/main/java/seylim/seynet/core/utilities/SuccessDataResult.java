package seylim.seynet.core.utilities;

import java.util.Optional;

public class SuccessDataResult<T> extends DataResult{

    public SuccessDataResult(){
        super(null, true);
    }

    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    public SuccessDataResult(String message){
        super(null, true, message);
    }
}
