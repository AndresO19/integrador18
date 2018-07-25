
package integrador.vistas;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import java.lang.reflect.*;
import java.text.*;
import static javafx.application.Application.launch;
import javafx.beans.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.image.*;
import integrador.rnegocio.dao.*;
import integrador.rnegocio.entidad.*;
import integrador.rnegocio.impl.*;
import integrador.accesodatos.*;

public class formEstudiante {
    
    
    
    
     private Label txtCedula;
    private Label txtNombres;
    private Label txtCodigo;
    private Label txtDescripcion;
    private Label txtCodigo_sicoa;
    private Label txtPeriodo;
    private Label txtNivel;
    /////////////////
    private Image pFondo;
    private BackgroundImage fondo;
    private Image logo;
    private ImageView visorlogo;
    //////////////////////////
    private TextField cedula;
    private Label nombres;
    private Label codigo;
    private Label descripcion;
    private Label codigo_sicoa;
    private Label periodo;
    private Label nivel;
    
    
    private Button btnEliminar;
    private Button btnLimpiar;
    private Button btnBuscar;
    private HBox pnlced;
    private GridPane pnlNombApe;
    private GridPane pnlFechDir;
    private GridPane pnlcontacto;
    private HBox pnlBotones;
    private VBox pntPrincipal;
    
    private Estudiante estu;

    public formEstudiante() {
        
          pFondo = new Image("file:src\\unachkardex\\multimedia\\FondoSubVentanas.jpg");
        fondo = new BackgroundImage(pFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        //LABELS DE LOS CAMPOS A USAR
        txtCedula = new Label("Cedula: ");
        txtCedula.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtCedula.setFill(Color.DARKBLUE);
        txtNombres = new Label("Nombres: ");
        txtNombres.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtNombres.setFill(Color.DARKBLUE);
        txtCodigo = new Label("Codigo: ");
        txtCodigo.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtCodigo.setFill(Color.DARKBLUE);
        txtDescripcion = new Label("Fecha de Nacimiento: ");
        txtDescripcion.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtDescripcion.setFill(Color.DARKBLUE);
        txtCodigo_sicoa = new Label("Codigo_sicoa: ");
        txtCodigo_sicoa.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtCodigo_sicoa.setFill(Color.DARKBLUE);
        txtPeriodo = new Label("Periodo: ");
        txtPeriodo.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtPeriodo.setFill(Color.DARKBLUE);
        txtNivel = new Label("E-mail: ");
        txtNivel.setFont(Font.font("Berlin Sans FB Demi", 20));
        //txtNivel.setFill(Color.DARKBLUE);

        //CAJAS DE TEXTO PARA CAMPOS
        cedula = new TextField("");
        cedula.setMaxSize(150, 25);
        cedula.setMinSize(150, 25);
        cedula.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        nombres = new Label("");
        nombres.setMaxSize(150, 25);
        nombres.setMinSize(150, 25);
        nombres.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        codigo = new Label("");
        codigo.setMaxSize(150, 25);
        codigo.setMinSize(150, 25);
        codigo.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        descripcion = new Label("");
        descripcion.setMaxSize(150, 25);
        descripcion.setMinSize(150, 25);
        descripcion.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        codigo_sicoa = new Label("");
        codigo_sicoa.setMaxSize(150, 25);
        codigo_sicoa.setMinSize(150, 25);
        codigo_sicoa.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        periodo = new Label("");
        periodo.setMaxSize(150, 25);
        periodo.setMinSize(150, 25);
        periodo.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        nivel = new Label("");
        nivel.setMaxSize(150, 25);
        nivel.setMinSize(150, 25);
        nivel.setStyle("-fx-border-color: mediumblue; -fx-border-width: 2px");
        //BOTONES A USAR
        btnEliminar = new Button("Eliminar");
        btnEliminar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnEliminarEventHandler(event);
            }
        });
        btnLimpiar = new Button("Limpiar");
        btnLimpiar.setFont(Font.font("Berlin Sans FB Demi", 20));
        btnBuscar = new Button("Buscar");
        btnBuscar.setFont(Font.font("Berlin Sans FB Demi", 15));
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btnBuscarEventHandler(event);
            }
        });

        //INGRESO EN PANELES
        //SUPERIOR
        pnlced = new HBox(20);
        pnlced.getChildren().addAll(txtCedula, cedula, btnBuscar);
        //nombre
        pnlNombApe = new GridPane();
        pnlNombApe.setHgap(20);
        pnlNombApe.setVgap(20);
        pnlNombApe.add(txtNombres, 0, 0);
        pnlNombApe.add(nombres, 1, 0);
        pnlNombApe.add(txtCodigo, 2, 0);
        pnlNombApe.add(codigo, 3, 0);
        //fecha y codigo_sicoa
        pnlFechDir = new GridPane();
        pnlFechDir.setHgap(20);
        pnlFechDir.setVgap(10);
        pnlFechDir.add(txtDescripcion, 0, 0);
        pnlFechDir.add(descripcion, 1, 0);
        pnlFechDir.add(txtCodigo_sicoa, 0, 1);
        pnlFechDir.add(codigo_sicoa, 1, 1);
        //Contacto        
        pnlcontacto = new GridPane();
        pnlcontacto.setHgap(20);
        pnlcontacto.setVgap(20);
        pnlcontacto.add(txtPeriodo, 0, 0);
        pnlcontacto.add(periodo, 1, 0);
        pnlcontacto.add(txtNivel, 2, 0);
        pnlcontacto.add(nivel, 3, 0);
        //botones
        pnlBotones = new HBox(20);
        pnlBotones.getChildren().addAll(btnEliminar, btnLimpiar);
        pnlBotones.setAlignment(Pos.CENTER);
        //final
        pntPrincipal = new VBox(10);
        logo = new Image("file:src\\unachkardex\\multimedia\\logo.jpg");
        visorlogo = new ImageView();
        visorlogo.setImage(logo);
        visorlogo.setFitHeight(200);
        visorlogo.setPreserveRatio(true);
        pntPrincipal.getChildren().addAll(visorlogo, pnlced, pnlNombApe, pnlFechDir, pnlcontacto, pnlBotones);
        pntPrincipal.setAlignment(Pos.CENTER);
        pntPrincipal.setPadding(new Insets(10));
        pntPrincipal.setBackground(new Background(fondo));
        pntPrincipal.setStyle("-fx-padding: 10; -fx-border-color: mediumblue; -fx-border-width: 2px");
       

    }

    public void btnLimpiarEventHandler(ActionEvent event) {
        cedula.setText("");
    }

    public void btnEliminarEventHandler(ActionEvent event) {
        IEstudiantes EstDao = new EstudianteImpl();
        try {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("INFORMACION DEL SISTEMA");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("Desea Eliminar este Producto?");
            confirmacion.showAndWait();
            if (confirmacion.getResult() == ButtonType.OK) {
                System.out.println("BBJUB");
                if (EstDao.eliminar(estu) > 0) { 
                    confirmacion.setTitle("INFORMACION DEL SISTEMA");
                    confirmacion.setHeaderText(null);
                    confirmacion.setContentText("Se a Eliminado Correctamente!!");
                    confirmacion.showAndWait();
                } else {
                    confirmacion.setTitle("INFORMACION DEL SISTEMA");
                    confirmacion.setHeaderText(null);
                    confirmacion.setContentText("No se pudo Eliminar!!");
                    confirmacion.showAndWait();
                }
            }
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se pudo Eliminar: " + e.getMessage());
            alerta.showAndWait();
        }

    }

    public void btnBuscarEventHandler(ActionEvent event) {
        IEstudiantes esDao = new EstudianteImpl();
        estu = new Estudiante();
        try {
            estu = esDao.obtener(Integer.parseInt(cedula.getText()));
            nombres.setText(estu.getNombre());
            codigo.setText(Integer.parseInt(estu.getCodigo()));
            codigo_sicoa.setText(Integer.parseInt(estu.getCodigo_sicoa()));
            periodo.setText(estu.getPeriodo());
            nivel.setText(estu.getNivel());
            descripcion.setText(String.valueOf(estu.getFechaNac()));
        } catch (Exception e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("INFORMACION DEL SISTEMA");
            alerta.setHeaderText(null);
            alerta.setContentText("No se encuentra el Producto " + cedula.getText());
            alerta.showAndWait();
        }
    }

    public Node getPntPrincipalP() {
        return pntPrincipal;
    }

   

}
    
    
    
    
}
