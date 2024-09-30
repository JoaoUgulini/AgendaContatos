package Agenda;

public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private String tipo;  // Tipo de contato: Pessoal ou Profissional

    public Contato(String nome, String telefone, String email, String tipo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
