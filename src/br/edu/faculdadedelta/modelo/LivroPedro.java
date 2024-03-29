package br.edu.faculdadedelta.modelo;

public class LivroPedro {
	
	private Long id;
	private String titulo;
	private EditoraPedro editora;
	private Double valor;
	public LivroPedro() {
		super();
	}
	public LivroPedro(Long id, String titulo, EditoraPedro editora, Double valor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.valor = valor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public EditoraPedro getEditora() {
		return editora;
	}
	public void setEditora(EditoraPedro editora) {
		this.editora = editora;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroPedro other = (LivroPedro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
