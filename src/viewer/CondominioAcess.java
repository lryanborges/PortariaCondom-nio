package viewer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.entity.MoradorPrincipal;

public class CondominioAcess extends Application {

private static Stage stage;
	
	public static void main(String args[]) throws Exception {
			launch();
	}

	@Override
	public void start(Stage stg) throws Exception {
        setStage(stg);
        stg.setTitle("Cadastro");
        telaRegistroMoradorSecundario();
    }
    
    public static void telaCadastroMoradorPrincipal() {
        try {
            Parent root = FXMLLoader.load(CondominioAcess.class.getResource("resources/cadastroMoradorPrincipal.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Cadastro de Moradores Principais");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaEdicaoMoradorPrincipal() {
        try {
            Parent root = FXMLLoader.load(CondominioAcess.class.getResource("resources/edicaoMoradorPrincipal.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Edição de Moradores Principais");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaRegistroMoradorPrincipal() {
        try {
            Parent root = FXMLLoader.load(CondominioAcess.class.getResource("resources/registroMoradorPrincipal.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Registro de Moradores Principais");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaCadastroMoradorSecundario() {
        try {
            Parent root = FXMLLoader.load(CondominioAcess.class.getResource("resources/cadastroMoradorSecundario.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Cadastro de Moradores Secundários");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaEdicaoMoradorSecundario() {
        try {
            Parent root = FXMLLoader.load(CondominioAcess.class.getResource("resources/edicaoMoradorSecundario.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Edição de Moradores Secundarios");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }
    
    public static void telaRegistroMoradorSecundario() {
        try {
            Parent root = FXMLLoader.load(CondominioAcess.class.getResource("resources/registroMoradorSecundario.fxml"));
            Scene scene = new Scene (root);
            stage.setScene(scene);
            stage.setTitle("Tela de Cadastro de Moradores Secundários");
            stage.show();
        }
        catch(Exception e) {    // captura exception qnd qm chamar ele throws Excep.
            e.printStackTrace();
        }
    }


	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CondominioAcess.stage = stage;
	}
	
}
