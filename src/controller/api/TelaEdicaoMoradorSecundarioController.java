package controller.api;

import controller.dto.MoradorPrincipalDTO;
import controller.dto.MoradorSecundarioDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.MoradorSecundarioBO;
import viewer.CondominioAcess;

public class TelaEdicaoMoradorSecundarioController {

    @FXML
    private TextField nascimento;

    @FXML
    private TextField nome;

    @FXML
    private TextField parentesco;
    static int id;
    MoradorSecundarioBO bo = new MoradorSecundarioBO();
    
    public static void telaEditar(MoradorSecundarioDTO mpDTO) {
    	CondominioAcess.telaEdicaoMoradorSecundario();
    	id = mpDTO.getId();
    }
    
    @FXML
    void editar(ActionEvent event) {
    	MoradorSecundarioDTO dto = new MoradorSecundarioDTO();
        dto.setNome(nome.getText());
        dto.setParentesco(parentesco.getText());
        dto.setDataNasc(nascimento.getText());
        dto.setId(id);
        
        bo.editar(dto);
        telaRegistros();
    }

    @FXML
    void telaRegistros() {
    	CondominioAcess.telaRegistroMoradorSecundario();
    }

}

