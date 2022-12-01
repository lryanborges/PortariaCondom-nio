package controller.api;

import controller.dto.AnimalDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.services.AnimalBO;
import viewer.CondominioAcess;

public class TelaEdicaoAnimalController {

    @FXML
    private TextField cor;

    @FXML
    private TextField especie;

    @FXML
    private TextField nome;

    @FXML
    private TextField raca;
    static int id;
    AnimalBO bo = new AnimalBO();
    
    
    public static void telaEditar(AnimalDTO aDTO) {
    	CondominioAcess.telaEdicaoAnimal();
    	id = aDTO.getId();
    }
    
    @FXML
    void editar(ActionEvent event) {
    	AnimalDTO dto = new AnimalDTO();
        dto.setNome(nome.getText());
        dto.setRaca(raca.getText());
        dto.setCor(cor.getText());
        dto.setEspecie(especie.getText());
        dto.setId(id);
        bo.editar(dto);
        telaRegistros();
    }

    @FXML
    void telaRegistros() {
    	CondominioAcess.telaRegistroAnimal();
    }

}
