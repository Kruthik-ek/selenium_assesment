package keyworddrivenclasses;

public class keywordExecutors { // keyword creation
	
keyword_implement k =new keyword_implement();
	
	public void executors(String keyword) {
		if(keyword.equals("LAUNCH_BROWSER")) {
			k.launchBrowser();
		}
		else if(keyword.equals("OPEN_URL")) {
			k.openurl();
		}
		else if(keyword.equals("SEARCH_TF")) {
			k.searchtf();
		}
		else if(keyword.equals("SEARCH_BUTTON")) {
			k.searchbutton();
		}
		else if(keyword.equals("CLOSE_BROWSER")) {
			k.closebrowser();
		
	}

}
}
