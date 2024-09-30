package Agenda;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class agenda extends JFrame {
    private Adicionar Adicionar;
    private Consulta Consulta;
    private Sobre Sobre;
    private JMenuBar menuBar;
    private JMenu menuAgenda;
    private JMenuItem menuCadastro, menuConsulta, menuSobre;

    public agenda() {
        initComponents();  // Inicializa os componentes e define o painel padrão
        this.setContentPane(new agenda());  // Define o painel padrão como tela inicial
    }

    // Método para inicializar os componentes e menus
    private void initComponents() {
        setTitle("Agenda de Contatos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 690, 499);

        // Configuração do MenuBar
        this.menuBar = new JMenuBar();
        setJMenuBar(this.menuBar);

        this.menuAgenda = new JMenu("Agenda");
        this.menuBar.add(this.menuAgenda);

        // Menu Cadastro
        this.menuCadastro = new JMenuItem("Cadastro");
        this.menuCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trocarParaCadastro();
            }
        });
        this.menuAgenda.add(this.menuCadastro);

        // Menu Consulta
        this.menuConsulta = new JMenuItem("Consulta");
        this.menuConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trocarParaConsulta();
            }
        });
        this.menuAgenda.add(this.menuConsulta);

        // Menu Sobre
        this.menuSobre = new JMenuItem("Sobre");
        this.menuSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                trocarParaSobre();
            }
        });
        this.menuAgenda.add(this.menuSobre);

        // Inicializa os painéis
        Adicionar = new Adicionar();
        Consulta = new Consulta();
        Sobre = new Sobre();
    }

    // Método para trocar para o painel de Cadastro
    public void trocarParaCadastro() {
        this.setContentPane(Adicionar);
        this.setVisible(true);  // Atualiza a janela com o novo painel
    }

    // Método para trocar para o painel de Consulta
    public void trocarParaConsulta() {
        Consulta.carregarContatosNaTabela();  // Atualiza a tabela ao abrir a tela de consulta
        this.setContentPane(Consulta);
        this.setVisible(true);
    }

    // Método para trocar para o painel Sobre
    public void trocarParaSobre() {
        this.setContentPane(Sobre);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                agenda frame = new agenda();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
