import java.util.ArrayList;
import java.util.List;

public class Curso extends Conteudo {

    private int cargaHoraria;

    // Lista estática de cursos disponíveis
    private static List<Curso> cursosDisponiveis = new ArrayList<>();

    // Inicialização dos cursos disponíveis
    static {
        cursosDisponiveis.add(new Curso("Curso Java", "Descrição curso Java", 10));
        cursosDisponiveis.add(new Curso("Curso Python", "Descrição curso Python", 8));
        cursosDisponiveis.add(new Curso("Curso JavaScript", "Descrição curso JavaScript", 6));
    }

    // Construtor da subclasse
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao); // Chama o construtor da superclasse
        this.cargaHoraria = cargaHoraria; // Inicializa o atributo da subclasse
    }

    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public static List<Curso> getCursosDisponiveis() {
        return cursosDisponiveis;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }
}