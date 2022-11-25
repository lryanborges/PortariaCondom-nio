package controller.api;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.dto.EmpregadoDTO;
import controller.dto.MoradorSecundarioDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.services.EmpregadoBO;
import model.services.MoradorSecundarioBO;
import viewer.CondominioAcess;

public class RegistroEmpregadoController {

    @FXML
    private TableColumn<EmpregadoDTO, String> columnApartamento;

    @FXML
    private TableColumn<EmpregadoDTO, String> columnCargo;

    @FXML
    private TableColumn<EmpregadoDTO, String> columnId;

    @FXML
    private TableColumn<EmpregadoDTO, String> columnIdMoradorP;

    @FXML
    private TableColumn<EmpregadoDTO, String> columnNome;

    @FXML
    private TableColumn<EmpregadoDTO, String> columnRg;

    @FXML
    private TableColumn<EmpregadoDTO, String> columnTurno;

    @FXML
    private Pane confirmarExclusao;
    @FXML private TableView<EmpregadoDTO> tabelaMoradorSecundario;
    EmpregadoBO bo = new EmpregadoBO();
    private ObservableList<EmpregadoDTO> listaMoradoresS;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarEmpregados();
	}
    
    public void listarEmpregados() {
    	        List<EmpregadoDTO> moradoresS = bo.listar();
    	        listaMoradoresS = FXCollections.observableArrayList(moradoresS);
    	        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
    	        columnCargo.setCellValueFactory(new PropertyValueFactory<>("cargo"));
    	        columnTurno.setCellValueFactory(new PropertyValueFactory<>("turno"));
    	        columnRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
    	        columnApartamento.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
    	        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
    	        columnIdMoradorP.setCellValueFactory(new PropertyValueFactory<>("idMoradorP"));
    	        
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
    	EmpregadoDTO dto = new EmpregadoDTO();
    	
    	dto.setId(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getNome());;
    	dto.setApartamento(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setCargo(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getCargo());
    	dto.setIdMoradorP(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getIdMoradorP());
    	dto.setTurno(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getTurno());
    	dto.setRg(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getRg());
    	
    	bo.apagar(dto);
    	
    	confirmarExclusao.setVisible(false);
    	listarEmpregados();
    }

    @FXML
    public void telaCadastrar(ActionEvent event) {
    	CondominioAcess.telaCadastroEmpregado();
    }

    @FXML
    public void telaEditar(ActionEvent event) {
    	EmpregadoDTO dto = new EmpregadoDTO();
    	
    	dto.setId(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getNome());;
    	dto.setApartamento(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setTurno(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getTurno());
    	dto.setIdMoradorP(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getIdMoradorP());
    	dto.setCargo(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getCargo());
    	dto.setRg(tabelaMoradorSecundario.getSelectionModel().getSelectedItem().getRg());
    	
    	TelaEdicaoEmpregadoController.telaEditar(dto);
    }

}

