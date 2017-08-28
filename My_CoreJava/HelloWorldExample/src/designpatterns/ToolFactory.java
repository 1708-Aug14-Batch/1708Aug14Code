package designpatterns;

public class ToolFactory {

	public ToolBox workWithTool(String toolType) {

		if (toolType.equalsIgnoreCase("hammer")) {
			return new Hammer();
		}
		else if (toolType.equalsIgnoreCase("wrench")) {
			return new Wrench();
		}
		else {
			return null;
		}
	}

}
