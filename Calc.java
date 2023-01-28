package chatsimples;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Toolkit;

public class Calc extends JFrame {
	
	private BotaoNumericoAction acaoBotao1 = new BotaoNumericoAction(1);
	private BotaoNumericoAction acaoBotao2 = new BotaoNumericoAction(2);
	private BotaoNumericoAction acaoBotao3 = new BotaoNumericoAction(3);
	private BotaoNumericoAction acaoBotao4 = new BotaoNumericoAction(4);
	private BotaoNumericoAction acaoBotao5 = new BotaoNumericoAction(5);
	private BotaoNumericoAction acaoBotao6 = new BotaoNumericoAction(6);
	private BotaoNumericoAction acaoBotao7 = new BotaoNumericoAction(7);
	private BotaoNumericoAction acaoBotao8 = new BotaoNumericoAction(8);
	private BotaoNumericoAction acaoBotao9 = new BotaoNumericoAction(9);
	private BotaoNumericoAction acaoBotao0 = new BotaoNumericoAction(0);
        
        private BotaoOperacaoAction acaoBotaoC = new BotaoOperacaoAction("C", "C");
        private BotaoOperacaoAction acaoBotaoPonto = new BotaoOperacaoAction(".", "Ponto");
        private BotaoOperacaoAction acaoBotaoIgual = new BotaoOperacaoAction("=", "Igual");
        private BotaoOperacaoAction acaoBotaoDiv = new BotaoOperacaoAction("/", "Div");
        private BotaoOperacaoAction acaoBotaoMult = new BotaoOperacaoAction("*", "Mult");
        private BotaoOperacaoAction acaoBotaoSoma = new BotaoOperacaoAction("+", "Soma");
        private BotaoOperacaoAction acaoBotaoSub = new BotaoOperacaoAction("-", "Sub");
        
        private BotaoOperacaoAction acaobotaoBackspace = new BotaoOperacaoAction("", "Apaga");
        
        
	private static double num1 = 0;
	private static double num2 = 0;
	private String conta;
	private JPanel contentPane;
	private JTextField txtDisplay;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Calc() {
		setTitle("Calcuzão");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Calc.class.getResource("/chatsimples/calculator.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Abaixo, formula para a JanelaIP aparecer centralizada na tela
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			setBounds((screenSize.width-221)/2, (screenSize.height-363)/2, 221, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		registrarAcoesDoTeclado(contentPane);
		
		txtDisplay = new JTextField();
		txtDisplay.setEditable(false);
		txtDisplay.setBackground(Color.WHITE);
		txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtDisplay.setText("0");
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setBounds(10, 11, 195, 43);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);
		
		
		contentPane.add(new JButton(acaoBotao1)).setBounds(10, 210, 45, 45);
		contentPane.add(new JButton(acaoBotao2)).setBounds(60, 210, 45, 45);
		contentPane.add(new JButton(acaoBotao3)).setBounds(110, 210, 45, 45);
		contentPane.add(new JButton(acaoBotao4)).setBounds(10, 160, 45, 45);
		contentPane.add(new JButton(acaoBotao5)).setBounds(60, 160, 45, 45);
		contentPane.add(new JButton(acaoBotao6)).setBounds(110, 160, 45, 45);
		contentPane.add(new JButton(acaoBotao7)).setBounds(10, 110, 45, 45);
		contentPane.add(new JButton(acaoBotao8)).setBounds(60, 110, 45, 45);
		contentPane.add(new JButton(acaoBotao9)).setBounds(110, 110, 45, 45);
		contentPane.add(new JButton(acaoBotao0)).setBounds(10, 260, 145, 45);
		
                contentPane.add(new JButton(acaoBotaoC)).setBounds(10, 60, 45, 45);
                contentPane.add(new JButton(acaoBotaoPonto)).setBounds(160, 160, 45, 45);
                contentPane.add(new JButton(acaoBotaoDiv)).setBounds(60, 60, 45, 45);
		contentPane.add(new JButton(acaoBotaoMult)).setBounds(110, 60, 45, 45);
		contentPane.add(new JButton(acaoBotaoSoma)).setBounds(160, 60, 45, 45);
                contentPane.add(new JButton(acaoBotaoSub)).setBounds(160, 110, 45, 45);
                contentPane.add(new JButton(acaoBotaoIgual)).setBounds(160, 210, 45, 95);
                
                
		JLabel lblVersao = new JLabel("v1.065.20");
		lblVersao.setForeground(Color.LIGHT_GRAY);
		lblVersao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVersao.setBounds(10, 310, 195, 14);
		contentPane.add(lblVersao);
	
	}
	
	
	
	public void PegaNum1(){
		Calc.num1 = Double.parseDouble(txtDisplay.getText());
		txtDisplay.setText("0");

	}
	public void Soma(){
		num2 = Double.parseDouble(txtDisplay.getText());
		double res = num1 + num2;
		txtDisplay.setText(Double.toString(res)); //converte RES para String
	}
	public void Divide(){
		num2 = Double.parseDouble(txtDisplay.getText());
		double res = num1 / num2;
		txtDisplay.setText(Double.toString(res)); //converte RES para String
	}
	public void Multiplica(){
		num2 = Double.parseDouble(txtDisplay.getText());
		double res = num1 * num2;
		txtDisplay.setText(Double.toString(res)); //converte RES para String
	}
	public void Subtrai(){
		num2 = Double.parseDouble(txtDisplay.getText());
		double res = num1 - num2;
		txtDisplay.setText(Double.toString(res)); //converte RES para String
	}
	
	
	
	private class BotaoNumericoAction extends AbstractAction{
	    private int numero;

	    public BotaoNumericoAction(int numero)
	    {
	        super(Integer.toString(numero));
	        this.numero = numero;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        txtDisplay.setText(txtDisplay.getText()+ numero);
	    }
	}
        
        private class BotaoOperacaoAction extends AbstractAction{
	    private String operacao;
            private String textoBotao;

	    public BotaoOperacaoAction(String textoBotao, String operacao)
	    {
	        super(textoBotao);
	        this.operacao = operacao;
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if ("C".equals(operacao)) {
                    txtDisplay.setText("0");
                }
                
                if ("Div".equals(operacao)) {
                    PegaNum1();
                    conta = "divide";
                }
                
                if ("Mult".equals(operacao)) {
                    PegaNum1();
                    conta = "multiplica";
                }
                
                if ("Soma".equals(operacao)) {
                    PegaNum1();
                    conta = "soma";
                }
                
                if ("Sub".equals(operacao)) {
                    PegaNum1();
                    conta = "subtrai";
                }
                
                if ("Ponto".equals(operacao)) {
                    txtDisplay.setText(txtDisplay.getText()+".");
                }
                
                if ("Igual".equals(operacao)) {
                    double senha = Double.parseDouble(txtDisplay.getText());
    			if (senha == 106520) {
                    setVisible(false); //fecha a janela da calculadora quando abre o chat
    				
                    JOptionPane.showMessageDialog(null, "Bem-Vindo ao Execuzões", "Execuzões", -1);
                    
                    String ip01 = "vazio";
                	String ip02 = "vazio";
                	String ip03 = "vazio";
                	String ip04 = "vazio";
                	String ip05 = "vazio";
                	int porta = 0;
                	
                    Conexao c01 = new Conexao(ip01, ip02, ip03, ip04, ip05, porta);
                    
                    JanelaIP jip = new JanelaIP(c01);
                    jip.setVisible(true);
    			}
    			
            	if (null != conta) switch (conta) {
                    case "soma":
                        Soma();
                        break;
                    case "divide":
                        Divide();
                        break;
                    case "multiplica":
                        Multiplica();
                        break;
                    case "subtrai":
                        Subtrai();
                        break;
                }
                }
                
	    }
	}
	

	private void registrarAcoesDoTeclado(JPanel contentPane) {
            //Damos um nome para cada ação. Esse nome é útil pois mais de
            //uma tecla pode ser associada a cada ação, como veremos abaixo

            ActionMap actionMap = contentPane.getActionMap();
            actionMap.put("botao1", acaoBotao1);
            actionMap.put("botao2", acaoBotao2);
            actionMap.put("botao3", acaoBotao3);
            actionMap.put("botao4", acaoBotao4);
            actionMap.put("botao5", acaoBotao5);
            actionMap.put("botao6", acaoBotao6);
            actionMap.put("botao7", acaoBotao7);
            actionMap.put("botao8", acaoBotao8);
            actionMap.put("botao9", acaoBotao9);
            actionMap.put("botao0", acaoBotao0);
            actionMap.put("botaoC", acaoBotaoC);
            actionMap.put("botaoPonto", acaoBotaoPonto);
            actionMap.put("botaoDiv", acaoBotaoDiv);
            actionMap.put("botaoMult", acaoBotaoMult);
            actionMap.put("botaoSoma", acaoBotaoSoma);
            actionMap.put("botaoSub", acaoBotaoSub);
            actionMap.put("botaoIgual", acaoBotaoIgual);
               
	    contentPane.setActionMap(actionMap);
	    
	    InputMap imap = contentPane.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
	    
	    //Teclas da parte de cima do teclado.
	    imap.put(KeyStroke.getKeyStroke("1"), "botao1");
	    imap.put(KeyStroke.getKeyStroke("2"), "botao2");
	    imap.put(KeyStroke.getKeyStroke("3"), "botao3");
	    imap.put(KeyStroke.getKeyStroke("4"), "botao4");
	    imap.put(KeyStroke.getKeyStroke("5"), "botao5");
	    imap.put(KeyStroke.getKeyStroke("6"), "botao6");
	    imap.put(KeyStroke.getKeyStroke("7"), "botao7");
	    imap.put(KeyStroke.getKeyStroke("8"), "botao8");
	    imap.put(KeyStroke.getKeyStroke("9"), "botao9");
	    imap.put(KeyStroke.getKeyStroke("0"), "botao0");
            imap.put(KeyStroke.getKeyStroke("ESCAPE"), "botaoC");
            imap.put(KeyStroke.getKeyStroke("C"), "botaoC");
            imap.put(KeyStroke.getKeyStroke("EQUALS"), "botaoIgual");
	    
	    //Botões do teclado numérico
	    imap.put(KeyStroke.getKeyStroke("NUMPAD1"), "botao1");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD2"), "botao2");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD3"), "botao3");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD4"), "botao4");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD5"), "botao5");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD6"), "botao6");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD7"), "botao7");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD8"), "botao8");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD9"), "botao9");
	    imap.put(KeyStroke.getKeyStroke("NUMPAD0"), "botao0");
            imap.put(KeyStroke.getKeyStroke("DIVIDE"), "botaoDiv");
            imap.put(KeyStroke.getKeyStroke("MULTIPLY"), "botaoMult");
            imap.put(KeyStroke.getKeyStroke("ADD"), "botaoSoma");
            imap.put(KeyStroke.getKeyStroke("SUBTRACT"), "botaoSub");
            imap.put(KeyStroke.getKeyStroke("SUBTRACT"), "botaoSub");
            imap.put(KeyStroke.getKeyStroke("DECIMAL"), "botaoPonto");
            imap.put(KeyStroke.getKeyStroke("PERIOD"), "botaoPonto");
            imap.put(KeyStroke.getKeyStroke("ENTER"), "botaoIgual");
	}
}