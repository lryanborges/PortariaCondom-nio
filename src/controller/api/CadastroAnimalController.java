package controller.api;

import controller.dto.AnimalDTO;
import controller.dto.MoradorPrincipalDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.AnimalBO;
import viewer.CondominioAcess;

public class CadastroAnimalController {
	@FXML private TextField raca;
    @FXML private TextField nome;
    @FXML private TextField cor;
    @FXML private TextField especie;
    AnimalBO bo = new AnimalBO();
    static int idMoradorP, apartamento;

	public static void cadastroMoradorS(MoradorPrincipalDTO mpDTO) {
	    CondominioAcess.telaCadastroAnimal();
	    idMoradorP = mpDTO.getId();
	    apartamento = mpDTO.getApartamento();
	}
    
    @FXML
    void cadastrar(ActionEvent event) {
    	AnimalDTO dto = new AnimalDTO();
        dto.setNome(nome.getText());
        dto.setApartamento(apartamento);
        dto.setRaca(raca.getText());
        dto.setCor(cor.getText());
        dto.setIdMorador(idMoradorP);
        dto.setEspecie(especie.getText());
        int id = bo.cadastrar(dto);
        dto.setId(id);
        CondominioAcess.telaRegistroAnimal();
    }

    @FXML
    public void telaRegistros() {
		 CondominioAcess.telaRegistroMoradorPrincipal();
	}
}
