package chatsimples;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JanelaIP extends JFrame {
	private JPanel painelPrincipal;
	private JTextField txtIP01;
	private JTextField txtIP02;
	private JTextField txtIP03;
	private JTextField txtIP04;
	private JTextField txtIP05;
	private JTextField txtPort;
	private JLabel lblPorta;
	private int porta;
	public static String ip01 = "vazio";
	public static String ip02 = "vazio";
	public static String ip03 = "vazio";
	public static String ip04 = "vazio";
	public static String ip05 = "vazio";
        
        static int numerodePessoas = 0;
	
	public JanelaIP(Observable c01) {
		setTitle("Execuzões");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaIP.class.getResource("/chatsimples/network.png")));
		setResizable(false);
                
                this.setDefaultCloseOperation(JanelaIP.DO_NOTHING_ON_CLOSE);  
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
                
                //Abaixo, formula para a JanelaIP aparecer centralizada na tela
                java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                setBounds((screenSize.width-247)/2, (screenSize.height-317)/2, 247, 317);
		getContentPane().setLayout(null);
		
		String msgIp = "192.168.11.";
		
		JLabel lblInsiraOsIps = new JLabel("Insira os IPs:");
		lblInsiraOsIps.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsIps.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblInsiraOsIps.setBounds(0, 11, 241, 20);
		getContentPane().add(lblInsiraOsIps);
		
		JLabel lblIP01 = new JLabel("IP 01:");
		lblIP01.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIP01.setBounds(52, 38, 33, 15);
		getContentPane().add(lblIP01);
		
		txtIP01 = new JTextField();
		txtIP01.setText(msgIp);
		txtIP01.setBounds(99, 38, 107, 20);
                txtIP01.setText("192.168.11.");
		txtIP01.setColumns(10);
                getContentPane().add(txtIP01);
		
		txtIP02 = new JTextField();
		txtIP02.setEditable(false);
		txtIP02.setColumns(10);
		txtIP02.setBounds(99, 71, 107, 20);
                txtIP02.setText("vazio");
		getContentPane().add(txtIP02);
		
		txtIP03 = new JTextField();
		txtIP03.setEditable(false);
		txtIP03.setColumns(10);
		txtIP03.setBounds(99, 105, 107, 20);
                txtIP03.setText("vazio");
		getContentPane().add(txtIP03);
		
		txtIP04 = new JTextField();
		txtIP04.setEditable(false);
		txtIP04.setColumns(10);
		txtIP04.setBounds(99, 136, 107, 20);
                txtIP04.setText("vazio");
		getContentPane().add(txtIP04);
		
		txtIP05 = new JTextField();
		txtIP05.setEditable(false);
		txtIP05.setToolTipText("");
		txtIP05.setColumns(10);
		txtIP05.setBounds(99, 167, 107, 20);
                txtIP05.setText("vazio");
		getContentPane().add(txtIP05);
		
		JCheckBox ativaIP02 = new JCheckBox("IP 02:");
		ativaIP02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (ativaIP02.isSelected()){
					txtIP02.setEditable(true);
					txtIP02.setText(msgIp);
				}
				else {
					txtIP02.setEditable(false);
					txtIP02.setText("vazio");
				}
			}
		});
		ativaIP02.setSelected(false);
		ativaIP02.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ativaIP02.setBounds(30, 69, 59, 23);
		getContentPane().add(ativaIP02);
		
		JCheckBox ativaIP03 = new JCheckBox("IP 03:");
		ativaIP03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (ativaIP03.isSelected()){
					txtIP03.setEditable(true);
					txtIP03.setText(msgIp);
				}
				else {
					txtIP03.setEditable(false);
					txtIP03.setText(null);
				}
			}
		});
		ativaIP03.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ativaIP03.setBounds(30, 103, 59, 23);
		getContentPane().add(ativaIP03);
		
		JCheckBox ativaIP04 = new JCheckBox("IP 04:");
		ativaIP04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				if (ativaIP04.isSelected()){
					txtIP04.setEditable(true);
					txtIP04.setText(msgIp);
				}
				else {
					txtIP04.setEditable(false);
					txtIP04.setText(null);
				}
				
			}
		});
		ativaIP04.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ativaIP04.setBounds(30, 134, 59, 23);
		getContentPane().add(ativaIP04);
		
		JCheckBox ativaIP05 = new JCheckBox("IP 05:");
		ativaIP05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				if (ativaIP05.isSelected()){
					txtIP05.setEditable(true);
					txtIP05.setText(msgIp);
				}
				else {
					txtIP05.setEditable(false);
					txtIP05.setText(null);
				}
			}
		});
		ativaIP05.setToolTipText("");
		ativaIP05.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ativaIP05.setBounds(30, 165, 59, 23);
		getContentPane().add(ativaIP05);

		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                            confirma();
                    }
		});
                
                getRootPane().setDefaultButton(btnConfirma); // Faz a tecla ENTER acionar o botão btnConfirma

		btnConfirma.setBounds(62, 234, 123, 31);
		getContentPane().add(btnConfirma);

                txtPort = new JTextField();
		txtPort.setText("5000");
		txtPort.setBounds(112, 203, 82, 20);
		getContentPane().add(txtPort);
		txtPort.setColumns(10);
		
		lblPorta = new JLabel("Porta:");
		lblPorta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPorta.setBounds(52, 202, 38, 17);
		getContentPane().add(lblPorta);
		painelPrincipal = new JPanel();
		painelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setpainelPrincipal(painelPrincipal);
		painelPrincipal.setLayout(null);
	}
		public void confirma(){
                    try {
                    int porta = Integer.parseInt(txtPort.getText());
                    if(porta > 999 && porta < 99999){
                                    ip01 = (txtIP01.getText());
                                    ip02 = (txtIP02.getText());
                                    ip03 = (txtIP03.getText());
                                    ip04 = (txtIP04.getText());
                                    ip05 = (txtIP05.getText());

                        int selectedOption = JOptionPane.showConfirmDialog(null,"Confirma?", "Execuzões", JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_OPTION) {
                            
                            if (!"vazio".equals(ip01)) {
                                numerodePessoas = numerodePessoas + 1;
                            }
                            if (!"vazio".equals(ip02)) {
                                numerodePessoas = numerodePessoas + 1;
                            }
                            if (!"vazio".equals(ip03)) {
                                numerodePessoas = numerodePessoas + 1;
                            }
                            if (!"vazio".equals(ip04)) {
                                numerodePessoas = numerodePessoas + 1;
                            }
                            if (!"vazio".equals(ip05)) {
                                numerodePessoas = numerodePessoas + 1;
                            }
                            
                            Conexao c01 = new Conexao(ip01, ip02, ip03, ip04, ip05, porta);

                            JanelaChat j = new JanelaChat(c01);
                            j.setLocationRelativeTo(null);
                            j.setVisible(true);

                            setVisible(false); //janela de IPs fechar quando a do chat abrir
                        }
                    }
                            else {
                                    JOptionPane.showMessageDialog(null, "Porta inválida!", "Erro!", 2);
                            }
                    }
                    catch (java.lang.NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Valor inválido!", "Erro!", 2);
                    }
                }
		public JanelaIP(String ip01, String ip02, String ip03, String ip04, String ip05) {
	}
		private void setpainelPrincipal(JPanel painelPrincipal) {
		}
}