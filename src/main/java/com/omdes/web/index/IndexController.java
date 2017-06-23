package com.omdes.web.index;

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
public class IndexController extends Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    public void index(){
        LOGGER.info("enter index page!");

        renderJsp(FWD_INDEX);
    }
}
