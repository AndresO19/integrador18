
package integrador.vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.image.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FormPrincipal extends Application {
    
    //Escenario
    public Image imagenPrincipal;
    public ImageView visorInicio;
    public Scene escenario; 
    //ventana General
    public Pane escritorio;
    public VBox superior;
    public BorderPane vPrincipal;
    
    //items menu
    public MenuBar menuPrincipal;
    public Menu mInicio;
    public Menu mEstudiante;
    public Menu mFacultades;
    public Menu mEscuelas;
    public Menu mPeriodos;
    public Menu mNiveles;
    public Menu mAmbitos;
    public Menu mModalidades;
    public Menu mManual;
    
    //items submenus
    public MenuItem smIniciarSesion;
    public MenuItem smSalir;
    public MenuItem smEstNuevo;
    public MenuItem smEstActualizar;
    public MenuItem smEstEliminar;
    public MenuItem smEstMostrarCodigo;
    public MenuItem smEstListado;
    public MenuItem smFacNuevo;
    public MenuItem smFacActualizar;
    public MenuItem smFacEliminar;
    public MenuItem smFacMostrarCodigo;
    public MenuItem smFacListado;
    public MenuItem smEscNuevo;
    public MenuItem smEscActualizar;
    public MenuItem smEscEliminar;
    public MenuItem smEscMostrarCodigo;
    public MenuItem smEscListado;
    public MenuItem smNivNuevo;
    public MenuItem smNivActualizar;
    public MenuItem smNivEliminar;
    public MenuItem smNivMostrarCodigo;
    public MenuItem smNivListado;
    public MenuItem smAmbNuevo;
    public MenuItem smAmbActualizar;
    public MenuItem smAmbEliminar;
    public MenuItem smAmbMostrarCodigo;
    public MenuItem smAmbListado;
    public MenuItem smModNuevo;
    public MenuItem smModActualizar;
    public MenuItem smModEliminar;
    public MenuItem smModMostrarCodigo;
    public MenuItem smModListado;
    public MenuItem smPerNuevo;
    public MenuItem smPerActualizar;
    public MenuItem smPerEliminar;
    public MenuItem smPerMostrarCodigo;
    public MenuItem smPerListado;
    public MenuItem smManualMostrar;
    
    @Override
    public void start(Stage primaryStage) {
        //Inicializar items
        imagenPrincipal=new Image("file:src/integrador/recursos/siget-011.jpg");
        visorInicio=new ImageView(imagenPrincipal);
        vPrincipal=new BorderPane();
        menuPrincipal=new MenuBar();
        mInicio=new Menu("Inicio");
        mEstudiante=new Menu("Estudiantes");
        mFacultades=new Menu("Facultades");
        mEscuelas=new Menu("Escuelas");
        mPeriodos=new Menu("Periodos");
        mNiveles=new Menu("Niveles");
        mAmbitos=new Menu("Ambitos");
        mModalidades=new Menu("Modalidades");
        mManual=new Menu("manual de Usuario");
        mEstudiante.setDisable(true);
        mFacultades.setDisable(true);
        mEscuelas.setDisable(true);
        mPeriodos.setDisable(true);
        mNiveles.setDisable(true);
        mAmbitos.setDisable(false);
        mModalidades.setDisable(true);
        superior=new VBox();
        escritorio=new Pane();
        //Ingreso de subitems a los menus
        smIniciarSesion=new MenuItem("Iniciar Sesion");
        smSalir=new MenuItem("Salir");
        smSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                salirEventHandler(event);
            }
        });
    smEstNuevo=new MenuItem("Estudiante Nuevo");
    smEstActualizar=new MenuItem("Estudiante Actualizar");
    smEstEliminar=new MenuItem("Estudiante Eliminar");
    smEstMostrarCodigo=new MenuItem("Estudiante por codigo");
    smEstListado=new MenuItem("Estudiante Listado");
    smFacNuevo=new MenuItem("Facultad Nuevo");
    smFacActualizar=new MenuItem("Facultad Actualizar");
    smFacEliminar=new MenuItem("Facultad Eliminar");
    smFacMostrarCodigo=new MenuItem("Facultad por codigo");
    smFacListado=new MenuItem("Facultad Listado");
    smEscNuevo=new MenuItem("Escuela Nuevo");
    smEscActualizar=new MenuItem("Escuela Actualizar");
    smEscEliminar=new MenuItem("Escuela Eliminar");
    smEscMostrarCodigo=new MenuItem("Escuela por codigo");
    smEscListado=new MenuItem("Escuela Listado");
    smPerNuevo=new MenuItem("Periodo Nuevo");
    smPerActualizar=new MenuItem("Periodo Actualizar");
    smPerEliminar=new MenuItem("Periodo Eliminar");
    smPerMostrarCodigo=new MenuItem("Periodo por codigo");
    smPerListado=new MenuItem("Periodo Listado");
    smNivNuevo=new MenuItem("Nivel Nuevo");
    smNivActualizar=new MenuItem("Nivel Actualizar");
    smNivEliminar=new MenuItem("Nivel Eliminar");
    smNivMostrarCodigo=new MenuItem("Nivel por codigo");
    smNivListado=new MenuItem("Nivel Listado");
    smAmbNuevo=new MenuItem("Ambito Nuevo");
    smAmbNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoNuevo=new Pane();
                ambitoNuevo.getChildren().add(nAmbito(event));
                escritorio.getChildren().add(ambitoNuevo);
            }
        });
    smAmbActualizar=new MenuItem("Ambito Actualizar");
    smAmbActualizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane ambitoAct=new Pane();
                ambitoAct.getChildren().add(aAmbito(event));
                escritorio.getChildren().add(ambitoAct);
            }
        });
    smAmbEliminar=new MenuItem("Ambito Eliminar");
    smAmbMostrarCodigo=new MenuItem("Ambito por codigo");
    smAmbListado=new MenuItem("Ambito Listado");
    smModNuevo=new MenuItem("Modalidad Nuevo");
    smModActualizar=new MenuItem("Modalidad Actualizar");
    smModEliminar=new MenuItem("Modalidad Eliminar");
    smModMostrarCodigo=new MenuItem("Modalidad por codigo");
    smModListado=new MenuItem("Modalidad Listado");
    smManualMostrar=new MenuItem("Mostrar Manual");
    //submenus
    mInicio.getItems().addAll(smIniciarSesion, smSalir); 
    mEstudiante.getItems().addAll(smEstNuevo, smEstActualizar, smEstEliminar, new SeparatorMenuItem(), smEstMostrarCodigo, smEstListado);
    mFacultades.getItems().addAll(smFacNuevo, smFacActualizar, smFacEliminar, new SeparatorMenuItem(), smFacMostrarCodigo, smFacListado);
    mEscuelas.getItems().addAll(smEscNuevo, smEscActualizar, smEscEliminar, new SeparatorMenuItem(), smEscMostrarCodigo, smEscListado);
    mPeriodos.getItems().addAll(smPerNuevo, smPerActualizar, smPerEliminar, new SeparatorMenuItem(), smPerMostrarCodigo, smPerListado);
    mNiveles.getItems().addAll(smNivNuevo, smNivActualizar, smNivEliminar, new SeparatorMenuItem(), smNivMostrarCodigo, smNivListado);
    mAmbitos.getItems().addAll(smAmbNuevo, smAmbActualizar, smAmbEliminar, new SeparatorMenuItem(), smAmbMostrarCodigo, smAmbListado);
    mModalidades.getItems().addAll(smModNuevo, smModActualizar, smModEliminar, new SeparatorMenuItem(), smModMostrarCodigo, smModListado);
    mManual.getItems().addAll(smManualMostrar);
        //ingreso de items menu
        menuPrincipal.getMenus().addAll(mInicio, mEstudiante, mFacultades, mEscuelas, mPeriodos, mNiveles, mAmbitos, mModalidades, mManual);
        superior.getChildren().addAll(visorInicio, menuPrincipal);
//Ingreso de item en ventana ordenado
        vPrincipal.setTop(superior);
        vPrincipal.setCenter(escritorio);
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
    
    public VentanaInterna nAmbito(ActionEvent event){
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("NUEVO AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormNambito NAmb = new FormNambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
return nuevo;
    }
    
    public VentanaInterna aAmbito(ActionEvent event){
        BorderPane AmbN = new BorderPane();
        Label titulo = new Label("ACTUALIZAR AMBITO");
        titulo.setFont(Font.font("Berlin Sans FB Demi", 20));
        titulo.setTextFill(Color.AZURE);
        Button cerrar = new Button("X");
        cerrar.setFont(Font.font("Arial Black", 18));
        cerrar.setTextFill(Color.CYAN);
        //Barra de Titulo subVentana
        BarraDeTitulo bTitulo = new BarraDeTitulo(titulo, cerrar);
        AmbN.setTop(bTitulo.getBarra());
        //Interior de la subVentana
        FormAambito NAmb = new FormAambito();
        AmbN.setCenter(NAmb.getPPrincipal());
        //Creacion de Ventana interna
        VentanaInterna nuevo = new VentanaInterna();
        nuevo.setRoot(AmbN);
        nuevo.makeDragable(bTitulo.getBarra());
        nuevo.makeDragable(titulo);
        nuevo.makeResizable(20);
        nuevo.makeFocusable();
        nuevo.setCloseButton(cerrar);
return nuevo;
    }
    
    public void salirEventHandler(ActionEvent event) {
        System.exit(0);
}
    
}
