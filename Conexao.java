package chatsimples;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao extends Observable {

    private int porta;
    private String mensagem;
    private String ip01;
	private String ip02;
	private String ip03;
	private String ip04;
	private String ip05;
        private String nome;

    public Conexao(String ip01, String ip02, String ip03, String ip04, String ip05, int porta) {
        this.ip01 = ip01;
        this.ip02 = ip02;
        this.ip03 = ip03;
        this.ip04 = ip04;
        this.ip05 = ip05;
        this.porta = porta;
        new Thread(new Recebe()).start();
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public String getIp01() {
        return ip01;
    }
    
    public String getIp02() {
        return ip02;
    }
    
    public String getIp03() {
        return ip03;
    }
    
    public String getIp04() {
        return ip04;
    }
    
    public String getIp05() {
        return ip05;
    }

    public int getPorta() {
        return porta;
    }

    public void envia(String texto) {
        new Thread(new Envia(texto)).start();
    }

    public void notifica(String mensagem) {
        this.mensagem = mensagem;
        setChanged();
        notifyObservers();
    }

    class Recebe implements Runnable {

        byte[] dadosReceber = new byte[255];
        boolean erro = false;
        DatagramSocket socket = null;

        @Override
        public void run() {
            while (true) {
                try {
                    socket = new DatagramSocket(getPorta());
                } 
                catch (SocketException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }
                erro = false;
                while (!erro) {
                    DatagramPacket pacoteRecebido = new DatagramPacket(dadosReceber, dadosReceber.length);
                    try {
                        socket.receive(pacoteRecebido);
                        byte[] b = pacoteRecebido.getData();
                        String s = "";
                        for (int i = 0; i < b.length; i++) {
                            if (b[i] != 0) {
                                s += (char) b[i];
                            }
                        }

                        Calendar calendar = new GregorianCalendar();
                        SimpleDateFormat out = new SimpleDateFormat("HH:mm:ss");
                        Date date = new Date();
                        calendar.setTime(date);
                        String horaAtual = out.format(calendar.getTime());
                        nome = pacoteRecebido.getAddress().toString();
                            while (s.length() > JanelaChat.contaMsg) {
                                s = s.substring(0, s.length() -1);
                            } // método para apagar o lixo após a mensagem
                        notifica("IP "+nome + " disse ("+horaAtual+"): " + s);
                    }
                    catch (Exception e) {
                        System.out.println("Erro: " + e);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        erro = true;
                        continue;
                    }
                }
            }
        }
    }
    class Envia implements Runnable {

        String texto;

        public Envia(String texto) {
            this.texto = texto;
        }

        @Override
        public void run() {

            byte[] dados = texto.getBytes();

            try {
                if (!"vazio".equals(JanelaIP.ip01)){
                    DatagramSocket clientSocket01 = new DatagramSocket();
                    InetAddress addr01 = InetAddress.getByName(getIp01());
                    DatagramPacket pacote = new DatagramPacket(dados, dados.length, addr01, getPorta());
                    clientSocket01.send(pacote);
                    clientSocket01.close();
                }
                
                if (!"vazio".equals(JanelaIP.ip02)){
                    DatagramSocket clientSocket02 = new DatagramSocket();
                    InetAddress addr02 = InetAddress.getByName(getIp02());
                    DatagramPacket pacote02 = new DatagramPacket(dados, dados.length, addr02, getPorta());
                    clientSocket02.send(pacote02);
                    clientSocket02.close();
                }

                if (!"vazio".equals(JanelaIP.ip03)){
                    DatagramSocket clientSocket03 = new DatagramSocket();
                    InetAddress addr03 = InetAddress.getByName(getIp03());
                    DatagramPacket pacote03 = new DatagramPacket(dados, dados.length, addr03, getPorta());
                    clientSocket03.send(pacote03);
                    clientSocket03.close();
                }

                if (!"vazio".equals(JanelaIP.ip04)){
                    DatagramSocket clientSocket04 = new DatagramSocket();
                    InetAddress addr04 = InetAddress.getByName(getIp04());
                    DatagramPacket pacote04 = new DatagramPacket(dados, dados.length, addr04, getPorta());
                    clientSocket04.send(pacote04);
                    clientSocket04.close();
                }

                if (!"vazio".equals(JanelaIP.ip05)){
                    DatagramSocket clientSocket05 = new DatagramSocket();
                    InetAddress addr05 = InetAddress.getByName(getIp05());
                    DatagramPacket pacote05 = new DatagramPacket(dados, dados.length, addr05, getPorta());
                    clientSocket05.send(pacote05);
                    clientSocket05.close();
                }
                
            }
            catch (SocketException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            catch (java.net.UnknownHostException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } //tratamento de erro para host desconhecido
            
            catch (IOException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}