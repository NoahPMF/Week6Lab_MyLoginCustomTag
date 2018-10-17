/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author 601354
 */
public class DebugTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        String debug = pageContext.getRequest().getParameter("debug");
        String domain = pageContext.getRequest().getServerName();

        try {
            JspWriter out = pageContext.getOut();
            if (!debug.equals(" ")) {
                if(domain.equals("test") || domain.equals("localhost")){
                return EVAL_BODY_INCLUDE;
                }
            }
        } catch (NullPointerException ioe) {
            System.out.println(ioe);
        }
        return SKIP_BODY;
    }

}
