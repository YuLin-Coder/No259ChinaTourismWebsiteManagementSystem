package dao;


import util.Request;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Map;
/**
 * 继承自ArrayList 的实现，并实现分页代码的展示
 * @param <E>
 */
public class Collect<E> extends ArrayList<E> {
    // 总数
    protected long count = 0;
    // 当前分页
    protected int page = -1;
    // 分页总数
    protected int pageCount = 0;
    // 第一行起始位置 limit firstRow,listRows 即可
    public int firstRow = 0;
    // 取数据库的行数
    public int listRows = 15;
    // URL 规则
    protected String urlRule = "";


    // 表现层代码
    private String info;
    private Collect()
    {

    }

    public String getUrlRule() {
        return urlRule;
    }

    public String getInfo() {
        return info;
    }
    /**
     *
     * @param count 总行数
     * @param pagesize  一页展示多少条数据
     */
    public Collect(long count , int pagesize )
    {
        this.listRows = pagesize;
        this.count = count;
        this.initLimit();
    }
    /**
     *
     * @param count 总行数
     * @param pagesize 一页展示多少条数据
     * @param page  当前页
     */
    public Collect(long count , int pagesize , int page )
    {
        this.listRows = pagesize;
        this.count = count;
        this.page = page;
        this.initLimit();
    }
    /**
     * 初始化
     */
    protected void initLimit()
    {
        // 取分页数有多少
        double ceil = (double) this.count / (double)this.listRows;
        // 分页页面总数
        this.pageCount =  this.count == 0 ? 0 : new Double(Math.ceil(ceil)).intValue();
        // 取URL 规则
        this.urlRule = getRequestUrlPath();
        // 获取第一行的位置
        firstRow = listRows*(page-1);
        // 渲染分页代码
        info = reader();
        //LocalRequestContext content = LocalRequestContextHolder.getLocalRequestContext();

        HttpServletRequest res = Request.getRequest();

        // 赋值给模版，模版采用 ${info.page} 即可显示分页
        PageCollect p = new PageCollect();

        p.setInfo(info);
        res.setAttribute("page" , p);
        res.setAttribute("totalCount" , this.count);
    }

    public long getCount()
    {
        return count;
    }

    public void setCount(long c)
    {
        this.count = c;
    }
    /**
     * 渲染页面展示函数
     * @return
     */
    public String reader()
    {
        // 初始化字符串缓冲区
        StringBuffer buffer = new StringBuffer();
        // 替换URL 规则
        String url = urlRule.replace("page={page}" , "");
        // 生成表单


        //buffer.append("<script>function submitPage(form) { var url=$(form).attr('action');location.href=url+'&page='+$(form).find('select[name=\"page\"]').val(); return false;  }</script>");
        buffer.append("<form action=\""+url+"\" onsubmit=\"return submitPage(this)\" method=\"get\"><div class=\"pages\">");
        buffer.append("<span>共").append(this.count).append("条").append("&nbsp;");

        Map<String,String[]> strs = Request.getRequest().getParameterMap();
        for (Map.Entry<String,String[]> v : strs.entrySet())
        {
            String key = v.getKey();
            String[] val = v.getValue();

            if( !key.equals("page") ){
                if(val != null && val.length>0){
                    for (int i=0;i<val.length;i++){
                        buffer.append("<input type='hidden' name='"+key+"' value='"+ (val[i] == null ? "" : val[i]) +"' />");
                    }
                }
            }
        }


        buffer.append(this.page).append("/").append(this.pageCount).append("页</span>");
        // 渲染第一页
        getFirstPage(buffer);
        // 渲染上一页
        getPrevPage(buffer);
        // 渲染页码 如： 1 2 3 4 5 这样
        getCenterPage(buffer);
        // 渲染下一页
        getNextPage(buffer);
        // 渲染最后一页
        getLastPage(buffer);
        // 渲染下拉框
        getSelect(buffer);
        buffer.append("</div></form>");
        //int currentPage = ;
        // 返回渲染好的HTML 代码
        return buffer.toString();
    }
    /**
     * 渲染下拉框
     * @param buffer
     */
    protected void getSelect(StringBuffer buffer)
    {
        buffer.append("<select name=\"page\" onchange=\"this.form.submit()\">");
        for(int i=1;i<=pageCount;i++){
            buffer.append("<option value='"+i+"'"+(page==i?" selected":"")+">"+i+"</option>");
        }
        buffer.append("</select>");
    }
    /**
     * 渲染页码 如1、2、3、4、5
     * @param buffer
     */
    protected void getCenterPage(StringBuffer buffer)
    {
        // 取中间页面
        int rollPage = 2;
        int show_nums = rollPage * 2 +1;
        int i=0;
        if(pageCount <= show_nums){

            for(i = 1;i<=pageCount;i++){
                if(i == this.page){
                    buffer.append("<a href=\"javascript:;\" class=\"active\">"+i+"</a>");
                }else{
                    buffer.append("<a href=\"").append(this.getUrlPath(i)).append("\">"+i+"</a>");
                }
            }
        }else if(page < (1+rollPage)){
            for(i = 1;i<=show_nums;i++){
                if(i == page){
                    buffer.append("<a href=\"javascript:;\" class=\"active\">"+i+"</a>");
                }else{
                    buffer.append("<a href=\"").append(this.getUrlPath(i)).append("\">"+i+"</a>");
                }
            }
        }else if(page >= (pageCount - rollPage)){
            for(i = pageCount - show_nums ; i <= pageCount ; i++){
                if(i == page){
                    buffer.append("<a href=\"javascript:;\" class=\"active\">"+i+"</a>");
                }else{
                    buffer.append("<a href=\"").append(this.getUrlPath(i)).append("\">"+i+"</a>");
                }
            }
        }else{
            int start_page = page - rollPage;
            int end_page = page + rollPage;
            for(i = start_page ; i<=end_page ; i++){
                if(i == page){
                    buffer.append("<a href=\"javascript:;\" class=\"active\">"+i+"</a>");
                }else{
                    buffer.append("<a href=\"").append(this.getUrlPath(i)).append("\">"+i+"</a>");
                }
            }
        }
    }
    /**
     * 渲染第一页
     * @param buffer
     */
    protected void getFirstPage(StringBuffer buffer)
    {
        buffer.append("<a href=\"").append(this.getUrlPath(1)).append("\">第一页</a>");
    }
    /**
     * 渲染上一页
     * @param buffer
     */
    protected void getPrevPage(StringBuffer buffer)
    {
        if(this.page == 1){
            getDisabledButton(buffer , "上一页");
        }else{
            buffer.append("<a href=\"").append(getUrlPath(this.page - 1)).append("\">上一页</a>");
        }
    }
    /**
     * 渲染下一页
     * @param buffer
     */
    protected void getNextPage(StringBuffer buffer)
    {
        if(this.page < this.pageCount)
        {
            buffer.append("<a href=\"").append(getUrlPath(this.page + 1)).append("\">下一页</a>");
        }else{
            getDisabledButton(buffer , "下一页");
        }
    }
    /**
     * 渲染最后一页
     * @param buffer
     */
    protected void getLastPage(StringBuffer buffer)
    {
        buffer.append("<a href=\"").append(this.getUrlPath(this.pageCount)).append("\">尾页</a>");
    }
    /**
     * 渲染不可点的按钮
     * @param buffer
     * @param name
     */
    protected void getDisabledButton(StringBuffer buffer , String name)
    {
        buffer.append("<a href='javascript:;' class=\"disabled\">").append(name).append("</a>");
    }
    /**
     * 获取替换成功的页码
     * @param page
     * @return
     */
    protected String getUrlPath(int page)
    {
        return this.urlRule.replace("{page}" , String.valueOf(page));
    }


    /**
     * 根据当前页面生成URL规则，
     * @return
     */
    protected String getRequestUrlPath()
    {

        // 获取当前线程的Request
        String queryString = Request.getRequest().getQueryString();
        if(queryString == null){
            queryString = "";
        }

        StringBuffer buffer = new StringBuffer(queryString.length()+16);

        // 获取URL path 参数如： /index.jsp
        String requestURI = Request.getRequest().getRequestURI();
        // 开始写入参数
        buffer.append(requestURI).append("?");
        // 获取URL提交的参数
        Map<String,String[]> param = Request.getRequest().getParameterMap();
        String name = "";
        String value = "";
        // 是否搜索page 参数
        boolean isSearchPage = false;
        int page = -1;

        for (Map.Entry<String, String[]> entry : param.entrySet()) {
            try{
                name = entry.getKey();
                String[] values = entry.getValue();
                // 当前参数等于=page
                if(name.equals("page")){
                    page = Integer.valueOf(values[0]).intValue();
                    // 写入url 规则的是：page={page} 使用时替换{page}即可
                    buffer.append(name).append("=").append("{page}").append("&");
                    isSearchPage = true;
                } else if (null == values) {
                    // 值等于null,所以也写入
                    buffer.append(name).append("=").append("&");
                } else if (values.length>1) {
                    // 同名参数，多个
                    for (int i = 0; i < values.length; i++) { //用于请求参数中有多个相同名称
                        value = URLEncoder.encode(values[i] , "UTF-8");
                        buffer.append(name).append("=").append(value).append("&");
                    }
                } else {
                    value = URLEncoder.encode(values[0] , "UTF-8");
                    buffer.append(name).append("=").append(value).append("&");//用于请求参数中请求参数名唯一
                }
            }catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        // 写入当前页码
        if(this.page == -1){
            this.page = page;
        }
        // 防止page 小于1
        this.page = Math.max(this.page , 1);

        // 没有搜索到页码直接写入
        if(!isSearchPage){
            buffer.append("page={page}&");
        }
        String result = buffer.toString();
        return result.substring(0 , result.length()-1);
    }


    public int getPage() {
        return page;
    }
}
