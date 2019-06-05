package secfio;

import java.util.Date;

public class ClipboardResult {
    private int id;
    private String content;
    private Date date;
    private int counter;

    public ClipboardResult(String content, int elementCounter) {
        this.content = content;
        this.date = new Date();
        this.id = elementCounter+1;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public int getCounter() {
        return counter;
    }

    public void  resultCopied(){
        this.counter += 1;
    }
}
