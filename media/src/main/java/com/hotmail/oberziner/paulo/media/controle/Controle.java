package com.hotmail.oberziner.paulo.media.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hotmail.oberziner.paulo.media.modelo.AlunoModelo;
import com.hotmail.oberziner.paulo.media.modelo.AlunoResposta;
import com.hotmail.oberziner.paulo.media.Repositorio.AlunoRepositorio;

@CrossOrigin(origins="https://localhost:4200")
@RestController
@RequestMapping("/api")
public class Controle {
	@Autowired
	private AlunoRepositorio AlunoRepositorio;
	
	@GetMapping("/aluno")
	public @ResponseBody List<AlunoModelo> consultar(){
		return this.AlunoRepositorio.findAll();
		
	};
	
	@GetMapping("/aluno/{codigo}")
	public @ResponseBody AlunoModelo buscar(@PathVariable("codigo") Integer codigo){
		return  this.AlunoRepositorio.findByCodigo(codigo);
		
	};
	
	@PostMapping("/aluno")
	public @ResponseBody AlunoResposta salvar(@RequestBody AlunoModelo aluno){
		try {
			this.AlunoRepositorio.save(aluno);
			return new AlunoResposta ("Registro salvo com sucesso");
		} catch (Exception e){
			return new AlunoResposta (e.getMessage());
		}
	
	};
	@PutMapping("/aluno")
	public @ResponseBody AlunoResposta atualizar(@RequestBody AlunoModelo aluno){
		try {
			this.AlunoRepositorio.save(aluno);
			return new AlunoResposta ("Registro atualizado com sucesso");
		} catch (Exception e){
			return new AlunoResposta (e.getMessage());
		}
	
	};
	
	@DeleteMapping("/aluno/{codigo}")
	public @ResponseBody AlunoResposta excluir(@PathVariable("codigo") Integer codigo){
		AlunoModelo AlunoModelo = AlunoRepositorio.findByCodigo(codigo);
		
		try {
			this.AlunoRepositorio.delete(AlunoModelo);
			return new AlunoResposta ("Registro excluido com sucesso");
		} catch (Exception e){
			return new AlunoResposta (e.getMessage());
		}
		
	};
	
}
