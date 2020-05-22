package sample;

import java.util.List;

public class ExternalAdapter implements AdditionalProcessing {
    @Override
    public void del_proc() {

    }

    @Override
    public boolean get_proc(List<Games> list) {
        return false;
    }
}
