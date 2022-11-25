package controller.api;

import java.net.URL;
import java.util.ResourceBundle;

import controller.dto.EmpregadoDTO;
import controller.dto.MoradorPrincipalDTO;
import controller.dto.MoradorSecundarioDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.services.EmpregadoBO;
import model.services.MoradorSecundarioBO;
import viewer.CondominioAcess;

public class TelaCadastroEmpregadoController implements Initializable {

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
    static int idMoradorP, apartamento;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		turno.getItems().addAll(turnos);
	}
    
    public static void cadastroEmpregado(MoradorPrincipalDTO mpDTO) {
	    CondominioAcess.telaCadastroEmpregado();
	    idMoradorP = mpDTO.getId();
	    apartamento = mpDTO.getApartamento();
	}
    
    @FXML
    void cadastrar(ActionEvent event) {
    	EmpregadoDTO dto = new EmpregadoDTO();
        dto.setNome(nome.getText());
        dto.setCargo(cargo.getText());
        dto.setRg(rg.getText());
        dto.setTurno(turno.getValue());
        dto.setApartamento(apartamento);
        dto.setIdMoradorP(idMoradorP);
        int id = bo.cadastrar(dto);
        dto.setId(id);
        CondominioAcess.telaRegistroEmpregado();
    }

    @FXML
    void telaRegistros(ActionEvent event) {
    	CondominioAcess.telaRegistroMoradorPrincipal();
    }

}
