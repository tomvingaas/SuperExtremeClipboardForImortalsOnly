package secfio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ClipBoardView extends JFrame {
    private JPanel panel;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel defaultTableModel;

    public ClipBoardView(String title) throws HeadlessException {
        super(title);
        panel = new JPanel();
        scrollPane = new JScrollPane();
        defaultTableModel = new DefaultTableModel(null, new Object[]{"Innhold", "Antall Ganger Kopiert", "Dato"});
        table = new JTable(defaultTableModel);
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 900);
        panel.add(scrollPane);

        this.add(panel);
    }


    public JPanel getPanel() {
        return panel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

}
