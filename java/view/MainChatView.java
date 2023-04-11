package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MainChatView extends javax.swing.JFrame {

    static final String sendIconURL = "java/icon/send.jpg";

    
    int x, y;
    public MainChatView() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        initMove();
    }

    private void init() {
        intiImage();
    }

    private void intiImage() {
        sendButton.setIcon(toIcon(sendIconURL, 60, 60));
        jScrollPane2.setOpaque(false);
        ourTextArea.setBackground(new Color(0, 0, 0, 0));
        jScrollPane2.getViewport().setOpaque(false);
        myTextArea.setCaretColor(Color.WHITE);
        initEvent();
    }
    
    private void initMove() {
        
        backgroundPanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
            
        });
        
        backgroundPanel1.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                MainChatView.this.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
        
    }
    
    private void initEvent() {
        sendButton.addActionListener((e) -> {
            String messageAvailable = ourTextArea.getText();
            if (!messageAvailable.isBlank()) {
                ourTextArea.append("\n");
            }
            
            // Handle if there are spaces, tabs, or enters, etc...
            String sendingMessage = myTextArea.getText().replaceAll(" +", " ").trim();
            ourTextArea.append(sendingMessage);
            myTextArea.setText("");
        });
    }

    public static ImageIcon toIcon(String url, int width, int height) {
        return new ImageIcon(
                new ImageIcon(url).getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel1 = new component.BackgroundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTextArea = new javax.swing.JTextArea();
        sendButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ourTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        myTextArea.setBackground(new java.awt.Color(12, 127, 149));
        myTextArea.setColumns(20);
        myTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        myTextArea.setForeground(new java.awt.Color(255, 255, 255));
        myTextArea.setRows(1);
        myTextArea.setWrapStyleWord(true);
        myTextArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(12, 127, 149)));
        jScrollPane1.setViewportView(myTextArea);

        sendButton.setBorderPainted(false);
        sendButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendButton.setFocusable(false);
        sendButton.setOpaque(false);

        ourTextArea.setEditable(false);
        ourTextArea.setColumns(20);
        ourTextArea.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ourTextArea.setForeground(new java.awt.Color(255, 255, 255));
        ourTextArea.setLineWrap(true);
        ourTextArea.setRows(5);
        ourTextArea.setWrapStyleWord(true);
        ourTextArea.setOpaque(false);
        jScrollPane2.setViewportView(ourTextArea);

        javax.swing.GroupLayout backgroundPanel1Layout = new javax.swing.GroupLayout(backgroundPanel1);
        backgroundPanel1.setLayout(backgroundPanel1Layout);
        backgroundPanel1Layout.setHorizontalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(backgroundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        backgroundPanel1Layout.setVerticalGroup(
            backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainChatView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainChatView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainChatView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainChatView.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainChatView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.BackgroundPanel backgroundPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea myTextArea;
    private javax.swing.JTextArea ourTextArea;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables
}
