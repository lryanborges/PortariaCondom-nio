package controller.api;

import java.net.URL;
import java.util.ResourceBundle;

import controller.dto.EmpregadoDTO;
import controller.dto.MoradorSecundarioDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.services.EmpregadoBO;
import viewer.CondominioAcess;

public class TelaEdicaoEmpregadoController implements Initializable {

    @FXML
    private TextField cargo;

    @FXML
    private TextField nome;

    @FXML
    private TextField rg;

    @FXML
    private ChoiceBox<String> turno;
    EmpregadoBO bo = new EmpregadoBO();
    private String[] turnos = {"Manhã","Tarde","Noite","Integral"};
    static int idMoradorP, apartamento, id;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		turno.getItems().addAll(turnos);
	}
    
    public static void telaEditar(EmpregadoDTO mpDTO) {
    	CondominioAcess.telaEdicaoEmpregado();
    	id = mpDTO.getId();
    }
    
    @FXML
    void editar(ActionEvent event) {
    	EmpregadoDTO dto = new EmpregadoDTO();
        dto.setNome(nome.getText());
        dto.setCargo(cargo.getText());
        dto.setTurno(turno.getValue());
        dto.setRg(rg.getText());
        dto.setId(id);
        
        bo.editar(dto);
        CondominioAcess.telaRegistroEmpregado();
    }

    @FXML
    void telaRegistros() {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }
}
