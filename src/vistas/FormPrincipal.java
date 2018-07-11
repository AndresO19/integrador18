
package vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;

public class FormPrincipal extends Application {
    
    //Escenario
    private Image imagenPrincipal;
    private ImageView visorInicio;
    private Scene escenario; 
    //ventana General
    private VBox vPrincipal;
    
    //items menu
    private MenuBar menuPrincipal;
    private Menu mInicio;
    private Menu mEstudiante;
    private Menu mDirectorCarrera;
    private Menu mTutoriasdeAsignatura;
    private Menu mTutoriaGrupal;
    private Menu mManual;
    
    
    @Override
    public void start(Stage primaryStage) {
        //Inicializar items
        imagenPrincipal=new Image("file:src\\recursos\\siget-011.jpg");
        visorInicio=new ImageView(imagenPrincipal);
        vPrincipal=new VBox();
        menuPrincipal=new MenuBar();
        mInicio=new Menu("Inicio");
        mEstudiante=new Menu("Estudiantes");
        mDirectorCarrera=new Menu("Director de Carrera");
        mTutoriasdeAsignatura=new Menu("Tutorias de Asignatura");
        mTutoriaGrupal=new Menu("Tutorias Grupales");
        mManual=new Menu("Manual de usuario");
        //ingreso de items menu
        menuPrincipal.getMenus().addAll(mInicio, mEstudiante, mDirectorCarrera, mTutoriasdeAsignatura, mTutoriaGrupal, mManual);
        //Ingreso de item en ventana ordenado
        vPrincipal.getChildren().addAll(visorInicio, menuPrincipal);
        vPrincipal.setMaxSize(865, 685);
        vPrincipal.setMinSize(860, 680);
        escenario = new Scene(vPrincipal, 860, 680, false);
        //ventana principal y configuracion
        primaryStage.setTitle("Integrador Gestion De Tutorias");
        primaryStage.setScene(escenario);
        primaryStage.setMaxWidth(vPrincipal.getWidth());
        primaryStage.setMaxHeight(vPrincipal.getHeight());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
