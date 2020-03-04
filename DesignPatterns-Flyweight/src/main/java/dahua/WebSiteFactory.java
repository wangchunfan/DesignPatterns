package dahua;

import java.util.HashMap;

/**
 * 网站工厂
 */
public class WebSiteFactory {
    private HashMap<String, WebSit> webSitHashMap = new HashMap();

    public WebSit createWetSit(String type) {
        if (!webSitHashMap.containsKey(type)) {
            webSitHashMap.put(type, new ConcreteWebSite(type));
        }
        return webSitHashMap.get(type);
    }

    public int getWebSitCount() {
        return webSitHashMap.size();
    }
}
