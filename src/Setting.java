
public enum Setting {
	OFF("[---]"), LOW("[--+]"), MEDIUM("[-++]"), HIGH("[+++]");

	private String _setting;

	Setting(String setting) {
		this._setting = setting;
	}

	@Override
	public String toString() {
		return _setting;
	}
}
