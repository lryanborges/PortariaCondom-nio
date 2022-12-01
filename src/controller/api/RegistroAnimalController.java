package controller.api;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.dto.AnimalDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.services.AnimalBO;
import viewer.CondominioAcess;

public class RegistroAnimalController implements Initializable {

    @FXML
    private TableColumn<AnimalDTO, String> columnAp;

    @FXML
    private TableColumn<AnimalDTO, String> columnCor;

    @FXML
    private TableColumn<AnimalDTO, String> columnEspecie;

    @FXML
    private TableColumn<AnimalDTO, String> columnId;

    @FXML
    private TableColumn<AnimalDTO, String> columnIdMoradorP;

    @FXML
    private TableColumn<AnimalDTO, String> columnNome;

    @FXML
    private TableColumn<AnimalDTO, String> columnRaca;

    @FXML
    private Pane confirmarExclusao;

    @FXML
    private TableView<AnimalDTO> tabelaAnimal;

    AnimalBO bo = new AnimalBO();
    private ObservableList<AnimalDTO> listaAnimais;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarAnimais();
	}
    
    public void listarAnimais() {
        List<AnimalDTO> animais = bo.listar();
        listaAnimais = FXCollections.observableArrayList(animais);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        columnAp.setCellValueFactory(new PropertyValueFactory<>("Apartamento"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        columnIdMoradorP.setCellValueFactory(new PropertyValueFactory<>("idMorador"));
        columnCor.setCellValueFactory(new PropertyValueFactory<>("Cor"));
        columnRaca.setCellValueFactory(new PropertyValueFactory<>("Raca"));
        columnEspecie.setCellValueFactory(new PropertyValueFactory<>("Especie"));
        
        tabelaAnimal.setItems(listaAnimais);
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
    void excluir(ActionEvent event) {
    	AnimalDTO dto = new AnimalDTO();
    	
    	dto.setId(tabelaAnimal.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaAnimal.getSelectionModel().getSelectedItem().getNome());;
    	dto.setApartamento(tabelaAnimal.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setCor(tabelaAnimal.getSelectionModel().getSelectedItem().getCor());
    	dto.setEspecie(tabelaAnimal.getSelectionModel().getSelectedItem().getEspecie());
    	dto.setNome(tabelaAnimal.getSelectionModel().getSelectedItem().getRaca());
    	dto.setIdMorador(tabelaAnimal.getSelectionModel().getSelectedItem().getIdMorador());
    	
    	bo.apagar(dto);
    	
    	confirmarExclusao.setVisible(false);
    	listarAnimais();
    }

    @FXML
    public void telaCadastrar(ActionEvent event) {
    	CondominioAcess.telaCadastroAnimal();
    }

    @FXML
    void telaEditar(ActionEvent event) {
    	AnimalDTO dto = new AnimalDTO();
    	
    	dto.setId(tabelaAnimal.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaAnimal.getSelectionModel().getSelectedItem().getNome());;
    	dto.setApartamento(tabelaAnimal.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setCor(tabelaAnimal.getSelectionModel().getSelectedItem().getCor());
    	dto.setEspecie(tabelaAnimal.getSelectionModel().getSelectedItem().getEspecie());
    	dto.setNome(tabelaAnimal.getSelectionModel().getSelectedItem().getRaca());
    	dto.setIdMorador(tabelaAnimal.getSelectionModel().getSelectedItem().getIdMorador());
    	
    	TelaEdicaoAnimalController.telaEditar(dto);
    }
    
    @FXML
    public void telaMain() {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }
    
}