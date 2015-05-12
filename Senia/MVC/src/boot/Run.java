package boot;

import controller.Controller;
import view.MyView;
import model.MyModel;

public class Run {

	public static void main(String[] args) {		//For git test - in Run of CLI - 23:23
		MyModel m=new MyModel();
		MyView v=new MyView();
		Controller c=new Controller(m, v);
		m.setController(c);
		v.setController(c);
		v.start();
	}
}
