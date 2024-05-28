package util.threadlocal;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
/**
 * 将数据保存到某个线程中
 */
public class LocalRequestContextHolder {
    private final static ThreadLocal<LocalRequestContext> contexts = new ThreadLocal<LocalRequestContext>();

    private LocalRequestContextHolder(){}

    public static void setLocalRequestContext(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        LocalRequestContext rc = new LocalRequestContext();
        //rc.servletContext = servletContext;
        rc.request = httpServletRequest;
        rc.response = httpServletResponse;
        rc.session = httpServletRequest.getSession();
        rc.cookies = new HashMap<String, Cookie>();
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for(Cookie ck : cookies) {
                rc.cookies.put(ck.getName(), ck);
            }
        }
        contexts.set(rc);
    }

    /**
     * 获取当前请求的上下文
     * @return
     */
    public static LocalRequestContext getLocalRequestContext(){
        return contexts.get();
    }

    /**
     * 清除当前线程对请求上下文对象的引用（即让GC回收当前请求上下文对象）
     */
    public static void destoryLocalRequestContext() {
        contexts.remove();
    }
}
