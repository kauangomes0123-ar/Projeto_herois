package Model;

public class SuperHeroi {

    private int id;
    private String nome;
    private String nomeReal;
    private String poder;
    private String universo;

    public SuperHeroi() {
    }

    public SuperHeroi(int id, String nome, String nomeReal, String poder, String universo) {
        this.id = id;
        this.nome = nome;
        this.nomeReal = nomeReal;
        this.poder = poder;
        this.universo = universo;
    }

    public SuperHeroi(String nome, String nomeReal, String poder, String universo) {
        this.nome = nome;
        this.nomeReal = nomeReal;
        this.poder = poder;
        this.universo = universo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeReal() {
        return nomeReal;
    }

    public void setNomeReal(String nomeReal) {
        this.nomeReal = nomeReal;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getUniverso() {
        return universo;
    }

    public void setUniverso(String universo) {
        this.universo = universo;
    }
}