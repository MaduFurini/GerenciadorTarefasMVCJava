/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.view;

import br.unifae.engsoftware.maduFurini.gerenciadortarefas.controller.TarefaController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author sempher
 */
public class FormularioTarefa extends javax.swing.JFrame {  
    TelaPrincipal telaPrincipal;

    // Controle de exibição do campo de conclusão
    private boolean isEditing = false;
    // Para localização de tarefas (para futuramente ser enviado para o controller)
    private int tarefaRow = -1;
            
    /**
     * Creates new form FormularioTarefa
     */
    public FormularioTarefa() {
        initComponents();
        this.screenConfigs();
    }

    /**
    * Seta configurações padrões para renderização de tarefas
    */
    public final void screenConfigs () {
        if (this.getTarefaLocation() != -1) {
           this.isEditing = true;
           
           this.setDataToEditTarefa();
        }
        jLabel3.setVisible(isEditing);
        concluidaField.setVisible(isEditing);
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // Garantir que a tela quando aberta, fique sempre na frente de qualquer outra tela aberta do pc
        this.toFront();
    }
    
    /**
    * Controle de chamada para criação e edição de tarefas
     * @return 
    */
    public boolean setDestinationToController() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String descricao = descricaoField.getText();
        int prioridade = Integer.parseInt((String) prioridadeField.getSelectedItem());
        LocalDate dataCriacao = LocalDate.parse(dataCriacaoField.getText(), formatter);
        boolean concluida = concluidaField.isSelected();

        TarefaController tarefaController = new TarefaController();

        if (this.getTarefaLocation() == -1) {
            if (prazoField.getText().isEmpty() || prazoField.getText().equals("  /  /    ")) {
                return tarefaController.storeSimples(descricao, prioridade, concluida, dataCriacao);
            } else {
                LocalDate prazo = LocalDate.parse(prazoField.getText(), formatter);
                return tarefaController.storeComPrazo(descricao, prioridade, concluida, dataCriacao, prazo);
            }
        }

        LocalDate prazo = null;
        if (!prazoField.getText().isEmpty() && !prazoField.getText().equals("  /  /    ")) {
            prazo = LocalDate.parse(prazoField.getText(), formatter);
        }

        return tarefaController.update(this.getTarefaLocation(), descricao, prioridade, concluida, dataCriacao, prazo);
    }

    /**
    * Função para setar dados das tarefas nos campos de preenchimento quando for edição de tarefas
    */
    public void setDataToEditTarefa() {
        Object[] dados = TarefaController.show(this.getTarefaLocation());
        
        descricaoField.setText((String) dados[0]);
        prioridadeField.setSelectedItem(dados[1]);
        concluidaField.setSelected((boolean) dados[2]);
        dataCriacaoField.setText((String) dados[3]);
        
        if (dados[4] != null) {
            prazoField.setText((String) dados[4]);
        }
    }
    
    public void setTarefaLocation(int row) {
        this.tarefaRow = row;
    }
    
    public int getTarefaLocation() {
        return this.tarefaRow;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        descricaoField = new javax.swing.JTextField();
        dataCriacaoField = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        prazoField = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prioridadeField = new javax.swing.JComboBox<>();
        concluidaField = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Manjari", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciador de Tarefas");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-dever-de-casa-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        saveBtn.setBackground(new java.awt.Color(0, 153, 102));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-salvar-20.png"))); // NOI18N
        saveBtn.setText("Salvar");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(255, 102, 102));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-cancelar-20.png"))); // NOI18N
        cancelBtn.setText("Cancelar");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição");

        descricaoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoFieldActionPerformed(evt);
            }
        });

        try {
            dataCriacaoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataCriacaoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dataCriacaoField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );

        jLabel4.setText("Data de Criação");

        try {
            prazoField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        prazoField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Prazo");

        jLabel6.setText("Prioridade");

        prioridadeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        concluidaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                concluidaFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Concluída");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dataCriacaoField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prazoField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(44, 44, 44))
                            .addComponent(descricaoField, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 58, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(concluidaField))
                            .addComponent(prioridadeField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricaoField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataCriacaoField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prazoField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prioridadeField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(concluidaField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void descricaoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoFieldActionPerformed
    }//GEN-LAST:event_descricaoFieldActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (descricaoField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo descrição é obrigatório", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean result = this.setDestinationToController();
        
        if (this.getTarefaLocation() == -1) {
            JOptionPane.showMessageDialog(rootPane, (result) ? "Tarefa cadastrada com sucesso!" : "Erro ao cadastrar tarefa!");
        } else {
            JOptionPane.showMessageDialog(rootPane, (result) ? "Tarefa editada com sucesso!" : "Erro ao editar tatefa!");
        }
        
        this.setVisible(false);
        telaPrincipal = new TelaPrincipal();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void concluidaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_concluidaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_concluidaFieldActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.setVisible(false);
        telaPrincipal = new TelaPrincipal();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox concluidaField;
    private javax.swing.JFormattedTextField dataCriacaoField;
    private javax.swing.JTextField descricaoField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField prazoField;
    private javax.swing.JComboBox<String> prioridadeField;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
