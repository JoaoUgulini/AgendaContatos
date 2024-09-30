package Agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Arquivo {
    private static String arquivo = "agenda.txt";

    // Função para gravar contatos no arquivo
    public static void atualizarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Contato contato : Consulta.contatos) {
                bw.write(contato.getNome() + "," + contato.getTelefone() + "," + contato.getEmail() + "," + contato.getTipo() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Função para ler contatos do arquivo
    public static void carregarArquivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    Consulta.contatos.add(new Contato(dados[0], dados[1], dados[2], dados[3]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}