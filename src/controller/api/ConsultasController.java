package controller.api;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.dto.ConsultasDTO;
import controller.dto.MoradorPrincipalDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.services.MoradorPrincipalBO;
import viewer.CondominioAcess;

public class ConsultasController implements Initializable {

    @FXML
    private TableColumn<ConsultasDTO, String> columMoradorS;

    @FXML
    private TableColumn<ConsultasDTO, String> columnAnimal;

    @FXML
    private TableColumn<ConsultasDTO, String> columnEmpregado;

    @FXML
    private TableColumn<ConsultasDTO, String> columnId;

    @FXML
    private TableColumn<ConsultasDTO, String> columnNome;

    @FXML
    private TableColumn<ConsultasDTO, String> columnVeiculo;

    @FXML
    private Pane confirmarExclusao;

    @FXML
    private TextField pesquisa;

    @FXML
    private TableView<ConsultasDTO> tabelaConsultas;
    
    private ObservableList<ConsultasDTO> consultasMP;
    
    MoradorPrincipalBO boMP = new MoradorPrincipalBO();

    static int id;
    static String nome, moradorS, empregado, veiculo, animal;
    
	public static void dadosMoradorP(List<MoradorPrincipalDTO> dto) {
		
		id = dto.get(1).getId();
		nome = dto.get(1).getNome();
		
	}
	public static void dadosMoradorS(MoradorPrincipalDTO dto) {
		
		
		
	}
	public static void dadosEmpregado(MoradorPrincipalDTO dto) {
		
	}
	public static void dadosVeiculo(MoradorPrincipalDTO dto) {
		
	}
	public static void dadosAnimal(MoradorPrincipalDTO dto) {
		
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarConsultas();
	}
    
	public void listarConsultas() {
		 /*List<MoradorPrincipalDTO> moradoresP = boMP.listar();
	        consultasMP = FXCollections.observableArrayList(moradoresP);
	        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
	        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
	        columMoradorS.setCellValueFactory(new PropertyValueFactory<>("moradorS"));
	        
	        tabelaConsultas.setItems(consultasMP);*/
	}
	
    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void pesquisar(ActionEvent event) {

    }

    @FXML
    void telaMain(ActionEvent event) {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }

}
