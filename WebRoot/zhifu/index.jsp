<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="util.Info" %>
<%@page import="dao.CommDAO" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML XMLNS:CC>
<HEAD><TITLE>支付宝 - 网上支付 安全快速！</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=utf-8">
    <META content=网上购物/网上支付/安全支付/安全购物/购物，安全/支付,安全/支付宝/安全,支付/安全，购物/支付,
          name=description 在线 付款,收款 网上,贸易 网上贸易.>
    <META content=网上购物/网上支付/安全支付/安全购物/购物，安全/支付,安全/支付宝/安全,支付/安全，购物/支付, name=keywords
          在线 付款,收款 网上,贸易 网上贸易.>
    <LINK href="images/layout.css"
          type=text/css rel=stylesheet>

    <SCRIPT language=JavaScript>
        <!--
        //校验输入框  -->
        function CheckForm() {
            if (document.alipayment.aliorder.value.length == 0) {
                alert("请输入图书名称.");
                document.alipayment.aliorder.focus();
                return false;
            }
            if (document.alipayment.alimoney.value.length == 0) {
                alert("请输入付款金额.");
                document.alipayment.alimoney.focus();
                return false;
            }
            var reg = new RegExp(/^\d*\.?\d{0,2}$/);
            if (!reg.test(document.alipayment.alimoney.value)) {
                alert("请正确输入付款金额");
                document.alipayment.alimoney.focus();
                return false;
            }
            if (Number(document.alipayment.alimoney.value) < 0.01) {
                alert("付款金额金额最小是0.01.");
                document.alipayment.alimoney.focus();
                return false;
            }
        }

        function glowit(which) {
            if (document.all.glowtext[which].filters[0].strength == 2)
                document.all.glowtext[which].filters[0].strength = 1
            else
                document.all.glowtext[which].filters[0].strength = 2
        }

        function glowit2(which) {
            if (document.all.glowtext.filters[0].strength == 2)
                document.all.glowtext.filters[0].strength = 1
            else
                document.all.glowtext.filters[0].strength = 2
        }

        function startglowing() {
            if (document.all.glowtext && glowtext.length) {
                for (i = 0; i < glowtext.length; i++)
                    eval('setInterval("glowit(' + i + ')",150)')
            } else if (glowtext)
                setInterval("glowit2(0)", 150)
        }

        if (document.all)
            window.onload = startglowing


    </SCRIPT>
</HEAD>
<style>
    <!--
    #glowtext {
        filter: glow(color=red, strength=2);
        width: 100%;
    }

    -->
</style>
<BODY text=#000000 bgColor=#ffffff leftMargin=0 topMargin=4>
<CENTER>

    <TABLE cellSpacing=0 cellPadding=0 width=760 border=0>
        <TBODY>
        <TR>
            <TD class=title>支付宝即时到帐付款快速通道</TD>
        </TR>
        </TBODY>
    </TABLE>
    <BR>
    <FORM name=alipayment onSubmit="return CheckForm();" action=alipayto.asp
          method=post target="_blank">
        <table>
            <tr>
                <td>
                    <TABLE cellSpacing=0 cellPadding=0 width=740 border=0>
                        <TR>
                            <TD class=form-left>收款方：</TD>
                            <TD class=form-star>*</TD>
                            <TD class=form-right>xxxx&nbsp;</TD>
                        </TR>
                        <TR>
                            <TD colspan="3" align="center">
                                <HR width=600 SIZE=2 color="#999999">
                            </TD>
                        </TR>
                        <TR style="display:none">
                            <TD class=form-left>订单号：</TD>
                            <TD class=form-star>*</TD>
                            <TD class=form-right><INPUT size=30 name=aliorder maxlength="200"
                                                        value=""><span>如：7月5日定货款。</span></TD>
                        </TR>
                        <TR style="display:none">
                            <TD class=form-left>付款金额：</TD>
                            <TD class=form-star>*</TD>
                            <TD class=form-right><INPUT maxLength=10 size=30 name=alimoney
                                                        onFocus="if(Number(this.value)==0){this.value='';}" value=""
                                                        readonly="readonly"/>
                                <span>如：112.21</span></TD>
                        </TR>
                        <TR style="display:none">
                            <TD class=form-left>备注：</TD>
                            <TD class=form-star></TD>
                            <TD class=form-right><TEXTAREA name=alibody rows=5 cols=40 wrap="physical"></TEXTAREA><BR>
                                （如联系方法，图书要求、数量等。100汉字内）
                            </TD>
                        </TR>
                        <TR>
                            <TD class=form-left>支付方式：</TD>
                            <TD class=form-star></TD>
                            <TD class=form-right>
                                <table>
                                    <tr>
                                        <td><input type="radio" name="pay_bank" value="directPay" checked><img
                                                src="images/alipay_1.gif" border="0"/></td>

                                        <td><input type="radio" name="pay_bank" value="ICBCB2C"/><img
                                                src="images/timg.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CMB"/><img
                                                src="images/CMB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="CCB"/><img
                                                src="images/CCB_OUT.gif" border="0"/></td>
                                        <td><input type="radio" name="pay_bank" value="BOCB2C"><img
                                                src="images/BOC_OUT.gif" border="0"/></td>
                                    </tr>

                                </table>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=form-left></TD>
                            <TD class=form-star></TD>
                            <TD class=form-right>
                                <img src="images/button_sure.gif"
                                                      onClick="javascript:location.href='../zhifu.jsp?id=<%=request.getParameter("id")%>&biao=<%=request.getParameter("biao")%>&referer='+encodeURIComponent(document.referrer);">
                            </TD>
                        </TR>
                    </TABLE>
                </td>

            </tr>
        </table>

    </FORM>


</BODY>
</HTML>
