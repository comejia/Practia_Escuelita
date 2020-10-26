package Steps;

import Helpers.PagesManager;

public class BaseSteps {

    public  static <T extends Object> T getPage(Class<T> type) throws Exception {
        return PagesManager.getPage(type);
    }

    public  static <T extends Object> T getPage(Class<T> type, String url) throws Exception {
        return PagesManager.getPage(type, url);
    }

    /*protected void waitForLoadPage() throws Exception {
        Assert.assertTrue("No se cargo correctamente la pagina selecionada", getPage(HomePage.class).waitForVanishLoadBar());
    }*/

}
