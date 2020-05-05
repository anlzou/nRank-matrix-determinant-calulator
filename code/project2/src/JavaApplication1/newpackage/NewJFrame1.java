package JavaApplication1.newpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class NewJFrame1 extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form NewJFrame1
     */
    public NewJFrame1() {
        initComponents();
    }
    public static double GetValue(double[][] p, int n) {
        if (n == 1) // 如果是一阶行列式,直接返回该元素
        {
            return p[0][0];
        }
        double sum = 0; // 累加求和变量
        for (int j = 0; j < n; j++) {// 遍历最后一行各元素,p[n - 1][j]
            int pt = (n - 1) + j;  // 符号判断指数
            double[][] p1 = new double[n][n];
            // 此过程是为了把行列式存放到临时数组中，不改变但前行列式
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    p1[row][col] = p[row][col];
                }
            }
            // 此过程，是为了将元素 p[n-1][j] 所在列之后的每一列向前移动一列，为后面获取该元素对应的余子式做准备
            for (int index = 0; index < n - 1; index++) {
                for (int index1 = j; index1 < n - 1; index1++) {
                    p1[index][index1] = p1[index][index1 + 1];
                }
            }
            // 此过程，截取临时数组 p1 左上角 n-1  阶行列式，提取元素 p[n-1][j] 的余子式
            double[][] temp = new double[n - 1][n - 1];
            for (int row = 0; row < n - 1; row++) {
                for (int col = 0; col < n - 1; col++) {
                    temp[row][col] = p1[row][col];
                }
            }
            // 求和：sum += 元素 * 符号 * 余子式
            // 因为，余子式是去除某一元素所在的行和列之后剩下的元素构成的 n-1 阶行列式
            // 即，余子式本质还是行列式，所以需要递归求行列式的值
            sum += p[n - 1][j] * Math.pow(-1, pt) * GetValue(temp, n - 1);
            // System.out.println(p[n - 1][j] + " * " + Math.pow(-1, pt) + " * " + GetValue(p1, n - 1));
        }
        return sum;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("行列式计算");
        setLocation(new java.awt.Point(500, 200));

        jTextField1.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setFont(new java.awt.Font("宋体", 3, 18)); // NOI18N
        jLabel3.setText("输入矩阵 解矩阵的行列式");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("计算");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("宋体", 3, 18)); // NOI18N
        jLabel4.setText("1-n阶矩阵:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = jTextArea1.getText();
        s = s+"\n";
        s = s.replaceAll("\n", " ");
        String[] tempi = s.split(" ");
        n = (int) Math.sqrt(tempi.length);
        //System.out.println(n);
        double a[][] = new double[n][n];
        for (int i = 0,j = 0,k = 0; i < tempi.length; i++) {
            a[j][k++] = Double.parseDouble(tempi[i]);
            if(k == n){
                j++;
                k = 0;
            }
        }
        for(double[]c:a){
            for(double n:c){
                System.out.print(n+ " ");
            }
            System.out.println();
        }
        jTextField1.setText(Double.toString(GetValue(a, n)));
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    int n = 1;
}