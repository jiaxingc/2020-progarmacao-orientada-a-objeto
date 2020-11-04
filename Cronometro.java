package Cronometro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cronometr {

    private JLabel contagemTempo;
    private Timer tm;
    private int contador=0;
    private boolean rodando=false;
 

    public void init(){
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame janela=new JFrame("Cronometro");
    janela.setSize(300,200);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    janela.setLayout(new BorderLayout());

    contagemTempo = new JLabel("00:00:00");
    contagemTempo.setFont(new Font(contagemTempo.getName(),Font.PLAIN,80));
    janela.add(contagemTempo,BorderLayout.CENTER);

    JPanel painel=new JPanel();
    painel.setLayout(new GridLayout(2,1));

    JButton btiniciar = new JButton("Iniciar");
    btiniciar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (!rodando) {
                tm = new Timer();
                rodando = (true);
                tm.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        contador++;
                        int seg = contador % 60;
                        int min = contador / 60;
                        int hora = min / 60;
                        min %= 60;
                        contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg));
                        
                        if(min % 2 == 0)
                            janela.getContentPane().setBackground(Color.yellow);
                        else 
                            janela.getContentPane().setBackground(Color.pink);
                    }
                }, 1000, 1000);
            }
        }
    });
    JButton btParar = new JButton("Parar");
    btParar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (rodando) {
                tm.cancel();
                rodando = false;
            }
        }
    });

    JButton btZerar = new JButton("Zerar");
    btZerar.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		contador = 0;
    		int seg = contador % 60;
            int min = contador / 60;
            int hora = min / 60;
            if (rodando) {
                tm.cancel();
                rodando = false;
            }
    		contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg));
    	}
    });
    painel.add(btiniciar);
    painel.add(btParar);
    painel.add(btZerar);
    painel.add(new JLabel(new ImageIcon("./src/unilasalle.png")));
    janela.add(painel, BorderLayout.EAST);
        janela.pack();
        janela.setVisible(true);
    }
    
}


package Cronometro;

import java.awt.EventQueue;

public class CronoTester {
    public static void main(String[] args) throws Exception {
        Cronometr c = new Cronometr();
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                c.init();
            }
        });
    };
}
