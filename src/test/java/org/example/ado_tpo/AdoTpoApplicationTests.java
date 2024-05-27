package org.example.ado_tpo;

import org.example.ado_tpo.Controllers.*;
import org.example.ado_tpo.Entities.*;
import org.example.ado_tpo.Enums.EstadoCuota;
import org.example.ado_tpo.Enums.Turno;
import org.example.ado_tpo.Enums.Estado;
import org.example.ado_tpo.Interfaces.MetodoDePago;
import org.example.ado_tpo.Interfaces.Reporte;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@SpringBootTest
class AdoTpoApplicationTests {

    private CarreraController carreraController;
    private MateriaController materiaController;
    private CursoController cursoController;
    private EstudianteController estudianteController;
    private DocenteController docenteController;
    private AulaController aulaController;
    private AsignaturaController asignaturaController;
    private PagoController pagoController;

    @BeforeEach
    void setUp() {
        carreraController = CarreraController.getInstance();
        materiaController = MateriaController.getInstancia();
        cursoController = CursoController.getInstancia();
        estudianteController = EstudianteController.getInstancia();
        docenteController = DocenteController.getInstancia();
        aulaController = AulaController.getInstancia();
        asignaturaController = AsignaturaController.getInstancia();
        pagoController = PagoController.getInstancia();

        // Crear una carrera y materias para las pruebas
        carreraController.crearCarrera("1", "Ingeniería en Informática", 3380);

        materiaController.nuevaMateria("1", "Análisis matemático 1", 24, 1350.5f);
        materiaController.nuevaMateria("2", "Análisis matemático 2", 40, 1450.5f);
        materiaController.nuevaMateria("3", "Análisis matemático 3", 60, 1500.5f);
        materiaController.nuevaMateria("4", "Programación 1", 60, 1650f);
        materiaController.nuevaMateria("5", "Programación 2", 50, 1750.5f);
        materiaController.nuevaMateria("6", "Programación 3", 40, 1750.5f);
        materiaController.nuevaMateria("7", "Teoría de Sistemas", 30, 1050.5f);

        materiaController.agregarCorrelativaPosterior("1", "2");
        materiaController.agregarCorrelativaAnterior("2", "1");
        materiaController.agregarCorrelativaPosterior("2", "3");
        materiaController.agregarCorrelativaPosterior("4", "5");
        materiaController.agregarCorrelativaAnterior("5", "4");
        materiaController.agregarCorrelativaPosterior("5", "6");
        materiaController.agregarCorrelativaAnterior("6", "5");

        aulaController.nuevaAula(20, 232);
        aulaController.nuevaAula(50, 942);
        aulaController.nuevaAula(30, 442);
        aulaController.nuevaAula(70, 814);
        aulaController.nuevaAula(30, 515);

        cursoController.crearCurso(1, 232, "7:45", "Lunes", "1", Turno.MANANA);
        cursoController.crearCurso(2, 942, "14:00", "Lunes", "2", Turno.TARDE);
        cursoController.crearCurso(3, 442, "18:30", "Martes", "3", Turno.NOCHE);
        cursoController.crearCurso(4, 814, "7:45", "Martes", "2", Turno.MANANA);
        cursoController.crearCurso(5, 515, "18:30", "Miércoles", "5", Turno.NOCHE);

        Carrera ingEnInformatica = carreraController.buscarCarreraPorCodigo("1");

        estudianteController.nuevoEstudiante("Pepe", "Sanchez", "43777666", "1122875", ingEnInformatica);
        estudianteController.nuevoEstudiante("Jose", "Rodriguez", "32532523", "1189894", ingEnInformatica);
        estudianteController.nuevoEstudiante("Carlo", "Perez", "75464524", "1191420", ingEnInformatica);
        estudianteController.nuevoEstudiante("Juana", "Godoy", "7544885", "1165826", ingEnInformatica);

        docenteController.nuevoDocente("Claudio", "Godio", "12478632", "1197284");
        docenteController.nuevoDocente("Ana Carolina", "Martinez", "40998899", "1197284");
        docenteController.nuevoDocente("Ricardo", "Thompson", "14586905", "1165277");
        docenteController.nuevoDocente("Fernando", "Acero", "10492893", "1147277");

        docenteController.getDocenteByLegajo("1197284").setDisponibilidad(Turno.NOCHE, "Miércoles");
        docenteController.getDocenteByLegajo("1147277").setDisponibilidad(Turno.TARDE, "Lunes");
        docenteController.getDocenteByLegajo("1147277").setDisponibilidad(Turno.MANANA, "Lunes");
        docenteController.getDocenteByLegajo("1147277").setDisponibilidad(Turno.NOCHE, "Miércoles");
        docenteController.getDocenteByLegajo("1147277").setDisponibilidad(Turno.MANANA, "Martes");
        docenteController.getDocenteByLegajo("1147277").setDisponibilidad(Turno.NOCHE, "Martes");

        cursoController.inscribirDocenteACurso("1147277", 1);
        cursoController.inscribirDocenteACurso("1147277", 2);
        cursoController.inscribirDocenteACurso("1147277", 4);
        cursoController.inscribirDocenteACurso("1147277", 3);
        cursoController.inscribirDocenteACurso("1197284", 5);

        // Crear y asignar asignaturas a los estudiantes
        asignarAsignaturasAEstudiantes();

        String legajoPepe = "1122875";
        cursoController.inscribirEstudianteACurso(legajoPepe, 1);
        cursoController.inscribirEstudianteACurso(legajoPepe, 5);
        // jose
        String legajoJose = "1189894";
        cursoController.inscribirEstudianteACurso(legajoJose, 4);
        cursoController.inscribirEstudianteACurso(legajoJose, 5);

        // carlo
        String legajoCarlo = "1191420";
        cursoController.inscribirEstudianteACurso(legajoCarlo, 1);
        cursoController.inscribirEstudianteACurso(legajoCarlo, 5);
        // juana
        String legajoJuana = "1165826";
        cursoController.inscribirEstudianteACurso(legajoJuana, 4);
        cursoController.inscribirEstudianteACurso(legajoJuana, 5);

        System.out.println("Setup cargado correctamente a memoria.");
    }

    private void asignarAsignaturasAEstudiantes() {
        // Crear y asignar asignaturas a los estudiantes
        List<Estudiante> estudiantes = estudianteController.getEstudiantes();
        for (Estudiante estudiante : estudiantes) {
            HistorialAcademico historial = estudiante.getHistorialAcademico();
            List<Asignatura> asignaturas = new ArrayList<>();

            for (Curso curso : cursoController.getCursos()) {
                Estado estado = Estado.POR_HACER;
                Asignatura asignatura = asignaturaController.crearAsignatura(curso, curso.getMateria(), estado);
                asignaturas.add(asignatura);
            }

            historial.setAsignaturas(asignaturas);
        }
    }


    @Test
    void almacenarMateriasDisponiblesParaCarrera() {
        System.out.println(" ");
        // Inicializar la lista para almacenar los resultados de las llamadas a agregarMateriaACarrera
        List<Boolean> resultados = new ArrayList<>();

        // Agregar cada materia a la carrera y almacenar el resultado
        resultados.add(carreraController.agregarMateriaACarrera("1", "1"));
        resultados.add(carreraController.agregarMateriaACarrera("1", "2"));
        resultados.add(carreraController.agregarMateriaACarrera("1", "3"));
        resultados.add(carreraController.agregarMateriaACarrera("1", "4"));
        resultados.add(carreraController.agregarMateriaACarrera("1", "5"));
        resultados.add(carreraController.agregarMateriaACarrera("1", "6"));
        resultados.add(carreraController.agregarMateriaACarrera("1", "7"));

        // Verificar que todas las materias se agregaron correctamente
        assertTrue(resultados.stream().allMatch(result -> result), "Todas las materias deberían haberse agregado correctamente");

        // Buscar la carrera y verificar el número de materias
        Carrera encontrada = carreraController.buscarCarreraPorCodigo("1");
        assertNotNull(encontrada, "La carrera debería haberse encontrado");

        System.out.println("El test almacenarMateriasDisponiblesParaCarrera corrio bien.");
    }

    @Test
    void visualizacionDeCursosPorCodigoMateriaYPorTurno() {
        System.out.println(" ");
        String codigoMateria = "2";
        Turno turno = Turno.MANANA;
        List<Curso> cursos = cursoController.getCursos();
        System.out.println("Buscar por turno: " + turno);
        for (Curso curso : cursos) {
            if (curso.getTurno() == turno) {
                System.out.println(curso.getMateria().getNombre());
            }
        }
        System.out.println("Buscar por materia: ");
        for (Curso curso : cursos) {
            if (Objects.equals(curso.getMateria().getCodigo(), codigoMateria)) {
                System.out.println(curso.getMateria().getNombre() + " " + curso.getDia() + " " + curso.getTurno());
            }
        }
    }

    @Test
    void visualizacionMateriasCursosEstudiantePostInscripcionACursoDocentesYEstudiantesConValidaciones() {
        System.out.println(" ");
        // pepe
        String legajoPepe = "1122875";
        List<Curso> cursos = cursoController.getCursos();
        // MateriasDePepe
        Estudiante pepe = estudianteController.getEstudianteByLegajo(legajoPepe);
        List<Curso> cursosDePepe = cursos.stream().filter(curso -> curso.getEstudiantesInscriptos().contains(pepe)).toList();

        for (Curso c : cursosDePepe) {
            System.out.println(c.getMateria().getNombre());
        }
    }

    @Test
    void visualizarCursosYCronogramaDocente() {
        System.out.println(" ");
        List<Curso> cursos = cursoController.getCursos();
        String legajo = "1147277";
        Docente docente = docenteController.getDocenteByLegajo(legajo);
        List<Curso> cursoDocente = cursos.stream().filter(curso -> curso.getDocentesAsignados().contains(docente)).toList();
        System.out.println("Materias del docente: " + docente.getNombre() + " " + docente.getApellido());
        for (Curso d : cursoDocente) {
            System.out.println(d.getMateria().getNombre());
        }

        System.out.println("Cronograma del docente: " + docente.getNombre() + " " + docente.getApellido());
        for (Curso d : cursoDocente) {
            System.out.println(d.getMateria().getNombre() + " " + d.getDia() + " " + d.getHorario());
        }
    }

    @Test
    void visualizarInformeDocente() {
        System.out.println(" ");
        String legajo = "1147277";
        Docente docente = docenteController.getDocenteByLegajo(legajo);
        Reporte reportePDF = new PDF();
        docente.generarReporte(legajo, reportePDF);
    }

    @Test
    void cargaHorariaDocente() {
        System.out.println(" ");
        String legajo = "1147277";
        docenteController.generarLiquidacion(legajo);
    }

    @Test
    void cantidadInscriptosPorCurso() {
        System.out.println(" ");
        List<Curso> cursos = cursoController.getCursos();
        for (Curso c : cursos) {
            System.out.println(c.getMateria().getNombre() + " " + c.getHorario() + " Cantidad de estudiantes inscriptos: " + c.getEstudiantesInscriptos().size());
        }
    }

    @Test
    void asignarDocentesACursosPorPreferenciasYTurno() {
        System.out.println(" ");
        System.out.println("Ejecucion de asignarDocentesACursosPorPreferenciasYTurno");
        docenteController.getDocenteByLegajo("1147277").setDisponibilidad(Turno.NOCHE, "Viernes");
        cursoController.crearCurso(6, 515, "18:30", "Viernes", "7", Turno.NOCHE);
        cursoController.inscribirDocenteACurso("1147277", 6);
    }
    @Test
    void inscripcionYFinalizacionDeCurso() {
        String legajoPepe = "1122875";
        int nroCurso = 1;
        Curso curso1 = cursoController.obtenerCurso(nroCurso);
        assertNotNull(curso1);

        Estudiante pepe = estudianteController.getEstudianteByLegajo(legajoPepe);
        assertNotNull(pepe);

        // Verificar que Pepe está inscrito en el curso 1
        assertTrue(curso1.getEstudiantesInscriptos().contains(pepe), "Pepe debería estar inscrito en el curso 1");

        // Simular que Pepe ha finalizado el curso 1
        Asignatura asignatura = pepe.getHistorialAcademico().getAsignaturas().stream()
                .filter(a -> a.getCurso().getNumero() == nroCurso)
                .findFirst()
                .orElse(null);
        assertNotNull(asignatura, "Asignatura del curso 1 debería estar en el historial de Pepe");
        asignatura.setEstado(Estado.FINALIZADO);

        // Intentar inscribir a Pepe en el curso 2 (correlativa de la materia del curso 1)
        Materia analisisMat2 = materiaController.buscarMateriaPorCodigo("2");
        assertNotNull(analisisMat2, "Materia Análisis matemático 2 debería existir");

        Curso curso2 = cursoController.crearCurso(6, 515, "10:00", "Viernes", "2", Turno.MANANA);
        cursoController.inscribirEstudianteACurso(legajoPepe, 6);

        // Verificar que Pepe está inscrito en el curso 6
        assertTrue(curso2.getEstudiantesInscriptos().contains(pepe), "Pepe debería estar inscrito en el curso 6");
        System.out.println("Test inscripcionYFinalizacionDeCurso corrio correctamente.");
    }
    void cambiarEstadoAsignatura(int numeroCurso, Estado estado, Estudiante pepe){

        Asignatura asignatura = pepe.getHistorialAcademico().getAsignaturas().stream()
                .filter(a -> a.getCurso().getNumero() == numeroCurso)
                .findFirst()
                .orElse(null);
        assertNotNull(asignatura, "Asignatura del curso 1 debería estar en el historial de Pepe");
        asignatura.setEstado(estado);
    }

    @Test
    void registrarYVerificarPago() {
        String legajoPepe = "1122875";
        Estudiante pepe = estudianteController.getEstudianteByLegajo(legajoPepe);
        assertNotNull(pepe);
        cambiarEstadoAsignatura(1, Estado.EN_CURSO, pepe);

        List<Asignatura> asignaturas = pepe
                .getHistorialAcademico()
                .getAsignaturas()
                .stream()
                .filter(asignatura -> asignatura.getEstado() == Estado.EN_CURSO).toList();

        for(Asignatura a : asignaturas){
            Materia mat = a.getMateria();
            Random random = new Random();
            int numeroCuota = random.nextInt(100) + 1;

            pago(numeroCuota, mat.getCosto(), pepe, asignaturas.indexOf(a));

        }

        System.out.println("El test registrarYVerificarPago corrio correctamente.");
    }
    private void pago(int numeroCuota, float monto, Estudiante pepe, int indiceAsignatura){
        // Crear una cuota pendiente y asignarla a una asignatura de Pepe
        Cuota cuota = new Cuota(numeroCuota, monto, EstadoCuota.IMPAGO, new Date(), null);
        Asignatura asignatura = pepe.getHistorialAcademico().getAsignaturas().get(indiceAsignatura);
        asignatura.setCuota(cuota);

        // Registrar un pago para la cuota
        MetodoDePago metodoDePago = new MercadoPago();
        pagoController.registrarPago(cuota, metodoDePago);

        // Verificar que la cuota está pagada
        assertEquals(EstadoCuota.PAGO, cuota.getEstadoCuota(), "La cuota debería estar pagada");

        // Verificar que el pago está registrado en el PagoController
        List<Pago> pagos = pagoController.getPagos();
        assertFalse(pagos.isEmpty(), "Debería haber pagos registrados");
        assertEquals(cuota, pagos.get(0).getCuota(), "La cuota del pago registrado debería coincidir con la cuota pagada");
        assertEquals(metodoDePago, pagos.get(0).getMetodoDePago(), "El método de pago del pago registrado debería coincidir");
        System.out.println("Cuota "+numeroCuota+" registrada y abonada correctamente. "+monto+"$.");
    }

}//TEST