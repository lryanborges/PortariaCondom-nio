package controller.api;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import controller.dto.MoradorPrincipalDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.services.MoradorPrincipalBO;
import viewer.CondominioAcess;

public class RegistroMoradorPrincipalController implements Initializable{
	
	@FXML private Pane confirmarExclusao;
	@FXML private TableView<MoradorPrincipalDTO> tabelaMoradorPrincipal;
	@FXML private TableColumn<MoradorPrincipalDTO, String> columnId;
	@FXML private TableColumn<MoradorPrincipalDTO, String> columnApartamento;
	@FXML private TableColumn<MoradorPrincipalDTO, String> columnBloco;
	@FXML private TableColumn<MoradorPrincipalDTO, String> columnCategoria;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnCpf;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnEmail;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnNasc;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnNome;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnRg;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnTelCelular;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnTelComercial;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnTelResidencial;
    @FXML private TableColumn<MoradorPrincipalDTO, String> columnZap;
    private ObservableList<MoradorPrincipalDTO> listaMoradoresP;
    MoradorPrincipalBO bo = new MoradorPrincipalBO();

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		listarMoradoresPrincipais();
	}
    
    public void listarMoradoresPrincipais() {
        List<MoradorPrincipalDTO> moradoresP = bo.listar();
        listaMoradoresP = FXCollections.observableArrayList(moradoresP);
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnApartamento.setCellValueFactory(new PropertyValueFactory<>("apartamento"));
        columnBloco.setCellValueFactory(new PropertyValueFactory<>("bloco"));
        columnCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        columnNasc.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
        columnRg.setCellValueFactory(new PropertyValueFactory<>("rg"));
        columnTelCelular.setCellValueFactory(new PropertyValueFactory<>("telCelular"));
        columnTelComercial.setCellValueFactory(new PropertyValueFactory<>("telComercial"));
        columnTelResidencial.setCellValueFactory(new PropertyValueFactory<>("telResidencial"));
        columnZap.setCellValueFactory(new PropertyValueFactory<>("autorizarZap"));
        
        tabelaMoradorPrincipal.setItems(listaMoradoresP);
    }
    
    @FXML
    public void telaCadastrar() {
    	CondominioAcess.telaCadastroMoradorPrincipal();
    }
    
    public void telaEditar() {
    	MoradorPrincipalDTO dto = new MoradorPrincipalDTO();
    	
    	dto.setId(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getNome());
    	dto.setCpf(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCpf());
    	dto.setRg(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getRg());
    	dto.setApartamento(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setBloco(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getBloco());
    	dto.setCategoria(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCategoria());
    	dto.setEmail(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getEmail());
    	dto.setDataNasc(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getDataNasc());
    	dto.setTelCelular(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelCelular());
    	dto.setTelResidencial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelResidencial());
    	dto.setTelComercial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelComercial());
    	dto.setAutorizarZap(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().isAutorizarZap());
    	
    	TelaEdicaoMoradorPrincipalController.telaEditar(dto);
    }
    
    public void confirmarExclusao() {
    	confirmarExclusao.setVisible(true);
    }
    
    public void excluir() {
    	
    	MoradorPrincipalDTO dto = new MoradorPrincipalDTO();
    	
    	dto.setId(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getNome());
    	dto.setCpf(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCpf());
    	dto.setRg(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getRg());
    	dto.setApartamento(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setBloco(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getBloco());
    	dto.setCategoria(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCategoria());
    	dto.setEmail(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getEmail());
    	dto.setDataNasc(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getDataNasc());
    	dto.setTelCelular(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelCelular());
    	dto.setTelResidencial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelResidencial());
    	dto.setTelComercial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelComercial());
    	dto.setAutorizarZap(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().isAutorizarZap());
    	
    	bo.apagar(dto);
    	
    	confirmarExclusao.setVisible(false);
    	listarMoradoresPrincipais();
    }
    
    public void cancelar() {
    	confirmarExclusao.setVisible(false);
    }
    
    public void cadastroMoradorS() {
    	
    	MoradorPrincipalDTO dto = new MoradorPrincipalDTO();
    	
    	dto.setId(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getNome());
    	dto.setCpf(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCpf());
    	dto.setRg(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getRg());
    	dto.setApartamento(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setBloco(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getBloco());
    	dto.setCategoria(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCategoria());
    	dto.setEmail(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getEmail());
    	dto.setDataNasc(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getDataNasc());
    	dto.setTelCelular(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelCelular());
    	dto.setTelResidencial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelResidencial());
    	dto.setTelComercial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelComercial());
    	dto.setAutorizarZap(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().isAutorizarZap());
    	
    	CadastroMoradorSecundarioController.cadastroMoradorS(dto);
    	
    }
    
    public void cadastroEmpregado() {
    	MoradorPrincipalDTO dto = new MoradorPrincipalDTO();
    	
    	dto.setId(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getId());
    	dto.setNome(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getNome());
    	dto.setCpf(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCpf());
    	dto.setRg(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getRg());
    	dto.setApartamento(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getApartamento());
    	dto.setBloco(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getBloco());
    	dto.setCategoria(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getCategoria());
    	dto.setEmail(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getEmail());
    	dto.setDataNasc(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getDataNasc());
    	dto.setTelCelular(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelCelular());
    	dto.setTelResidencial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelResidencial());
    	dto.setTelComercial(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().getTelComercial());
    	dto.setAutorizarZap(tabelaMoradorPrincipal.getSelectionModel().getSelectedItem().isAutorizarZap());
    	
    	TelaCadastroEmpregadoController.cadastroEmpregado(dto);
    }

}
