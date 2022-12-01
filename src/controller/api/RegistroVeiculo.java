package controller.api;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import controller.dto.MoradorSecundarioDTO;
import controller.dto.VeiculoDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.services.VeiculoBO;
import viewer.CondominioAcess;

public class RegistroVeiculo implements Initializable{
	
    @FXML    private TableColumn<VeiculoDTO, String> columnApartamento;

    @FXML    private TableColumn<VeiculoDTO, String> columnCor;

    @FXML    private TableColumn<VeiculoDTO, String> columnId;

    @FXML    private TableColumn<VeiculoDTO, String> columnIdMoradorP;

    @FXML    private TableColumn<VeiculoDTO, String> columnMarca;

    @FXML    private TableColumn<VeiculoDTO, String> columnModelo;

    @FXML    private TableColumn<VeiculoDTO, String> columnPlaca;

    @FXML    private Pane confirmarExclusao;

    @FXML    private TableView<VeiculoDTO> tabelaVeiculo;
    		 VeiculoBO bo = new VeiculoBO();
    		 private ObservableList<VeiculoDTO> listaVeiculosS;

    	@Override
    	public void initialize(URL arg0, ResourceBundle arg1) {
    		// TODO Auto-generated method stub
    		listarVeiculos();	
    	}

    public void listarVeiculos() {
        List<VeiculoDTO> veiculosS = bo.listar();
        listaVeiculosS = FXCollections.observableArrayList(veiculosS);
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        columnCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        columnPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        columnApartamento.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
        columnIdMoradorP.setCellValueFactory(new PropertyValueFactory<>("id_MoradorP"));
        
        tabelaVeiculo.setItems(listaVeiculosS);
}
    
    
    @FXML    void cancelar(ActionEvent event) {
    	confirmarExclusao.setVisible(false);
    }

    @FXML
    void confirmarExclusao(ActionEvent event) {
    	confirmarExclusao.setVisible(true);
    }

    @FXML
    void excluir(ActionEvent event) {
    	VeiculoDTO dto = new VeiculoDTO();
    	
    	dto.setId(tabelaVeiculo.getSelectionModel().getSelectedItem().getId());
    	dto.setMarca(tabelaVeiculo.getSelectionModel().getSelectedItem().getMarca());;
    	dto.setModelo(tabelaVeiculo.getSelectionModel().getSelectedItem().getModelo());;
    	dto.setCor(tabelaVeiculo.getSelectionModel().getSelectedItem().getCor());;
    	dto.setPlaca(tabelaVeiculo.getSelectionModel().getSelectedItem().getPlaca());;
    	dto.setApartamento(tabelaVeiculo.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setId_MoradorP(tabelaVeiculo.getSelectionModel().getSelectedItem().getId_MoradorP());
    	
    	bo.apagar(dto);
    	
    	confirmarExclusao.setVisible(false);
    	listarVeiculos();

    }

    @FXML
    void telaCadastrar(ActionEvent event) {

    	CondominioAcess.telaCadastroVeiculo();
    }

    @FXML
    void telaEditar(ActionEvent event) {
    	VeiculoDTO dto = new VeiculoDTO();
    	
    	dto.setId(tabelaVeiculo.getSelectionModel().getSelectedItem().getId());
    	dto.setMarca(tabelaVeiculo.getSelectionModel().getSelectedItem().getMarca());;
    	dto.setModelo(tabelaVeiculo.getSelectionModel().getSelectedItem().getModelo());;
    	dto.setCor(tabelaVeiculo.getSelectionModel().getSelectedItem().getCor());;
    	dto.setPlaca(tabelaVeiculo.getSelectionModel().getSelectedItem().getPlaca());;
    	dto.setApartamento(tabelaVeiculo.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setId_MoradorP(tabelaVeiculo.getSelectionModel().getSelectedItem().getId_MoradorP());
    	
    	TelaEdicaoVeiculo.telaEditar(dto);
    }
    
    @FXML
    public void telaMain() {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }

}

