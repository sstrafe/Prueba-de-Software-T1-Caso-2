package T1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistroMatriculaTest {

    @Test
    @DisplayName("Debería validar límite de créditos para alumno nuevo")
    void deberiaValidarLimiteCreditosAlumnoNuevo() {
        ServicioAcademico servicioMock = Mockito.mock(ServicioAcademico.class);
        RegistroMatricula registro = new RegistroMatricula(servicioMock);
        List<Curso> cursos = List.of(new Curso("C1", 10), new Curso("C2", 5));
        String resultado = registro.matricular("A01", cursos, true);
        assertEquals("Límite de créditos excedido para alumno nuevo", resultado);
    }

    @Test
    @DisplayName("Debería validar vacantes disponibles")
    void deberiaValidarVacantesDisponibles() {
        ServicioAcademico servicioMock = Mockito.mock(ServicioAcademico.class);
        Mockito.when(servicioMock.tieneVacantes("C1")).thenReturn(false);
        RegistroMatricula registro = new RegistroMatricula(servicioMock);
        List<Curso> cursos = List.of(new Curso("C1", 5));
        String resultado = registro.matricular("A01", cursos, false);
        assertEquals("No hay vacantes disponibles", resultado);
    }
}