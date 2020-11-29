package modelo;

public class Chiste {
	private Integer id;
	private String type;
	private String setup;
	private String punchline;

	public Chiste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chiste(Integer id, String type, String setup, String punchline) {
		super();
		this.id = id;
		this.type = type;
		this.setup = setup;
		this.punchline = punchline;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSetup() {
		return setup;
	}

	public void setSetup(String setup) {
		this.setup = setup;
	}

	public String getPunchline() {
		return punchline;
	}

	public void setPunchline(String punchline) {
		this.punchline = punchline;
	}

	@Override
	public String toString() {
		return "Chiste [id=" + id + ", type=" + type + ", setup=" + setup + ", punchline=" + punchline + "]";
	}

}
