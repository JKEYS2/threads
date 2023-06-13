import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Boolean.TRUE;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(Thread.currentThread().getName());

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
        MyThread myThread4 = new MyThread();

        myThread1.setName("myThread1");
        myThread2.setName("myThread2");
        myThread3.setName("myThread3");
        myThread4.setName("myThread4");

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();



//        doing it with an interface
        Thread runnable1 = new Thread(new MyRunnable());
        Thread runnable2 = new Thread(new MyRunnable());
        Thread runnable3 = new Thread(new MyRunnable());
        Thread runnable4 = new Thread(new MyRunnable());

        runnable1.setName("runnable1");
        runnable2.setName("runnable2");
        runnable3.setName("runnable3");
        runnable4.setName("runnable4");

        runnable1.start();
        runnable2.start();
        runnable3.start();
        runnable4.start();







        JFrame myFrame = new JFrame("Thread stuff");
        myFrame.setVisible(TRUE);
        myFrame.setSize(800, 800);

        JPanel myPanel = new JPanel();
        JProgressBar myProgressBar = new JProgressBar();
        myProgressBar.setSize(700, 20);

        myPanel.add(myProgressBar);
        myFrame.add(myPanel);



        JButton myBtn = new JButton("Click");
        myPanel.add(myBtn);

        Thread myProgressBarUpdater = new Thread(new MyProgressBarUpdater(myProgressBar));

        ActionListener myActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("action");
                if (e.getSource() == myBtn) {
                    System.out.println("btn click");
                    myProgressBar.setValue(0);
                    myProgressBarUpdater.start();
                }
            }
        };

        myBtn.addActionListener(myActionListener);

    }

}