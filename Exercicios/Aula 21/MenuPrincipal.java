package pesquisaexercicio;

public class MenuPrincipal extends javax.swing.JFrame {

    private StringBuffer termoDigitado;

    public MenuPrincipal() {
        initComponents();
        termoDigitado = new StringBuffer();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        lblTexto = new javax.swing.JLabel();
        scrollTexto = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        lblBusca = new javax.swing.JLabel();
        lblContagem = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        txtContagem = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTexto.setText("Texto");

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        scrollTexto.setViewportView(areaTexto);

        lblBusca.setText("Buscar: ");

        lblContagem.setText("Ocorrências: ");

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        txtContagem.setEnabled(false);

        btnReset.setText("Limpar");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtContagem, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTexto)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReset)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBusca)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContagem)
                    .addComponent(txtContagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {
        char tecla = evt.getKeyChar();
        if (!Character.isISOControl(tecla)) {
            termoDigitado.append(tecla);
        } else if (tecla == '\b' && termoDigitado.length() > 0) {
            termoDigitado.deleteCharAt(termoDigitado.length() - 1);
        }

        String conteudo = areaTexto.getText();
        String termo = termoDigitado.toString();

        // Remove os destaques da busca anterior
        javax.swing.text.Highlighter marcador = areaTexto.getHighlighter();
        marcador.removeAllHighlights();

        int total = 0;

        if (!termo.isEmpty() && !conteudo.isEmpty()) {
            int posicao = 0;
            String conteudoMin = conteudo.toLowerCase();
            String termoMin = termo.toLowerCase();

            // Pintor de fundo na cor laranja
            javax.swing.text.Highlighter.HighlightPainter pintor =
                new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(java.awt.Color.ORANGE);

            while ((posicao = conteudoMin.indexOf(termoMin, posicao)) != -1) {
                total++;
                try {
                    // Marca o trecho encontrado no JTextArea
                    marcador.addHighlight(posicao, posicao + termo.length(), pintor);
                } catch (javax.swing.text.BadLocationException ex) {
                    ex.printStackTrace();
                }
                posicao += termo.length();
            }
        }

        txtContagem.setText(String.valueOf(total));
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {
        areaTexto.setText("");
        txtBusca.setText("");
        txtContagem.setText("");
        termoDigitado = new StringBuffer();
        // Tira os destaques ao limpar
        areaTexto.getHighlighter().removeAllHighlights();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnReset;
    private javax.swing.JLabel lblTexto;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblContagem;
    private javax.swing.JScrollPane scrollTexto;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JTextField txtContagem;
    private javax.swing.JTextField txtBusca;
}
