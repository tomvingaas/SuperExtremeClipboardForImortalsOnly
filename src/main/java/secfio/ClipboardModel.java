package secfio;

import java.util.ArrayList;
import java.util.List;

public class ClipboardModel {
    private List<ClipboardResult> clipboardResults;

    public ClipboardModel( ) {
        this.clipboardResults = new ArrayList<>();
    }

    public List<ClipboardResult> getClipboardResults() {
        return clipboardResults;
    }

    public ClipboardResult getResult(int id){
        return this.clipboardResults.get(id);
    }
}
