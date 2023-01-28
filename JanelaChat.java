package chatsimples;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JanelaChat extends JFrame implements Observer {
    
    static int contaMsg; //contador de caracteres da caixa de texto
    
    public void conexaoCom() { /* m�todo que escreve quais IPs est�o conectados */
        escreve("Conex�o estabelecida com:");
        
        escreve("+ "+ conexao.getIp01() + ":" + conexao.getPorta());
        
        if (!"vazio".equals(conexao.getIp02())) {
            escreve("+ "+ conexao.getIp02() + ":" + conexao.getPorta());
        }
        
        if (!"vazio".equals(conexao.getIp03())) {
            escreve("+ "+ conexao.getIp03() + ":" + conexao.getPorta());
        }
        
        if (!"vazio".equals(conexao.getIp04())) {
            escreve("+ "+ conexao.getIp04() + ":" + conexao.getPorta());
        }
        
        if (!"vazio".equals(conexao.getIp05())) {
            escreve("+ "+ conexao.getIp05() + ":" + conexao.getPorta());
        }
    }
    
    private Conexao conexao;
    public JanelaChat(Conexao conexao) {
        super("Execuz�es - " + JanelaIP.numerodePessoas + " conex�es");
        setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaChat.class.getResource("/chatsimples/network.png")));
        this.conexao = conexao;
        this.setResizable(true); //(des)habilita redimensionar a tela
        initComponents();
        conexao.addObserver(this);
        conexaoCom(); //puxa o metodo CONEXAOCOM que escreve quais IPs est�o conectados
        
                mensagemjTextArea.requestFocusInWindow();
    }

	private void envia() {
        if (!mensagemjTextArea.getText().isEmpty()) {
            contaMsg = mensagemjTextArea.getText().length();
            conexao.envia(mensagemjTextArea.getText());
                Calendar calendar = new GregorianCalendar();
                SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                calendar.setTime(date);
                String horaAtual = out.format(calendar.getTime());
            escreve("Voc� disse ("+horaAtual+"): "+mensagemjTextArea.getText());
            mensagemjTextArea.setText("");
        }
    }
    private void limpa() {
            chatjTextArea.setText("");
            conexaoCom(); //puxa o metodo CONEXAOCOM que escreve quais IPs estão conectados
    }

    private void escreve(String texto){
        chatjTextArea.append(texto+"\n");
         if (!chatjTextArea.getText().isEmpty() && !chatjTextArea.isFocusOwner()) {
                chatjTextArea.setCaretPosition(chatjTextArea.getText().length()); // tirado o -1
            }
    }
    
        private void initComponents() {
        chatjScrollPane = new JScrollPane();
        chatjTextArea = new JTextArea();
        mensagemjScrollPane = new JScrollPane();
        mensagemjTextArea = new JTextArea();
        enviarjButton = new JButton();
        limparjButton = new JButton();
        
        this.setMinimumSize(new Dimension(390,245)); //tamanho mínimo da janela larguraxaltura
        this.setDefaultCloseOperation(JanelaChat.DO_NOTHING_ON_CLOSE);  
        this.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                            int selectedOption = JOptionPane.showConfirmDialog(null,"Deseja encerrar Execuzões?", "Sair",JOptionPane.YES_NO_OPTION);  
                            if (selectedOption == JOptionPane.YES_OPTION) {
                                System.exit(0);  
                            }  
                        } 
                    }  
                });

        enviarjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        limparjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        chatjTextArea.setEditable(false);
        chatjTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        chatjTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        chatjTextArea.setFont(new java.awt.Font("Tahoma", 0, 12));
        chatjTextArea.setLineWrap(true);
        chatjTextArea.setColumns(20);
        chatjTextArea.setRows(5);

        chatjScrollPane.setViewportView(chatjTextArea);

        mensagemjTextArea.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite sua mensagem:"));
        mensagemjTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        mensagemjTextArea.setFont(new java.awt.Font("Tahoma", 0, 12));
        mensagemjTextArea.setLineWrap(true);
        mensagemjTextArea.setColumns(20);
        mensagemjTextArea.setRows(3);
        mensagemjTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mensagemjTextAreaKeyReleased(evt);
            }
        });
        
        mensagemjScrollPane.setViewportView(mensagemjTextArea);

        enviarjButton.setText("Enviar");
        enviarjButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarjButtonActionPerformed(evt);
            }
        });

        limparjButton.setText("Limpar");
        limparjButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                limparjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chatjScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mensagemjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enviarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limparjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chatjScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mensagemjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enviarjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(limparjButton))))
        );

        pack();
    }                       

    private void enviarjButtonActionPerformed(ActionEvent evt) {                                              
        envia(); //bot�o ENVIAR chama o m�todo ENVIA()
    } 
    private void limparjButtonActionPerformed(ActionEvent evt) {                                              
        limpa(); //bot�o ENVIAR chama o m�todo ENVIA()
    } 

    private void mensagemjTextAreaKeyReleased(KeyEvent evt) {                                              
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            envia();
        }
    }
    
    private JTextArea chatjTextArea;
    private JButton enviarjButton;
    private JButton limparjButton;
    private JScrollPane chatjScrollPane;
    private JScrollPane mensagemjScrollPane;
    private JTextArea mensagemjTextArea;

    @Override
    public void update(Observable obsObservable, Object arg) {
        escreve(conexao.getMensagem());
        JanelaChat.this.toFront(); //faz a janela piscar laranja quando receber uma nova mensagem
    }
}