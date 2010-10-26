import java.io.File;


public interface ControllerInterface {
	/* Aqui ficam os métodos que um controlador deve implementar  */
	void umlToXmi(File file);
	void xmiToUml(File file);
}
