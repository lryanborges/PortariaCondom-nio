package controller.api;

import controller.dto.VeiculoDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.VeiculoBO;
import viewer.CondominioAcess;

public class TelaEdicaoVeiculo {
    @FXML private TextField cor;
    @FXML private TextField marca;
    @FXML private TextField modelo;
    @FXML private TextField placa;
    static int id;
    VeiculoBO bo = new VeiculoBO();
    

    public static void telaEditar(VeiculoDTO vDTO) {
    	CondominioAcess.telaEdicaoVeiculo();
    	id = vDTO.getId();
    }
    @FXML void editar(ActionEvent event) {
    	VeiculoDTO dto = new VeiculoDTO();
        dto.setCor(cor.getText());
        dto.setMarca(marca.getText());
        dto.setModelo(modelo.getText());
        dto.setPlaca(placa.getText());
        dto.setId(id);
        
        bo.editar(dto);
        telaRegistros();
    }
    @FXML void telaRegistros() {
    	CondominioAcess.telaRegistroVeiculo();
    }

}
