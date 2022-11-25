package controller.api;

import controller.dto.MoradorPrincipalDTO;
import controller.dto.MoradorSecundarioDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.MoradorSecundarioBO;
import viewer.CondominioAcess;

public class CadastroMoradorSecundarioController {

    @FXML private TextField nascimento;
    @FXML private TextField nome;
    @FXML private TextField parentesco;
    MoradorSecundarioBO bo = new MoradorSecundarioBO();
    static int idMoradorP, apartamento;

	public static void cadastroMoradorS(MoradorPrincipalDTO mpDTO) {
	    CondominioAcess.telaCadastroMoradorSecundario();
	    idMoradorP = mpDTO.getId();
	    apartamento = mpDTO.getApartamento();
	}
    
    @FXML
    void cadastrar(ActionEvent event) {
    	MoradorSecundarioDTO dto = new MoradorSecundarioDTO();
        dto.setNome(nome.getText());
        dto.setParentesco(parentesco.getText());
        dto.setDataNasc(nascimento.getText());
        dto.setApartamento(apartamento);
        dto.setIdMoradorP(idMoradorP);
        int id = bo.cadastrar(dto);
        dto.setId(id);
        telaRegistros();
    }

    @FXML
    public void telaRegistros() {
		 CondominioAcess.telaRegistroMoradorSecundario();
	}

}