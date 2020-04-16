package tests;

import org.testng.annotations.Test;

import pages.TEDsearchpage;

public class TEDsearchTest extends TestBase{
	
	TEDsearchpage TEDsearchobj;
	
	@Test (priority = 0)
	public void TEDSearchinGoogleplay()
	
	{
		TEDsearchobj = new TEDsearchpage(driver);
		TEDsearchobj.SelectApps();
		TEDsearchobj.SelectEducation();
		TEDsearchobj.TedSearch();
	
	}
	
	@Test (priority = 1)
	public void fbsearchingoogleplay() {
		
		TEDsearchobj = new TEDsearchpage(driver);
		TEDsearchobj.FBsearch();
	}

}
