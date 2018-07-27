
package integrador.vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;

public class FormPrincipal extends Application {
    
    //Escenario
    public Image imagenPrincipal;
    public ImageView visorInicio;
    public Scene escenario; 
    //ventana General
    public VBox vPrincipal;
    
    //items menu
    public MenuBar menuPrincipal;
    public Menu mInicio;
    public Menu mEstudiante;
    public Menu mFacultades;
    public Menu mEscuelas;
    public Menu mNiveles;
    public Menu mAmbitos;
    public Menu mModalidades;
    public Menu mManual;
    
    
    @Override
    public void start(Stage primaryStage) {
        //Inicializar items
        imagenPrincipal=new Image("file:src\\recursos\\siget-011.jpg");
        visorInicio=new ImageView(imagenPrincipal);
        vPrincipal=new VBox();
        menuPrincipal=new MenuBar();
        mInicio=new Menu("Inicio");
        mEstudiante=new Menu("Estudiantes");
        mFacultades=new Menu("Facultades");
        mEscuelas=new Menu("Escuelas");
        mNiveles=new Menu("Niveles");
        mAmbitos=new Menu("Ambitos");
        mModalidades=new Menu("Modalidades");
        mManual=new Menu("manual de Usuario");
        mEstudiante.setDisable(true);
        mFacultades.setDisable(true);
        mEscuelas.setDisable(true);
        mNiveles.setDisable(true);
        mAmbitos.setDisable(true);
        mModalidades.setDisable(true);
        //ingreso de items menu
        menuPrincipal.getMenus().addAll(mInicio, mEstudiante, mFacultades, mEscuelas, mNiveles, mAmbitos, mModalidades, mManual);
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
