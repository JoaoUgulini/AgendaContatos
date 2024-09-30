package Agenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Adicionar extends JPanel {
    private JTextField nome, telefone, email;
    private JComboBox<String> tipoContato;
    private JButton btnSalvar;

    public Adicionar() {
        setLayout(new GridLayout(5, 2));
        nome = new JTextField();
        telefone = new JTextField();
        email = new JTextField();
        tipoContato = new JComboBox<>(new String[]{"Pessoal", "Profissional"});

        add(new JLabel("Nome:"));
        add(nome);
        add(new JLabel("Telefone:"));
        add(telefone);
        add(new JLabel("Email:"));
        add(email);
        add(new JLabel("Tipo de Contato:"));
        add(tipoContato);

        btnSalvar = new JButton("Salvar");
        add(btnSalvar);

        // Adiciona ação para o botão salvar
        btnSalvar.addActionListener(e -> salvarContato());
    }

    // Método para salvar contato
    private void salvarContato() {
        String nomeContato = nome.getText();
        String telefoneContato = telefone.getText();
        String emailContato = email.getText();
        String tipo = (String) tipoContato.getSelectedItem();

        if (nomeContato.isEmpty() || telefoneContato.isEmpty() || emailContato.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Contato novoContato = new Contato(nomeContato, telefoneContato, emailContato, tipo);
            Consulta.contatos.add(novoContato);  // Adiciona o contato na lista de contatos
            Arquivo.atualizarArquivo();  // Atualiza o arquivo
            JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
        }
    }
}

