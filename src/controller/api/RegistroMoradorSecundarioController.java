package controller.api;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.dto.MoradorPrincipalDTO;
import controller.dto.MoradorSecundarioDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.services.MoradorSecundarioBO;
import viewer.CondominioAcess;

public class RegistroMoradorSecundarioController implements Initializable {

	@FXML
	private TableColumn<MoradorSecundarioDTO, String> columnApartamento;
	 
	@FXML
	private TableColumn<MoradorSecundarioDTO, String> columnId;

    @FXML
    private TableColumn<MoradorSecundarioDTO, String> columnIdMoradorP;

    @FXML
    private TableColumn<MoradorSecundarioDTO, String> columnNascimento;

    @FXML
    private TableColumn<MoradorSecundarioDTO, String> columnNome;

    @FXML
    private TableColumn<MoradorSecundarioDTO, String> columnParentesco;

    @FXML
    private Pane confirmarExclusao;
    @FXML private TableView<MoradorSecundarioDTO> tabelaMoradorSecundario;
    MoradorSecundarioBO bo = new MoradorSecundarioBO();
    private ObservableList<MoradorSecundarioDTO> listaMoradoresS;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarMoradoresSecundarios();
	}
    
    public void listarMoradoresSecundarios() {
    	        List<MoradorSecundarioDTO> moradoresS = bo.listar();
    	        listaMoradoresS = FXCollections.observableArrayList(moradoresS);
    	        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	        columnApartamento.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
    	        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	        columnIdMoradorP.setCellValueFactory(new PropertyValueFactory<>("idMoradorP"));
    	        columnNascimento.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
    	        columnParentesco.setCellValueFactory(new PropertyValueFactory<>("parentesco"));

    	        
    	        tabelaMoradorSecundario.setItems(listaMoradoresS);
    }
	
    @FXML
    public void cancelar(ActionEvent event) {
    	confirmarExclusao.setVisible(false);
    }

    @FXML
    public void confirmarExclusao(ActionEvent event) {
    	confirmarExclusao.setVisible(true);
    }

    @FXML
    public void excluir(ActionEvent event) {
    	MoradorSecundarioDTO dto = new MoradorSecundarioDTO();
    	
    	dto.setId(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getNome());;
    	dto.setApartamento(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setDataNasc(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getDataNasc());
    	dto.setIdMoradorP(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getIdMoradorP());
    	dto.setParentesco(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getParentesco());
    	
    	bo.apagar(dto);
    	
    	confirmarExclusao.setVisible(false);
    	listarMoradoresSecundarios();
    }

    @FXML
    public void telaCadastrar(ActionEvent event) {
    	CondominioAcess.telaCadastroMoradorSecundario();
    }

    @FXML
    public void telaEditar(ActionEvent event) {
    	MoradorSecundarioDTO dto = new MoradorSecundarioDTO();
    	
    	dto.setId(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getNome());;
    	dto.setApartamento(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setDataNasc(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getDataNasc());
    	dto.setIdMoradorP(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getIdMoradorP());
    	dto.setParentesco(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getParentesco());
    	
    	TelaEdicaoMoradorSecundarioController.telaEditar(dto);
    }
    
    @FXML
    public void telaMain() {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }

}
