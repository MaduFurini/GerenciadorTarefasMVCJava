/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.unifae.engsoftware.maduFurini.gerenciadortarefas.view;

import br.unifae.engsoftware.maduFurini.gerenciadortarefas.controller.TarefaController;
import br.unifae.engsoftware.maduFurini.gerenciadortarefas.model.Tarefa;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sempher
 */
public class TelaPrincipal extends javax.swing.JFrame {
    JTable tabela;

    FormularioTarefa ft = new FormularioTarefa();
    TarefaController controller = new TarefaController();

    /**
     * Creates new form FormularioTarefa
     */
    public TelaPrincipal() {
        initComponents();
        this.screenConfigs();
    }
    
    // Função padrão para definir os parêmtros como nulo -> evitar de mexer no código já feito
    public final void screenConfigs () {
        screenConfigs(null);
    }
        
    public final void screenConfigs (List<Tarefa> tarefas) {
        ft.setVisible(false);

        this.setLocationRelativeTo(null);

        this.tabela = tarefasTable;
        
        DefaultTableModel modeloTabela;
        if (tarefas != null){
            modeloTabela = controller.gerarTabela(tarefas);
        } else {
            modeloTabela = controller.gerarTabela(null); 
        }
        tabela.setModel(modeloTabela);
        
        this.setVisible(true);
        // Garantir que a tela quando aberta, fique sempre na frente de qualquer outra tela aberta do pc
        this.toFront();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        prazoField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tarefasTable = new javax.swing.JTable();
        newTarefaBtn = new javax.swing.JButton();
        prioridadeFilterField = new javax.swing.JComboBox<>();
        logoutBtn = new javax.swing.JButton();
        editTarefaBtn = new javax.swing.JButton();
        removeTarefaBtn = new javax.swing.JButton();
        prazoFilterField = new javax.swing.JComboBox<>();
        filterBtn = new javax.swing.JButton();
        cleanFilterBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        try {
            prazoField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        prazoField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Manjari", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gerenciador de Tarefas");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-dever-de-casa-64.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tarefasTable.setBackground(new java.awt.Color(0, 153, 102));
        tarefasTable.setForeground(new java.awt.Color(255, 255, 255));
        tarefasTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Prioridade", "Data Criação", "Prazo", "Concluída"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tarefasTable.setGridColor(new java.awt.Color(204, 204, 204));
        tarefasTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tarefasTable);
        if (tarefasTable.getColumnModel().getColumnCount() > 0) {
            tarefasTable.getColumnModel().getColumn(0).setResizable(false);
            tarefasTable.getColumnModel().getColumn(1).setResizable(false);
            tarefasTable.getColumnModel().getColumn(2).setResizable(false);
            tarefasTable.getColumnModel().getColumn(3).setResizable(false);
            tarefasTable.getColumnModel().getColumn(4).setResizable(false);
        }

        newTarefaBtn.setBackground(new java.awt.Color(0, 153, 102));
        newTarefaBtn.setForeground(new java.awt.Color(255, 255, 255));
        newTarefaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-mais-20.png"))); // NOI18N
        newTarefaBtn.setText("Nova Tarefa");
        newTarefaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTarefaBtnActionPerformed(evt);
            }
        });

        prioridadeFilterField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridade", "1", "2", "3", "4", "5" }));
        prioridadeFilterField.setToolTipText("");
        prioridadeFilterField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prioridadeFilterFieldActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(255, 102, 102));
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-cancelar-20.png"))); // NOI18N
        logoutBtn.setText("Sair");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        editTarefaBtn.setBackground(new java.awt.Color(0, 153, 102));
        editTarefaBtn.setForeground(new java.awt.Color(255, 255, 255));
        editTarefaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-l├бpis-20.png"))); // NOI18N
        editTarefaBtn.setText("Editar");
        editTarefaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTarefaBtnActionPerformed(evt);
            }
        });

        removeTarefaBtn.setBackground(new java.awt.Color(153, 0, 51));
        removeTarefaBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeTarefaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-lixo-20.png"))); // NOI18N
        removeTarefaBtn.setText("Remover");
        removeTarefaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTarefaBtnActionPerformed(evt);
            }
        });

        prazoFilterField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prazo", "Sem Prazo", "Hoje", "Próximos 7 dias", "Últimos 7 dias", "Ordem crescente", "Ordem decrescente" }));
        prazoFilterField.setToolTipText("");
        prazoFilterField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prazoFilterFieldActionPerformed(evt);
            }
        });

        filterBtn.setBackground(new java.awt.Color(0, 153, 102));
        filterBtn.setForeground(new java.awt.Color(255, 255, 255));
        filterBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-filter-20.png"))); // NOI18N
        filterBtn.setText("Filtrar");
        filterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterBtnActionPerformed(evt);
            }
        });

        cleanFilterBtn.setBackground(new java.awt.Color(102, 102, 102));
        cleanFilterBtn.setForeground(new java.awt.Color(255, 255, 255));
        cleanFilterBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-clear-20.png"))); // NOI18N
        cleanFilterBtn.setText("Limpar");
        cleanFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanFilterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeTarefaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editTarefaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prioridadeFilterField, 0, 117, Short.MAX_VALUE)
                            .addComponent(filterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(prazoFilterField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cleanFilterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 552, Short.MAX_VALUE)
                        .addComponent(newTarefaBtn)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prioridadeFilterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prazoFilterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterBtn)
                            .addComponent(cleanFilterBtn)))
                    .addComponent(newTarefaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeTarefaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editTarefaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newTarefaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTarefaBtnActionPerformed
        this.setVisible(false);
        ft.setVisible(true);
    }//GEN-LAST:event_newTarefaBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void editTarefaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTarefaBtnActionPerformed
        int row = this.tabela.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        this.setVisible(false);
        
        ft.setTarefaLocation(row);
        ft.screenConfigs();
    }//GEN-LAST:event_editTarefaBtnActionPerformed

    private void removeTarefaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeTarefaBtnActionPerformed
        int row = this.tabela.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para remover!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa tarefa permanentemente?", "Continua", JOptionPane.OK_CANCEL_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {            
            boolean result = controller.destroy(row);
            
            JOptionPane.showMessageDialog(rootPane, (result) ? "Tarefa removida com sucesso!" : "Erro ao remover tarefa!");
            
            this.setVisible(false);
            this.screenConfigs();
        }
    }//GEN-LAST:event_removeTarefaBtnActionPerformed

    private void prioridadeFilterFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prioridadeFilterFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prioridadeFilterFieldActionPerformed

    private void prazoFilterFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prazoFilterFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prazoFilterFieldActionPerformed

    private void filterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterBtnActionPerformed
        // Primeiro pega todas as tarefas para depois aplicar os filtros - meio que sobrescrever a lista com as condições impostas
        List<Tarefa> tarefas = TarefaController.index();

        if (prioridadeFilterField.getSelectedIndex() != 0) {
            int prioridade = Integer.parseInt(prioridadeFilterField.getSelectedItem().toString());
            
            tarefas = TarefaController.filtroPorPrioridade(prioridade);
        }
        
        if (prazoFilterField.getSelectedIndex() != 0) {
            String prazo = prazoFilterField.getSelectedItem().toString();
            
            tarefas = TarefaController.filtroPorPrazo(prazo);
        }
        
        this.setVisible(false);
        this.screenConfigs(tarefas);
    }//GEN-LAST:event_filterBtnActionPerformed

    private void cleanFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanFilterBtnActionPerformed
        prioridadeFilterField.setSelectedIndex(0);
        prazoFilterField.setSelectedIndex(0);
    }//GEN-LAST:event_cleanFilterBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cleanFilterBtn;
    private javax.swing.JButton editTarefaBtn;
    private javax.swing.JButton filterBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton newTarefaBtn;
    private javax.swing.JFormattedTextField prazoField1;
    private javax.swing.JComboBox<String> prazoFilterField;
    private javax.swing.JComboBox<String> prioridadeFilterField;
    private javax.swing.JButton removeTarefaBtn;
    private javax.swing.JTable tarefasTable;
    // End of variables declaration//GEN-END:variables
}
