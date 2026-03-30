package T1;

public class Curso {
    private String id;
    private int creditos;

    public Curso(String id, int creditos) {
        this.id = id;
        this.creditos = creditos;
    }
    public String getId() {
        return id;
    }
    public int getCreditos() {
        return creditos;
    }
}
