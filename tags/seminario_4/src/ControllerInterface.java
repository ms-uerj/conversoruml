import java.io.File;


public interface ControllerInterface {
	/* Aqui ficam os m�todos que um controlador deve implementar  */
	void umlToXmi(File file, File directory)throws Exception;
	void xmiToUml(File file, File directory)throws Exception;
}
