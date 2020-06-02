package br.edu.faculdadedelta.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.faculdadedelta.dao.LivroDaoPedro;
import br.edu.faculdadedelta.modelo.EditoraPedro;
import br.edu.faculdadedelta.modelo.LivroPedro;


@ManagedBean
@SessionScoped
public class LivroControllerPedro {
	
	private LivroPedro livro = new LivroPedro();
	private LivroDaoPedro dao = new LivroDaoPedro();
	private EditoraPedro editoraSelecionada = new EditoraPedro();
	
	public LivroPedro getLivro() {
		return livro;
	}
	public void setLivro(LivroPedro livro) {
		this.livro = livro;
	}
	public EditoraPedro getEditoraSelecionada() {
		return editoraSelecionada;
	}
	public void setEditoraSelecionada(EditoraPedro editoraSelecionada) {
		this.editoraSelecionada = editoraSelecionada;
	}
	
	public void limparCampos() {
		livro = new LivroPedro();
	}
	
	private void exibirMensagem(String mensagem) {
		FacesMessage msg = new FacesMessage(mensagem);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String salvar() {
		try {
			if(livro.getId() == null) {
				livro.setEditora(editoraSelecionada);
				dao.incluir(livro);
				limparCampos();
				exibirMensagem("Inclusao realizada com sucesso.");
			} else {
				livro.setEditora(editoraSelecionada);
				dao.alterar(livro);
				limparCampos();
				exibirMensagem("Alteracao realizada com sucesso.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		return "CadastroLivro.xhtml";
	}

	public String editar() {
		livro.setEditora(editoraSelecionada);
		return "CadastroLivro.xhtml";
	}
	
	public String excluir() {
		try {
			livro.setEditora(editoraSelecionada);
				dao.excluir(livro);
				limparCampos();
				exibirMensagem("Exclusao realizada com sucesso.");
			} catch (Exception e) {
				e.printStackTrace();
				exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
			}
			return "ListaLivro.xhtml";
	}
	
	public List<LivroPedro> getListar(){
		List<LivroPedro> listaRetorno = new ArrayList<>();
		
		try {
		listaRetorno = dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			exibirMensagem("Erro ao realizar a operação, tente novamente mais tarde! " + e.getMessage());
		}
		
		return listaRetorno;
	}
}
