package seylim.seynet.core.business;

import seylim.seynet.core.utilities.Result;

import java.util.ArrayList;
import java.util.List;

public class BusinessRules {
    public static Result[] run(Result... logics){
        List<Result> results = new ArrayList<Result>();
        for (Result logic:logics) {
            if (!logic.isSuccess()){
                results.add(logic);
            }
        }
        return results.toArray(new Result[results.size()]);
    }
}
