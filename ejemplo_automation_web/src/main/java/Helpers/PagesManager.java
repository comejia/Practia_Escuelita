package Helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagesManager {

    private static Map<String, Object> pages = new HashMap<>();

    private static String defaultUrl = null;

    private static <T extends Object> T getNewPage(Class<T> type) throws Exception {
        Class cls = Class.forName(type.getName());
        Object page = cls.newInstance();
        pages.put(type.getName(), page);
        return type.cast(page);
    }

    public  static <T extends Object> T getPage(Class<T> type) throws Exception {
        return getPage(type, null);
    }

    public  static <T extends Object> T getPage(Class<T> type, String url) throws Exception {

        if(url != null) {
            defaultUrl = url;
            DriverWeb.getInstance().get(url);
        }
        if(!pages.containsKey(type.getName())) {
            pages.put(type.getName(), getNewPage(type));
        }
        return type.cast(pages.get(type.getName()));

    }

    public static void close() {
        pages = new HashMap<>();
        DriverWeb.closeDriver();
    }

    public static void clearSession() {
        pages = new HashMap<>();
        DriverWeb.getInstance().get(defaultUrl);
    }
}
