package com.omdes.web.account;

import com.jfinal.core.Controller;
import com.omdes.web.WebURIMappingConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.omdes.web.WebForwardConstant.FWD_ACCOUNT_INDEX;

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

        renderJsp(FWD_ACCOUNT_INDEX);
    }

    public void add() {
        LOGGER.info("account add");

        //renderJsp("add.jsp");
        redirect(WebURIMappingConstant.URI_ACCOUNT_ADD_REDIRECT);
    }

    //URL隐藏add，显示成toAddPage
    public void toAddPage(){
        renderJsp("success.jsp");
    }
}
