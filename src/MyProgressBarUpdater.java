import javax.swing.*;

import static java.lang.Boolean.TRUE;

// todo: change this to call a function in a MyProgressBar method
// move the for loop into this
public class MyProgressBarUpdater implements Runnable {

    JProgressBar progressBar;

    public MyProgressBarUpdater(JProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    //    heck this is currently an overload not an override
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("run");
            int progress = progressBar.getValue();
            if (progress == 99) {
                JFrame errorBox = new JFrame();
                errorBox.setSize(200, 100);
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Error loading");

                panel.add(label);
                errorBox.add(panel);
                errorBox.setVisible(TRUE);
                break;
            }
            progressBar.setValue(progress + 1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
