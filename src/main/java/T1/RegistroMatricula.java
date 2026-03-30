package T1;

import java.util.List;

public class RegistroMatricula {
    private ServicioAcademico servicio;

    public RegistroMatricula(ServicioAcademico servicio) {
        this.servicio = servicio;
    }

    public String matricular(String alumnoId, List<Curso> cursos, boolean esNuevo) {
        int total = cursos.stream().mapToInt(Curso::getCreditos).sum();
        if (esNuevo && total > 12) {
            return "Límite de créditos excedido para alumno nuevo";
        }
        return "Matrícula exitosa";
    }
}
