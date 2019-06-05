package secfio;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

    private static void createAndShowGUI(){
        ClipBoardView view = new ClipBoardView("Super Extreme Clipboard For Imortals Only");
        ClipboardModel model = new ClipboardModel();
        ClipboardController controller = new ClipboardController(model, view);
        view.setVisible(true);


    }
}
