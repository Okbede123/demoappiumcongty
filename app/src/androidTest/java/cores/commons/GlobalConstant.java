package cores.commons;


import java.util.ArrayList;

public class GlobalConstant {

    public static final String OS_NAME = System.getProperty("os.name");

    public static final String GETLINK_PROJECT = System.getProperty("user.dir");
    public static final String LINK_PROJECT = GETLINK_PROJECT + "\\src\\test\\java\\filefolder\\";
    public static final String UPLOAD_PICTURES = "xpath=//input[@type = 'file']";
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String USER_NAME = "mngr476454";
    public static final String PASSWORD = "YjepAtE";

    public static final String BROWSER_NAME = "cv_zdscw7";
    public static final String BROWSER_AUTOMATE_KEY = "PJf6JMnc9RVPW4wNw6Kg";
    public static final String BROWSER_STACK_URL = "https://"+ BROWSER_NAME+ ":"+ BROWSER_AUTOMATE_KEY+"@hub-cloud.browserstack.com/wd/hub";
    public static final String LINK_APPIUM_HTTP = "http://127.0.0.1:4723/wd/hub";

    public static final ArrayList<String> getListTextToolTip(){
        ArrayList<String> TEXT_TOOLTIPS = new ArrayList<>();
        TEXT_TOOLTIPS.add("Nhấn vào đây để thêm mới đơn hàng");
        TEXT_TOOLTIPS.add("Nếu chưa có hàng hóa cần chọn, nhấn vào đây để thêm mới");
        TEXT_TOOLTIPS.add("Liên kết với cửa hàng trên sàn Shopee, TikTok Shop hay Lazada của bạn để đồng bộ hàng hóa, đơn hàng với KiotOnline");
        TEXT_TOOLTIPS.add("Khởi tạo website bán hàng nhanh chóng, giao diện bắt mắt, đồng bộ dữ liệu với KiotOnline cùng MyKiot.");

        return TEXT_TOOLTIPS;
    }


}
