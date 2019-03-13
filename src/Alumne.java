public class Alumne {

    private float nota;
    private String nom;
    private String estado;

    public Alumne(float nota, String nom) {
        this.nota = nota;
        this.nom = nom;

        if(this.nota < 5) this.setEstado("Suspès");
        else if (this.nota >= 5) this.setEstado("Aprovat");
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
