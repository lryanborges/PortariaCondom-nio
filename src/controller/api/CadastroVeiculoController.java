package controller.api;

import controller.dto.MoradorPrincipalDTO;
import controller.dto.VeiculoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.VeiculoBO;
import viewer.CondominioAcess;

public class CadastroVeiculoController {
    @FXML private TextField cor;
    @FXML private TextField marca;
    @FXML private TextField modelo;
    @FXML private TextField placa;
    VeiculoBO bo = new VeiculoBO();
    static int idMoradorP, apartamento;
    
	public static void cadastroVeiculoS(MoradorPrincipalDTO vDTO) {
	    CondominioAcess.telaCadastroVeiculo();
	    idMoradorP = vDTO.getId();
	    apartamento = vDTO.getApartamento();
	}
        

    @FXML void cadastrar(ActionEvent event) {
    	VeiculoDTO dto = new VeiculoDTO();
        dto.setCor(cor.getText());
        dto.setMarca(marca.getText());
        dto.setModelo(modelo.getText());
        dto.setPlaca(placa.getText());
        dto.setApartamento(apartamento);
        dto.setId_MoradorP(idMoradorP);
        int id = bo.cadastrar(dto);
        dto.setId(id);
        CondominioAcess.telaRegistroVeiculo();
    }

    @FXML void telaRegistros() {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }

}
