package secfio;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClipboardController {
    private ClipboardModel model;
    private ClipBoardView view;
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public ClipboardController(ClipboardModel model, ClipBoardView view) {
        this.model = model;
        this.view = view;

        ClipboardListener cbl = new ClipboardListener();
        cbl.start();

    }

    public class ClipboardListener extends Thread implements ClipboardOwner{
        Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();

        public void run() {
            Transferable trans = sysClip.getContents(this);
            regainOwnership(trans);
            System.out.println("Listening to board...");
            while(true) {}
        }

        public void lostOwnership(Clipboard c, Transferable t) {
            try {
                sleep(20);
            } catch(Exception e) {
                System.out.println("Exception: " + e);
            }
            Transferable contents = sysClip.getContents(this);
            processContents(contents);
            regainOwnership(contents);
        }

        void processContents(Transferable t) {
            System.out.println("Processing: " + t);
            try {
                String transferData = (String) t.getTransferData(DataFlavor.stringFlavor);
                System.out.println(transferData);
                ClipboardResult clipboardResult = new ClipboardResult(transferData, model.getClipboardResults().size());
                model.getClipboardResults().add(clipboardResult);
                view.getDefaultTableModel().addRow(new String[]{clipboardResult.getContent(),( clipboardResult.getCounter() + " ganger"), clipboardResult.getDate().toString() });
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        void regainOwnership(Transferable t) {
            sysClip.setContents(t, this);
        }
    }
}
