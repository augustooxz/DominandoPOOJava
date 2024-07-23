import java.time.LocalDate;

public class Mentoria extends Conteudo{

    private LocalDate data = LocalDate.now();

    public Mentoria(String titulo, String descricao) {
        super(titulo, descricao); // Chama o construtor da superclasse

    }

    public double calcularXp() {
        return XP_PADRAO + 20d;
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }
}