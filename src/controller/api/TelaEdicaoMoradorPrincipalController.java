package controller.api;

import java.net.URL;
import java.util.ResourceBundle;

import controller.dto.MoradorPrincipalDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.services.MoradorPrincipalBO;
import viewer.CondominioAcess;

public class TelaEdicaoMoradorPrincipalController implements Initializable {

	@FXML private TextField apartamento;
    @FXML private TextField bloco;
    @FXML private TextField cpf;
    @FXML private TextField email;
    @FXML private TextField nasc;
    @FXML private TextField nome;
    @FXML private TextField rg;
    @FXML private TextField telCelular;
    @FXML private TextField telComercial;
    @FXML private TextField telResidencial;
    @FXML private ChoiceBox<String> categoria;
    @FXML private CheckBox zap;
    private String[] categorias = {"Proprietario","Locatario"};
    private static int id;
    MoradorPrincipalBO bo = new MoradorPrincipalBO();
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		categoria.getItems().addAll(categorias);
	}
    
    public static void telaEditar(MoradorPrincipalDTO mpDTO) {
    	CondominioAcess.telaEdicaoMoradorPrincipal();
    	id = mpDTO.getId();
    }

    @FXML
    public void editar() {
    	 MoradorPrincipalDTO dto = new MoradorPrincipalDTO();
    	 dto.setId(id);
         dto.setNome(nome.getText());
         dto.setCpf(cpf.getText());
         dto.setRg(rg.getText());
         dto.setEmail(email.getText());
         dto.setApartamento(Integer.parseInt(apartamento.getText()));
         dto.setBloco(bloco.getText());
         dto.setCategoria(categoria.getValue());
         dto.setDataNasc(nasc.getText());
         dto.setTelCelular(telCelular.getText());
         dto.setTelComercial(telComercial.getText());
         dto.setTelResidencial(telResidencial.getText());
         dto.setAutorizarZap(zap.isSelected());
         bo.editar(dto);
         telaRegistros();
    }

	public void telaRegistros() {
		 CondominioAcess.telaRegistroMoradorPrincipal();
	}
	
}
