package com.omdes.web.account;

import com.jfinal.core.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.omdes.web.WebForwardConstant.FWD_INDEX;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/13
 * Time: 16:47
 */
public class AccountController extends Controller {
    private static final Logger LOGGER= LoggerFactory.getLogger(AccountController.class);

    public void index() {
        LOGGER.info("enter account panel");

        renderJsp(FWD_INDEX);
    }

    public void add() {
        LOGGER.info("account add");

        //renderJsp("add.jsp");
        redirect("/actions/user/toAddPage");
    }

    //URL隐藏login，显示成success
    public void toAddPage(){
        renderJsp("success.jsp");
    }
}
