
/*
 * Copr. (c) 2013 Piradian.com
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;

public class Calculator extends javax.swing.JDialog {

  private DefaultListModel m = new DefaultListModel();
  final private String StatusOK = "Status: OK";

  public Calculator(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    init();
  }

  private void init () {
    setPosition();
    Status.setText(StatusOK);
    Operation.setModel(m);
    m.add(0, "+ add");
    m.add(1, "- subtract");
    m.add(2, "x multiply");
    m.add(3, "\u00f7 divide");
    m.add(4, "1/A reciprocal");
    Operation.setSelectedIndex(0);
    clearInputFields();
  }

  private void setPosition () {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension windowSize = this.getSize();
    int windowX = Math.max(0, (screenSize.width  - windowSize.width ) / 2);
    int windowY = Math.max(0, (screenSize.height - windowSize.height) / 2);
    this.setLocation(windowX, windowY);
  }

 public static boolean isLong (String d) {
   boolean maybe = false;
   try {
     Long.parseLong(d);
     maybe = true;
   } catch (NumberFormatException e) {
     maybe = false;
   }
   return maybe;
 }

  private void clearInputFields() {
    an.setText(null);  an.setForeground(Color.BLACK);
    ad.setText(null);  ad.setForeground(Color.BLACK);
    bn.setText(null);  bn.setForeground(Color.BLACK);
    bd.setText(null);  bd.setForeground(Color.BLACK);
    rn.setText(null);
    rd.setText(null);
  }

  private boolean validateInput (int op) {
    boolean goodInput = true;
    switch (op) {
      case 0:
      case 1:
      case 2:
      case 3:
        // Numerator A must be integer
        if (!isLong(an.getText())) {
          Status.setText("Status:  Numerator A must be an integer.");
          goodInput = false;
        }

        // Denominator A must be non-zero integer
        if (!isLong(ad.getText())) {
          Status.setText("Status:  Denominator A must be an integer.");
          goodInput = false;
        } else if (Long.parseLong(ad.getText()) == 0) {
          Status.setText("Status:  Denominator A cannot be zero.");
          goodInput = false;
        }

        // Numerator B must be integer
        if (!isLong(bn.getText())) {
          Status.setText("Status:  Numerator B must be an integer.");
          goodInput = false;
        }

        // Denominator B must be non-zero integer
        if (!isLong(bd.getText())) {
          Status.setText("Status:  Denominator B must be an integer.");
          goodInput = false;
        } else if (Long.parseLong(bd.getText()) == 0) {
          Status.setText("Status:  Denominator B cannot be zero.");
          goodInput = false;
        }
        break;
      case 4:
        if (!isLong(an.getText())) {
          Status.setText("Status:  Numerator A must be an integer.");
          goodInput = false;
        } else if (Long.parseLong(an.getText()) == 0) {
          Status.setText("Status:  Numerator A cannot be zero.");
          goodInput = false;
        }
        if (!isLong(ad.getText())) {
          Status.setText("Status:  Denominator A must be an integer.");
          goodInput = false;
        } else if (Long.parseLong(ad.getText()) == 0) {
          Status.setText("Status:  Denominator A cannot be zero.");
          goodInput = false;
        }
        break;
      default:
        System.err.println("INFO: validateInput() got op = " + op);
        goodInput = false;
    }
    if (goodInput) {
      Status.setText(StatusOK);
      Status.setForeground(Color.BLACK);
    } else {
      Status.setForeground(Color.RED);
      // message is already set, we just make it red.
    }
    return goodInput;
  }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        an = new javax.swing.JTextField();
        ad = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Operation = new javax.swing.JList();
        jPanel3 = new javax.swing.JPanel();
        bn = new javax.swing.JTextField();
        bd = new javax.swing.JTextField();
        SepB = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        rn = new javax.swing.JTextField();
        rd = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        FractionB = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Equals = new javax.swing.JButton();
        Status = new javax.swing.JLabel();
        Clear = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        MFile = new javax.swing.JMenu();
        MFileExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fraction Calculator - Piradian.com");
        setResizable(false);

        an.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        an.setText("jTextField1");
        an.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        ad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ad.setText("jTextField2");
        ad.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(an)
                    .addComponent(ad, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator3)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(an, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Operation.setModel(new DefaultListModel());
        Operation.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Operation.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                OperationValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Operation);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        bn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bn.setText("jTextField3");
        bn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        bd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bd.setText("jTextField4");
        bd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        SepB.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bn, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(bd))
                .addContainerGap())
            .addComponent(SepB)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SepB, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rn.setBackground(new java.awt.Color(255, 255, 255));
        rn.setEditable(false);
        rn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rn.setText("jTextField5");
        rn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        rd.setBackground(new java.awt.Color(255, 255, 255));
        rd.setEditable(false);
        rd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rd.setText("jTextField6");
        rd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rn, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(rd))
                .addContainerGap())
            .addComponent(jSeparator2)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(rd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Fraction A:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Operation:");

        FractionB.setText("Fraction B:");

        jLabel4.setText("Result:");

        Equals.setText("=");
        Equals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqualsActionPerformed(evt);
            }
        });

        Status.setText(StatusOK);

        Clear.setText("C");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        MFile.setText("File");

        MFileExit.setText("Exit");
        MFileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MFileExitActionPerformed(evt);
            }
        });
        MFile.add(MFileExit);

        jMenuBar1.add(MFile);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Equals))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FractionB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Clear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Exit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(FractionB)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(Equals)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Status)
                    .addComponent(Exit)
                    .addComponent(Clear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void MFileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MFileExitActionPerformed
    this.dispose();
    System.exit(0);
  }//GEN-LAST:event_MFileExitActionPerformed

  private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
    this.dispose();
    System.exit(0);
  }//GEN-LAST:event_ExitActionPerformed

  private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
    clearInputFields();
    Status.setForeground(Color.BLACK);
    Status.setText(StatusOK);
  }//GEN-LAST:event_ClearActionPerformed

  private void EqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EqualsActionPerformed
    /*
     * Operations are:
     *  0 => +
     *  1 => -
     *  2 => x
     *  3 => /
     *  4 => ^(-1)
     */
    int op = Operation.getSelectedIndex();
    boolean unhandledSwitch = false;
    if (validateInput(op)) {
      Fraction A, B, R;
      switch (op) {
        case 0:   // addition
          A = new Fraction(Long.parseLong(an.getText()), Long.parseLong(ad.getText()));
          B = new Fraction(Long.parseLong(bn.getText()), Long.parseLong(bd.getText()));
          R = Fraction.add(A, B);
          break;
        case 1:   // subtraction
          A = new Fraction(Long.parseLong(an.getText()), Long.parseLong(ad.getText()));
          B = new Fraction(Long.parseLong(bn.getText()), Long.parseLong(bd.getText()));
          R = Fraction.subtract(A, B);
          break;
        case 2:   // multiplication
          A = new Fraction(Long.parseLong(an.getText()), Long.parseLong(ad.getText()));
          B = new Fraction(Long.parseLong(bn.getText()), Long.parseLong(bd.getText()));
          R = Fraction.multiply(A, B);
          break;
        case 3:   // division
          A = new Fraction(Long.parseLong(an.getText()), Long.parseLong(ad.getText()));
          B = new Fraction(Long.parseLong(bn.getText()), Long.parseLong(bd.getText()));
          R = Fraction.divide(A, B);
          break;
        case 4:   // reciprocal
          A = new Fraction(Long.parseLong(an.getText()), Long.parseLong(ad.getText()));
          R = Fraction.reciprocal(A);
          break;
        default:
          R = new Fraction(0,1);
          unhandledSwitch = true;
      }//switch
      if (!unhandledSwitch) {
        R.reduce();
        rn.setText(String.valueOf(R.getNumerator()));
        rd.setText(String.valueOf(R.getDenominator()));
      } else {
        System.err.println("INFO:  Unhandled switch in EqualsActionPerformed()");
      }
    }
  }//GEN-LAST:event_EqualsActionPerformed

  private void OperationValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_OperationValueChanged
    if (Operation.getSelectedIndex() == 4) {  // reciprocal
      bn.setText(null);
      bd.setText(null);
      FractionB.setEnabled(false);
      bn.setEnabled(false); bn.setBackground(Color.LIGHT_GRAY);
      bd.setEnabled(false); bd.setBackground(Color.LIGHT_GRAY);
    } else {
      FractionB.setEnabled(true);
      bn.setEnabled(true); bn.setBackground(Color.WHITE);
      bd.setEnabled(true); bd.setBackground(Color.WHITE);
    }
  }//GEN-LAST:event_OperationValueChanged

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        Calculator dialog = new Calculator(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Equals;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel FractionB;
    private javax.swing.JMenu MFile;
    private javax.swing.JMenuItem MFileExit;
    private javax.swing.JList Operation;
    private javax.swing.JSeparator SepB;
    private javax.swing.JLabel Status;
    private javax.swing.JTextField ad;
    private javax.swing.JTextField an;
    private javax.swing.JTextField bd;
    private javax.swing.JTextField bn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField rd;
    private javax.swing.JTextField rn;
    // End of variables declaration//GEN-END:variables

}
