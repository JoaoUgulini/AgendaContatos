package Agenda;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.LinkedList;

public class Consulta extends JPanel {
    private JTable tabelaContatos;
    private DefaultTableModel modeloTabela;
    public static LinkedList<Contato> contatos = new LinkedList<>();  // Lista de contatos

    public Consulta() {
        setLayout(new BorderLayout());

        // Tabela de contatos
        String[] colunas = {"Nome", "Telefone", "Email", "Tipo de Contato"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaContatos = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaContatos);
        add(scrollPane, BorderLayout.CENTER);

        // Botões de Ação (Editar e Remover)
        JPanel painelAcoes = new JPanel();
        JButton btnEditar = new JButton("Editar");
        JButton btnRemover = new JButton("Remover");

        btnEditar.addActionListener(e -> editarContatoSelecionado());
        btnRemover.addActionListener(e -> removerContatoSelecionado());

        painelAcoes.add(btnEditar);
        painelAcoes.add(btnRemover);
        add(painelAcoes, BorderLayout.SOUTH);
    }

    // Função para carregar contatos na tabela
    public void carregarContatosNaTabela() {
        modeloTabela.setRowCount(0);  // Limpa a tabela
        for (Contato contato : contatos) {
            modeloTabela.addRow(new Object[]{contato.getNome(), contato.getTelefone(), contato.getEmail(), contato.getTipo()});
        }
    }

    // Função para editar o contato selecionado
    private void editarContatoSelecionado() {
        int selectedRow = tabelaContatos.getSelectedRow();
        if (selectedRow != -1) {
            String nomeAtualizado = JOptionPane.showInputDialog(this, "Atualize o Nome:", tabelaContatos.getValueAt(selectedRow, 0));
            String telefoneAtualizado = JOptionPane.showInputDialog(this, "Atualize o Telefone:", tabelaContatos.getValueAt(selectedRow, 1));
            String emailAtualizado = JOptionPane.showInputDialog(this, "Atualize o Email:", tabelaContatos.getValueAt(selectedRow, 2));
            String tipoAtualizado = (String) JOptionPane.showInputDialog(this, "Atualize o Tipo de Contato:", "Editar Tipo", JOptionPane.QUESTION_MESSAGE, null, new String[]{"Pessoal", "Profissional"}, tabelaContatos.getValueAt(selectedRow, 3));

            contatos.get(selectedRow).setNome(nomeAtualizado);
            contatos.get(selectedRow).setTelefone(telefoneAtualizado);
            contatos.get(selectedRow).setEmail(emailAtualizado);
            contatos.get(selectedRow).setTipo(tipoAtualizado);

            carregarContatosNaTabela();
            Arquivo.atualizarArquivo();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um contato para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Função para remover o contato selecionado
    private void removerContatoSelecionado() {
        int selectedRow = tabelaContatos.getSelectedRow();
        if (selectedRow != -1) {
            contatos.remove(selectedRow);
            carregarContatosNaTabela();
            Arquivo.atualizarArquivo();
            JOptionPane.showMessageDialog(this, "Contato removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um contato para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}